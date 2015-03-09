<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<script>
		function login(){
	if(form1.uid.value==""){
		alert("请填写用户名");
		return false;
	}
	if(form1.password.value==""){
		alert("请填写用户密码");	
		return false;
	}
	var span_id=document.getElementById("span_id");
	 var uid = document.getElementById("uid").value.trim(); 
	 reg= /^[0-9a-zA-Z]*$/g;
	 if(!reg.test(uid)){
	   span_id.innerHTML="<font color='red'>用户名输入不规范！请重新输入！</font>";
	   form1.uid.value="";
	   form1.password.value="";
	 return false;
	 }
}
		
		</script>
		<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
		<title>大学生在线考试系统</title>

		<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setDateHeader("Expires",0);
response.setHeader("Pragma","no-cache");

 
%>
		<style type="text/css">
<!--
.STYLE1 {
	font-size: 24px
}

#form1 .STYLE1 {
	font-family: "Microsoft YaHei UI";
	font-size: 100%;
	line-height: 142%;
	font-weight: bold;
	color: #FFFFFF;
	background-color: #0072C6;
	text-align: center;
	text-indent: 0px;
	width: 84.4688px;
	margin-top: 0px;
	margin-right: 2px;
	margin-bottom: 0px;
	margin-left: 2px;
	padding-top: 3px;
	padding-right: 12px;
	padding-bottom: 5px;
	padding-left: 12px;
	border-top-style: none;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style: none;
}

.STYLE2 {
	font-size: 16px;
	font-family: "Microsoft YaHei UI";
}

#form1 .zimui12 .ziti16 .tiyanshehui {
	color: #999999;
}

.STYLE4 {
	font-size: 12px;
	font-family: "Microsoft YaHei UI";
}

.STYLE5 {
	font-family: "Microsoft YaHei UI";
	font-size: 12px;
	color: #099;
}

.STYLE6 {
	font-family: "Microsoft YaHei UI"
}

.STYLE7 {
	font-family: "Microsoft YaHei UI";
	font-size: 14px;
}

.STYLE8 {
	font-size: 14px
}

.STYLE11 {
	font-family: "Microsoft YaHei UI";
	font-size: 18px;
}
-->
</style>
	</head>

	<body>
		<form id="form1" name="form1" method="post" action="user_check.jsp">
			<table width="1023" height="450" border="0" align="center">
				<tr>
					<td width="574" height="523" rowspan="6">
						<img src="images/BB.jpg" width="441" height="480" />
					</td>
					<td height="56">
						<div align="left">
							<p>
								&nbsp;
							</p>
							<p>
								<img src="images/s1.gif" width="212" height="70" />
							</p>
						</div>
					</td>
				</tr>
				<tr>
					<td height="29">
						<span class="STYLE5" id="span_id">*请正确输入用户名和密码</span>

					</td>
				</tr>
				<tr>
					<td height="60">
						<label></label>
						<span class="STYLE2">用户名</span>
						<label>
							<input type="text" name="uid" id="uid" />
						</label>
					</td>
				</tr>
				<tr>
					<td height="60">
						<span class="STYLE2">密&nbsp;&nbsp; 码</span>
						<label>
							<input type="password" name="password" id="password" />
						</label>
					</td>
				</tr>
				<tr>
					<td height="27" valign="top">
						<span class="STYLE11">学生 <label>
								<input type="radio" name="radiobutton" value="radiobutton"
									checked />
							</label> &nbsp;&nbsp; 教师 <label>
								<input type="radio" name="radiobutton" value="radiobutton" />
							</label> </span>
					</td>
				</tr>
				<tr>
					<td height="65" valign="top">
						<label>
							<br />
							<input type="submit" name="Submit" value="登陆"
								onClick="return login()" class="STYLE1" />
							&nbsp;
						</label>
						<label>
							<input name="Submit2" type="reset" value="取消" class="STYLE1" />
						</label>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div align="center">
							<span class="zimui12"><span class="zitimax">&nbsp;<span
									style="text-align: left">&nbsp;</span> </span> </span>
							<hr />
							<span class="zimui12" style="text-align: left"><span
								class="ziti16"><span class="tiyanshehui STYLE4">版权所有:Copyright
										2014 南京工程学院 通信工程学院</span> </span> </span><span class="ziti16 STYLE4 STYLE6"
								style="text-align: left"></span>
						</div>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
