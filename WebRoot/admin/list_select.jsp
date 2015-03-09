<%@ page language="java"
	import="java.util.*,com.core.*,com.dao.*,com.model.*"
	pageEncoding="gbk"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.Iterator"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>选择题列表</title>


	</head>
<style type="text/css">
<!--
.STYLE8 {font-family: "Microsoft YaHei UI"}
.STYLE9 {font-size: 24px}
a{text-decoration: none;}
-->
</style>
<body>
	<table width="100%" height="157" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC">
		
			<tr>
				<td width="131" height="37" bgcolor="#D9EBFE">
				  <div align="center" class="STYLE5 STYLE2 STYLE3 STYLE8 STYLE9">
			  题号					</div>			  </td>
				<td width="340" bgcolor="#D9EBFE">
				  <div align="center" class="STYLE5 STYLE2 STYLE3 STYLE8 STYLE9">
			  题目					</div>			  </td>
				<td width="148" bgcolor="#D9EBFE">
				  <div align="center" class="STYLE5 STYLE2 STYLE3 STYLE8 STYLE9">
			  答案					</div>			  </td>
				<td colspan="2" bgcolor="#D9EBFE">
				  <div align="center" class="STYLE5 STYLE2 STYLE3 STYLE8 STYLE9">
			  管理					</div>			  </td>
			</tr>

			<%
				int submit_page = ParamUtils.getIntParameter(request, "page");
				DbBasetableFactory bf = new DbBasetableFactory();
				Collection coll = bf.ListSelect(submit_page, "");
			//	out.print("coll:" + coll.size());
				if (coll == null || coll.size() <= 0) {
			%>

			<tr>
				<td colspan="5" bgcolor="#F0F0F9">
					<div align="center">
						<span class="STYLE5">当前无信息					</span></div>				</td>
			</tr>
			<%
				} else {
					Iterator it = coll.iterator();
					while (it.hasNext()) {
						Select s = (Select) it.next();
			%>
			<tr>
				<td height="37" bgcolor="#F0F0F9">
					<div align="center">
					<span class="STYLE8"></span>					</div><%=s.getTimu_id()%></td>
				<td bgcolor="#F0F0F9">
					<div align="center">
					<span class="STYLE8"></span>				<a href="info_select.jsp?timu_id=<%=s.getTimu_id() %>">	</div><%=s.getTimu()%></a></td>
				<td bgcolor="#F0F0F9">
					<div align="center">
					<span class="STYLE8"></span>					</div><%=s.getAns()%></td>
				<td width="114" bgcolor="#F0F0F9">
					<div align="center">
						<span class="STYLE8"></span>					<a href="update_select.jsp?action=modify&uid=<%=s.getTimu_id() %>" onClick="javascript:return confirm('你确定修改该选择题吗？')"><img src="../images/xiugai.png" width="58" height="17" /></a></div>				</td>
			    <td width="114" bgcolor="#F0F0F9"><div align="center"><a href="modify_select.jsp?action=del&uid_v=<%=s.getTimu_id() %>" onClick="javascript:return confirm('你确定删除该选择题吗？')"><img src="../images/shanchu.png" width="57" height="18" /></a></div></td>
			</tr>
			<%
				}
				}
			%>
			<tr>
			  <td height="25" colspan="5" bgcolor="#D9EBFE"><%=HtmlUtils.table(bf.getRow("selectinfo"),submit_page,"list_select.jsp")%></td>
	  </tr>
			<tr>
				<td height="23" colspan="5" bgcolor="#D9EBFE">
					<div align="center" class="STYLE8">
					  <label>
					  <input name="Submit" type="submit" value="添加试题" onclick="javascript:location.href='add_select.jsp'" />
					  </label>
			  </div>				</td>
			</tr>
</table>
</body>
</html>
