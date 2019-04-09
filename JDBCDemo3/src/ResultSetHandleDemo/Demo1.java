package ResultSetHandleDemo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.queryrunner.C3P0Util;
import com.queryrunner.Student;

public class Demo1 {
	@Test
	public void test1() throws Exception{
		//ArrayHandler:适合取1条记录。把该条记录的每列值封装到一个数组中Object[]
		QueryRunner qr=new QueryRunner(C3P0Util.getDateSource());
		Object[] query = qr.query("select * from student", new ArrayHandler());
		//Object[] query = qr.query("select * from student where id=?", new ArrayHandler(),2);
		for(Object ob:query){
			System.out.println(ob);
		}
	}
	@Test
	public void test2() throws Exception{
		//BeanHandler  查询一条数据并封装到Student对象中
		QueryRunner qr=new QueryRunner(C3P0Util.getDateSource());
		//Student [id=1, name=tom, password=888]
		Student st = qr.query("select * from student", new BeanHandler<Student>(Student.class));
		//Student st = qr.query("select * from student where id=?", new BeanHandler<Student>(Student.class),2);
		System.out.println(st);
	}
	@Test
	public void test3() throws Exception{
		//BeanListHandler  查询所有数据以Student类型存入list集合
		QueryRunner qr=new QueryRunner(C3P0Util.getDateSource());
		List<Student> list = qr.query("select * from student", new BeanListHandler<Student>(Student.class));
		for (Student st : list) {
			System.out.println(st);
			
		}
	}
	@Test
	public void test4() throws Exception{
		//MapHandler:适合取1条记录。把当前记录的列名和列值放到一个Map中
		QueryRunner qr=new QueryRunner(C3P0Util.getDateSource());
		Map<String, Object> map = qr.query("select * from student", new MapHandler());
		for (Entry<String, Object> m : map.entrySet()) {
			System.out.println(m);
		}
	}
	@Test
	public void test5() throws Exception{
		//MapListHandler:适合取多条记录。把每条记录封装到一个Map中，再把Map封装到List中
		QueryRunner qr=new QueryRunner(C3P0Util.getDateSource());
		List<Map<String,Object>> list=qr.query("select * from student", new MapListHandler());
		for (Map<String, Object> map : list) {
			for (Entry<String, Object> m : map.entrySet()) {
				System.out.println(m);
			}
			
		}
	}
	@Test
	public void test6() throws Exception{
		//ScalarHandler:适合取单行单列数据   
		QueryRunner qr=new QueryRunner(C3P0Util.getDateSource());
		Object ob=qr.query("select * from student", new ScalarHandler(2));//表示第一行   第二列
		//Object ob=qr.query("select * from student where id=2", new ScalarHandler(1));//表示第二行  第一列
		System.out.println(ob);
	}
}
