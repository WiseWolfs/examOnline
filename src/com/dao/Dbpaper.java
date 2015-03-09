package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.dao.*;
import com.model.*;
import com.core.*;

public class Dbpaper extends Paper {
	Paper p = new Paper();
	Dbpaper(){
		
	}
	public Paper Dbpapers(String sql) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DataBase.getConnection();
			ps = con.prepareStatement(FinalConstants.SELECT_PAPER + sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			if (rs.next()) {
				p.setBn(rs.getInt("blank_num"));
				p.setBv(rs.getInt("blank_value"));
				p.setOn(rs.getInt("operate_num"));
				p.setOv(rs.getInt("operate_num"));
				p.setSn(rs.getInt("select_num"));
				p.setSv(rs.getInt("select_value"));
				p.setPu((ParamUtils.getSqlString(rs.getString("paper_user"))));
				p.setPt((ParamUtils.getSqlString(rs.getString("paper_timu"))));
				p.setPp(rs.getInt("paper_type"));
			
			
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println(ps + " Dbpaper(String sql) " + p.getPt());
		}
		return p;
	}

	public Dbpaper(HttpServletRequest request) {
		p.setBn(Integer.parseInt(ParamUtils.getRequestString(request,
				"blank_num")));
		p.setBv(Integer.parseInt(ParamUtils.getRequestString(request,
				"blank_value")));
		p.setOn(Integer.parseInt(ParamUtils.getRequestString(request,
				"operate_num")));
		p.setOv(Integer.parseInt(ParamUtils.getRequestString(request,
				"operate_value")));
		p.setSn(Integer.parseInt(ParamUtils.getRequestString(request,
				"select_num")));
		p.setSv(Integer.parseInt(ParamUtils.getRequestString(request,
				"select_value")));
		p.setPu(ParamUtils.getRequestString(request, "paper_user"));
		p.setPt(ParamUtils.getRequestString(request, "paper_timu"));
		p.setPp(Integer.parseInt(ParamUtils.getRequestString(request,"paper_type")));

	}
	public boolean Update(){
		boolean b=false;
		Connection con=null;
		PreparedStatement ps=null;
		DataBase.getConnection();
		try {
			ps=con.prepareStatement(FinalConstants.UPDATE_PAPER);
			ps.setInt(1, p.getBn());
			ps.setInt(2, p.getOn());
			ps.setInt(3, p.getSn());
			ps.setInt(4, p.getBv());
			ps.setInt(5, p.getOv());
			ps.setInt(6, p.getSv());
			ps.setString(7, p.getPu());
			ps.setString(8, p.getPt());
			ps.setInt(9, p.getPp());
			   if (ps.executeUpdate() > 0) {
	                b = true;
	            } else {
	                b = false;
	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				b=false;
			}
		}
		return b;
	}

	public boolean Insert() {
		boolean b = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataBase.getConnection();
			ps = con.prepareStatement(FinalConstants.INSERT_PAPER);
			ps.setInt(1, p.getBn());
			ps.setInt(2, p.getOn());
			ps.setInt(3, p.getSn());
			ps.setInt(4, p.getBv());
			ps.setInt(5, p.getSv());
			ps.setInt(6, p.getOv());
			ps.setString(7, p.getPu());
			ps.setString(8, p.getPt());
			ps.setInt(9, p.getPp());

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
			System.out.println(ps + " Dbpaper.Insert()");
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
