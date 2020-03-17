package com.yeqifu.exer07;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: 落亦-
 * @Date: 2020/3/17 9:39
 */
public class C3p0ConnectionTest {

    /**
     * 方式一：
     * @throws Exception
     */
    @Test
    public void testConnection() throws Exception {
        //创建数据库连接池
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/jdbc?serverTimezone=UTC");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("123456");
        //设置初始时数据库连接池中的连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //获取数据库连接
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println(connection);

        //销毁数据库连接池
        DataSources.destroy(comboPooledDataSource);
    }

    /**
     * 使用配置文件
     */
    @Test
    public void testConnection2() throws Exception {
        ComboPooledDataSource cpds = new ComboPooledDataSource("c3p0");
        Connection conn = cpds.getConnection();
        System.out.println(conn);
    }


}
