<%@ page language="java"
	import="java.util.*,com.core.*,com.dao.*,com.model.*"
	pageEncoding="GBK"%>
	<%
	String id=request.getParameter("id");
	String chp=request.getParameter("chp");
	session.removeAttribute("error");
	DbBasetableFactory bf = new DbBasetableFactory();
if(bf.CreatBlankChp(request) && bf.CreatBlankDiff(request)){
		out.println("恭喜您！章节录入成功！");
	} else {
	
		session.setAttribute("error", "添加判断题失败！");
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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>录入结果</title>
	</head>
	<body>
		<table width="433" height="65" border="0" align="center">
			<tr>
				<td class="STYLE7">
					<a href="add_chp_b.jsp">继续录入</a>
				</td>
				<td>
					<a href="main.jsp" class="STYLE7" >返回主页面</a>
				</td>
			</tr>
		</table>
	</body>
</html>
