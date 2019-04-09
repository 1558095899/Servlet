package DBConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class DButils {
	private static String driverClass;
	private static String url;
	private static String user;
	private static String password;
	static{
		ResourceBundle r = ResourceBundle.getBundle("dbinfo");
		//下面的driverClass、url、user、password不能加String
		driverClass = r.getString("driverClass");
		url = r.getString("url");
		user = r.getString("user");
		password = r.getString("password");
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws Exception{		
			return  DriverManager.getConnection(url, user, password);
	}
	public static void CloseAll(ResultSet rs, Statement sm, Connection conn){
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}rs=null;
			}  
			if(sm!=null){
				try {
					sm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}sm=null;	
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
