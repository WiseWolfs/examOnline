<%@ page language="java" import="java.util.*,com.core.*,com.dao.*,com.model.*" pageEncoding="GBK"%>
<%
	String timu_id=request.getParameter("timu_id");
	System.out.print("timu_id"+timu_id);
	DbBasetableFactory bf=new DbBasetableFactory();
	Select s=bf.SearchSelect("where timu_id='"+timu_id+"'");

	
 %>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>设置选择题属性</title>

<style type="text/css">
<!--
.STYLE9 {font-size: 24}
.STYLE11 {
	font-family: "Microsoft YaHei UI";
	font-size: 36px;
	color: #FFFFFF;
}
.STYLE13 {font-family: "Microsoft YaHei UI"; font-size: 16; font-weight: bold; }
-->
</style>
</head>
	

<body>
<table width="402" height="337" border="0" align="center">
  <tr>
    <td height="39" colspan="2" bgcolor="#0072C6"><div align="center"><span class="STYLE11">选择题信息</span></div></td>
  </tr>
  <tr>
    <td width="73" height="39" bgcolor="#D9EBFE"><span class="STYLE13">题目：</span></td>
    <td width="319" bgcolor="#D9EBFE"><span class="STYLE9"><%=s.getTimu() %></span></td>
  </tr>
  <tr>
    <td bgcolor="#F0F0F9"><span class="STYLE13">答案：</span></td>
    <td bgcolor="#F0F0F9"><span class="STYLE9"><%=s.getAns() %></span></td>
  </tr>
  <tr>
    <td bgcolor="#D9EBFE"><span class="STYLE13">A选项：</span></td>
    <td bgcolor="#D9EBFE"><span class="STYLE9"><%=s.getA() %></span></td>
  </tr>
  <tr>
    <td bgcolor="#F0F0F9"><span class="STYLE13">B选项：</span></td>
    <td bgcolor="#F0F0F9"><span class="STYLE9"><%=s.getB() %></span></td>
  </tr>
  <tr>
    <td bgcolor="#D9EBFE"><span class="STYLE13">C选项：</span></td>
    <td bgcolor="#D9EBFE"><span class="STYLE9"><%=s.getC() %></span></td>
  </tr>
  <tr>
    <td bgcolor="#F0F0F9"><span class="STYLE13">D选项：</span></td>
    <td bgcolor="#F0F0F9"><span class="STYLE9"><%=s.getD() %></span></td>
  </tr>
  <tr>
    <td height="37" colspan="2" bgcolor="#0072C6"><label></label>
      <label>
      <div align="center">
     <input name="Submit2" type="button" value="关闭窗口"  onClick="javascript:location.href='main.jsp'">
      </div>
    </label></td>
  </tr>
</table>
</body>
</html>
