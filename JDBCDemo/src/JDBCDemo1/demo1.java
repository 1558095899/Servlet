package JDBCDemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class demo1 {

	public static void main(String[] args) throws Exception{
		//1、加载驱动   架包下的Driver驱动类
		Class.forName("com.mysql.jdbc.Driver");
		//2、获取connection连接  
		//格式： jdbc：mysql：//地址（url）：端口号（3306）/需要访问的数据库名（mydb1），账户名，密码
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1", "root", "root");
		//3、得到sql语句对象statement
		Statement cr = conn.createStatement();
		//4、执行语句
		ResultSet rs = cr.executeQuery("select * from dept");
		//5、处理数据
		while(rs.next()){
			//rs获取对象类型为Object  3个为一行 其数字为每一列位置
			System.out.println(rs.getObject(1));//第一列
			System.out.println(rs.getObject(2));//第二列
			System.out.println(rs.getObject(3));//第三列
			System.out.println("----------------");
		}
		//6、关闭资源
		rs.close();
		cr.close();
		conn.close();
	}

}
