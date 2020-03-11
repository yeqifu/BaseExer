package com.yeqifu.exer01.connection;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: 落亦-
 * @Date: 2020/3/11 18:07
 */
public class ConnectionTest {
    /**
     * 方式一
     * @throws SQLException
     */
    @Test
    public void connectTest01() throws SQLException {
        //获取Driver实现类的对象
        Driver driver = new com.mysql.cj.jdbc.Driver();
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","123456");
        /**
         * jdbc:  协议
         * mysql: 子协议
         * 127.0.0.1:3306/jdbc?serverTimezone=UTC 子名称
         * 主机(IP地址) 端口号 数据库名称  UTC为全球标准时间   GMT为北京时区也就是东八区    东八区领先UTC8个小时
         */
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc?serverTimezone=UTC";
        Connection connection = driver.connect(url,info);
        System.out.println(connection);
    }

    /**
     * 方式二：不出现第三方的API，移植性更好
     * @throws Exception
     */
    @Test
    public void connectionTest02() throws Exception {
        //通过反射的方式获取Driver实现类的对象
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc?serverTimezone=UTC";
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","123456");
        Connection connect = driver.connect(url, info);
        System.out.println(connect);
    }

    /**
     * 方式三：使用DriverManager替换Driver
     */
    @Test
    public void connectionTest03() throws Exception {
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        //注册驱动
        DriverManager.registerDriver(driver);
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc?serverTimezone=UTC";
        String user = "root";
        String password = "123456";
        //获得连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }


    /**
     * 方式四：只是显示的加载驱动，不用显示的注册驱动
     */
    @Test
    public void connectionTest04() throws Exception {
        //加载驱动
        Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
        /*Driver driver = (Driver) clazz.newInstance();
        //注册驱动
        DriverManager.registerDriver(driver);*/

        String url = "jdbc:mysql://127.0.0.1:3306/jdbc?serverTimezone=UTC";
        String user = "root";
        String password = "123456";

        //获得连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    /**
     * 方式五：通过读取配置文件的方式获得连接
     * 此种方式的好处：
     * 1.实现了数据与代码的分离，解耦
     * 2.如果修改了配置信息，可以避免程序重新打包
     */
    @Test
    public void connectionTest05() throws Exception{
        //通过流的方式读取配置文件
        //InputStream inputStream = new FileInputStream("src/jdbc.properties");

        //1.通过反射的方式读取配置文件中的信息
        InputStream inputStream = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties properties = new Properties();
        properties.load(inputStream);

        String driver = (String) properties.get("driver");
        String url = (String) properties.get("url");
        String user = (String) properties.get("user");
        String password = (String) properties.get("password");

        //2.加载驱动
        Class.forName(driver);
        //3.获取连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }


}






















