package com.baidu.context;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletContext01")
public class ServletContext01 extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do POST");

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 通过this获得 ServletContext对象
        ServletContext servletContext = this.getServletContext();
        // 1. 获得web应用全局的初始化参数
        String initParameter = servletContext.getInitParameter("driver");
        System.out.println(initParameter);

        //2. 获得web应用中任何资源的绝对路径（重要 重要 重要）获得a,b,c,d.txt
        // 2.1 获得b.txt
        String path_B = servletContext.getRealPath("b.txt");// 相对路径：相对于web的路径（Tomcat中webapps下的web下的目录）
        System.out.println(path_B);
        // 2.2 获得c.txt
        String path_C = servletContext.getRealPath("WEB-INF/c.txt");
        System.out.println(path_C);
        // 2.3 获得d.txt
        String path_D = servletContext.getRealPath("WEB-INF/lib/d.txt");
        System.out.println(path_D);
        // 2.4 获得a.txt
        String path_A = servletContext.getRealPath("classes/a.txt");
        System.out.println(path_A);

        // 3. ServletContext是一个域对象（重要 重要 重要）
        String name = (String)servletContext.getAttribute("name");
        System.out.println(name);

            //ServletContext2中演示记录登录人次
        System.out.println("do GET");
    }
}
