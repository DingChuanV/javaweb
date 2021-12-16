<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>添加用户--管理后台</title>
  <%@include file="../common/common.jsp" %>
  <script type="text/javascript">
	 function check(){
		var tname = document.getElementById("tname");

		if(tname.value == ""){
			alert("请输入主题名称！！");
			tname.focus();
			return false;
		}		
		return true;
	}
  </script>
</head>
<body>

  <form name ="dataFrm" id="dataFrm" action="${action!=null?'/user/modified':'/user/add'}" method="post">
    <c:if test="${requestScope.user.id!=null}"><input  name="id" value="${requestScope.user.getId()}" style="display: none;" type="text" /></c:if>
    <table  width="100%" border="0" cellspacing="5" cellpadding="0">
      <thead>
      <tr><td align="center" colspan="2" class="text_tabledetail2">增加用户</td></tr>
      </thead>
      <tbody>
        <tr >
          <td style="text-align:right;"><label> 用户名称: </label></td>
          <td style="text-align:left;"><input name="username" type="text" value="${requestScope.user.getUsername()}" class="opt_input" id="name"/></td>
        </tr>
        <tr >
          <td style="text-align:right;"><label> 用户密码: </label></td>
          <td style="text-align:left;"><input name="password" type="text" value="${requestScope.user.getPassword()}" class="opt_input" id="password"/></td>
        </tr>
        <tr >
          <td style="text-align:right;"><label> 确认密码: </label></td>
          <td style="text-align:left;"><input name="con_password" type="text" value="${requestScope.user.getPassword()}" class="opt_input" id="confirm_passsword"/></td>
        </tr>
        <tr >
          <td style="text-align:right;"><label> Email: </label></td>
          <td style="text-align:left;"><input name="email" type="text" class="opt_input" value="${requestScope.user.getEmail()}" id="email"/></td>
        </tr>
        <tr >
          <td style="text-align:right;"><label> 用户类型: </label></td>
          <td style="text-align:left;">
            <select name="usertype">
              <option value="0" <c:if test="${requestScope.user.getUsertype()==0}">selected</c:if> >管理员</option>
              <option value="1" <c:if test="${requestScope.user.getUsertype()==1}">selected</c:if> >普通用户</option>
            </select>
          </td>
        </tr>

        <tr>
          <td style="text-align:right;"><button type="submit" id="addTopicSubmit" class="page-btn"  class="opt_sub">提交</button></td>
          <c:if test="${requestScope.user==null}"><td style="text-align:left;"><input type="reset" class="page-btn"  value="重置" class="opt_sub" /></td></c:if>
        </tr>
      </tbody>
    </table>
  </form>

</body>
</html>
