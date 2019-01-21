package WorkDemo;
//登入界面   跳转
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Enter extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<center><br/>");
		out.println("<font size='18' color='BLACK'>登入界面</font>");
		out.write("<form action='"+request.getContextPath()+"/show' method='post'>");
		out.write("用户名：<input type='text' name='username'/><br/>");
		out.write("密&nbsp;码：<input type='password' name='pass'/><br/>");
		out.write("<input type='submit'style='width:50; height:50;' value='登录'/><br/>");
		out.println("<img src='22.jpg'>");
		out.write("</form>");
		out.println("</center>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
