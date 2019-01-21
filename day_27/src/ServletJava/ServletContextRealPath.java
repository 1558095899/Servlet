//获取绝对路径
package ServletJava;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextRealPath extends HttpServlet {
	
	public String hello;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取绝对路径
		//D:\Tomcat\webapps\day_27\WEB-INF\a.properties
		String realPath = this.getServletContext().getRealPath("/WEB-INF/a.properties");
		System.out.println(realPath);
		//D:\Tomcat\webapps\day_27
		String realPath2 = this.getServletContext().getRealPath("/");
		System.out.println(realPath2);
		
		//获取路径内的信息-
		Properties pro = new Properties();//创建属性properties对象
		pro.load(new FileInputStream(realPath));
		System.out.println(pro.getProperty("key"));
		
	}



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
