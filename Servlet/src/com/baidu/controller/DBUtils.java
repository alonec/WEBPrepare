package com.baidu.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @Auther: chenxin
 * @Date: 2018/7/4 19:40
 * @Description:
 */
public class DBUtils {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {

        InputStream in = null;

        try {
            // 1.加载properties文件，获得InputStream流
            in = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 2.使用properties处理流
            Properties properties = new Properties();
            properties.load(in);
            // 3.根据key获得需要的值
           driver = properties.getProperty("driver");
           url = properties.getProperty("url");
           username = properties.getProperty("username");
           password = properties.getProperty("password");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得连接
     * @return
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            // 1.加载驱动
            Class.forName(driver);
            // 2.获得连接
            conn = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    /**
     * 功能描述: 关闭资源
     */
    public static void release(Connection conn, Statement statement, ResultSet resultSet){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if(statement != null){
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }finally {
                        if(conn != null){
                            try {
                                conn.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }

    }

}