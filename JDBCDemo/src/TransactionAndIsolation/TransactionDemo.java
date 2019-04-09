package TransactionAndIsolation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import JDBCDemo1.DButils;
//JDBC中设置事务
public class TransactionDemo {
	@Test
	public void test(){
		Connection conn=null;
		PreparedStatement ps=null;
		PreparedStatement ps1=null;
		try {
			
			conn=DButils.getConnection();
			//设置事务隔离级别    要在开启事务之前
			//conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);//mysql默认隔离级别 不用设置
			//开启事务
			conn.setAutoCommit(false);//相当于 begin 或是  start transaction
			ps=conn.prepareStatement("update account set account=account-100 where name='aaa'");
			int i = ps.executeUpdate();
			//在没有开启事务情况下    发生异常  下一条语句不会发生    但上一条语句已经执行
			//int a=10/0;
			ps1=conn.prepareStatement("update account set account=account+100 where name='bbb'");
			int i1 = ps1.executeUpdate();
			
			//提交事务
			conn.commit();
		} catch (Exception e) {
			//异常时  rollback  回滚事务
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
