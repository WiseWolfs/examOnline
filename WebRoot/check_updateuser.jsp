<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.model.*"%>
<%@ page import="com.core.*"%>
<%@ page import="com.dao.*,java.util.*,java.sql.*"%>
<%
	User u=null;
	u=(User)session.getAttribute("user");
	u.setPassword(ParamUtils.getRequestString(request,"t1"));
	Connection con = null;
		PreparedStatement ps = null;
		con = DataBase.getConnection();
		ps = con.prepareStatement(FinalConstants.UPDATE_USER_p);
	//	ps=con.prepareStatement(FinalConstants.UPDATE_USER_p);
		ps.setString(1,u.getPassword());
		ps.setString(2,u.getUid());
			if(ps.executeUpdate() > 0){
			out.println("恭喜您，密码修改成功！");
			}else {
		session.setAttribute("error", "在用户信息修改失败！");
		response.sendRedirect("error.jsp");
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'check_updateuser.jsp' starting page</title>
  </head>
  
  <body>
  </body>
</html>
