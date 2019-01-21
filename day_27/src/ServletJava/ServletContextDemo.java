//请求转发
package ServletJava;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("现在忙，没空");
		System.out.println("请Demo1帮忙------");
		//请求向下转发
	
		ServletContext sc = this.getServletContext();
		//路径为xml配置文件中的url-pattern
		RequestDispatcher re = sc.getRequestDispatcher("/Demo1");
		re.forward(request, response);
		System.out.println("事情做完了-------");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
