<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.model.*"%>
<%@ page import="com.core.*"%>
<%@ page import="com.dao.*,java.util.*,java.sql.*"%>
<%
	if (!Crazyadept.UserIsOK(session, FinalConstants.STATUS_ADMIN))
		return;
	session.removeAttribute("error");
	String action = request.getParameter("action").toString();
	String uid_v = request.getParameter("uid_v");
	//	out.println("uid: "+uid_v+"action: "+action);
	DbBasetableFactory bf = new DbBasetableFactory();
	if (action == null || "".equals(action)) {
		return;
	} else if ("del".equals(action)
			&& bf.DeleteSelect("WHERE timu_id='" + uid_v + "'")) {
		response.sendRedirect("list_select.jsp");
	} else if ("modify".equals(action)) {
		Select s = new Select();
		s = bf.SearchSelect("WHERE timu_id='" + uid_v + "'");
		s.setA(ParamUtils.getRequestString(request, "A"));
		s.setB(ParamUtils.getRequestString(request, "B"));
		s.setC(ParamUtils.getRequestString(request, "C"));
		s.setD(ParamUtils.getRequestString(request,"D"));
		s.setAns(ParamUtils.getRequestString(request,"ans"));
		s.setTimu(ParamUtils.getRequestString(request, "timu"));
	System.out.println("first:u.getName"+s.getTimu());
		Connection con = null;
		PreparedStatement ps = null;
		con = DataBase.getConnection();
		ps = con.prepareStatement(FinalConstants.UPDATE_SELECT);
	System.out.println("ps: "+ps);
		ps.setString(1, s.getA());
		ps.setString(2, s.getB());
		ps.setString(3,s.getC());
		ps.setString(4, s.getD());
		ps.setString(5,s.getAns());
		ps.setString(6, s.getTimu());
		if (ps.executeUpdate() > 0) {
			out.println("second:u.getTimu" +s.getTimu());
		}
	System.out.println("u.getName"+s.getTimu());
		response.sendRedirect("list_select.jsp");
	} else {
		session.setAttribute("error", "在用户信息列表中操作失败");
		response.sendRedirect("error.jsp");
	}
%>