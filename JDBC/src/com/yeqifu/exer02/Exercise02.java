package com.yeqifu.exer02;

import com.yeqifu.exer01.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * @Author: 落亦-
 * @Date: 2020/3/13 19:04
 */
public class Exercise02 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type:");
        String type = scanner.next();
        System.out.println("IDCard:");
        String idCard = scanner.next();
        System.out.println("ExamCard:");
        String examCard = scanner.next();
        System.out.println("StudentName:");
        String studentName = scanner.next();
        System.out.println("Location");
        String location = scanner.next();
        System.out.println("Grade");
        String grade = scanner.next();
        String sql = "insert into examStudent (type,idCard,examCard,studentName,location,grade) values (?,?,?,?,?,?)";
        int update = update(sql, type, idCard,examCard,studentName,location,grade);
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
