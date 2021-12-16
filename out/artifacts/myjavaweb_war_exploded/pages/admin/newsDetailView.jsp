<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.uin.entity.News"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.uin.service.NewsService" %>
<%@ page import="com.uin.service.impl.NewsServiceImpl" %>
<%@include file="../common/common.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>`
<html>
	<head>
		<link href="<%=request.getContextPath() %>/css/common.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=request.getContextPath() %>/ckeditor/ckeditor.js"> </script>
	</head>
<body>
<%--<%--%>
<%--	int id = Integer.parseInt(request.getParameter("id"));--%>
<%--	News news = newsService.getNewsById(id);--%>

<%--	--%>
<%-- %>--%>
<div class="main-content-right">
      
        <div class="main-text-box">
      		<div class="main-text-box-tbg">
                <div class="main-text-box-bbg">
                    <div class="article-box">
                    	<!--新闻的标题-->
                        <h1>${news.getTitle()}</h1>
                        <div class="source-bar">发布者：${news.getAuthor()} 分类：新闻信息 更新时间：${news.getCreatedate() }</div>
                        <div class="article-content">
                            <span class="article-summary"><b>摘要：${news.getSummary()}</b></span>

<%--                         	<%--%>
<%--                         		if(news.getPicpath() == null || news.getPicpath().equals("")){--%>
<%--                         	 %>--%>
							<c:if test="${news.getPicpath() == null || news.getPicpath().equals('')}">
								新闻图片：暂无<br/>
							</c:if>
                         	 <c:if test="${!(news.getPicpath() == null || news.getPicpath().equals(''))}">
								 <img src="<%=request.getContextPath() %>/upload/${news.getPicpath() }"/><br/>
							 </c:if>
                         	${news.getContent()}
                         </div>
                    </div>
                </div>
            </div>
        </div>
        
    </div>
</body>
</html>