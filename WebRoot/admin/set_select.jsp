<%@ page language="java"
	import="java.util.*,com.core.*,com.dao.*,com.model.*"
	pageEncoding="gbk"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.Iterator"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>设置选择题属性</title>
<style type="text/css">
<!--
.STYLE1 {
	font-family: "Microsoft YaHei UI";
	font-size: 36px;
	color: #FFFFFF;
}
.STYLE3 {font-size: 24px; font-family: "Microsoft YaHei UI";}
-->
</style>
<script type="text/javascript">

 
 function d()
{
	var i=1;
	for(;i<3;i++){
	var d1=document.getElementById("d1"+i).value;
	d1=Number(d1);
	var d2=document.getElementById("d2"+i).value;
	d2=Number(d2);
	var d3=document.getElementById("d3"+i).value;
	d3=Number(d3);
	var d4=document.getElementById("d4"+i).value;
	d4=Number(d4);
	if(d1+d2+d3+d4==1){
	continue;
	}
	else{
	alert("对不起，当前难度比例分配错误！");
	break;
	}
	
	
	
	}
	
}
</script>
</head>
	

<body>
<form id="form1" name="form1" method="post" action="save_select.jsp">
  <table width="911" height="283" border="0" align="center">
    <tr>
      <td height="57" colspan="8" bgcolor="#0072C6"><div align="center"><span class="STYLE1">设置选择题属性</span></div></td>
    </tr>
    <tr>
      <td width="51" height="51" bgcolor="#D9EBFE"><div align="center"><span class="STYLE3">chp</span></div></td>
      <td width="165" align="center" bgcolor="#D9EBFE"><div align="center"><span class="STYLE3">章节名称</span></div></td>
      <td width="105" align="center" bgcolor="#D9EBFE" class="STYLE3"><div align="center">章节比重</div></td>
      <td width="84" align="center" bgcolor="#D9EBFE"><div align="center"><span class="STYLE3">容易</span></div></td>
      <td width="84" align="center" bgcolor="#D9EBFE"><div align="center"><span class="STYLE3">简单</span></div></td>
      <td width="84" align="center" bgcolor="#D9EBFE"><div align="center"><span class="STYLE3">一般</span></div></td>
      <td width="84" align="center" bgcolor="#D9EBFE"><div align="center"><span class="STYLE3">困难</span></div></td>
      <td width="220" align="center" bgcolor="#D9EBFE"><div align="center" class="STYLE3">
        <div align="center">管理</div>
      </div></td>
    </tr>
    <%
				int submit_page = ParamUtils.getIntParameter(request, "page");
				int count=1;
				DbBasetableFactory bf = new DbBasetableFactory();
				Collection coll = bf.ListSelectChp(submit_page, "");
			//	out.print("coll:" + coll.size());
				if (coll == null || coll.size() <= 0) {
			%>
    <tr>
      <td colspan="8" bgcolor="#F0F0F9"><div align="center"><span class="STYLE3">当前无选择题章节信息，请添加！</span></div>     </td>
    </tr>
    <%
				} else {
					Iterator it = coll.iterator();
					while (it.hasNext()) {
						SelectChp s = (SelectChp) it.next();
						
						System.out.println("s"+s.getChp());
			%>
    <tr>
      <td bgcolor="#F0F0F9">&nbsp;<%=s.getId() %></td>
      <td bgcolor="#F0F0F9">&nbsp;<%=s.getChp()%></td>
      
      <td bgcolor="#F0F0F9">
      <select name="chp<%=count %>"  id="chp<%=count %>">
        <option value="0">0</option>
        <option value="0.05">5%</option>
        <option value="0.1">10%</option>
        <option value="0.15">15%</option>
        <option value="0.20" >20%</option>
        <option value="0.25">25%</option>
        <option value="0.30">30%</option>
        <option value="0.35">35%</option>
        <option value="0.40">40%</option>
        <option value="0.45">45%</option>
        <option value="0.50">50%</option>
        <option value="0.55">55%</option>
        <option value="0.60">60%</option>
        <option value="0.65">65%</option>
        <option value="0.70">70%</option>
        <option value="0.75">75%</option>
        <option value="0.80">80%</option>
        <option value="0.85">85%</option>
        <option value="0.90">90%</option>
        <option value="0.95">95%</option>
        <option value="1">100%</option>
      </select> </td>
      <%
      System.out.println("count"+count);
      session.setAttribute("id"+count,s.getId());
     
       %>
      <td bgcolor="#F0F0F9"><label>
        <select name="d1<%=count %>"  id="d1<%=count %>">
          <option value="0">0</option>
          <option value="0.5">5%</option>
          <option value="0.10">10%</option>
          <option value="0.15">15%</option>
          <option value="0.20" selected="selected">20%</option>
          <option value="0.25">25%</option>
          <option value="0.30">30%</option>
          <option value="0.35">35%</option>
          <option value="0.40">40%</option>
          <option value="0.45">45%</option>
          <option value="0.50">50%</option>
          <option value="0.55">55%</option>
          <option value="0.60">60%</option>
          <option value="0.65">65%</option>
          <option value="0.70">70%</option>
          <option value="0.75">75%</option>
          <option value="0.80">80%</option>
          <option value="0.85">85%</option>
          <option value="0.90">90%</option>
          <option value="0.95">95%</option>
          <option value="1">100%</option>
        </select>
      </label></td>
      <td bgcolor="#F0F0F9"><label>
        <select name="d2<%=count %>" id="d2<%=count %>">
		  <option value="0" >0</option>
          <option value="0.5">5%</option>
          <option value="0.10">10%</option>
          <option value="0.15">15%</option>
          <option value="0.20">20%</option>
          <option value="0.25">25%</option>
          <option value="0.30" selected="selected">30%</option>
          <option value="0.35">35%</option>
          <option value="0.40">40%</option>
          <option value="0.45">45%</option>
          <option value="0.50">50%</option>
          <option value="0.55">55%</option>
          <option value="0.60">60%</option>
          <option value="0.65">65%</option>
          <option value="0.70">70%</option>
          <option value="0.75">75%</option>
          <option value="0.80">80%</option>
          <option value="0.85">85%</option>
          <option value="0.90">90%</option>
          <option value="0.95">95%</option>
          <option value="1">100%</option>
        </select>
      </label></td>
      <td bgcolor="#F0F0F9"><label>
        <select name="d3<%=count %>" id="d3<%=count %>">
		 <option value="0" >0</option>
          <option value="0.5">5%</option>
          <option value="0.10">10%</option>
          <option value="0.15">15%</option>
          <option value="0.20">20%</option>
          <option value="0.25">25%</option>
          <option value="0.30" selected="selected">30%</option>
          <option value="0.35">35%</option>
          <option value="0.40">40%</option>
          <option value="0.45">45%</option>
          <option value="0.50">50%</option>
          <option value="0.55">55%</option>
          <option value="0.60">60%</option>
          <option value="0.65">65%</option>
          <option value="0.70">70%</option>
          <option value="0.75">75%</option>
          <option value="0.80">80%</option>
          <option value="0.85">85%</option>
          <option value="0.90">90%</option>
          <option value="0.95">95%</option>
          <option value="1">100%</option>
        </select>
      </label></td>
      <td bgcolor="#F0F0F9"><label>
        <select name="d4<%=count %>" id="d4<%=count %>">
		   <option value="0">0</option>
          <option value="0.5">5%</option>
          <option value="0.10">10%</option>
          <option value="0.15">15%</option>
          <option value="0.20" selected="selected">20%</option>
          <option value="0.25">25%</option>
          <option value="0.30">30%</option>
          <option value="0.35">35%</option>
          <option value="0.40">40%</option>
          <option value="0.45">45%</option>
          <option value="0.50">50%</option>
          <option value="0.55">55%</option>
          <option value="0.60">60%</option>
          <option value="0.65">65%</option>
          <option value="0.70">70%</option>
          <option value="0.75">75%</option>
          <option value="0.80">80%</option>
          <option value="0.85">85%</option>
          <option value="0.90">90%</option>
          <option value="0.95">95%</option>
          <option value="1">100%</option>
        </select>
      </label></td>
      <td bgcolor="#F0F0F9">&nbsp;&nbsp;&nbsp;
      <a href="modify_chp.jsp?action=del&id=<%=s.getId() %> "onClick="javascript:return confirm('你确定删除该章节吗？')"><img src="../images/shanchu.png" width="57" height="18"/></a></td>
    </tr>
    	<%
    	 count++;
				}
				}
			%>
    <tr>
      <td colspan="8" bgcolor="#2B579A"><label>
        <div align="center">
<input type="hidden" name="sumCount" value="<%=count%>" />
          <input name="Submit" type="button" value="添加章节" onClick="javascript:location.href='add_chp.jsp'"/>
          <input name="Submit2" type="submit" value="保存" onClick="return d()" />
          <input name="button" type="submit" value="退出" />
        </div>
      </label></td>
    </tr>
  </table>
</form>
</body>
</html>
