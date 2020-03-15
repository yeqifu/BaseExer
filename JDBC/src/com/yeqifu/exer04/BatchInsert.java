package com.yeqifu.exer04;

import com.yeqifu.exer01.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * 批量插入的   种实现方法
 * @Author: 落亦-
 * @Date: 2020/3/15 9:53
 */
public class BatchInsert {
    /**
     * 方式一：使用statement实现批量插入
     */
    @Test
    public void batchInsert1() {
        Connection connection = null;
        Statement statement = null;

        try {
            long start = System.currentTimeMillis();
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            for (int i = 0; i < 10000; i++) {
                String sql = "insert into goods (name) values ('name_"+i+"')";
                statement.execute(sql);
            }
            long end = System.currentTimeMillis();
            //插入10000条数据所花时间为  33304
            System.out.println("插入10000条数据所花时间为："+(end-start));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,statement);
        }
    }

    /**
     * 方式二：使用preparedStatement实现批量插入
     */
    @Test
    public void batchInsert2(){
        Connection connection = null;
        Statement statement = null;

        try {
            long start = System.currentTimeMillis();
            connection = JDBCUtils.getConnection();
            String sql= "insert into goods (name) values (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < 10000; i++) {
                preparedStatement.setString(1,"name_"+i);
                preparedStatement.execute();
            }
            long end = System.currentTimeMillis();
            /**
             * 插入10000条数据所花时间为  33432
             */
            System.out.println("插入10000条数据所花时间为："+(end-start));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,statement);
        }
    }

    /**
     * 方式三：使用addBatch+preparedStatement实现批量插入
     */
    @Test
    public void batchInsert3(){
        Connection connection = null;
        Statement statement = null;

        try {
            long start = System.currentTimeMillis();
            connection = JDBCUtils.getConnection();
            String sql= "insert into goods (name) values (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < 10000; i++) {
                preparedStatement.setString(1,"name_"+i);
                //1.攒sql
                preparedStatement.addBatch();
                if(i%500==0){
                    //2.执行batch
                    preparedStatement.executeBatch();
                    //3.清空batch
                    preparedStatement.clearBatch();
                }
            }
            long end = System.currentTimeMillis();
            /**
             * 插入10000条数据所花时间为  1320
             */
            System.out.println("插入10000条数据所花时间为："+(end-start));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,statement);
        }
    }

    /**
     * 方式四：设置连接不允许自动提交
     */
    @Test
    public void batchInsert4(){
        Connection connection = null;
        Statement statement = null;

        try {
            long start = System.currentTimeMillis();
            connection = JDBCUtils.getConnection();
            //设置不允许自动提交数据
            connection.setAutoCommit(false);
            String sql= "insert into goods (name) values (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < 10000; i++) {
                preparedStatement.setString(1,"name_"+i);
                //1.攒sql
                preparedStatement.addBatch();
                if(i%500==0){
                    //2.执行batch
                    preparedStatement.executeBatch();
                    //3.清空batch
                    preparedStatement.clearBatch();
                }
            }
            //提交数据
            connection.commit();
            long end = System.currentTimeMillis();
            /**
             * 插入10000条数据所花时间为  1227
             */
            System.out.println("插入10000条数据所花时间为："+(end-start));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,statement);
        }
    }

}
