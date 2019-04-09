package ServletDemo1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieClass extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie[] ck = request.getCookies();
		for(int i=0;ck!=null && i<ck.length;i++){
			if("at".equals(ck[i].getName())){
				long l = Long.parseLong(ck[i].getValue());
				out.println(new Date(l).toLocaleString());
			}
		}
		Cookie cookie = new Cookie("at",System.currentTimeMillis()+"");
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
