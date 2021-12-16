<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
<!-- 让超链接后的页面在页面的右下部分显示 -->
<base target="rightFrame"/>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css"/>
<style type="text/css">
<!--

-->
</style>
</head>

<body>
<!--页面顶部-->
<jsp:include page="adminTop.jsp"></jsp:include>
<!--页面中部-->
<div id="content" class="main-content clearfix">
	<jsp:include page="adminSidebar.jsp"></jsp:include>
	<jsp:include page="adminRightbar.jsp"></jsp:include>

</div>
<!--页面底部-->
<jsp:include page="adminBottom.jsp"></jsp:include>
</body>
</html>