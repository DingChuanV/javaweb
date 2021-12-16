<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="../common/common.jsp" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    if (${msg!=null}){
        alert("${msg}");
    }
    function addCategory(){
        window.location="/pages/admin/categoryDetail.jsp";
    }
</script>
<div class="main-content-right">
    <!--即时新闻-->
    <div class="main-text-box">
        <div class="main-text-box-tbg">
            <div class="main-text-box-bbg">
<%--                <form name ="searchForm" id="searchForm" action="${pageContext.request.contextPath}/category/query" method="post">--%>
<%--                    <div>--%>
<%--                        分类标题<input type="text" name="title" id="name" value='${name}'/>--%>
<%--                        <button type="submit" class="page-btn">GO</button>--%>
<%--                        <button type="button" onclick="addCategory();" class="page-btn">增加</button>--%>
<%--                        <input type="hidden" name="currentPageNo" value="1"/>--%>
<%--                        <input type="hidden" name="pageSize" value="10"/>--%>
<%--                        <input type="hidden" name="totalPageCount" value="2"/>--%>
<%--                    </div>--%>
<%--                </form>--%>
<%--                --%>
                <table cellpadding="1" cellspacing="1" class="admin-list">
                    <thead >
                        <tr class="admin-list-head">
                            <th>分类id</th>
                            <th>分类名称</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${categories}" var="cat" varStatus="status">
                            <tr <c:if test="${status.count%2 == 0}">class="admin-list-td-h2"</c:if> >
                                <td> ${cat.id} </td>
                                <td> ${cat.name} </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/category/modified?mid=${cat.id}">修改</a> &nbsp;&nbsp;
                                    <a href="javascript:if(confirm('确认是否删除此新闻？')) location='${pageContext.request.contextPath}/category/deleteById?id=${cat.id}'">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

<%--                <div class="page-bar">--%>
<%--                    <ul class="page-num-ul clearfix">--%>
<%--                        <li>共${pageInfo.totalCount}条记录&nbsp;&nbsp; ${pageInfo.currentPage}/${pageInfo.totalPageCount}页</li>--%>
<%--                        <c:if test="${pageInfo.currentPage > 1}">--%>
<%--                            <a href="${pageContext.request.contextPath}/category/query?currentPageNo=1&title=${title}">首页</a>--%>
<%--                            <a href="${pageContext.request.contextPath}/category/query?currentPageNo=${pageInfo.currentPage-1}&title=${title}">上一页</a>--%>
<%--                        </c:if>--%>
<%--                        <c:if test="${pageInfo.currentPage!=pageInfo.totalPageCount}">--%>
<%--                            <a href="${pageContext.request.contextPath}/category/query?currentPageNo=${pageInfo.currentPage+1}&title=${title}">下一页</a>--%>
<%--                            <a href="${pageContext.request.contextPath}/category/query?currentPageNo=${pageInfo.totalPageCount}&title=${title}">最后一页</a>--%>
<%--                        </c:if>--%>
<%--                    </ul>--%>
<%--                    <span class="page-go-form"><label>跳转至</label>--%>
<%--                 <input type="text" name="inputPage" id="inputPage" class="page-key" />页--%>
<%--                 <button type="button" class="page-btn" onClick='javascript:jump_to()'>GO</button>--%>
<%--                                <script type="text/javascript">--%>
<%--                                    function jump_to() {--%>
<%--                                        let inputPage = document.getElementById("inputPage").value;--%>
<%--                                        window.location.href = "/category/query?currentPageNo="+inputPage+'&title='+'${title}';--%>
<%--                                    }--%>

<%--                                </script>--%>
<%--                </span>--%>
<%--                </div>--%>
            </div>
        </div>
    </div>
</div>