package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import com.core.DataBase;

import com.core.FinalConstants;
import com.core.ParamUtils;
import com.model.User;

public class Dbuser extends User {
	User u = new User();
	public User Dbusers(String sql) {
		User user = new User();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DataBase.getConnection();
			ps = con.prepareStatement(FinalConstants.SELECT_USER + sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			if (rs.next()) {
				user.setUid(ParamUtils.getSqlString(rs.getString("uid")));
				user.setPassword(ParamUtils.getSqlString(rs
						.getString("password")));
				user.setStatus(rs.getInt("status"));
				user.setName(ParamUtils.getSqlString(rs.getString("name")));
				user.setBanji(ParamUtils.getSqlString(rs.getString("banji")));
				user.setFinals(rs.getFloat("finals"));
				user.setRefinals(rs.getFloat("refinals"));
				user.setYuanxi(ParamUtils.getSqlString(rs.getString("yuanxi")));
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println(ps + " Dbuser(String sql) " + user.getUid());
		}
		return user;
	}

	public Dbuser(HttpServletRequest request) {
		u.setUid(ParamUtils.getRequestString(request, "uid"));
		u.setPassword(ParamUtils.getRequestString(request, "password"));
		u.setBanji(ParamUtils.getRequestString(request, "banji"));
		u.setYuanxi(ParamUtils.getRequestString(request, "yuanxi"));
		u.setName(ParamUtils.getRequestString(request, "name"));
		//u.setFinals(Float.parseFloat(ParamUtils.getRequestString(request, "finals")));
		//u.setRefinals(Float.parseFloat(ParamUtils.getRequestString(request, "refinals")));
		//u.setStatus(Integer.parseInt(ParamUtils.getRequestString(request, "status")));
	//	u.setIspass(Integer.parseInt(ParamUtils.getRequestString(request, "ispass")));
		

	}

	public Dbuser() {
		// TODO Auto-generated constructor stub
	}

	public boolean Insert() {
		boolean b = false;
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataBase.getConnection();
			ps = con.prepareStatement(FinalConstants.INSERT_USER);
			ps.setString(1, u.getName());
			ps.setString(2, u.getUid());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getBanji());
			ps.setString(5, u.getYuanxi());

			if (ps.executeUpdate() > 0) {
				b = true;
			} else {
				b = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			b = false;
		} finally {
			try {
				if(ps!=null){
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return b;
	}

	public boolean Update() {
		boolean b = false;
		Connection con = null;
		PreparedStatement ps = null;
		con = DataBase.getConnection();
		try {
			ps = con.prepareStatement(FinalConstants.UPDATE_USER);
			ps.setString(1, u.getPassword());
			ps.setInt(2, u.getStatus());
			ps.setString(3, u.getName());
			ps.setString(4, u.getBanji());
			ps.setString(5, u.getYuanxi());
			ps.setString(6, u.getUid());
			if (ps.executeUpdate() > 0) {
				b = true;
			} else {
				b = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			b = false;
		} finally {
			try {
				  System.out.println(ps + " Dbaffiche.Update() ");
				  if(ps!=null){
						ps.close();
					}
					if(con!=null){
						con.close();
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return b;
	}

	public Collection Select(String sql) {
		Collection coll = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DataBase.getConnection();
		try {
			ps = con.prepareStatement(FinalConstants.SELECT_USER);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {

				u.setUid(ParamUtils.getSqlString(rs.getString("uid")));
				u
						.setPassword(ParamUtils.getSqlString(rs
								.getString("password")));

				coll.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if(ps!=null){
				ps.close();
			}
			if(rs!=null){
				rs.close();
			}
			if(con!=null){
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return coll;
	}

	public Collection Select(int page, String sql) {
		Collection coll = new ArrayList();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		int tip = FinalConstants.STEP * (page - 1);
		con = DataBase.getConnection();
		try {
			ps = con.prepareStatement(FinalConstants.SELECT_USER + sql);
			rs = ps.executeQuery();
			if (tip <= 0) {
				rs.beforeFirst();
			} else {
				if (!rs.absolute(tip)) {
					rs.beforeFirst();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			for (int i = 1; rs.next() && i <= FinalConstants.STEP; i++) {
				try {
					User user = new User();
					user.setUid(ParamUtils.getSqlString(rs.getString("uid")));
					user.setPassword(ParamUtils.getSqlString(rs
							.getString("password")));
					user.setBanji(ParamUtils.getSqlString(rs.getString("banji")));
					user.setName(ParamUtils.getSqlString(rs.getString("name")));
					user.setFinals(rs.getFloat("finals"));
					user.setRefinals(rs.getFloat("refinals"));
					user.setYuanxi(ParamUtils.getSqlString(rs.getString("yuanxi")));
					coll.add(user);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null){
					ps.close();
				}
				if(rs!=null){
					rs.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return coll;
		}

	}
}
	