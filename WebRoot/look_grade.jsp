<%@ page language="java" import="java.util.*,com.core.*,com.model.*,com.dao.*" pageEncoding="GBK"%>
<%
	String uid=ParamUtils.getRequestString(request,"uid");
	DbBasetableFactory bf=new DbBasetableFactory();
	User u=bf.SearchUser("where uid='"+uid+"'");
	
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>查看成绩</title>

<style type="text/css">
<!--
body {
	background-color: #F7F8F9;
}
.STYLE3 {font-family: "Microsoft YaHei UI"; font-size: 36px; color: #FFFFFF; }
.STYLE12 {font-family: "Microsoft YaHei UI"; font-size: 16px; font-weight: bold; }
-->
</style>
</head>

<body>
<table width="100%" border="0" cellpadding="1" cellspacing="1" bordercolor="#999999">
  <tr>
    <td height="32" bgcolor="#D9EBFE"><div align="center" class="STYLE6">姓名</div></td>
    <td bgcolor="#D9EBFE"><div align="center" class="STYLE6">学号</div></td>
    <td bgcolor="#D9EBFE"><div align="center" class="STYLE6">班级</div></td>
    <td bgcolor="#D9EBFE"><div align="center" class="STYLE6">期末成绩</div></td>
    <td bgcolor="#D9EBFE"><div align="center" class="STYLE6">补考成绩</div></td>
    <td bgcolor="#D9EBFE"><div align="center" class="STYLE6">操作</div></td>
  </tr>
  <tr>
    <td height="47" bgcolor="#F0F0F9"><%=u.getName() %>&nbsp;</td>
    <td bgcolor="#F0F0F9"><%=u.getUid() %>&nbsp;</td>
    <td bgcolor="#F0F0F9">&nbsp;<%=u.getBanji() %></td>
    <td bgcolor="#F0F0F9">&nbsp;<%=u.getFinals() %></td>
    <td bgcolor="#F0F0F9">&nbsp;<%=u.getRefinals() %></td>
    <td bgcolor="#F0F0F9">&nbsp;<label>
      <div align="center">
        <input name="Submit" type="button" value="关闭窗口" onClick="javascript:location.href='main.jsp'"/>
        </div>
    </label></td>
  </tr>
</table>
</body>
</html>
