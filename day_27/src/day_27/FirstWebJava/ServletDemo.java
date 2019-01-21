//创建Servlet方法二：适配器 GenericServlet
package day_27.FirstWebJava;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public  class ServletDemo extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("适配器GenericServlet创建Servlet");
		
	}

}
