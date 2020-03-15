package com.yeqifu.exer01.preparedStatement;

import com.yeqifu.exer01.utils.JDBCUtils;
import org.junit.Test;

import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * @Author: 落亦-
 * @Date: 2020/3/12 12:53
 */
public class PreparedStatementTest {

    /**
     * 插入一条数据
     */
    @Test
    public void preparedStatement(){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //读取配置文件
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

            Properties properties = new Properties();
            properties.load(is);

            String driverClass = properties.getProperty("driverClass");
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");

            //注册驱动
            Class.forName(driverClass);
            //获取连接
            connection = DriverManager.getConnection(url, user, password);

            String sql = "insert into blog_user(name,password,age,comment,birthday) values (?,?,?,?,?)";

            ps = connection.prepareStatement(sql);
            ps.setString(1,"斯嘉丽");
            ps.setString(2,"123456");
            ps.setInt(3,35);
            ps.setString(4,"黑寡妇");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("1975-2-13");
            ps.setDate(5,new Date(date.getTime()));
            boolean execute = ps.execute();
            if (true==true){
                System.out.println("插入成功");
            }else {
                System.out.println("插入失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            try {
                if (ps!=null){
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 更新一条记录
     */
    @Test
    public void testUpdate(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //获取连接
            connection = JDBCUtils.getConnection();
            //预编译sql语句，返回PrepareStatement实例
            String sql = "update blog_user set name = ? where id = ?";
            preparedStatement = connection.prepareStatement(sql);
            //填充占位符
            preparedStatement.setString(1,"伊丽莎白奥尔森");
            preparedStatement.setInt(2,2);
            //执行sql
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            JDBCUtils.closeResource(connection,preparedStatement);
        }
    }

    /**
     * 通用的增、删、改操作
     * @param sql
     * @param args
     * @throws Exception
     */
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

    @Test
    public void testCommentUpdate(){
        /*String sql = "update blog_user set name = ? where id = ?";
        update(sql,"斯嘉丽约翰逊",3);*/


        /**
         * order为关键字    如果表名为关键字  要加上  `  `
         */
        String sql = "update `order` set name = ? where id = ?";
        update(sql,"DDD",1);

    }

    /**
     * 查询数据表中的一条数据
     * @throws Exception
     */
    @Test
    public void testSelect() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from blog_user where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,1);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            Integer id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");
            Integer age = resultSet.getInt("age");
            Date birthday = resultSet.getDate("birthday");
            String comment = resultSet.getString("comment");
            User user = new User(id,name,password,age,comment,birthday);
            System.out.println(user);
        }
    }


}
