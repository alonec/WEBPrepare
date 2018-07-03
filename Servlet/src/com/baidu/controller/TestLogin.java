package com.baidu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 测试Servlet的三种请求转发方式forward、redirect、include
 */
@WebServlet(name = "TestLogin", urlPatterns = "/testLogin")
public class TestLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("gbk");
        response.setCharacterEncoding("gbk");
        response.setContentType("text/html;charset=gbk");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter pw = response.getWriter();
       // pw.write("include包含。");

        if(username.equals("123")&&password.equals("123")){
            //include测试（转发：将当前request和response对象保存，交给指定的url处理。并没有表示页面的跳转，
            // 所以地址栏的地址不会发生改变。）
//            request.getRequestDispatcher("WEB-INF/login/success.html").include(request, response);

            //forward测试（转发，将当前request和response对象保存，交给指定的url处理。
            // 并没有表示页面的跳转，所以地址栏的地址不会发生改变。）
            request.getRequestDispatcher("WEB-INF/login/success.html").forward(request, response);
        }else{
            // （重定向：包含两次浏览器请求，浏览器根据url请求一个新的页面，所有的业务处理都转到下一个页面，
            //  地址栏的地址会变发生改变。）
//            response.sendRedirect("login/fail.html");
            // 重定向是响应的方法。重定向不能访问WEB-INF下的文件。所以fail.html应该放在web下面
            response.sendRedirect(request.getContextPath()+"/fail.html");
            System.out.println(request.getContextPath());
        }
    }
}
