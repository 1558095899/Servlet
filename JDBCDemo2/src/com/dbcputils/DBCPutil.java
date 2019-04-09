package com.dbcputils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPutil {
	private static DataSource ds=null;
	//初始化代码块
	static{
		Properties p = new Properties();//实例化属性对象		
		try {
			//获取DBCPutil对象字节码文件并从而获得dbcpconfig.propertie
			//加载
			p.load(DBCPutil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));
			ds= BasicDataSourceFactory.createDataSource(p);//得到一个数据源
		} catch (Exception e) {
			throw new RuntimeException("初始化错误！");
		}
	}
	//等待用户连接
	public static Connection getConnection(){
		try {
			Connection conn = ds.getConnection();
			return conn;
		} catch (SQLException e) {
			throw new RuntimeException("服务器忙。。。。");
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
