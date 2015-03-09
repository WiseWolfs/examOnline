<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>确认进入考试页面</title>
<style type="text/css">
<!--
.STYLE1 {
	font-family: "Microsoft YaHei UI";
	font-size: 36px;
	color: #FFFFFF;
}
.STYLE2 {
	font-family: "Microsoft YaHei UI";
	font-size: 18px;
}
.STYLE3 {
	font-family: "Microsoft YaHei UI";
	color: #FF0000;
}
-->
</style>
</head>

<body>
<table width="664"  align="center" bordercolor="#0072C6" border="1" cellspacing="0" cellpadding="0">
  <tr>
    <td height="51" bgcolor="#0072C6"><div align="center"><span class="STYLE1">在线考试系统</span></div></td>
  </tr>
  <tr>
    <td height="40"><span class="STYLE2">请确认是否进入考试系统？</span></td>
  </tr>
  <tr>
    <td height="33"><span class="STYLE3">*确认后开始考试计时！</span></td>
  </tr>
  <tr>
    <td height="49"><label>
      </label>      
      <div align="center">
        <input name="Submit" type="submit" value="确认" onClick="javascript:location.href='examOnline.jsp'"/>
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
     <label>
     <input name="reset" type="reset" value="取消" />
     </label>
    </div></td>
  </tr>
</table>
</body>

</html>
