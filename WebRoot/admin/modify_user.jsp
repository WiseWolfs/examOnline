<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.model.*"%>
<%@ page import="com.core.*"%>
<%@ page import="com.dao.*,java.util.*,java.sql.*"%>
<%
	

	session.removeAttribute("error");
	String action = request.getParameter("action").toString();
	String uid_v = request.getParameter("uid_v");
	//System.out.print("user attri"+us.getBanji());
	System.out.println("uid: "+uid_v+"action: "+action);
	DbBasetableFactory bf = new DbBasetableFactory();
	if (action == null || "".equals(action)) {
		return;
	} else if ("add".equals(action) && bf.CreatUser(request)) {
		response.sendRedirect("list_user.jsp");
	} else if ("del".equals(action) && bf.DeleteUser("WHERE uid='" + uid_v + "'")) {
		response.sendRedirect("list_user.jsp");
	} else if ("modify".equals(action)) {
		User u=new User();
		u = bf.SearchUser("WHERE uid='" + uid_v + "'");
		System.out.println("first:u.getName"+u.getName());
		u.setBanji(ParamUtils.getRequestString(request,"banji"));
		u.setName(ParamUtils.getRequestString(request,"name"));
		u.setPassword(ParamUtils.getRequestString(request,"password"));
		u.setUid(ParamUtils.getRequestString(request,"uid_v"));
		u.setYuanxi(ParamUtils.getRequestString(request,"yuanxi"));
		//u.setStatus(ParamUtils.getIntParameter(request,"status"));
		System.out.println("SECOND:u.getName"+u.getName());
		Connection con = null;
		PreparedStatement ps = null;
		con = DataBase.getConnection();
		ps = con.prepareStatement(FinalConstants.UPDATE_USER);
		out.println("ps: "+ps);
		ps.setString(1, u.getPassword());
		//ps.setInt(2, u.getStatus());
		ps.setString(2, u.getName());
		ps.setString(3, u.getBanji());
		ps.setString(4, u.getYuanxi());
		ps.setString(5, u.getUid());
		if(ps.executeUpdate() > 0){
			out.println("second:u.getName"+u.getName());
		}
		//out.println("u.getName"+u.getName());
	response.sendRedirect("list_user.jsp");
	} else {
		session.setAttribute("error", "在用户信息列表中操作失败");
		response.sendRedirect("error.jsp");
	}
%>
