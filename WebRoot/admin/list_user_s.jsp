<%@ page language="java"
	import="java.util.*,com.core.*,com.dao.*,com.model.*"
	pageEncoding="gbk"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.Iterator"%>
<%
	String search=request.getParameter("search");//search为按XX搜索
	String search_text=request.getParameter("search_text");//搜索框中的输入内容
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	
		<title>用户信息列表</title>
	</head>

<body>
	<style type="text/css">
<!--
.STYLE5 {font-family: "Microsoft YaHei UI"}
.STYLE6 {color: #000000}
.STYLE8 {font-size: 24px}
-->
</style>


<table width="100%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC">
		
			<tr>
				<td width="95" height="25" bgcolor="#D9EBFE">
			  <div align="center" class="STYLE13 STYLE5 STYLE6 STYLE8"><span class="STYLE14">姓名</span> </div></td>
				<td width="95" bgcolor="#D9EBFE">
			  <div align="center" class="STYLE13 STYLE5 STYLE6 STYLE8"><span class="STYLE14">学号</span> </div></td>
				<td width="95" bgcolor="#D9EBFE">
			  <div align="center" class="STYLE13 STYLE5 STYLE6 STYLE8"><span class="STYLE14">密码</span> </div></td>
				<td width="95" bgcolor="#D9EBFE">
			  <div align="center" class="STYLE13 STYLE5 STYLE6 STYLE8"><span class="STYLE14">班级</span> </div></td>
				<td width="126" bgcolor="#D9EBFE">
			  <div align="center" class="STYLE13 STYLE5 STYLE6 STYLE8"><span class="STYLE14">期末考试</span> </div></td>
				<td width="97" bgcolor="#D9EBFE">
			  <div align="center" class="STYLE13 STYLE5 STYLE6 STYLE8"><span class="STYLE14">补考</span> </div></td>
				<td width="183" bgcolor="#D9EBFE">
			  <div align="center" class="STYLE13 STYLE6 STYLE5 STYLE8"><span class="STYLE14">管理</span> </div></td>
			</tr>
			<%	
				int submit_page = ParamUtils.getIntParameter(request, "page");
				DbBasetableFactory bf = new DbBasetableFactory();
				Collection coll=bf.ListUser(submit_page,"where "+search+"='"+search_text+"'");
					//Collection coll = bf.ListUser(submit_page, "where uid='"+search_text+"'");
				
		//		out.print("coll:" + coll.size());
				if (coll == null || coll.size() <= 0) {
			%>
			<tr>
				<td height="27" colspan="7" bgcolor="#F0F0F9">
					<div align="center"><span class="STYLE13 STYLE14">无用户信息</span> </div></td>
			</tr>
			<%
				} else {
					Iterator it = coll.iterator();
					while (it.hasNext()) {
						User u = (User) it.next();
			%>
			<tr>
				<td height="37" bgcolor="#F0F0F9">
					<span class="STYLE14"><%=u.getName()%></span></td>
				<td bgcolor="#F0F0F9">
					<span class="STYLE14"><%=u.getUid()%></span></td>
				<td bgcolor="#F0F0F9">
					<span class="STYLE14"><%=u.getPassword()%></span></td>
				<td bgcolor="#F0F0F9">
					<span class="STYLE14"><%=u.getBanji()%></span></td>
				<td bgcolor="#F0F0F9">
					<span class="STYLE14"><%=u.getFinals()%></span></td>
				<td bgcolor="#F0F0F9">
					<span class="STYLE14"><%=u.getRefinals()%></span></td>
				<td bgcolor="#F0F0F9">
					<span class="STYLE8"></span><a
						href="update_user.jsp?action=modify&uid=<%=u.getUid()%>" onClick="javascript:return confirm('你确定修改该用户信息吗？')"><img src="../images/xiugai.png" border="0"></a>
						<a href="modify_user.jsp?action=del&uid_v=<%=u.getUid() %>" onClick="javascript:return confirm('你确定删除该用户信息吗？')"><img src="../images/shanchu.png" border="0"></a>				</td>
			</tr>
			<%
				}
				}
			%>
			<tr>
			  <td height="36" colspan="7" bgcolor="#D9EBFE"><%=HtmlUtils.table(bf.getRow("user"),submit_page,"list_user.jsp")%></td>
	  </tr>
</table>
</body>
</html>
