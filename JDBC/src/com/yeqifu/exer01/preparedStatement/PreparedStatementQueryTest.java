package com.yeqifu.exer01.preparedStatement;

import com.yeqifu.exer01.utils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 落亦-
 * @Date: 2020/3/13 13:35
 */
public class PreparedStatementQueryTest {

    @Test
    public void testGetInstance(){
        String sql = "select order_id orderId,order_name orderName,order_age orderAge from `order` where order_id = ?";
        Order order = getInstance(Order.class, sql, 1);
        System.out.println(order);

        String sql2 = "select id,name,password,age,comment,birthday from blog_user where id = ?";
        User user = getInstance(User.class, sql2, 2);
        System.out.println(user);
    }

    /**
     * 针对于不同表的通用查询操作，返回表的一条记录
     * @param clazz 数据表所对应的实体类的对象
     * @param sql   查询的sql语句
     * @param args  占位符
     * @param <T>
     * @return
     */
    public <T> T getInstance(Class<T> clazz,String sql,Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            //声明预处理语句
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                //填充占位符
                preparedStatement.setObject(i+1,args[i]);
            }
            //执行sql,获得结果集
            resultSet = preparedStatement.executeQuery();
            //根据结果集获取元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            //根据元数据获取列数
            int columnCount = metaData.getColumnCount();
            if (resultSet.next()){
                //通过反射创建对象
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    //根据元数据获得列名
                    String columnName = metaData.getColumnLabel(i + 1);
                    //根据resultSet获取列值
                    Object columnValue = resultSet.getObject(i+1);

                    //通过反射将对象指定的columnName的属性赋值为指定的值columnValue
                    Field declaredField = clazz.getDeclaredField(columnName);
                    declaredField.setAccessible(true);
                    declaredField.set(t,columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }
        return null;
    }

    @Test
    public void testGetForList(){
        String sql = "select * from blog_user where id < ?";
        List<User> userList = getForList(User.class, sql, 3);
        for (User user : userList) {
            System.out.println(user);
        }

        String sql2 = "select order_id orderId,order_name orderName,order_age orderAge from `order`";
        List<Order> orderList = getForList(Order.class, sql2);
        //lambda表达式   Consume消费者
        orderList.forEach(System.out::println);
    }

    public <T> List<T> getForList(Class<T> clazz,String sql,Object... args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            //声明预处理语句
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                //填充占位符
                preparedStatement.setObject(i+1,args[i]);
            }
            //执行sql,获得结果集
            resultSet = preparedStatement.executeQuery();
            //根据结果集获取元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            //根据元数据获取列数
            int columnCount = metaData.getColumnCount();
            //创建集合对象
            List<T> list = new ArrayList<T>();
            while (resultSet.next()){
                //通过反射创建对象
                T t = clazz.newInstance();
                //处理结果集一行数据中的每一个列:给t对象指定的属性赋值
                for (int i = 0; i < columnCount; i++) {
                    //根据元数据获得列名
                    String columnName = metaData.getColumnLabel(i + 1);
                    //根据resultSet获取列值
                    Object columnValue = resultSet.getObject(i+1);

                    //通过反射将对象指定的columnName的属性赋值为指定的值columnValue
                    Field declaredField = clazz.getDeclaredField(columnName);
                    declaredField.setAccessible(true);
                    declaredField.set(t,columnValue);
                }
                //将对象添加到集合中去
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }
        return null;
    }




}
