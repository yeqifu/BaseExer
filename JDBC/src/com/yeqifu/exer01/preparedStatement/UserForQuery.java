package com.yeqifu.exer01.preparedStatement;

import com.yeqifu.exer01.utils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @Author: 落亦-
 * @Date: 2020/3/13 9:59
 */
public class UserForQuery {

    @Test
    public void testUserForQuery(){
        String sql = "select name,age,comment from blog_user where id = ?";
        User userForQuery = getUserForQuery(sql, 2);
        System.out.println(userForQuery);
    }

    /**
     * 查询blog_user表中数据的通用操作
     * @param sql
     * @param args
     * @return
     */
    public User getUserForQuery(String sql,Object... args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }
            resultSet = preparedStatement.executeQuery();
            //通过结果集获取元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            //通过元数据获得结果集的列数
            int columnCount = metaData.getColumnCount();

            if (resultSet.next()){
                User user = new User();
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object columnValue = resultSet.getObject(i + 1);
                    //通过元数据获得列名
                    String columnName = metaData.getColumnName(i+1);
                    //给user对象指定的columnName属性，赋值为columnValue：通过反射
                    Field declaredField = User.class.getDeclaredField(columnName);
                    declaredField.setAccessible(true);
                    declaredField.set(user,columnValue);
                }
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }
        return null;

    }

}
