package com.yeqifu.exer03;

import com.yeqifu.exer01.utils.JDBCUtils;
import org.junit.Test;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * @Author: 落亦-
 * @Date: 2020/3/14 21:21
 */
public class InsertBlob {

    /**
     * 插入Blob字段
     */
    @Test
    public void insertTest(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "insert into customers (name,email,birth,photo) values (?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"Scarlett Johnson");
            preparedStatement.setString(2,"15279230588@qq.com");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parse = simpleDateFormat.parse("1975-2-13");
            preparedStatement.setDate(3,new Date(parse.getTime()));
            InputStream inputStream = new FileInputStream(new File("Scarlett_Johansson.jpg"));
            preparedStatement.setBlob(4,inputStream);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,preparedStatement);
        }
    }

    /**
     * 读取blob类型的字段
     * @throws Exception
     */
    @Test
    public void queryTest() throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        FileOutputStream fileOutputStream = null;
        InputStream photo = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select * from customers where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,6);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Date birth = resultSet.getDate("birth");

                photo = resultSet.getBinaryStream("photo");
            }

            fileOutputStream = new FileOutputStream("Scarlett_Johansson1.jpg");
            byte[] bytes = new byte[1024];
            int len;
            while ((len=photo.read(bytes))!= -1){
                fileOutputStream.write(bytes,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection,preparedStatement,resultSet);
            if(photo!=null){
                photo.close();
            }
            if (fileOutputStream!=null) {
                fileOutputStream.close();
            }
        }
    }

}
