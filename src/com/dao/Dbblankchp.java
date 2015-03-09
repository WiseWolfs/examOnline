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
import com.model.BlankChp;

public class Dbblankchp extends BlankChp {
	
	BlankChp b=new BlankChp();
	public Dbblankchp(){
		
	}

	public BlankChp Dbblankchps(String sql) {
		BlankChp b=new BlankChp();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DataBase.getConnection();
			ps = con.prepareStatement(FinalConstants.SELECT_BLANKCHP + sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			if (rs.next()) {
				b.setChp_r(rs.getFloat("chp_r"));
				b.setId(rs.getInt("id"));
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println(ps + " Dbblankchp(String sql) " + b.getId());
		}
		return b;
	}
	public Dbblankchp(HttpServletRequest request) {

		b.setChp(ParamUtils.getRequestString(request, "chp"));
		b.setId(Integer.parseInt(ParamUtils.getRequestString(request, "id")));
	
		

	}
	public boolean Insert() {
		boolean be = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataBase.getConnection();
			ps = con.prepareStatement(FinalConstants.INSERT_BLANKCHP);
			ps.setInt(1, b.getId());
			ps.setString(2, b.getChp());

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
			System.out.println(ps + " Dbblankchp.Insert()");
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
	public Collection BlankChp(int page, String sql) {
		Collection coll = new ArrayList();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		int tip = FinalConstants.STEP * (page - 1);
		con = DataBase.getConnection();
		try {
			ps = con.prepareStatement(FinalConstants.SELECT_BLANKCHP + sql);
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
					BlankChp b = new BlankChp();
					b.setChp_r(rs.getFloat("chp_r"));
					b.setId(rs.getInt("id"));
					b.setChp(ParamUtils.getSqlString(rs.getString("chp")));
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
	
}
