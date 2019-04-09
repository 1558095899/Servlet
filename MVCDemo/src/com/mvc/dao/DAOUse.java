package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.mvc.dbutils.DBUtils;
import com.mvc.user.User;

public class DAOUse {
	//注册操作
	public User logister(User user){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnction();
			ps=conn.prepareStatement("INSERT INTO USER(NAME,PASSWORD,DATE) VALUES(?,?,?)");
			ps.setString(1,user.getName());
			ps.setString(2, user.getPassword());
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String f = sdf.format(user.getDate());
			ps.setString(3,f);
			int i=ps.executeUpdate();
			if(i>0){
				System.out.println("添加用户成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		 throw new RuntimeException("添加用户失败");	
		}
		finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		return null;
	}
	
	//登入操作    
	/**
	 * 把数据与数据库进行对比   .next()方法有返回值 则表示对比成功  取得数据
	 * 存在则   把数据存入javabean（user）中  返回user 并在servlet服务页进行判断是否为null 不为null表示登入成功 
	 * 不存在返回null  登入失败
	 * 
	 */
	public User login(User user){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnction();
			ps = conn.prepareStatement("SELECT * FROM USER WHERE NAME=? AND PASSWORD=?");
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			//查询得到执行下一步
			if(rs.next()){
				User u=new User();
				//注意：在数据库中     name是从第二列开始    第一列为id
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setDate(rs.getDate(4));
				return u;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBUtils.closeAll(rs, ps, conn);
		}
		
		return null;
	}
}
