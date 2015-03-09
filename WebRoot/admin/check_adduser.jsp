<%@ page language="java"
	import="java.util.*,com.core.*,com.dao.*,com.model.*"
	pageEncoding="gbk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
if (!Crazyadept.UserIsOK(session, FinalConstants.STATUS_ADMIN))
		return;
	/*String name=ParamUtils.getRequestString(request,"name");
	String uid=ParamUtils.getRequestString(request,"uid");
	String banji=ParamUtils.getRequestString(request,"banji");
	System.out.println("name:"+name+"uid:"+uid+"banji"+banji);*/
	
	session.removeAttribute("error");
	DbBasetableFactory bf = new DbBasetableFactory();
	if (bf.CreatUser(request)) {
		out.println("恭喜您！用户录入成功！");
	} else {
		session.setAttribute("error", "添加用户失败！");
		response.sendRedirect("error.jsp");
	}
 %>
 <style type="text/css">
<!--
.STYLE7 {
	color: #FF0000;
	font-size: 24px;
}
-->
</style>
<html>
  <head>
    <title>check_user</title>
  </head>

	<body>
		<table width="433" height="65" border="0" align="center">
			<tr>
				<td class="STYLE7">
					<a href="add_user.jsp">继续录入</a>
				</td>
				<td>
					<a href="main.jsp" class="STYLE7" >返回主页面</a>
				</td>
			</tr>
		</table>
</html>
