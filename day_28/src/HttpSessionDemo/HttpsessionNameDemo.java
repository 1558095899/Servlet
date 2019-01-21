//HttpSession  会话
package HttpSessionDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HttpsessionNameDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	/*		1、为什么要学HttpSession?
			> 它也是一个域对象: session   servletContext  request 
			> 同一个会话下，可以使一个应用的多个资源共享数据
			> cookie客户端技术，只能存字符串。HttpSession服务器端的技术，它可以存对象。
			2、常用方法
			把数据保存在HttpSession对象中，该对象也是一个域对象。
			void setAttribute(String name,Object value);
			Object getAttribute(String name);
			void removeAttribute(String name);//删除数据  但 session还在
			HttpSession.getId():

			setMaxInactiveInterval(int interval)  设置session的存活时间
			invalidate() 使此会话无效   删除session*/
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//获取网页上的name		即地址栏  http://localhost/day_28/nameDemo1?name=tom/...	
		String name = request.getParameter("name");
		//获取session
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		Class<? extends HttpSession> class1 = session.getClass();
		System.out.println("getClass:"+class1);
		String id = session.getId();
		System.out.println("getId:"+id);
		long lastAccessedTime = session.getLastAccessedTime();
		System.out.println("lastAccessedTime:"+new Date(lastAccessedTime).toLocaleString());
		//设置session的存活时间
		session.setMaxInactiveInterval(Integer.MAX_VALUE);
		//session.invalidate();//删除会话
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
