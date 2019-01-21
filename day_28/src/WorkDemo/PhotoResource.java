//点击查看 
package WorkDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PhotoResource extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<font size='18' color='RED'>点击查看老婆详情:</font><br/>");
		
		out.println("<h1>");
		out.println("<a href='/day_28/photo1.html'>斯卡哈</a>");
		out.println("</h1>");
		
		out.println("<h1>");
		out.println("<a href='/day_28/photo4.html'>冲田总司</a>");
		out.println("</h1>");
		
		out.println("<h1>");
		out.println("<a href='/day_28/photo3.html'>玉藻前</a>");
		out.println("</h1>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
