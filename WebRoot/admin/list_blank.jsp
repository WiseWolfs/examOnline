<%@ page language="java"
	import="java.util.*,com.core.*,com.dao.*,com.model.*"
	pageEncoding="gbk"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.Iterator"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<style type="text/css">
<!--
.STYLE9 {font-family: "Microsoft YaHei UI"}
.STYLE10 {font-size: 24px}

a{text-decoration: none;}
-->
</style>
</head>

<body>
 <table width="100%" height="177" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC">
  
  <tr>
    <td width="71" height="34" bgcolor="#D9EBFE"><div align="center" class="STYLE3 STYLE2 STYLE9 STYLE10">题号</div></td>
    <td width="513" bgcolor="#D9EBFE"><div align="center" class="STYLE3 STYLE2 STYLE9 STYLE10">题目</div></td>
    <td width="51" bgcolor="#D9EBFE"><div align="center" class="STYLE3 STYLE2 STYLE9 STYLE10">答案</div></td>
    <td width="80" colspan="2" bgcolor="#D9EBFE"><div align="center" class="STYLE3 STYLE2 STYLE9 STYLE10">管理</div></td>
  </tr>
  	<%
				int submit_page = ParamUtils.getIntParameter(request, "page");
				DbBasetableFactory bf = new DbBasetableFactory();
				Collection coll = bf.ListBlank(submit_page, "");
			//	out.print("coll:" + coll.size());
				if (coll == null || coll.size() <= 0) {
%>
  <tr>
    <td height="35" colspan="5" bgcolor="#F0F0F9"><div align="center">无试题信息</div></td>
  </tr>
  	<%
				} else {
					Iterator it = coll.iterator();
					while (it.hasNext()) {
						Blank b = (Blank) it.next();
						System.out.print("bbbbb"+b.getTimu()+" ");
			%>
  <tr height="38">
    <td height="41"  bgcolor="#F0F0F9">&nbsp;<%=b.getId() %></td>
    <td bgcolor="#F0F0F9">&nbsp;<a href="info_blank.jsp?id=<%=b.getId() %>"><%=b.getTimu() %></a></td>
  <%if(b.getAns().equals("1")){%>  <td bgcolor="#F0F0F9">&nbsp;正确</td>
  <%}else{ %><td bgcolor="#F0F0F9">&nbsp;错误</td><%} %>
  	
    <td align="center" valign="middle" bgcolor="#F0F0F9">
      <div align="center" class="STYLE3">
        <div align="center"><a href="update_blank.jsp?action=modify&id=<%=b.getId() %>" onClick="javascript:return confirm('你确定修改该选择题吗？')"><img src="../images/xiugai.png"/></a></div>
    </div></td>
    <td align="center" valign="middle" bgcolor="#F0F0F9"><div align="center">
      <div align="center" class="STYLE3">
        <div align="center"><a href="modify_blank.jsp?action=del&id=<%=b.getId() %>" onClick="javascript:return confirm('你确定删除该选择题吗？')"><img src="../images/shanchu.png"/></a></div>
    </div></td>
  </tr>

  	<%
				}
				}
			%>
  <tr>
    <td height="29" colspan="5" bgcolor="#D9EBFE">&nbsp;<%=HtmlUtils.table(bf.getRow("blankinfo"),submit_page,"list_blank.jsp")%></td>
  </tr>
  <tr>
    <td height="36" colspan="5" bgcolor="#D9EBFE">
      <div align="center">
        <input name="Submit" type="submit" value="添加试题" onclick="javascript:location.href='add_blank.jsp'" />
      </div>
    </td>
  </tr>
</table>
</body>
</html>
