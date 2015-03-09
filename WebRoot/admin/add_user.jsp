<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<html>
 <head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>添加用户信息</title>
<style type="text/css">
<!--
.STYLE1{
	color: #FFFFFF;
	font-family: "Microsoft YaHei UI";
	font-size: 36px;
}
.STYLE4 {font-family: "Microsoft YaHei UI"; font-size: 24px; }
-->
</style>
<script>
	function add_user() {
		if (form1.name.value == "") {
			alert("姓名不能为空");
			return false;
		}
		if (form1.uid.value == "") {
			alert("学号不能为空！");
			return false;
		}
		if (form1.password.value == "") {
			alert("密码不能为空！");
			return false;
		}
		if (form1.banji.value == "") {
			alert("请输入班级");
			return false;
		}
		if (form1.yuanxi.value == "") {
			alert("请输入院系");
			return false;
		}
		if (form1.status.value == "") {
			alert("请输入权限");
			return false;
		}
	}
</script>
</head>

<body>
<form id="form1" name="form1" method="post" action="check_adduser.jsp">
  <table width="350" height="400" border="0" align="center">
    <tr>
      <td width="321" height="57" bgcolor="#0072C6"><div align="center" class="STYLE1">添加学生信息</div></td>
    </tr>
    <tr>
      <td bgcolor="#F0F0F9"><span class="STYLE4">姓名：  
          <label>
          <input type="text" name="name" />
          </label>
      </span></td>
    </tr>
    <tr>
      <td bgcolor="#F0F0F9"><span class="STYLE4">学号：
        <input type="text" name="uid" />
      </span></td>
    </tr>
    <tr>
      <td bgcolor="#F0F0F9"><span class="STYLE4">密码：
        <input type="text" name="password" />
      </span></td>
    </tr>
    <tr>
      <td bgcolor="#F0F0F9"><span class="STYLE4">班级：
        <input type="text" name="banji" />
      </span></td>
    </tr>
    <tr>
      <td bgcolor="#F0F0F9"><span class="STYLE4">院系：
        <input type="text" name="yuanxi" />
      </span></td>
    </tr>
    <tr>
     
    </tr>
    <tr>
      <td bgcolor="#D9EBFE"><label>
        &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;  &nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;
        <input name="Submit" type="submit" value="确认" onClick="return add_user()"/>
        &nbsp; 
        <input name="Submit2" type="submit" value="取消" />
      </label></td>
    </tr>
  </table>
</form>
</body>
</html>
