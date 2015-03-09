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
import com.model.*;

public class Dbselect extends Select {
	Select s = new Select();
	public Dbselect() {
	}

	public Select Dbselects(String sql) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DataBase.getConnection();
			ps = con.prepareStatement(FinalConstants.SELECT_SELECT + sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			if (rs.next()) {
				s.setA(ParamUtils.getSqlString(rs.getString("A")));
				s.setB(ParamUtils.getSqlString(rs.getString("B")));
				s.setC(ParamUtils.getSqlString(rs.getString("C")));
				s.setD(ParamUtils.getSqlString(rs.getString("D")));
				s.setAns(ParamUtils.getSqlString(rs.getString("ans")));
				s.setTimu(ParamUtils.getSqlString(rs.getString("timu")));
				s.setTime_id(rs.getInt("timu_id"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println(ps + " Dbselect(String sql) " + s.getTimu_id());
		}
		return s;
	}

	public Collection select(String sql) {
		Collection coll = new ArrayList();
		Connection con = null;
		Select s = new Select();
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DataBase.getConnection();
		try {
			ps = con.prepareStatement(FinalConstants.SELECT_SELECT);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {

				s.setTime_id(rs.getInt("timu_id"));
				s.setTimu(ParamUtils.getSqlString(rs.getString("timu")));
				s.setAns(ParamUtils.getSqlString(rs.getString("ans")));
				s.setA(ParamUtils.getSqlString(rs.getString("a")));
				s.setB(ParamUtils.getSqlString(rs.getString("b")));
				s.setC(ParamUtils.getSqlString(rs.getString("c")));
				s.setD(ParamUtils.getSqlString(rs.getString("d")));

				System.out.println("s.getTimu" + s.getTimu());
				System.out.println("s.getA" + s.getA());
				coll.add(s);
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

	public Dbselect(HttpServletRequest request) {

		s.setA(ParamUtils.getRequestString(request, "A"));
		s.setB(ParamUtils.getRequestString(request, "B"));
		s.setC(ParamUtils.getRequestString(request, "C"));
		s.setD(ParamUtils.getRequestString(request, "D"));
		s.setTimu(ParamUtils.getRequestString(request, "timu"));
		s.setAns(ParamUtils.getRequestString(request, "ans"));
		s.setChp(Integer.parseInt(ParamUtils.getRequestString(request, "chp")));
		s.setDiff(Integer.parseInt(ParamUtils.getRequestString(request, "diff")));
		

	}

	public boolean Insert() {
		boolean b = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataBase.getConnection();
			ps = con.prepareStatement(FinalConstants.INSERT_SELECT);
			ps.setString(1, s.getTimu());
			ps.setString(2, s.getAns());
			ps.setString(3, s.getA());
			ps.setString(4, s.getB());
			ps.setString(5, s.getC());
			ps.setString(6, s.getD());
			ps.setInt(7, s.getChp());
			ps.setInt(8, s.getDiff());
			if (ps.executeUpdate() > 0) {
				b = true;
			} else {
				b = false;
			}
		} catch (SQLException e) {
			b = false;
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println(ps + " Dbselect.Insert()");
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				ps = null;
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				con = null;
			}
		}
		return b;
	}

	public Collection Select(int page, String sql) {
		Collection coll = new ArrayList();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		int tip = FinalConstants.STEP * (page - 1);
		con = DataBase.getConnection();
		try {
			ps = con.prepareStatement(FinalConstants.SELECT_SELECT + sql);
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
					Select s = new Select();
					s.setTime_id(rs.getInt("timu_id"));
					s.setTimu(ParamUtils.getSqlString(rs.getString("timu")));
					s.setAns(ParamUtils.getSqlString(rs.getString("ans")));
					s.setA(ParamUtils.getSqlString(rs.getString("a")));
					s.setB(ParamUtils.getSqlString(rs.getString("b")));
					s.setC(ParamUtils.getSqlString(rs.getString("c")));
					s.setD(ParamUtils.getSqlString(rs.getString("d")));
					coll.add(s);
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
	
	public Collection Select_r(int page, String sql) {
		Collection coll = new ArrayList();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		int tip = FinalConstants.STEP * (page - 1);
		con = DataBase.getConnection();
		try {
			ps = con.prepareStatement(FinalConstants.SELECT_SELECT_r + sql);
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
					Select s = new Select();
					s.setTime_id(rs.getInt("timu_id"));
					s.setTimu(ParamUtils.getSqlString(rs.getString("timu")));
					s.setAns(ParamUtils.getSqlString(rs.getString("ans")));
					s.setA(ParamUtils.getSqlString(rs.getString("a")));
					s.setB(ParamUtils.getSqlString(rs.getString("b")));
					s.setC(ParamUtils.getSqlString(rs.getString("c")));
					s.setD(ParamUtils.getSqlString(rs.getString("d")));
					coll.add(s);
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
