package DBConnectionPool;

import java.sql.Connection;
import java.util.Collections;
import java.util.LinkedList;

public class DBConnectionPool {
//创建连接池
	private static LinkedList<Connection> pool = (LinkedList<Connection>) Collections
			.synchronizedList(new LinkedList<Connection>());
	static {
		try {
			Connection conn;
			for (int i = 0; i < 10; i++) {
				conn = DButils.getConnection();
				pool.add(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 等待连接 连接池 判断pool是否有连接 有就返回
	public Connection getConnectionPool() {
		Connection conn = null;
		if (pool.size() > 0) {
			conn = pool.removeFirst();
			return conn;
		} else {
			throw new RuntimeException("服务器忙。。。。。。");
		}
	}

	// 释放资源 把资源放回连接池
	public void release(Connection conn) {
		pool.addLast(conn);
	}
}
