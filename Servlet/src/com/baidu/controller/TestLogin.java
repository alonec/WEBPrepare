package com.baidu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试Servlet的三种请求转发方式forward、redirect、include
 */
public class TestLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应头：解决中文乱码《告诉客户端要用UTF-8格式的数码表，同时服务器也会自动更改格式》
        response.setContentType("UTF-8");
        request.setCharacterEncoding("UTF-8");

        // 1.通过request获得请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+password);
        // 2.进行数据库验证
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // 2.1.获得连接
            conn = DBUtils.getConnection();
            // 2.2.获得语句执行者
            statement = conn.createStatement();
            // 3.3.执行语句
            statement.executeQuery("select * from customer where username = "+username+" and password="+password);
            // 3.4 获得查询结果
            resultSet = statement.getResultSet();
            // 3.登录成功，显示成功页面
            // 4.登录失败，显示提示信息
            if(resultSet.next()){
                response.sendRedirect(request.getContextPath()+"success.html");
            }else{
                response.sendRedirect(request.getContextPath()+"fail.html");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // 5.关闭资源
            DBUtils.release(conn,statement,resultSet);
        }


        System.out.println("Do POST");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
