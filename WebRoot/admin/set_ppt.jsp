<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<style type="text/css">
<!--
body {
	background-color: #F7F8F9;
}
.STYLE1 {
	font-size: 24px;
	color: #FFFFFF;
}
.STYLE2 {color: #FF0000}
a{TEXT-DECORATION:none}
-->
</style></head>

<body>

  <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC">
    <tr>
      <td height="35" colspan="3" bgcolor="#0E4495"><div align="center" class="STYLE1">PPT模板</div></td>
    </tr>
    <tr>
      <td width="17%" height="35" bgcolor="#F0F0F9"><div align="right">设置目录路径</div></td>
      <td width="53%" bgcolor="#F0F0F9"><label>
        <input type="text" name="textfield"  style="width:400px; height:25px"/>
      </label></td>
      <td width="30%" rowspan="5" bgcolor="#F0F0F9"><span class="STYLE2">注意：</span></td>
    </tr>
    <tr>
      <td height="41" bgcolor="#F0F0F9"><div align="right">标题设置</div></td>
      <td bgcolor="#F0F0F9"><label>
        <input type="text" name="textfield2" style="width:400px; height:25px"/>
      </label></td>
    </tr>
    <tr>
      <td height="32" bgcolor="#F0F0F9"><div align="right">正文超链接</div></td>
      <td bgcolor="#F0F0F9"><label>
        <input type="text" name="textfield3"style="width:400px; height:25px" />
      </label></td>
    </tr>
    <tr>
      <td height="45" bgcolor="#F0F0F9"><div align="right">背景</div></td>
      <td bgcolor="#F0F0F9"><label>
        <input type="text" name="textfield4" style="width:400px; height:25px"/>
      </label></td>
    </tr>
    <tr>
      <td height="46" bgcolor="#F0F0F9"><div align="right">插入图片</div></td>
      <td bgcolor="#F0F0F9"><label>
        <input type="text" name="textfield5" style="width:400px; height:25px" />
      </label></td>
    </tr>
    <tr>
      <td height="64" bgcolor="#F0F0F9">&nbsp;</td>
      <td bgcolor="#F0F0F9"><label>
   <a href="create_timu.jsp"   >  <input name="Submit" type="submit" value="生成题目" /></a>
      </label>
        <label>
       &nbsp;&nbsp;&nbsp;&nbsp; 
    <a href="pptTest/answer.ppt">   <input name="Submit2" type="submit" value="打开PPT" /></a>
      </label></td>
      <td bgcolor="#F0F0F9">&nbsp;</td>
    </tr>
  </table>

</body>
</html>
