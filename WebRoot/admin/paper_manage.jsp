<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>设置试卷</title>
	</head>
	<link href="../css/admin.css" rel="stylesheet" type="text/css">
	<script>
function add_paper(){
	var select_num=document.getElementById("select_num").value;
	var blank_num=document.getElementById("blank_num").value;
	var operate_num=document.getElementById("operate_num").value;
	var select_value=document.getElementById("select_value").value;
	var blank_value=document.getElementById("blank_value").value;
	var operate_value=document.getElementById("operate_value").value;
	 var reg = /^\d+$/;//限制只能输入数字
	 
	
	if(form1.paper_timu.value==""){
		alert("请填写试卷名");
		return false;
	}
	if(form1.paper_user.value==null){
		alert("请输入命题人姓名");
		return false;
	}
	if(form1.select_num.value==null){
		alert("请输入选择题数目");
		return false;
	}
	if(form1.select_value.value==null){
		alert("请输入选择题分值");
		return false;
	}
	if(form1.operate_num.value==null){
		alert("请输入操作题数目");
		return false;
	}
	if(form1.operate_value.value==null){
		alert("请输入操作题分值");
		return false;
	}
	if(form1.blank_num.value==""){
		alert("请输入填空题数目");
		return false;
	}
	if(form1.blank_value.value==""){
		alert("请输入填空题分值");
		return false;
	}
	if(((form1.blank_value.value)*(form1.blank_num.value)+(form1.select_num.value)*(form1.select_value.value)+(form1.operate_num.value)*(form1.operate_value.value))!=100){
		alert("分数设置不合理");
		return false;
	}
	
	  if(!reg.test(blank_value)){
	 alert("判断题分值输入不规范！");
	 form1.blank_value.value="";
	 return false;
	 }
	   if(!reg.test(blank_num)){
	 alert("判断题数目输入不规范！");
	 form1.blank_num.value="";
	 return false;
	 }
	 
	 if(!reg.test(select_value)){
	 alert("选择题分值输入不规范！");
	 form1.select_value.value="";
	 return false;
	 }
	   if(!reg.test(select_num)){
	 alert("选择题数目输入不规范！");
	 form1.select_num.value="";
	 return false;
	 }
	 
	 if(!reg.test(opetate_value)){
	 alert("操作题分值输入不规范！");
	 form1.blank_value.value="";
	 return false;
	 }
	   if(!reg.test(operate_num)){
	 alert("操作题数目输入不规范！");
	 form1.blank_num.value="";
	 return false;
	 }
}
</script>

	<style type="text/css">
<!--
.STYLE2 {
	font-size: 18px
}

.STYLE3 {
	font-family: "Microsoft YaHei UI"
}

.STYLE4 {
	font-size: 18px;
	font-family: "Microsoft YaHei UI";
}

a {
	text-decoration: none
}
-->
</style>
	<body>
		<form id="form1" name="form1" method="post" action="set_paper.jsp">
			<table width="100%" height="306" border="1" cellpadding="0"
				cellspacing="0" bordercolor="#CCCCCC">
				<tr>
					<td height="50">
						<span class="STYLE2"><span class="STYLE3">试卷标题：</span> <label>
								<input type="text" name="paper_timu" />
							</label> </span>
					</td>
				</tr>
				<tr>
					<td height="42">
						<span class="STYLE4">选择题数目： <label>
								<input type="text" name="select_num" id="select_num"/>
							</label> 分值： <label>
								<input type="text" name="select_value" id="select_value" />
							</label> <label>
								<input name="Submit" type="button" value="设置选择题属性"
									onClick="javascript:location.href='set_select.jsp'" />
							</label>
						</span>
					</td>
				</tr>
				<tr>
					<td height="53">
						<span class="STYLE4">判断题数目： <label>
								<input type="text" name="blank_num" id="blank_num"/>
							</label> 分值： <label>
								<input type="text" name="blank_value" id="blank_value" />
							</label> </span><label>
								<input name="Submit" type="button" value="设置判断题属性"
									onClick="javascript:location.href='set_blank.jsp'" />
							</label>
					</td>
				</tr>
				<tr>
					<td height="43">
						<span class="STYLE4">操作题数目： <label>
								<input type="text" name="operate_num" id="operate_num" />
							</label> 分值： <label>
								<input type="text" name="operate_value" id="operate_value"/>
							</label> </span>
					</td>
				</tr>
				<tr>
					<td height="64">
						<span class="STYLE4">命题人： <label>
								<input type="text" name="paper_user" />
							</label> <label>
								考试类型：
								<input type="radio" name="paper_type" id="pp1" value="0"
									checked="checked" />
								期末考试
							</label> <label>
								<input type="radio" name="paper_type" id="pp2" value="1" />
								补考
							</label> </span>
					</td>
				</tr>
				<tr>
					<td height="38">
						<span class="STYLE3"> <label>
						</span>
						<div align="right" class="STYLE3">

							<div align="left">
								&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="submit" name="Submit" value="提交"
									onClick="return add_paper()" />

								<label>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input name="Submit2" type="reset" value="取消" />
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</label>


							</div>
						</div>

						<span class="STYLE3"> </label> </span>
					</td>
				</tr>
		  </table>
		</form>

	</body>
</html>
