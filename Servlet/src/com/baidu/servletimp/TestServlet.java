package com.baidu.servletimp;

import javax.servlet.*;
import java.io.IOException;

/**
 * 实现HttpServlet类，并重写doGet和doPost方法
 */
public class TestServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init Running.....");
        // 得到servlet的命名空间name
        String servletName = servletConfig.getServletName();
        System.out.println(servletName);

        // 根据init的命名空间的名称得到配置文件的value值
        String initParameter = servletConfig.getInitParameter("namespace");
        System.out.println(initParameter);

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        // 设置编码格式: 必须放在第一行
        servletRequest.setCharacterEncoding("UTF-8");

        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        System.out.println("service Running.....");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy Running.....");

    }
}
