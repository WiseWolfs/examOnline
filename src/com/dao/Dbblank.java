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

public class Dbblank extends Blank {
	Blank b = new Blank();
	public Dbblank() {
	}

	public Blank Dbblanks(String sql) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = DataBase.getConnection();
			ps = con.prepareStatement(FinalConstants.SELECT_BLANK + sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = ps.executeQuery();
			if (rs.next()) {
				b.setAns(ParamUtils.getSqlString(rs.getString("ans")));
				b.setTimu(ParamUtils.getSqlString(rs.getString("timu")));
				b.setId(rs.getInt("id"));
				b.setChp(rs.getInt("chp"));
				b.setDiff(rs.getInt("diff"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println(ps + " Dbblank(String sql) " + b.getTimu());
		}
		return b;
	}

	public Collection blank(String sql) {
		Collection coll = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = DataBase.getConnection();
		try {
			ps = con.prepareStatement(FinalConstants.SELECT_BLANK);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {

				b.setAns(ParamUtils.getSqlString(rs.getString("ans")));
				b.setTimu(ParamUtils.getSqlString(rs.getString("timu")));
				b.setId(rs.getInt("id"));
				b.setChp(rs.getInt("chp"));
				b.setDiff(rs.getInt("diff"));

				System.out.println("s.getTimu" + b.getTimu());
				System.out.println("s.getA" + b.getAns());
				coll.add(b);
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

	public Dbblank(HttpServletRequest request) {
		
		b.setAns(ParamUtils.getRequestString(request, "ans"));
		b.setChp(Integer.parseInt(ParamUtils.getRequestString(request, "chp")));
		b.setTimu(ParamUtils.getRequestString(request, "timu"));
		b.setDiff(Integer.parseInt(ParamUtils.getRequestString(request, "diff")));

	}

	public boolean Insert() {
		boolean be = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataBase.getConnection();
			ps = con.prepareStatement(FinalConstants.INSERT_BLANK);
			ps.setString(1, b.getTimu());
			ps.setString(2, b.getAns());
			ps.setInt(3, b.getChp());
			ps.setInt(4, b.getDiff());
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
			System.out.println(ps + " Dbblank.Insert()");
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

	public Collection Blank(int page, String sql) {
		Collection coll = new ArrayList();
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		int tip = FinalConstants.STEP * (page - 1);
		con = DataBase.getConnection();
		try {
			ps = con.prepareStatement(FinalConstants.SELECT_BLANK+ sql);
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
					Blank b=new Blank();//去掉后，会重复输出一样的数据
					b.setAns(ParamUtils.getSqlString(rs.getString("ans")));
					b.setTimu(ParamUtils.getSqlString(rs.getString("timu")));
					b.setId(rs.getInt("id"));
					b.setChp(rs.getInt("chp"));
					b.setDiff(rs.getInt("diff"));

					System.out.println("s.getTimu" + b.getTimu());
					System.out.println("s.getA" + b.getAns());
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
