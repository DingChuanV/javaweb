<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/9/9
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String username = (String)session.getAttribute("username");
    %>
    <%=username%>
</body>
</html>
