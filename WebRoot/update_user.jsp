<%@ page language="java" import="java.util.*,com.dao.*,com.model.*" pageEncoding="gbk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
 <%
 	String uid=request.getParameter("uid");
 	DbBasetableFactory bf=new DbBasetableFactory();
 	User u=(User)bf.SearchUser("where uid='"+uid+"'");
 	session.setAttribute("user",u);
 	
 	
 
  %>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>修改密码</title>
<script>
function t()
{
	var span_id=document.getElementById("span_id");
	reg= /^[0-9a-zA-Z]*$/g;
	if(form1.t1.value==""||form1.t2.value==""){
	alert("请输入密码");
	return false;
	}
	var t1=document.getElementById("t1").value;
	var t2=document.getElementById("t2").value;
	if(t1!=t2)
	{
	alert("两次输入的密码不一致，请重新输入！");
	form1.t1.value="";
	form1.t2.value="";
	return false;
	}

	 if(!reg.test(t1)){
	   span_id.innerHTML="<font color='red'>*密码应由数字或者字母组成！</font>";
	   form1.t1.value="";
	   form1.t2.value="";
	 return false;
	 }

}

</script>

<style type="text/css">
<!--
.STYLE12 {
	font-family: "Microsoft YaHei UI";
	font-size: 36px;
	color: #FFFFFF;
}
.STYLE13 {font-family: "Microsoft YaHei UI"}
.STYLE16 {font-size: 16px; font-weight: bold; }
-->
</style>
</head>
<body>
<form id="form1" name="form1" method="post" action="check_updateuser.jsp">
  <table width="400" height="202" border="0" align="center">
    <tr>
      <td colspan="2" bgcolor="#2679CE"><div align="center"><span class="STYLE12">修改密码</span></div></td>
    </tr>
    <tr>
      <td width="102" height="46" bgcolor="#F0F0F9"><div align="right" class="STYLE16"><span class="STYLE13">请输入新密码:</span></div></td>
      <td width="288" bgcolor="#F0F0F9"><label>
        <input type="text" name="t1" id="t1" />
      </label><span id="span_id"></span></td>
    </tr>
    <tr>
      <td height="46" bgcolor="#F0F0F9"><div align="right" class="STYLE16"><span class="STYLE13">请确认密码：</span></div></td>
      <td bgcolor="#F0F0F9"><label>
        <input type="text" name="t2" id="t2" />
      </label></td>
    </tr>
    <tr>
      <td height="38" colspan="2" bgcolor="#2679CE"><label>
        <div align="center">
          <input name="Submit" type="submit" value="确认"  onClick="return t();"/>
          <input name="Submit2" type="button" value="返回" />
          </div>
      </label></td>
    </tr>
  </table>
</form>
</body>
</html>
