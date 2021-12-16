<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/11/2
  Time: 8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String userename = "admin";

    request.setAttribute("username", userename);
    request.setAttribute("student.name", "张三");
    ArrayList<Object> list = new ArrayList<>();

    list.add("北京洪水");
    list.add("热火夺冠");

    request.setAttribute("list", list);
%>

${username}<br/>
${requestScope["student.name"]}<br>
${list[1]}<br>

</body>
</html>
