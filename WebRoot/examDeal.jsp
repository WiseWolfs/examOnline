<%@ page language="java" import="java.util.*,com.model.*,com.core.*,com.dao.*,java.sql.*" pageEncoding="GBK"%>
<style type="text/css">
<!--
.STYLE1 {
	color: #FF0000;
	font-size: 24px;
}
-->
</style>
<%
	int i = 1, errorCount = 0, rightCount = 0;//选择题
	int i_b=1,errorCount_b=0,rightCount_b=0;//判断题
	
	float sum_score;
	float sum_score_b;
	
	int sumCount = Integer.parseInt(request.getParameter("sumCount"));
	int sumCount_b=Integer.parseInt(request.getParameter("sumCount_b"));
	User u=(User)session.getAttribute("user");
	System.out.println("u.getUid"+u.getUid());
	
	for (i = 1; i <= sumCount; i++) {
		String myans = request.getParameter("myans" + i);
		String ans = (String) session.getAttribute("ans" + i);
%>
<%
	if (myans == null) {
			errorCount++;
%>
<%
	} else if (myans.equals(ans))
			rightCount++;
		else {
			errorCount++;
		}
	}
%>
<% 
for (i_b = 1; i_b <= sumCount_b; i_b++) {
		String myans_b = request.getParameter("myans_b" + i_b);
		String ans_b = (String) session.getAttribute("ans_b" + i_b);
%>
<%
	if (myans_b == null) {
			errorCount_b++;
%>
<%
	} else if (myans_b.equals(ans_b))
			rightCount_b++;
		else {
			errorCount_b++;
		}

	}
%>
<html>
	<head>
		<title>考试结果</title>

	</head>
	<body>
		<p class="STYLE1">
			您答对题数：
		</p><%=rightCount+rightCount_b%><br />
		<p class="STYLE1">
			您答错题数：
		</p><%=errorCount+errorCount_b%><br />
		<p class="STYLE1">
		<%
		sum_score=2*rightCount+2*rightCount_b;
		 %>
		
			本次测试您的总成绩为：
		</p><%=sum_score%>分
		
		<br />
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		<%
		DbBasetableFactory bf = new DbBasetableFactory();
		User user=bf.SearchUser("where uid='"+u.getUid()+"'");
		Connection con = null;
		PreparedStatement ps = null;
		con = DataBase.getConnection();
		ps = con.prepareStatement(FinalConstants.UPDATE_USER_f);
		ps.setFloat(1,sum_score);
		ps.setString(2,u.getUid());
		if(ps.executeUpdate() > 0)
			System.out.println("u.getUid"+u.getUid());
		
		
		
		 %>
	  <label>
<input name="Submit" type="submit" value="关闭窗口" onClick="javascript:location.href='main.jsp'"/>
</label>
		<br>
	</body>
</html>
