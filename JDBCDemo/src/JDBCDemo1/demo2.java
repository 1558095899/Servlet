package JDBCDemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class demo2 {
	//查询    executequery
		@Test
		public void test() throws Exception{
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//连接
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
			Statement sm = conn.createStatement();
			//执行语句
			ResultSet rs = sm.executeQuery("select id,name,password from student");
			//处理结果
			while(rs.next()){
				System.out.println(rs.getObject("id"));
				System.out.println(rs.getObject("name"));
				System.out.println(rs.getObject("password"));
				System.out.println("---------------");
			}
			rs.close();
			sm.close();
			conn.close();
			
		}
		//增删改    executeupdate
		@Test
		public void test1() throws Exception{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
			Statement sm = conn.createStatement();
			int re = sm.executeUpdate("DELETE FROM student WHERE id=3");
			if(re>0){
				System.out.print("success"+"\t");
				System.out.println(re+"行受影响");
			}
			sm.close();
			conn.close();
			
		} 
		
		//把数据存放到list集合中  并查询出
		@Test
		public void test2() throws Exception{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
			Statement sm = conn.createStatement();
			ResultSet rs = sm.executeQuery("select id,name,password from student");
			List<student> list=new ArrayList<student>();
			while(rs.next()){
				student st=new student();
				st.setId(rs.getInt("id"));
				st.setName(rs.getString("name"));
				st.setPassword(rs.getInt("password"));
				list.add(st);
			}
			for (student student : list) {
				System.out.println(student);
			}
			rs.close();
			sm.close();
			conn.close();
		}
}

