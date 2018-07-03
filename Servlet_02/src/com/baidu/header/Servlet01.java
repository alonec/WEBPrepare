package com.baidu.header;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 设置响应头:  setHeader()
 */
@WebServlet(name = "Servlet01",urlPatterns = "/servlet01")
public class Servlet01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 添加响应头信息:添加多个
        response.addHeader("name","zhangsan");
        response.addHeader("name","lisi");
        // 设置响应头信息：设置，只会更改
        response.setHeader("sex","male");
        response.setHeader("sex","female");

    }
}
