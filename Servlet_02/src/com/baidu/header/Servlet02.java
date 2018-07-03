package com.baidu.header;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 测试重定向
 */
@WebServlet(name = "Servlet02",urlPatterns = "/servlet02")
public class Servlet02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Servlet02中响应不了， 告知客户端去重定向到servlet2
       /* // 方式一：
        //1、设置状态码302
        response.setStatus(302);
        //2、设置响应头Location
        response.setHeader("location","/Servlet_02/servlet01");*/

        // 方式二：使用封装好的方法
        response.sendRedirect("/Servlet_02/servlet01");
    }
}
