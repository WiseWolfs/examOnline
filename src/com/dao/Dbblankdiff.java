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
import com.model.BlankDiff;

public class Dbblankdiff {
	BlankDiff b=new BlankDiff();
	public Dbblankdiff(){
		
	}
	public BlankDiff Dbblankdiffs(String sql) {
		BlankDiff b=new BlankDiff();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DataBase.getConnection();
			ps = con.prepareStatement(FinalConstants.SELECT_BLANKDIFF + sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			if (rs.next()) {
				b.setD1_r(rs.getFloat("d1_r"));
				b.setD2_r(rs.getFloat("d2_r"));
				b.setD3_r(rs.getFloat("d3_r"));
				b.setD4_r(rs.getFloat("d4_r"));
				b.setId(rs.getInt("id"));
				
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println(ps + " Dbblankchp(String sql) " + b.getD1_r());
		}
		return b;
	}
	public Dbblankdiff(HttpServletRequest request) {
		b.setId(Integer.parseInt(ParamUtils.getParameter(request, "id")));
		
	}
	public Collection BlankDiff(int page, String sql) {
		Collection coll = new ArrayList();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		int tip = FinalConstants.STEP * (page - 1);
		con = DataBase.getConnection();
		try {
			ps = con.prepareStatement(FinalConstants.SELECT_BLANKDIFF + sql);
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
					BlankDiff b = new BlankDiff();
					b.setD1_r(rs.getFloat("d1_r"));
					b.setD2_r(rs.getFloat("d2_r"));
					b.setD3_r(rs.getFloat("d3_r"));
					b.setD4_r(rs.getFloat("d4_r"));
					
					
					coll.add(b);
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
	
	public boolean Insert() {
		boolean be = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataBase.getConnection();
			ps = con.prepareStatement(FinalConstants.INSERT_BLANKDIFF);
			ps.setInt(1, b.getId());
			

			if (ps.executeUpdate() > 0) {
				be = true;
			} else {
				be = false;
			}
		} catch (SQLException e) {
			be = false;
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println(ps + " Dbblankdiff.Insert()");
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
		return be;
	}
	
}
