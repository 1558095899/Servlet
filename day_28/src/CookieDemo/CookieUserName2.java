package CookieDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUserName2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String username="";
		String checked="";
		Cookie[] cookies = request.getCookies();
		for (int i = 0;cookies!=null && i < cookies.length; i++) {
			if("userName".equals(cookies[i].getName())){
				username = cookies[i].getValue();
				checked="checked='checked'";
			}
			
		}
		
		out.println("<form action='"+request.getContextPath()+"/name' method='post'>");
		out.println("用户名：<input type='text' name='username'value='"+username+"'><br>");
		out.println("密码：<input type='password' name='pass'><br>");
		out.println("记住用户名：<input type='checkbox' name='remeber'"+checked+"><br>");
		out.println("<input type='submit' value='注册'>");
		out.println("</form>");*/
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String userName ="";
		String checked = "";
		//得到客户端保存的Cookie数据
		Cookie[] cookies = request.getCookies();
		for (int i = 0;cookies!=null && i < cookies.length; i++) {
			if("userName".equals(cookies[i].getName())){
				userName = cookies[i].getValue();
				checked = "checked='checked'";
			}
		}
		
		out.write("<form action='"+request.getContextPath()+"/name' method='post'>");
		out.write("用户名：<input type='text' name='userName' value='"+userName+"'/><br/>");
		out.write("密码：<input type='password' name='pwd'/><br/>");
		out.write("<input type='checkbox' name='remember' "+checked+" />记住用户名<br/>");
		out.write("<input type='submit' value='登录'/><br/>");
		out.write("</form>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
