package com.baidu.context;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletContext02", urlPatterns ="servletContext02" )
public class ServletContext02 extends HttpServlet {
    @Override
    // 注意这里只能用void init()。否则
    public void init() throws ServletException {
        // init 方法只执行一次，所以在此定义count计数
        int count = 0;
        // 获得ServletContext对象
        ServletContext context = this.getServletContext();
        context.setAttribute("count",count);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获得ServletContext对象
        ServletContext context = this.getServletContext();
        //  测试ServletContext的作用域.在ServletContext1中调用
        context.setAttribute("name","zhangsan");
        // 测试登录计数
        int count = (int)context.getAttribute("count");
        count++;
        context.setAttribute("count",count);
        System.out.println("你是第"+count+"位访问的人！");
    }
}
