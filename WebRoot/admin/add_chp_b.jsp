<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<script>
function check(){
if(form1.id.value==""){
alert("请输入章节号");
return false;
}
if(form1.chp.value==""){
alert("请输入章节名称");
return false;
}
var id=document.getElementById("id").value;
var chp=document.getElementById("chp").value;
	var reg=/^\d+$/g;
	if(!reg.test(id)){
	alert("章节号必须为数字");
	return false;
	}
}

</script>
 
<style type="text/css">
<!--
.STYLE1 {
	font-size: 36px;
	color: #FFFFFF;
	font-family: "Microsoft YaHei UI";
}
.STYLE4 {font-family: "Microsoft YaHei UI"; font-weight: bold; }
-->
</style>
</head>

<body>
<form id="form1" name="form1" method="post" action="check_add_chpb.jsp">
  <table width="369" height="179" border="0" align="center">
    <tr>
      <td height="60" colspan="2" bgcolor="#2679CE"><div align="center" class="STYLE1">添加章节</div></td>
    </tr>
    <tr>
      <td bgcolor="#D9EBFE"><span class="STYLE4">章节号：
          <label></label>
      </span></td>
      <td bgcolor="#D9EBFE"><input type="text" name="id" id="id"/></td>
    </tr>
    <tr>
      <td bgcolor="#D9EBFE"><span class="STYLE4">章节名称：
          <label></label>
      </span></td>
      <td bgcolor="#D9EBFE"><input type="text" name="chp" id="chp" /></td>
    </tr>
    <tr>
      <td height="33" colspan="2" bgcolor="#2679CE"><label></label>
        <label>
        <div align="center">
          <input type="submit" name="Submit" value="提交" onClick="return check();"/>
          &nbsp;
          <input name="Submit2" type="reset" value="重置" />
          </div>
      </label></td>
    </tr>
  </table>
</form>
     

</body>
</html>
