package JDBCDemo1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class PrepareStatementDemo {
	//添加
	@Test
	public void test1(){
		Connection conn=null;
		PreparedStatement sm=null;
		ResultSet rs=null;
		
		try {
			conn=DButils.getConnection();
			sm = conn.prepareStatement("INSERT INTO student VALUES(?,?,?)");
			//第一个参数表示第几个问号，第二个是填值
			sm.setInt(1, 3);
			sm.setString(2, "lili");
			sm.setInt(3, 789);
			int i = sm.executeUpdate();
			if(i>0){
				System.out.println("success");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DButils.CloseAll(rs, sm, conn);
		}
	}
	//改
	@Test
	public void test2(){
		Connection conn=null;
		PreparedStatement sm=null;
		ResultSet rs=null;
		try {
			conn=DButils.getConnection();
			sm = conn.prepareStatement("UPDATE student SET NAME=? WHERE id=?");
			sm.setString(1, "jerry");
			sm.setInt(2, 2);
			int i = sm.executeUpdate();
			if(i>0){
				System.out.println("success");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DButils.CloseAll(rs, sm, conn);
		}		
	}
	
	//删
	@Test
	public void test3(){
		
		Connection conn=null;
		PreparedStatement sm=null;
		ResultSet rs=null;
		try {
			conn=DButils.getConnection();
			sm = conn.prepareStatement("DELETE FROM student WHERE id=?");
			sm.setInt(1, 3);
			int i = sm.executeUpdate();
			if(i>0){
				System.out.println("success");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DButils.CloseAll(rs, sm, conn);
		}	
	}
	
	
	//原始方法
	@Test
	public void test4(){
		Connection conn = null;
		Statement sm = null;
		ResultSet rs = null;
		try {
			conn = DButils.getConnection();
			sm = conn.createStatement();
			rs = sm.executeQuery("select id,name,password from student");
			while (rs.next()) {
			System.out.println(rs.getObject("id"));
			System.out.println(rs.getObject("name"));
			System.out.println(rs.getObject("password"));
			System.out.println("-------------------");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			DButils.CloseAll(rs, sm, conn);
		}
	}
	@Test
	public void test5(){
		
		Connection conn=null;
		PreparedStatement sm=null;
		ResultSet rs=null;
		try {
			conn=DButils.getConnection();
			sm = conn.prepareStatement("select * FROM student WHERE id=? and name=?");
			sm.setInt(1,3);
			sm.setString(2, "lili");
			rs = sm.executeQuery();
			if(rs.next()){
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DButils.CloseAll(rs, sm, conn);
		}	
	}
	
}
