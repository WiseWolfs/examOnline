<%@ page language="java" import="java.util.*,com.model.*"
	pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>在线考试系统</title>
<style type="text/css">
<!--
.STYLE1 {
	font-family: "Microsoft YaHei UI";
	color: #FFFFFF;
}
.STYLE2 {font-family: "Microsoft YaHei UI"}
.STYLE3 {	font-family: "Microsoft YaHei UI";
	color: #FFFFFF;
	font-size: 24px;

}
a{text-decoration: none;}
-->
</style>
<%
	User u=(User)session.getAttribute("user");
%>
</head>

<frameset rows="110,*"  frameborder="NO" border="0" framespacing="0">
	<frame src="top.jsp" noresize="noresize" frameborder="NO" name="topFrame" scrolling="no" marginwidth="0" marginheight="0" target="main" />
  <frameset cols="200,*"  rows="560,*" id="frame">
	<frame src="left.jsp" name="leftFrame" noresize="noresize" marginwidth="0" marginheight="0" frameborder="0" scrolling="no" target="main" />
	<frame src="right.jsp" name="main" marginwidth="0" marginheight="0" frameborder="0" scrolling="auto" target="_self" />
  </frameset>
<noframes>
  <body></body>
    </noframes>
</html>
