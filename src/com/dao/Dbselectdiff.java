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
import com.model.SelectChp;
import com.model.SelectDiff;

public class Dbselectdiff {
	SelectDiff s=new SelectDiff();
	public Dbselectdiff(){
		
	}
	public SelectDiff Dbselectdiffs(String sql) {
		SelectDiff s=new SelectDiff();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DataBase.getConnection();
			ps = con.prepareStatement(FinalConstants.SELECT_SELECTDIFF + sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			if (rs.next()) {
				s.setD1_r(rs.getFloat("d1_r"));
				s.setD2_r(rs.getFloat("d2_r"));
				s.setD3_r(rs.getFloat("d3_r"));
				s.setD4_r(rs.getFloat("d4_r"));
				s.setId(rs.getInt("id"));
				
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println(ps + " Dbselectchp(String sql) " + s.getD1_r());
		}
		return s;
	}
	public Dbselectdiff(HttpServletRequest request) {
		s.setId(Integer.parseInt(ParamUtils.getParameter(request, "id")));
		
	}
	public Collection Select(int page, String sql) {
		Collection coll = new ArrayList();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		int tip = FinalConstants.STEP * (page - 1);
		con = DataBase.getConnection();
		try {
			ps = con.prepareStatement(FinalConstants.SELECT_SELECTDIFF + sql);
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
					SelectDiff s = new SelectDiff();
					s.setD1_r(rs.getFloat("d1_r"));
					s.setD2_r(rs.getFloat("d2_r"));
					s.setD3_r(rs.getFloat("d3_r"));
					s.setD4_r(rs.getFloat("d4_r"));
					
					
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
	
	public boolean Insert() {
		boolean b = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataBase.getConnection();
			ps = con.prepareStatement(FinalConstants.INSERT_SELECTDIFF);
			ps.setInt(1, s.getId());
			

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
			System.out.println(ps + " Dbselectdiff.Insert()");
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
	
}
