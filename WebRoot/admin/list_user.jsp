<%@ page language="java"
	import="java.util.*,com.core.*,com.dao.*,com.model.*"
	pageEncoding="gbk"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.Iterator"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>用户信息列表</title>
	</head>
	<style type="text/css">
<!--
.STYLE1 {
	color: #FFFFFF;
	font-size: 14px;
}
.STYLE8 {
	font-size: 18px
}
.STYLE10 {
	font-size: 36px;
	font-family: "Microsoft YaHei UI";
	color: #FFFFFF;
}
.STYLE13 {font-size: 24px}
.STYLE14 {font-family: "Microsoft YaHei UI"}
-->
    </style>
<body>
	<table width="100%"  border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC">
		
			<tr>
				<td  height="38" width="98" bgcolor="#D9EBFE">
					<div align="center" class="STYLE13"><span class="STYLE14">姓名</span> </div></td>
				<td height="38" width="98" bgcolor="#D9EBFE">
					<div align="center" class="STYLE13"><span class="STYLE14">学号</span> </div></td>
				<td height="38" width="98" bgcolor="#D9EBFE">
					<div align="center" class="STYLE13"><span class="STYLE14">密码</span> </div></td>
				<td height="38" width="98" bgcolor="#D9EBFE">
					<div align="center" class="STYLE13"><span class="STYLE14">班级</span> </div></td>
				<td height="38" width="98" bgcolor="#D9EBFE">
					<div align="center" class="STYLE13"><span class="STYLE14">期末考试</span> </div></td>
				<td height="38" width="98" bgcolor="#D9EBFE">
					<div align="center" class="STYLE13"><span class="STYLE14">补考</span> </div></td>
				<td height="38"  width="98" bgcolor="#D9EBFE">
					<div align="center" class="STYLE13"><span class="STYLE14">管理</span> </div></td>
			</tr>
			<%
				int submit_page = ParamUtils.getIntParameter(request, "page");
				DbBasetableFactory bf = new DbBasetableFactory();
				Collection coll = bf.ListUser(submit_page, "");
		//		out.print("coll:" + coll.size());
				if (coll == null || coll.size() <= 0) {
			%>
			<tr>
				<td colspan="7" bgcolor="#F0F0F9">
					<div align="center"><span class="STYLE13 STYLE14">无用户信息</span> </div></td>
			</tr>
			<%
				} else {
					Iterator it = coll.iterator();
					while (it.hasNext()) {
						User u = (User) it.next();
			%>
			<tr>
				<td bgcolor="#F0F0F9">
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
			<tr height="37">
			  <td colspan="7" bgcolor="#D9EBFE"><%=HtmlUtils.table(bf.getRow("user"),submit_page,"list_user.jsp")%></td>
	  </tr>
			<tr>
			  <td height="37" colspan="7" bgcolor="#F0F0F9">
					<div align="center" class="STYLE8">
			  
			  <label>
			  <input name="Submit" type="submit" value="添加用户" onclick="javascript:location.href='add_user.jsp'"/>
			  </label>
			 				</div>			  </td>
			</tr>
</table>
</body>
</html>
