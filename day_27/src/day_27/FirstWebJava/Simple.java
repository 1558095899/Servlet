//创建servlet方法一： Servlet接口
package day_27.FirstWebJava;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public  class Simple implements Servlet{
	
	//实例化
	public Simple(){
		System.out.println("-------实例化Simple--------");
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("---------destroy执行----------");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("---------init执行----------");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("----------service执行-------------");
		
	}


	
}
