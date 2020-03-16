package com.yeqifu.exer06.dao;

import com.yeqifu.exer01.utils.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO:data(base) access object 数据库访问对象
 * @Author: 落亦-
 * @Date: 2020/3/16 15:34
 */
public abstract class BaseDao {

    /**
     * 通用的增、删、改操作 --- 考虑事务
     * @param connection    数据库连接
     * @param sql           sql语句
     * @param args          需要填充的占位符
     * @throws SQLException
     */
    public void update(Connection connection,String sql,Object... args) {
        PreparedStatement preparedStatement = null;
        try {
            //关闭自动提交
            connection.setAutoCommit(false);
            //声明preparedStatement预处理语句
            preparedStatement = connection.prepareStatement(sql);
            //填充占位符
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }
            //执行sql语句
            preparedStatement.execute();
            //提交事务
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                //出现异常，进行回滚操作
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            JDBCUtils.closeResource(null,preparedStatement);
        }

    }


    /**
     * 通用的查询数据库中表的一条记录的操作 --- 考虑事务
     * @param connection    数据库连接
     * @param clazz         数据库表对应的实体类对象
     * @param sql           sql语句
     * @param args          需要填充的占位符
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> T getInstance(Connection connection,Class<T> clazz,String sql,Object... args) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //声明预处理的preparedStatement
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                //填充占位符
                preparedStatement.setObject(i+1,args[i]);
            }
            //执行sql，获取结果集
            resultSet = preparedStatement.executeQuery();
            //通过resultSet获取元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            //通过元数据获取数据库中表的列数
            int columnCount = metaData.getColumnCount();

            if (resultSet.next()){
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    //通过resultSet获取每一列的列值
                    Object columnValue = resultSet.getObject(i+1);
                    //通过metaData获取数据库中表的列名
                    String columnLabel = metaData.getColumnLabel(i + 1);

                    //给t对象的指定的columnLabel赋值为columnValue:通过过反射
                    Field declaredField = clazz.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(t,columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(null,preparedStatement,resultSet);
        }
        return null;
    }

    /**
     * 通用的查询出多条结果的方法 ---考虑事务
     * @param connection    数据库连接
     * @param clazz        数据库表对应的实体类对象
     * @param sql           sql语句
     * @param args          需要填充的占位符
     * @param <T>
     * @return
     */
    public <T> List<T> getForList(Connection connection,Class<T> clazz,String sql,Object... args) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //声明预处理语句
            preparedStatement = connection.prepareStatement(sql);
            //填充占位符
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }
            //执行sql
            resultSet = preparedStatement.executeQuery();
            //通过resultSet获取元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            //通过元数据获取列数
            int columnCount = metaData.getColumnCount();
            //创建一个list存放clazz实体类的对象
            ArrayList<T> list = new ArrayList<T>();
            while (resultSet.next()){
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    //通过metaData获取列名
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    //通过resultSet获取列值
                    Object columnValue = resultSet.getObject(i+1);
                    //将columnLabel对应的属性赋值columnValue:通过反射
                    Field declaredField = clazz.getDeclaredField(columnLabel);
                    declaredField.setAccessible(true);
                    declaredField.set(t,columnValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(null,preparedStatement,resultSet);
        }
        return null;
    }

    //用于查询特殊值的通用的方法
    public <E> E getValue(Connection connection,String sql,Object...args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            for(int i = 0;i < args.length;i++){
                ps.setObject(i + 1, args[i]);
            }
            //执行sql
            rs = ps.executeQuery();
            if(rs.next()){
                return (E) rs.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.closeResource(null, ps, rs);
        }
        return null;
    }


}
