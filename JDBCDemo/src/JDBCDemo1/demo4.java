package JDBCDemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class demo4 {
	@Test
	public void test1(){
		Connection conn = null;
		Statement sm = null;
		ResultSet rs = null;
		try {
			conn = DButils.getConnection();
			sm = conn.createStatement();
			rs = sm.executeQuery("select * from student");
			while (rs.next()) {
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			DButils.CloseAll(rs, sm, conn);
		}
	}
	@Test
	public void test2(){
		Connection conn=null;
		Statement sm=null;
		ResultSet rs=null;
		try {
			conn = DButils.getConnection();
			sm = conn.createStatement();
			rs = sm.executeQuery("select * from student");
			List<student> list=new ArrayList<student>();
			while(rs.next()){
				student st=new student();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setPassword(rs.getInt(3));
				list.add(st);
			}
			for (student student : list) {
				System.out.println(student);
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
