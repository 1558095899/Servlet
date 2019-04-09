package com.c3p0utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0util {
	private static DataSource ds = new ComboPooledDataSource();//得到资源
	public static Connection getConnection(){
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("服务器忙。。。");
		}
	}
	//释放资源 或者关闭
		public static void release(Connection conn,Statement sm,ResultSet rs){
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}rs=null;
			}  
			if(sm!=null){
				try {
					sm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}sm=null;	
			}  
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		}
}
