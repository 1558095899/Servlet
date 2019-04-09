package com.mvc.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {
	private static String driverclass;
	private static String url;
	private static String user;
	private static String password;
	
	static{
		
		try {
			ResourceBundle b = ResourceBundle.getBundle("db");
			driverclass=b.getString("driverclass");
			url=b.getString("url");
			user=b.getString("user");
			password=b.getString("password");
			Class.forName(driverclass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnction() throws Exception{
		return DriverManager.getConnection(url, user, password);
	}
	public static void closeAll(ResultSet rs,PreparedStatement ps,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}rs=null;
		}  
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}ps=null;	
		}  
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
