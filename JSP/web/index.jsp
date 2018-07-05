<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

    <%--  <%! java代码%> ---- 会被翻译成servlet的成员的内容--%>
    <%!
      int j = 0;
    %>
    <%--  <%java代码%> ----- 内部的java代码翻译到service方法的内部 --%>
    <%
      // java注释
      for(int i=0; i<10; ++i){
         System.out.println(i);
    }%>
    <!-- HTML注释HTML注释-->
    <%--  <%=java变量或表达式> ----- 会被翻译成service方法内部out.print() --%>
    <%= "xxxxxxxxxxxxxxxxxxx"%>

    aaaaaaaaaaa
    <%
    %>
    <%="dddddddddddddddddd"%>
  </body>
</html>
