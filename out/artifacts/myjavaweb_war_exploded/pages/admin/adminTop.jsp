<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header">
    <div class="main-top">
        <div class="logo"><a href=""><span>新闻大视野</span></a></div>
        <div class="nav">
            <ul class="clearfix">
                <li><a href="<%=request.getContextPath()%>/index.jsp" target="_parent">首页</a></li>
                <li><a href="#">国内</a></li>
                <li><a href="#">国际</a></li>
                <li><a href="#">娱乐</a></li>
                <li><a href="#">军事</a></li>
            </ul>
        </div>
    </div>
    <!--banner-->
    <div class="main-banner"><img src="<%=request.getContextPath()%>/images/banner.png" />
    </div>
    <!--管理工具栏-->
    <div class="admin-bar"><span class="fr"><a href="${pageContext.request.contextPath}/user/logout">退出账户</a></span>管理员：<c:if test="${user!=null}">${user.getUsername()}</c:if>
    </div>
</div>