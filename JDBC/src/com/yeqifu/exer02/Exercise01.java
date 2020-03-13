package com.yeqifu.exer02;

import com.yeqifu.exer01.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * @Author: 落亦-
 * @Date: 2020/3/13 17:56
 */
public class Exercise01 {

    @Test
    public void insert01(){
        boolean execute = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "insert into customers(name,email,birth) values (?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"安妮海瑟薇");
            preparedStatement.setString(2,"1784525940@qq.com");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parse = simpleDateFormat.parse("1975-2-13");
            preparedStatement.setDate(3,new Date(parse.getTime()));

            execute = preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,preparedStatement);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入名称：");
        String name = scanner.next();
        System.out.println("请输入邮箱：");
        String email = scanner.next();
        System.out.println("请输入生日：");
        String birth = scanner.next();
        String sql = "insert into customers (name,email,birth) values (?,?,?)";
        int update = update(sql, name, email, birth);
        if (update>0){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
    }

    /**
     * 通用的增、删、改操作
     * @param sql
     * @param args
     * @throws Exception
     */
    public static int update(String sql,Object... args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i+1,args[i]);
            }
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,preparedStatement);
        }
        return 0;
    }

}
