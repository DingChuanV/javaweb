<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%@ page import="java.time.format.DateTimeFormatterBuilder" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/9/7 0007
  Time: 上午 8:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>用户信息</title>
  <%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");

    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String email = request.getParameter("email");
    String[] hobbys = request.getParameterValues("hobby");


    if (username != null && "admin".equals(username)) {
      Cookie cookie = new Cookie("username", username);
      response.addCookie(cookie);
      response.sendRedirect("userCreate.jsp");
    } else {
      session.setAttribute("username", username);
      session.setAttribute("password", password);

      response.sendRedirect("fail.jsp");
    }

  %>
</head>
<body>
<%--<ul>--%>

<%--  <li>用户名：<%=name%></li>--%>
<%--  <li>密码：<%=password%></li>--%>
<%--  <li>邮箱：<%=email%></li>--%>
<%--  <ul>--%>
<%--    <%--%>
<%--      if(hobbys!=null&&hobbys.length!=0){--%>
<%--        for(String hobby:hobbys){--%>


<%--    %>--%>
<%--    <li>爱好：<%=hobby%></li>--%>
<%--    <%--%>
<%--      }--%>
<%--    }--%>
<%--    %>--%>

<%--  </ul>--%>
<%--</ul>--%>
</body>
</html>

