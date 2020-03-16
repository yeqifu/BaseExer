package com.yeqifu.exer05;

import com.yeqifu.exer01.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: 落亦-
 * @Date: 2020/3/15 21:52
 */
public class TransactionTest {

    /***********未考虑事务下的转账操作*************/
    /**
     * 模拟AAA向BBB转账100元  中途出现意外情况（如网络拥塞）
     * 结果AAA少了100元而BBB却没有多100元
     */
    @Test
    public void transaction(){
        String sql1 = "update user_table set balance = balance-100 where user = ?";
        update(sql1,"AAA");
        //模拟网络异常
        int result = 10/0;
        String sql2 = "update user_table set balance = balance+100 where user = ?";
        update(sql2,"BBB");
    }


    public void update(String sql,Object... args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                //修改其为自动提交，主要针对的是数据库连接池中连接的重复使用
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //关闭资源
            JDBCUtils.closeResource(connection,preparedStatement);
        }
    }





    /**************考虑事务下的转账操作*****************/
    @Test
    public void testForTranscation() {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            //查看是否自动提交
            System.out.println(connection.getAutoCommit());
            //1.设置不自动提交
            connection.setAutoCommit(false);
            String sql1 = "update user_table set balance = balance-100 where user = ?";
            updateForTranscation(connection,sql1,"AAA");

            //模拟网络异常
            int result = 10/0;

            String sql2 = "update user_table set balance = balance+100 where user = ?";
            updateForTranscation(connection,sql2,"BBB");
            System.out.println("转账成功");
            //2.转账完成提交事务
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //3.转账失败时，进行回滚
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            JDBCUtils.closeResource(connection,null);
        }
    }

    /**
     * 通用的增、删、改操作   ----考虑事务
     * @param connection
     * @param sql
     * @param args
     */
    public void updateForTranscation(Connection connection,String sql,Object... args){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(null,preparedStatement);
        }
    }













}
