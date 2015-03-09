package com.core;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class DataBase {
	public static Connection conn = null;
	public static Statement st = null;
	public static ResultSet rs = null;
	private static String propFileName = "/com/connDB.properties";
	private static Properties prop = new Properties();
	private static String dbClassName = "com.mysql.jdbc.Driver";
	private static String dbUrl = "jdbc:mysql://127.0.0.1:3306/myexam?user=root&password=root&useUnicode=true";

	public static void main(String args[]) {
		System.out.print(getRow("user"));
	}

	public DataBase() {
		try {
			InputStream in = this.getClass().getResourceAsStream(propFileName);
			prop.load(in);
			dbClassName = prop.getProperty("DB_CLASS_NAME");
			dbUrl = prop.getProperty("DB_URL");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {

			Class.forName(dbClassName).newInstance();
			conn = DriverManager.getConnection(dbUrl);

		} catch (Exception ee) {
			ee.printStackTrace();
		}
		if (conn == null) {
			System.err
					.println("警告: DbConnectionManager.getConnection() 获得数据库链接失败.\r\n\r\n链接类型:"
							+ dbClassName + "\r\n链接位置:" + dbUrl);
		}
		return conn;
	}

	public static int getRow(String sql) {
		int i = 0;
		conn = DataBase.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select count(*) from " + sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			i = 0;
		} finally {
			System.out.println("select count(*) from " + sql);
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;

	}

	public static boolean Delete(String sql) {
		boolean b = false;
		Connection con = null;
		PreparedStatement ps = null;
		con = getConnection();
		try {
			ps = con.prepareStatement(sql);
			if (ps.executeUpdate(sql) > 0) {
				b = true;
			} else {
				b = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			b = false;
		} finally {
			System.out.println(ps+"DataBase.Delete()+sql");
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				b = false;
			}

		}
		return b;
	}
}