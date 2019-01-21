package HttpServletRequest;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletRequestHeader extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*1、请求行  
		
		getMethod(); 获得请求方式
		***getRequestURL();返回客户端发出请求时的完整URL。
		***getRequestURI(); 返回请求行中的资源名部分。
		*****getContextPath(); 当前应用的虚拟目录 /day09_01_request
		getQueryString() ; 返回请求行中的参数部分*/
		//获取request方法名  
		//org.apache.catalina.connector.RequestFacade
		String name = request.getClass().getName();
		System.out.println(name);
		//获得请求方法   GET
		String method = request.getMethod();
		System.out.println(method);
		//返回客户端的完整URL http://localhost/day_27/request
		StringBuffer url = request.getRequestURL();
		System.out.println(url);
		//返回请求客户端的资源名   /day_27/request
		String uri = request.getRequestURI();
		System.out.println(uri);
		//当前请求行中的虚拟目录  /day_27
		String path = request.getContextPath();
		System.out.println(path);
		//获取访问ip地址
		String addr = request.getRemoteAddr();
		System.out.println(addr);
		//主机
		String host = request.getRemoteHost();
		System.out.println(host);
		//本地地址
		String localAddr = request.getLocalAddr();
		System.out.println(localAddr);
		//请求服务器名localhost
		String serverName = request.getServerName();
		System.out.println(serverName);
		//获取请求用户名密码
		String parameter = request.getParameter(serverName);
		System.out.println(parameter);//null
		System.out.println("-------------------------");
		
		
		/*2、请求消息头
		 * String   getHeader(String name)  根据头名称得到头信息值
		 Enumeration   getHeaderNames()  得到所有头信息name
		 Enumeration   getHeaders(String name)  根据头名称得到相同名称头信息值
*/
		//一：获取请求消息头的所有names 并遍历打印
		Enumeration names = request.getHeaderNames();
		while(names.hasMoreElements()){
			String e = (String) names.nextElement();
			System.out.println(e);
		}
		System.out.println("--------------");
		//二：根据指定的name获取   后面部分
		String header = request.getHeader("accept");
		System.out.println(header);
		
		System.out.println("-------------------");
		//三：打印 name 的所有信息
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()){
			String nextElement = headerNames.nextElement();
			System.out.println(nextElement+":"+request.getHeader(nextElement));
			
			
		//快捷创建方法：选中目标 右键点击Refator 下的extract method
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
