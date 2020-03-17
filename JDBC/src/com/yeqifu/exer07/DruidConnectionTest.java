package com.yeqifu.exer07;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: 落亦-
 * @Date: 2020/3/17 13:32
 */
public class DruidConnectionTest {

    @Test
    public void druidConnection() throws Exception {
        Properties properties = new Properties();

        InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");

        properties.load(resourceAsStream);

        DataSource source = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = source.getConnection();
        System.out.println(connection);
    }

}
