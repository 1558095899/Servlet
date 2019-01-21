package CookieDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieClear extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Cookie cookie = new Cookie("AccessTime", "");
		cookie.setPath("/");
		//设置0值 即为删除 cookie
		cookie.setMaxAge(0);
		//响应添加一个cookie给浏览器
		response.addCookie(cookie);
		out.println("<html>");
		out.println("<head>");
		out.println("<titil></titil>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<font size='20'color='RED'>clear finish !!</font>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
