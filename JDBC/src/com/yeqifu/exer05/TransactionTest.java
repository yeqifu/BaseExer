package com.yeqifu.exer05;

import com.yeqifu.exer01.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @Author: 落亦-
 * @Date: 2020/3/15 21:52
 */
public class TransactionTest {

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
            JDBCUtils.closeResource(connection,preparedStatement);
        }
    }
}
