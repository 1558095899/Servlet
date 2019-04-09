package DBConnectionPool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;
//DataSource   sun公司规定的数据源(连接池)
public class MyDataSource implements DataSource {
	private static LinkedList<Connection> pool=(LinkedList<Connection>) Collections
			.synchronizedList(new LinkedList<Connection>());
	static{
		try{
			for (int i = 0; i < 10; i++) {
				Connection conn = DButils.getConnection();
				pool.add(conn);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	//重写父类方法	
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn=null;
		if(pool.size()>0){
			conn=pool.removeFirst();
			// 向有参构造器传递参数    并Myconn获得改写后的close方法
			MyConnection Myconn=new MyConnection(conn,pool);
			//此时  Myconn内的close方法已经别重写
			return Myconn;
		}else{
			throw new RuntimeException("服务器忙。。。。");
		}
		
		
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public Connection getConnection(String username, String password)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
