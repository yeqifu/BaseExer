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
 * @Date: 2020/3/13 10:32
 */
public class OrderForQuery {

    /**
     * 针对于表的字段名与类的属性名不相同的情况：
     * 	  1. 必须声明sql时，使用类的属性名来命名字段的别名
     * 	  2. 使用ResultSetMetaData时，需要使用getColumnLabel()来替换getColumnName(),获取列的别名。
     *
     * 	     说明：如果sql中没有给字段其别名，getColumnLabel()获取的就是列名
     */
    @Test
    public void testOrderForQuery(){
        String sql = "select order_id orderId,order_name orderName,order_age orderAge from `order` where order_id = ?";
        Order order = orderForQuery(sql,1);
        System.out.println(order);
    }

    /**
     * 通用的查询order表的方法
     * @param sql
     * @param args
     * @return
     * @throws Exception
     */
    public Order orderForQuery(String sql,Object... args) {
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
            //获取元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            //获得列数
            int columnCount = metaData.getColumnCount();
            if (resultSet.next()){
                Order order = new Order();
                for (int i = 0; i < columnCount; i++) {
                    //获取每一列的列名:通过metaData来获取
//                    String columnName = metaData.getColumnName(i + 1);  --不推荐使用
                    String columnName = metaData.getColumnLabel(i + 1);
                    //获取每一列的列值:通过resultSet来获取
                    Object columnValue = resultSet.getObject(i + 1);

                    //通过反射，将对象指定名columnName的属性赋值为指定的值columnValue
                    Field declaredField = Order.class.getDeclaredField(columnName);
                    declaredField.setAccessible(true);
                    declaredField.set(order,columnValue);
                }
                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }
        return null;
    }


    @Test
    public void testQuery1(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select order_id,order_name,order_age from `order` where order_id = ?";
            preparedStatement = connection.prepareStatement(sql);
            //填充占位符
            preparedStatement.setObject(1,1);
            //返回结果集
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Integer orderId = (Integer) resultSet.getObject(1);
                String orderName = (String) resultSet.getObject(2);
                Integer orderAge = (Integer) resultSet.getObject(3);
                Order order = new Order(orderId, orderName, orderAge);
                System.out.println(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }
    }

}
