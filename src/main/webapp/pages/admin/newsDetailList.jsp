<%@page import="com.uin.entity.News"%>
<%@ page import="com.uin.util.PageHelper" %>
<%@ page import="com.uin.entity.NewsCriteria" %>
<%@ page import="java.util.List" %>
<%@ page import="org.apache.commons.lang3.StringUtils" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>`
<%--动态包含无法使用，页面报错，newsService无法使用 <jsp:include page="../common/common.jsp" /> --%>
<%@include file="../common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>无标题文档</title>
    <style type="text/css">
    </style>
    <script>
        if (${msg!=null}){
            alert("${msg}");
        }
        function addNews(){
            window.location="/pages/admin/newsDetailCreateSimple.jsp";
        }
    </script>
</head>
    <body>
        <!--主体-->
        <div class="main-content-right">
            <!--即时新闻-->
            <div class="main-text-box">
                <div class="main-text-box-tbg">
                    <div class="main-text-box-bbg">
                        <form name ="searchForm" id="searchForm" action="${pageContext.request.contextPath}/news/query" method="post">
                            <div>
                                新闻分类：
                                <select name="categoryId">
                                    <option value="0">全部</option>

                                    <option value='1' >国内</option>

                                    <option value='2' >国际</option>

                                    <option value='3' >娱乐</option>

                                    <option value='4' >军事</option>

                                    <option value='5' >财经</option>

                                    <option value='6' >天气</option>

                                </select>
                                新闻标题<input type="text" name="title" id="title" value='${title}'/>
                                <button type="submit" class="page-btn">GO</button>
                                <button type="button" onclick="addNews();" class="page-btn">增加</button>
                                <input type="hidden" name="currentPageNo" value="1"/>
                                <input type="hidden" name="pageSize" value="10"/>
                                <input type="hidden" name="totalPageCount" value="2"/>
                            </div>
                        </form>
                        <table cellpadding="1" cellspacing="1" class="admin-list">
                            <thead >
                            <tr class="admin-list-head">
                                <th>新闻标题</th>
                                <th>作者</th>
                                <th>时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="news" items="${pageInfo.data}" varStatus="status" >
                                <tr id="${status.index}" <c:if test="${status.index%2==0}">class="admin-list-td-h2"</c:if> >
                                    <td><a href='${pageContext.request.contextPath}/news/queryById?id=${news.id}'>${news.title}</a></td>
                                    <td>${news.author}</td>
                                    <td>${news.createdate}</td>
                                    <td><a href='${pageContext.request.contextPath}/news/modified?mid=${news.id}'>修改</a>
                                        <a href="javascript:if(confirm('确认是否删除此新闻？')) location='/news/delById?id=${news.id}'">删除</a>
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                        <div class="page-bar">
                            <ul class="page-num-ul clearfix">
                                <li>共${pageInfo.totalCount}条记录&nbsp;&nbsp; ${pageInfo.currentPage}/${pageInfo.totalPageCount}页</li>
                                <c:if test="${pageInfo.currentPage > 1}">
                                    <a href="${pageContext.request.contextPath}/news/query?currentPageNo=1&title=${title}">首页</a>
                                    <a href="${pageContext.request.contextPath}/news/query?currentPageNo=${pageInfo.currentPage-1}&title=${title}">上一页</a>
                                </c:if>
                                <c:if test="${pageInfo.currentPage!=pageInfo.totalPageCount}">
                                    <a href="${pageContext.request.contextPath}/news/query?currentPageNo=${pageInfo.currentPage+1}&title=${title}">下一页</a>
                                    <a href="${pageContext.request.contextPath}/news/query?currentPageNo=${pageInfo.totalPageCount}&title=${title}">最后一页</a>
                                </c:if>
                            </ul>
                            <span class="page-go-form"><label>跳转至</label>
                 <input type="text" name="inputPage" id="inputPage" class="page-key" />页
                 <button type="button" class="page-btn" onClick='javascript:jump_to()'>GO</button>
                                <script type="text/javascript">
                                    function jump_to() {
                                        let inputPage = document.getElementById("inputPage").value;
                                        window.location.href = "/news/query?currentPageNo="+inputPage+'&title='+'${title}';
                                    }

                                </script>
                </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>