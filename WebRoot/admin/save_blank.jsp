<%@ page contentType="text/html; charset=GBK"%>
<%@ page import="com.model.*"%>
<%@ page import="com.core.*"%>
<%@ page import="com.dao.*,java.util.*,java.sql.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%
	int count=1,id;//chp是章节比重,id是章节号
	float chp_r;
	float d11,d22,d33,d44;
	DbBasetableFactory bf=new DbBasetableFactory();
	//String idd;
	int sumCount=Integer.parseInt(request.getParameter("sumCount"))-1;
	for(int i=1;i<=sumCount;i++){
		 id=(Integer)session.getAttribute("id"+count);
		chp_r=Float.parseFloat(request.getParameter("chp"+count));
		d11=Float.parseFloat(request.getParameter("d1"+count));
		d22=Float.parseFloat(request.getParameter("d2"+count));
		d33=Float.parseFloat(request.getParameter("d3"+count));
		d44=Float.parseFloat(request.getParameter("d4"+count));
		BlankDiff sd=bf.SearchBlankDiff("where id='"+id+"'");
		sd.setD1_r(d11);
		sd.setD2_r(d22);
		sd.setD3_r(d33);
		sd.setD4_r(d44);
		sd.setId(id);
		System.out.println("d1"+d11);
		BlankChp s=bf.SearchBlankChp("where id='"+id+"'");
		s.setChp_r(chp_r);
		s.setId(id);
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps1=null;
		con = DataBase.getConnection();
		ps = con.prepareStatement(FinalConstants.UPDATE_BLANKCHP);
		ps1=con.prepareStatement(FinalConstants.UPDATE_BLANKDIFF);
		ps1.setFloat(1,sd.getD1_r());
		ps1.setFloat(2,sd.getD2_r());
		ps1.setFloat(3,sd.getD3_r());
		ps1.setFloat(4,sd.getD4_r());
		ps1.setInt(5,sd.getId());
		ps.setFloat(1,s.getChp_r());
		ps.setInt(2,s.getId());
			if (ps.executeUpdate() > 0) {
			out.println("first:u.getId" +s.getId()+"保存成功");
		}
		if (ps1.executeUpdate() > 0) {
			out.println("second:u.getId" +s.getId()+"保存成功");
		}
		

		count++;
		
	}
	response.sendRedirect("paper_manage.jsp");
	
	
 %>
  <head>
    <title>保存属性设置</title>
  </head>
  <body>
  </body>
</html>
