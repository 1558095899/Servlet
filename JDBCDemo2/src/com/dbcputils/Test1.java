package com.dbcputils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class Test1 {
	//查
	@Test
	public void test1(){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;		
		try {
			conn=DBCPutil.getConnection();
			ps=conn.prepareStatement("select * from student");
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));
				System.out.println("-----------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DBCPutil.release(conn, ps, rs);
		}
	}
}
