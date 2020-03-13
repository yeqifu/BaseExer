package com.yeqifu.exer01.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Author: 落亦-
 * @Date: 2020/3/12 13:47
 */
public class JDBCUtils {
    /**
     * 获取数据库的连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        Connection connection = null;
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
        return connection;
    }

    /**
     * 关闭资源
     * @param connection
     * @param ps
     */
    public static void closeResource(Connection connection, Statement ps){
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

    /**
     * 关闭资源
     * @param connection
     * @param ps
     */
    public static void closeResource(Connection connection, Statement ps,ResultSet set){
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
        try {
            if (set!=null){
                set.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
