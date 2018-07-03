package com.baidu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *   整个项目起点控制器
 *   注解配置Tomcat不能低于7.0 8.0 9.0
 */
// 用注解配置Servlet（name和urlPatterns和文件配置中的一样）
@WebServlet(name = "homeController",urlPatterns ="/homeController" )
public class HomeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do POST");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/index.html").forward(request,response);
        System.out.println("do GET");
    }
}
