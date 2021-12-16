<%@ page import="com.uin.entity.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="../common/common.jsp" %>
<script src="http://lib.sinaapp.com/js/jquery/1.7.2/jquery.min.js">
</script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    var msg = '${msg}';
    if (msg!=null&&msg!==''){
        alert(msg);
    };

   function addCategory(){
       window.location.href = "/pages/admin/userDetail.jsp";
   }
</script>
<div class="main-content-right">
    <!--即时新闻-->
    <div class="main-text-box">
        <div class="main-text-box-tbg">
            <div class="main-text-box-bbg">
                <form name ="searchForm" id="searchForm" action="${pageContext.request.contextPath}/user/query" method="post">
                    <div>
                        <select id="ctype">
                            <option value="id" selected>用户id</option>
                            <option value="username">用户名</option>
                            <option value="email">用户邮箱</option>
                            <option value="usertype">用户类型</option>
                        </select>
                        <input type="text" name="id" id="ip_con" value=''/>
                        <button type="submit" class="page-btn">GO</button>
                        <button type="button" onclick="addCategory();" class="page-btn">增加</button>
                        <input type="hidden" name="currentPageNo" value="1"/>
                        <input type="hidden" name="pageSize" value="10"/>
                        <input type="hidden" name="totalPageCount" value="2"/>
                    </div>
                </form>
                <script>
                    $('#ctype').on('change',function(){
                        //  获取select中选中option的文本值
                        var text =$(this).find("option:selected").text()
                        //  获取select中选中option的value值
                        var opval=this.options[this.selectedIndex].value;
                        $('#ip_con').attr("name", opval);
                        console.log(opval+'-----'+text)

                    })
                </script>


                <table cellpadding="1" cellspacing="1" class="admin-list">
                    <thead >
                        <tr class="admin-list-head">
                            <th>用户id</th>
                            <th>用户名称</th>
                            <th>用户email</th>
                            <th>用户类型</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${pageInfo.data}" var="user" varStatus="status">
                            <tr <c:if test="${status.count%2 == 0}">class="admin-list-td-h2"</c:if> id="${status.index}" >
                                <td> ${user.id} </td>
                                <td> ${user.username} </td>
                                <td> ${user.email} </td>
                                <td> ${user.usertype == 0 ? "管理员" : "普通用户"} </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/user/modified?mid=${user.id}">修改</a> &nbsp;&nbsp;
                                    <a href="javascript:if(confirm('确认是否删除此新闻？')) location='${pageContext.request.contextPath}/user/deleteById?id=${user.id}'">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <div class="page-bar">
                    <ul class="page-num-ul clearfix">
                        <li>共${pageInfo.totalCount}条记录&nbsp;&nbsp; ${pageInfo.currentPage}/${pageInfo.totalPageCount}页</li>
                        <c:if test="${pageInfo.currentPage > 1}">
                            <a href="${pageContext.request.contextPath}/user/query?currentPageNo=1">首页</a>
                            <a href="${pageContext.request.contextPath}/user/query?currentPageNo=${pageInfo.currentPage-1}">上一页</a>
                        </c:if>
                        <c:if test="${pageInfo.currentPage!=pageInfo.totalPageCount}">
                            <a href="${pageContext.request.contextPath}/user/query?currentPageNo=${pageInfo.currentPage+1}">下一页</a>
                            <a href="${pageContext.request.contextPath}/user/query?currentPageNo=${pageInfo.totalPageCount}">最后一页</a>
                        </c:if>
                    </ul>
                    <span class="page-go-form"><label>跳转至</label>
                 <input type="text" name="inputPage" id="inputPage" class="page-key" />页
                 <button type="button" class="page-btn" onClick='javascript:jump_to()'>GO</button>
                                <script type="text/javascript">
                                    function jump_to() {
                                        let inputPage = document.getElementById("inputPage").value;
                                        window.location.href = "/user/query?currentPageNo="+inputPage;
                                    }

                                </script>
                </span>
                </div>
            </div>
        </div>
    </div>
</div>