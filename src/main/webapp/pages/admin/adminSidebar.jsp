<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="main-content-left">
	<!--新闻管理-->
	<div class="class-box">
	    <div class="class-box-header">
	        <h3>新闻管理</h3>
	    </div>
	    <div class="class-box-content">
	        <ul>
	            <li><a href="${pageContext.request.contextPath}/news/query">新闻管理</a></li>
	            <li class="clear-bottom-line"><a href="javascript:void(0);">最新新闻</a></li>
	        </ul>
	    </div>
	</div>
    <!--主题管理-->
    <div class="class-box">
        <div class="class-box-header">
            <h3>分类管理</h3>
        </div>
        <div class="class-box-content">
            <ul>
                <li><a href="${pageContext.request.contextPath}/category/query">分类管理</a></li>
                <li class="clear-bottom-line"><a href="${pageContext.request.contextPath}/pages/admin/categoryDetail.jsp">添加分类</a></li>
            </ul>
        </div>
    </div>
    <!--账户管理-->
    <div class="class-box">
        <div class="class-box-header">
            <h3>用户管理</h3>
        </div>
        <div class="class-box-content">
            <ul>
                <li><a href="${pageContext.request.contextPath}/user/query">用户管理</a></li>
                <li class="clear-bottom-line"><a href="${pageContext.request.contextPath}/pages/admin/userDetail.jsp">添加用户</a></li>
            </ul>
        </div>
    </div>
        <!--//-->
    </div>