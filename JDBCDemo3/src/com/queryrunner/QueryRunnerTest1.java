package com.queryrunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

public class QueryRunnerTest1 {
	//不带可变参数 
	@Test
	public void test1() throws Exception{
		QueryRunner qr=new QueryRunner(C3P0Util.getDateSource());//获取数据源
		//向数据库查询数据  并向Student对象封装查询到的数据   返回一个list集合    遍历打印
		List<Student> list = qr.query("select * from student", new BeanListHandler<Student>(Student.class));
		for (Student student : list) {
			System.out.println(student);
		}
	}
	//test1的原理
	@Test
	public void test2() throws Exception{
		QueryRunner qr=new QueryRunner(C3P0Util.getDateSource());
		List<Student> list = qr.query("select * from student", new ResultSetHandler<ArrayList<Student>>(){

			@Override
			public ArrayList<Student> handle(ResultSet rs) throws SQLException {
				ArrayList<Student> list=new ArrayList<Student>();
				while(rs.next()){
					Student s=new Student();
					s.setId(rs.getInt(1));
					s.setName(rs.getString(2));
					s.setPassword(rs.getInt(3));
					list.add(s);
				}
				return list;
			}
			
		});
		for (Student student : list) {
			System.out.println(student);
		}
	}
	@Test
	public void test11() throws Exception{
		QueryRunner qr=new QueryRunner(C3P0Util.getDateSource());//获取数据源
		//ArrayListHandler
		//读取多条数据   并把每一条数据封装在Object[]数组中  ，再存入list集合
		//所以当只遍历list集合时   得到的是Object数组      然后在对数组中的数据进行遍历才能拿到具体数据
		List<Object[]> list = qr.query("select * from student", new ArrayListHandler());
		for (Object[] ob : list) {
			for(Object o:ob){
				System.out.println(o);
			}
		}
	}
	
	//带可变参数  查询
	@Test
	public void test3() throws Exception{
		//QueryRunner需获取数据源  
		QueryRunner qr = new QueryRunner(C3P0Util.getDateSource());
		//问号与可变参数一一对应
		List<Student> list=qr.query("select * from student where id=? and name=?", new BeanListHandler<Student>(Student.class),1,"tom");
		for (Student st : list) {
			System.out.println(st);
		}
	}
	//带可变参数的  增删改
	@Test
	public void test4() throws Exception{
		//创建QueryRunner对象   传入数据源
		QueryRunner qr=new QueryRunner(C3P0Util.getDateSource());
		//int i = qr.update("insert into student(id,name,password) values(5,'uuuu',555)");
		//int i=qr.update("delete from student where id=?",5);
		int i = qr.update("update student set name=? where id=?", "saber",4);
		
		
	}
	//当QueryRunner对象没有获取数据源时
	@Test
	public void test5() throws Exception, Exception{
		QueryRunner qr=new QueryRunner();
		int i=qr.update(C3P0Util.getConnection(), "insert into student(id,name,password) values(?,?,?)", 5,"lilith",999);
		if(i>0){
			System.out.println("success");
		}
		
	}
	//batch  批量处理
	@Test
	public void test6() throws Exception{
		QueryRunner qr=new QueryRunner(C3P0Util.getDateSource());
		Object[][] params=new Object[10][];//高维代表多少条sql语句    即执行十次insert操作
		for(int i=0;i<params.length;i++){
			//表示每一条语句  中对应问号的值
			params[i]=new Object[]{5+i,"lili"+i,888};
		}
		qr.batch("insert into student(id,name,password) values(?,?,?)",params);
		/*//批量修改password
		Object[][] params=new Object[5][];
		for(int i=0;i<params.length;i++){
			params[i]=new Object[]{888,1+i};
		}
		qr.batch("update student set password=? where id=?", params);*/
	}
}
