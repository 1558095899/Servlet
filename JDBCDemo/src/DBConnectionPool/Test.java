package DBConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class Test {
	/**
	 * MyDateSource类中有getConnection方法       调用该方法(1)之后   实例化了MyConnection  
	 * 并向MyConnection类中参构造器传递参数     而MyConnection继承已经实现了Connection接口的WraperDesign类
	 * 并重写了close方法   
	 * Myconn获得改写后的close方法    并return回Test类中（1）中的conn
	 */
	@org.junit.Test
	public void test(){
		Connection conn=null;
		PreparedStatement ps=null;
		DataSource ds=new MyDataSource();
		try {
			conn=ds.getConnection();//1
			ps = conn.prepareStatement("");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			//使用装饰设计模式    重写close（）方法    使连接放回连接池
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
