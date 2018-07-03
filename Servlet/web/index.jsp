<%--
  Created by IntelliJ IDEA.
  User: cxwzj
  Date: 2018/7/1
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录页面</title>
  </head>
  <body>
   <%--该action--%>
  <form action="testLogin" method="get">
   user: <input type="text" name="username"/><br/>
    password:<input type="text" name="password"/><br/>
    <button type="submit">登录</button>
  </form>
  </body>
</html>
