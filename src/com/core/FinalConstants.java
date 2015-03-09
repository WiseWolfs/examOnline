package com.core;

public final class  FinalConstants {
	public static int STEP = 15; // 每页显示几条数据
	public static final int STATUS_USER = 0;// 普通用户
	public static final int STATUS_ADMIN = 1;// 管理员
	public static final int PAPER_FINALS=0;//考试类型为期末考试
	public static final int PAPER_REFINALS=1;//考试类型为补考
	public static final int USER_PASS=0;//学生成绩及格
	public static final int USER_REPASS=1;//学生成绩不及格
//user
	public static final String INSERT_USER = "INSERT INTO user (name,uid,password,banji,yuanxi)VALUES(?,?,?,?,?)";
	public static final String UPDATE_USER = "UPDATE user SET password=?,name=?,banji=?,yuanxi=? where uid=?";
	public static final String UPDATE_USER_p="UPDATE user SET password=? where uid=?";
	public static final String UPDATE_USER_f="UPDATE user SET finals=? where uid=?";
	public static final String UPDATE_USER_r="UPDATE user SET refinals=? where uid=?";
	public static final String SELECT_USER = "SELECT * FROM user ";
	public static final String DELETE_USER = "DELETE FROM user ";
//selectbp备选数据库
	public static final String SELECT_SELECTBP="select * from selectbp";
//select	
	public static final String SELECT_SELECT = "SELECT * FROM selectinfo ";
	public static final String INSERT_SELECT = "INSERT INTO selectinfo (timu,ans,A,B,C,D,chp,diff) values(?,?,?,?,?,?,?,?)";
	public static final String DELETE_SELECT = "DELETE FROM selectinfo  ";
	public static final String SELECT_SELECT_r="select * from selectinfo order by rand() limit ";
	public static final String UPDATE_SELECT = "UPDATE selectinfo SET A=?,B=?,C=?,D=?,ans=? where timu=?";
//blank
	public static final String SELECT_BLANK="SELECT * FROM blankinfo ";
	public static final String INSERT_BLANK ="INSERT INTO blankinfo (timu,ans,chp,diff) value(?,?,?,?)";
	public static final String DELETE_BLANK ="DELETE FROM blankinfo ";
	public static final String UPDATE_BLANK ="UPDATE blankinfo SET ans=? where timu=?";
	
//selectchp
	public static final String SELECT_SELECTCHP="SELECT * FROM selectchp ";
	public static final String UPDATE_SELECTCHP_r="UPDATE selectchp SET chp_r=? where id=?";
	public static final String UPDATE_SELECTCHP="UPDATE selectchp SET chp_r=? where id=?";
	public static final String INSERT_SELECTCHP="INSERT INTO selectchp (id,chp) values(?,?)";
	public static final String DELETE_SELECTCHP="DELETE FROM selectchp ";
//blankchp
	public static final String SELECT_BLANKCHP="SELECT * FROM blankchp ";
	public static final String UPDATE_BLANKCHP_r="UPDATE blankchp SET chp_r=? where id=?";
	public static final String UPDATE_BLANKCHP="UPDATE blankchp SET chp_r=? where id=?";
	public static final String INSERT_BLANKCHP="INSERT INTO blankchp (id,chp) values(?,?)";
	public static final String DELETE_BLANKCHP="DELETE FROM blankchp ";
	
//selectdiff
	public static final String SELECT_SELECTDIFF="SELECT * FROM selectdiff ";
	public static final String INSERT_SELECTDIFF="INSERT INTO selectdiff (id) values (?)";
	public static final String DELETE_SELECTDIFF="DELETE FROM selectdiff ";
	public static final String UPDATE_SELECTDIFF="UPDATE selectdiff SET d1_r=?,d2_r=?,d3_r=?,d4_r=? where id=?";

//blankdiff
	public static final String SELECT_BLANKDIFF="SELECT * FROM blankdiff ";
	public static final String INSERT_BLANKDIFF="INSERT INTO blankdiff (id) values (?)";
	public static final String DELETE_BLANKDIFF="DELETE FROM blankdiff ";
	public static final String UPDATE_BLANKDIFF="UPDATE blankdiff SET d1_r=?,d2_r=?,d3_r=?,d4_r=? where id=?";

	
//paper
	public static final String INSERT_PAPER = "INSERT INTO paperinfo (blank_num,operate_num,select_num,blank_value,select_value,operate_value,paper_user,paper_timu)VALUES(?,?,?,?,?,?,?,?)";
	public static final String UPDATE_PAPER = "UPDATE paperinfo SET blank_num=?,operate_num=?,select_num=?,blank_value=?,operate_value=?,select_value=?,paper_user=?,paper_timu=? where paper_type=?";
	public static final String SELECT_PAPER = "SELECT * from paperinfo ";
}
