<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.model.*"%>
<%@ page import="com.core.*"%>
<%@ page import="com.dao.*,java.util.*,java.sql.*"%>
<%
	if (!Crazyadept.UserIsOK(session, FinalConstants.STATUS_ADMIN))
		return;
	session.removeAttribute("error");
	String action = request.getParameter("action").toString();
	String id = request.getParameter("id");
	//	out.println("uid: "+uid_v+"action: "+action);
	DbBasetableFactory bf = new DbBasetableFactory();
	if (action == null || "".equals(action)) {
		return;
	} else if ("del".equals(action)
			&& bf.DeleteBlank("WHERE id='" +id+ "'")) {
		response.sendRedirect("list_blank.jsp");
	} else if ("modify".equals(action)) {
		Blank b=new Blank();
		b = bf.SearchBlank("WHERE id='" + id + "'");
		b.setAns(ParamUtils.getRequestString(request,"ans"));
		b.setTimu(ParamUtils.getRequestString(request, "timu"));
		Connection con = null;
		PreparedStatement ps = null;
		con = DataBase.getConnection();
		ps = con.prepareStatement(FinalConstants.UPDATE_BLANK);
	System.out.println("ps: "+ps);
		ps.setString(1, b.getAns());
		ps.setString(2, b.getTimu());
		if (ps.executeUpdate() > 0) {
			out.println("second:u.getTimu" +b.getTimu());
		}
		response.sendRedirect("list_blank.jsp");
	} else {
		session.setAttribute("error", "在用户信息列表中操作失败");
		response.sendRedirect("error.jsp");
	}
%>