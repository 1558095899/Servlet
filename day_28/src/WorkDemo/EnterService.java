//登入处理   判断是否相等  是则登入成功   并自动刷新跳转
package WorkDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EnterService extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		if("tom".equals(username)&& "123".equals(pass)){
			out.println("<font size='18'>登入成功</font>");
			response.setHeader("refresh", "1;url="+request.getContextPath()+"/resource");
		}else{
			out.println("登入失败");
			response.setHeader("refresh", "2;url="+request.getContextPath()+"/enter");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
