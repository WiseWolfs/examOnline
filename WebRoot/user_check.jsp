<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ page import="com.core.*"%>
<%@ page import="com.dao.*,com.model.*"%>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 0);
	response.setHeader("Pragma", "no-cache");
	request.setCharacterEncoding("GBK")	;
	String uid = ParamUtils.getRequestString(request, "uid");
	DbBasetableFactory bf = new DbBasetableFactory();
	session.removeAttribute("error");
	session.removeAttribute("user");
	String password = ParamUtils.getRequestString(request, "password");
	System.out.println("uid:" + uid + "    " + "password:" + password);
	User u = bf.SearchUser("where uid='" + uid + "' and password='"
			+ password + "'");
	if (u.getUid() == null) {
		session.setAttribute("error", "用户名或密码错误");
		response.sendRedirect("index.jsp");
	} else if (uid != null && !"".equals(uid)
			&& u.getStatus() == FinalConstants.STATUS_ADMIN) {
		session.setAttribute("user", u);
		response.sendRedirect("admin/index.jsp");
	} else if ((uid != null && !"".equals(uid) && u.getStatus() == FinalConstants.STATUS_USER)) {
		session.setAttribute("user", u);
		System.out.println("u.getName"+u.getName());
		response.sendRedirect("homepage.jsp");
	} else {
		session.setAttribute("error", "用户名或密码错误");
		response.sendRedirect("error.jsp");
	}
%>

