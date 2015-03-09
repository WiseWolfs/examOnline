<%@ page language="java" import="java.util.*,com.core.*,com.dao.*,com.model.*" pageEncoding="gbk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	String id=request.getParameter("id");
	DbBasetableFactory bf=new DbBasetableFactory();
	Blank b=bf.SearchBlank("where id='"+id+"'");
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>

<style type="text/css">
<!--
.STYLE3 {
	font-family: "Microsoft YaHei UI";
	font-size: 36px;
	color: #FFFFFF;
}
.STYLE6 {font-family: "Microsoft YaHei UI"; font-weight: bold; }
-->
</style>
</head>

<body>
<table width="366" height="232" border="0" align="center">
  <tr>
    <td height="71" colspan="2" bgcolor="#2679CE"><div align="center"><span class="STYLE3">判断题信息列表</span></div></td>
  </tr>
  <tr>
    <td width="66" bgcolor="#F0F0F9"><div align="center"><span class="STYLE6">题号：</span></div></td>
    <td width="290" bgcolor="#F0F0F9">&nbsp;<%=b.getId() %></td>
  </tr>
  <tr>
    <td bgcolor="#F0F0F9"><div align="center"><span class="STYLE6">题目：</span></div></td>
    <td bgcolor="#F0F0F9">&nbsp;<%=b.getTimu() %></td>
  </tr>
  <tr>
    <td bgcolor="#F0F0F9"><div align="center"><span class="STYLE6">答案：</span></div></td>
    <td bgcolor="#F0F0F9">&nbsp;<%=b.getAns() %></td>
  </tr>
  <tr>
    <td height="29" colspan="2" bgcolor="#2679CE"><label>
      <div align="center">
        <input name="Submit" type="submit" value="关闭窗口" onclick="javascript:location.href='main.jsp'" />
        </div>
    </label></td>
  </tr>
</table>
</body>
</html>
