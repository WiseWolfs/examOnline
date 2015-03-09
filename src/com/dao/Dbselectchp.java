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
import com.model.Select;
import com.model.SelectChp;

public class Dbselectchp extends SelectChp {
	
	SelectChp s=new SelectChp();
	public Dbselectchp(){
		
	}

	public SelectChp Dbselectchps(String sql) {
		SelectChp s=new SelectChp();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DataBase.getConnection();
			ps = con.prepareStatement(FinalConstants.SELECT_SELECTCHP + sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			if (rs.next()) {
				s.setChp_r(rs.getFloat("chp_r"));
				s.setId(rs.getInt("id"));
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println(ps + " Dbselectchp(String sql) " + s.getId());
		}
		return s;
	}
	public Dbselectchp(HttpServletRequest request) {

		s.setChp(ParamUtils.getRequestString(request, "chp"));
		s.setId(Integer.parseInt(ParamUtils.getRequestString(request, "id")));
	
		

	}
	public boolean Insert() {
		boolean b = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataBase.getConnection();
			ps = con.prepareStatement(FinalConstants.INSERT_SELECTCHP);
			ps.setInt(1, s.getId());
			ps.setString(2, s.getChp());

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
			System.out.println(ps + " Dbselectchp.Insert()");
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
			ps = con.prepareStatement(FinalConstants.SELECT_SELECTCHP + sql);
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
					SelectChp s = new SelectChp();
					s.setChp_r(rs.getFloat("chp_r"));
					s.setId(rs.getInt("id"));
					s.setChp(ParamUtils.getSqlString(rs.getString("chp")));
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
