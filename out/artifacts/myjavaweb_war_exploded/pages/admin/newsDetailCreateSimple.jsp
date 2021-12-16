<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<link href="<%=request.getContextPath() %>/css/common.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="<%=request.getContextPath() %>/ckeditor/ckeditor.js"> </script>
	</head>
<body>
<form name ="dataFrm" id="dataFrm" action="${action!=null?'/news/modified':'/news/add'}" method="post"  enctype="multipart/form-data">
	<table  width="100%" border="0" cellspacing="5" cellpadding="0">
		<thead>
			<tr>
				<td align="center" colspan="2" class="text_tabledetail2">
					<c:if test="${news==null}"><span>增加新闻</span></c:if>
					<c:if test="${news!=null}"><span>修改新闻</span></c:if>
				</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<input  name="id" value="${news.id}" style="display: none;" type="text"  />
				<td style="text-align:right;" class="text_tabledetail2">分类</td>
				<td style="text-align:left;"> 
				<!-- 列出所有的新闻分类 -->
					<select name="categoryId">

						<option value="1" <c:if test="${news.categoryId==1}">selected</c:if> >国内</option>
	        			<option value="2" <c:if test="${news.categoryId==2}">selected</c:if> >国际</option>
	        			<option value="3" <c:if test="${news.categoryId==3}">selected</c:if> >娱乐</option>
	        			<option value="4" <c:if test="${news.categoryId==4}">selected</c:if>>军事</option>
	        			<option value="5" <c:if test="${news.categoryId==5}">selected</c:if>>财经</option>
	        			<option value="6" <c:if test="${news.categoryId==6}">selected</c:if>>天气</option>
	        		</select>
				</td>
			</tr>
			<tr>
				<td style="text-align:right;" class="text_tabledetail2">标题</td>
				<td style="text-align:left;"><input type="text" name="title" value="${news.title}"/></td>
			</tr>
			<tr>
				<td style="text-align:right;" class="text_tabledetail2">作者</td>
				<td style="text-align:left;"><input type="text" name="author" value="${news.author}"/></td>
			</tr>
			
			<tr>
				<td style="text-align:right;" class="text_tabledetail2">摘要</td>
				<td style="text-align:left;"><textarea id="summary" name="summary" rows="8" cols="50" >${news.summary}</textarea></td>
			</tr>
			<tr>
				<td style="text-align:right;" class="text_tabledetail2">内容</td>
				<td style="text-align:left;">
				<div id="xToolbar"></div>
				<textarea id="newscontent" name="newscontent" rows="8" cols="30" class="ckeditor">${news.content}</textarea></td>
			</tr>
			<tr>
				<td style="text-align:right;" class="text_tabledetail2">上传图片 </td>
				<td style="text-align:left;"><input type="file" name="picPath" value="${news.picpath}"/></td>
			</tr>
			<tr>
				<td style="text-align:center;" colspan="2">
					<button type="submit" class="page-btn" name="save">保存</button>
					<button type="button" class="page-btn" name="return" onclick="javascript:location.href='/news/query'">返回</button>
				</td>
			</tr>
		</tbody>
	</table>
</form>
<script>
	CKEDITOR.replace("newscontent");
</script>
</body>
</html>