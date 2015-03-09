<%@ page language="java" import="java.util.*,com.dao.*,com.core.*,com.model.*" pageEncoding="gbk"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<style type="text/css">
<!--
.STYLE5 {
	font-size: 36px;
	color: #FF0000;
}

.STYLE6 {
	font-size: 18px
}
.STYLE1 {
	font-family: "Microsoft YaHei UI";
	font-size: 36px;
	color: #FF0000;
}
.STYLE4 {font-size: 16px; font-weight: bold; }
-->

</style>

		<title>录入选择题</title>
	</head>
	<script>
	function add_select() {
		if (form1.timu.value == "") {
			alert("请输入题目");
			return false;
		}
		if (form1.ans.value == "") {
			alert("请输入答案");
			return false;
		}
		if (form1.A.value == "") {
			alert("请输入A选项");
			return false;
		}
		if (form1.B.value == "") {
			alert("请输入B选项");
			return false;
		}
		if (form1.C.value == "") {
			alert("请输入C选项");
			return false;
		}
		if (form1.D.value == "") {
			alert("请输入D选项");
			return false;
		}
		if(form1.ans.value!=form1.A.value && form1.ans.value!=form1.B.value && form1.ans.value!=form1.C.value && form1.ans.value!=form1.D.value){
		alert("选项设置错误，无答案匹配项");
		return false;
		}
	
	}
</script>
<%
	int submit_page = ParamUtils.getIntParameter(request, "page");
	int count=1;
	DbBasetableFactory bf=new DbBasetableFactory();
	Collection coll = bf.ListSelectChp(submit_page, "");
	
 %>
	<body>
		<form id="form1" name="form1" method="post"
			action="check_addselect.jsp">
			  <table width="674" height="298" border="0" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
    <tr>
      <td colspan="2"><label>
        <div align="left"><span class="STYLE1">&nbsp;&nbsp;  &nbsp;  &nbsp;&nbsp;    &nbsp;&nbsp;  &nbsp;  &nbsp;    &nbsp;         录入选择题</span></div>
        </label></td>
    </tr>
    <tr>
    
      <td height="66"><span class="STYLE4">章节：</span>
        <label>
        <select name="chp" >
        <%
    	if (coll == null || coll.size() <= 0) {
	
     %>
          <option value="noinfo">当前无章节信息</option>
            <%
				 }else {
					Iterator it = coll.iterator();
					while (it.hasNext()) {
						SelectChp s = (SelectChp) it.next();
						System.out.println("s"+s.getChp());
			%>
			   <option value="<%=s.getId() %>"><%=count++ %>. <%=s.getChp() %></option>
			   <%}} %>
          
        </select>
      </label></td>
      
       
      <td><span class="STYLE4">难度：</span>
        <label>
        <select name="diff">
          <option value="1">容易</option>
          <option value="2">简单</option>
          <option value="3">困难</option>
          <option value="4">复杂</option>
        </select>
      </label></td>
    </tr>
    <tr>
      <td width="336" height="66"><span class="STYLE4">
        <label>题目：<br />
        <br /> 
        <textarea name="timu" ></textarea>
        </label>
      </span></td>
      <td width="338"><p class="STYLE4">答案：</p>
        <p class="STYLE4">
          <textarea name="ans" ></textarea>
        </p></td>
    </tr>
    
    <tr>
      <td height="66"><p class="STYLE4">A选项：</p>
        <p class="STYLE4">
          <textarea name="A"></textarea>
      </p></td>
      <td><p class="STYLE4">B选项：</p>
        <p class="STYLE4">
          <textarea name="B" ></textarea>
        </p></td>
    </tr>
    
    <tr>
      <td height="66"><p class="STYLE4">C选项：</p>
        <p class="STYLE4">
          <textarea name="C" ></textarea>
        </p></td>
      <td><p class="STYLE4">D选项：</p>
        <p class="STYLE4">
          <textarea name="D" ></textarea>
        </p></td>
    </tr>
    
    <tr>
      <td colspan="2"><label>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; 
        <input type="submit" name="Submit" value="提交" onClick="return add_select()"/>
      </label>
        <label >
       &nbsp;&nbsp;      &nbsp; 
       <input name="Submit2" type="reset" value="重置" />
      </label></td>
    </tr>
  </table>
		</form>
	</body>
</html>
