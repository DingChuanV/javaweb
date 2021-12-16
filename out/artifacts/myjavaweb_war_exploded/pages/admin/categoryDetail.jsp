<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>添加分类--管理后台</title>
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

  <form name ="dataFrm" id="dataFrm" action="${action!=null?'category/modified':'/category/add'}" method="post">
    <input value="${category.id}" type="text" style="display:none;" name="id"/>
    <table  width="100%" border="0" cellspacing="5" cellpadding="0">
      <thead>
      <tr><td align="center" colspan="2" class="text_tabledetail2">增加分类</td></tr>
      </thead>
      <tbody>
        <tr >
          <td style="text-align:right;"><label> 分类名称: </label></td>
          <td style="text-align:left;"><input name="name" type="text" value="${category.name}" class="opt_input" id="tname"/></td>
        </tr>
        <tr>
          <td style="text-align:right;"><button type="submit" id="addTopicSubmit" class="page-btn" class="opt_sub" >提交</button></td>
          <td style="text-align:left;"><input type="reset" class="page-btn"  value="重置" class="opt_sub" /></td>
        </tr>
      </tbody>
    </table>
  </form>

</body>
</html>
