package DBConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

public class MyConnection extends WraperDesign{
	//适配器
	private Connection conn;
	LinkedList<Connection> pool;
	//继承WraperDesign类    筛选出需要改写的方法并重写
	public MyConnection(Connection conn,LinkedList<Connection> pool){
		//显式调用父类有参构造器
		super(conn);
		this.conn=conn;
		this.pool=pool;
	}
	
	//重写close
	@Override
	public void close() throws SQLException {
		pool.addLast(conn);
	}
	
}
