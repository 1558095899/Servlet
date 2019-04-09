package com.c3p0utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class Test2 {
	@Test
	public void test1(){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=C3P0util.getConnection();
			ps=conn.prepareStatement("insert into student(id,name,password) values(4,'lucy',222)");
			int i=ps.executeUpdate();
			if(i>0){
				System.out.println("success");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
