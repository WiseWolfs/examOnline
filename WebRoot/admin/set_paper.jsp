<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import="com.core.*,com.model.*,com.dao.*"%>
<%@ page import="java.sql.*"%>
<%
	if (!Crazyadept.UserIsOK(session, FinalConstants.STATUS_ADMIN))
		return;
	session.removeAttribute("error");
	DbBasetableFactory bf = new DbBasetableFactory();
	int pp = Integer.parseInt(request.getParameter("paper_type"));
	Paper p = bf.SearchPaper("where paper_type='" + pp + "'");
	p.setBn(Integer.parseInt(ParamUtils.getRequestString(request,
			"blank_num")));
	p.setBv(Integer.parseInt(ParamUtils.getRequestString(request,
			"blank_value")));
	p.setOn(Integer.parseInt(ParamUtils.getRequestString(request,
			"operate_num")));
	p.setOv(Integer.parseInt(ParamUtils.getRequestString(request,
			"operate_value")));
	p.setSn(Integer.parseInt(ParamUtils.getRequestString(request,
			"select_num")));
	p.setSv(Integer.parseInt(ParamUtils.getRequestString(request,
			"select_value")));
	p.setPu(ParamUtils.getRequestString(request, "paper_user"));
	p.setPt(ParamUtils.getRequestString(request, "paper_timu"));
	p.setPp(Integer.parseInt(ParamUtils.getRequestString(request,
			"paper_type")));
	//		out.println("first:u.getName"+u.getName());
	Connection con = null;
	PreparedStatement ps = null;
	con = DataBase.getConnection();
	ps = con.prepareStatement(FinalConstants.UPDATE_PAPER);
	//out.println("ps: "+ps);
	ps.setInt(1, p.getBn());
	ps.setInt(2, p.getOn());
	ps.setInt(3, p.getSn());
	ps.setInt(4, p.getBv());
	ps.setInt(5, p.getOv());
	ps.setInt(6, p.getSv());
	ps.setString(7, p.getPu());
	ps.setString(8, p.getPt());
	ps.setInt(9, pp);
	if (ps.executeUpdate() > 0) {
		out.print("恭喜您！试卷属性设置成功！");
		//response.sendRedirect("index.jsp");
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>试卷属性设置</title>
	</head>
<style type="text/css">
<!--
.STYLE2 {
	font-family: "Microsoft YaHei UI";
	font-size: 36px;
	color: #FFFFFF;
}
.STYLE3 {
	font-size: 24px;
	font-family: "Microsoft YaHei UI";
}
a{TEXT-DECORATION:none}
-->
</style>
</head>

<body>
<table width="400" border="0" align="center">
  <tr>
    <td height="50" bgcolor="#0072C6"><div align="center"><span class="STYLE2">试题录入</span></div></td>
  </tr>
  <tr>
    <td height="50" bgcolor="#D9EBFE" class="STYLE3"><div align="center"><a href="add_select.jsp">1.录入选择题</a></div></td>
  </tr>
  <tr>
    <td height="50" bgcolor="#F0F0F9" class="STYLE3"><div align="center"><a href="add_judge.jsp">2.录入判断题</a></div></td>
  </tr>
  <tr>
    <td height="50" bgcolor="#D9EBFE"><div align="center"><span class="STYLE3"><a href="add_operate.jsp">3.录入操作题</a></span></div></td>
  </tr>
  <tr>
    <td height="50" bgcolor="#F0F0F9"><label>
      <div align="center">
        <input name="Submit" type="submit" value="返回" onclick="javascript:location.href='main.jsp'" />
        </div>
    </label></td>
  </tr>
</table>
</body>
</html>
