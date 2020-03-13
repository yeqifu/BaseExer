package com.yeqifu.exer02;

import com.yeqifu.exer01.utils.JDBCUtils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.Scanner;

/**
 * @Author: 落亦-
 * @Date: 2020/3/13 21:48
 */
public class Exercise03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择你要输入的类型：");
        System.out.println("a:准考证号");
        System.out.println("b:身份证号");
        String type = scanner.next();

        if ("b".equals(type)){
            System.out.println("请输入身份证号：");
            String idCard = scanner.next();
            ExamStudent examStudent = testSearchForIdCard(idCard);
            if (null!=examStudent){
                System.out.println("流水号："+examStudent.getFlowId());
                System.out.println("四级/六级："+examStudent.getType());
                System.out.println("身份证号："+examStudent.getIdCard());
                System.out.println("准考证号："+examStudent.getExamCard());
                System.out.println("学生姓名："+examStudent.getStudentName());
                System.out.println("区域："+examStudent.getLocation());
                System.out.println("成绩："+examStudent.getGrade());
            }else {
                System.out.println("查无此人！请重新进入程序！");
            }
        }else if ("a".equals(type)){
            System.out.println("请输入准考证号：");
            String examCard = scanner.next();
            ExamStudent examStudent = testSearchForExamCard(examCard);
            if (null!=examStudent){
                System.out.println("流水号："+examStudent.getFlowId());
                System.out.println("四级/六级："+examStudent.getType());
                System.out.println("身份证号："+examStudent.getIdCard());
                System.out.println("准考证号："+examStudent.getExamCard());
                System.out.println("学生姓名："+examStudent.getStudentName());
                System.out.println("区域："+examStudent.getLocation());
                System.out.println("成绩："+examStudent.getGrade());
            }else {
                System.out.println("查无此人！请重新进入程序！");
            }
        } else{
            System.out.println("您的输入有误，请重新进入程序！");
        }
    }

    /**
     * 根据身份证号查询学生
     * @param idCard
     * @return
     */
    public static ExamStudent testSearchForIdCard(String idCard){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select FlowID flowId,type type,IDCard idCard,ExamCard examCard,StudentName studentName,Location location,Grade grade from examstudent where IDCard = ?";

            //声明预处理语句
            preparedStatement = connection.prepareStatement(sql);

            //填充占位符
            preparedStatement.setObject(1,idCard);

            //执行sql,获得结果集
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Integer flowId = (Integer) resultSet.getObject(1);
                Integer types = (Integer) resultSet.getObject(2);
                String idCards = (String) resultSet.getObject(3);
                String examCards = (String) resultSet.getObject(4);
                String studentName = (String) resultSet.getObject(5);
                String location = (String) resultSet.getObject(6);
                Integer grade = (Integer) resultSet.getObject(7);
                ExamStudent examStudent = new ExamStudent(flowId,types,idCards,examCards,studentName,location,grade);
                return examStudent;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }
        return null;
    }

    public static ExamStudent testSearchForExamCard(String examCard){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select FlowID flowId,type type,IDCard idCard,ExamCard examCard,StudentName studentName,Location location,Grade grade from examstudent where examCard = ?";

            //声明预处理语句
            preparedStatement = connection.prepareStatement(sql);

            //填充占位符
            preparedStatement.setObject(1,examCard);

            //执行sql,获得结果集
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Integer flowId = (Integer) resultSet.getObject(1);
                Integer types = (Integer) resultSet.getObject(2);
                String idCard = (String) resultSet.getObject(3);
                String examCards = (String) resultSet.getObject(4);
                String studentName = (String) resultSet.getObject(5);
                String location = (String) resultSet.getObject(6);
                Integer grade = (Integer) resultSet.getObject(7);
                ExamStudent examStudent = new ExamStudent(flowId,types,idCard,examCards,studentName,location,grade);
                return examStudent;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
        }
        return null;
    }

}
