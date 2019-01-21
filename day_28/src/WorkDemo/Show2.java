//获取商品名称  并存入name中
package WorkDemo;
import WorkDemo.Books;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Show2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<font size='18' color='BLACK'>点击购买老婆:</font>");

		Map<String, String> map = Books.getMap();
		for (Map.Entry<String, String> m: map.entrySet()) {
			out.println("<h1>");
			out.println("<a href='/day_28/addbook?name="+m.getValue()+"'>"+m.getValue()+"</a>");
			out.println("</h1>");
		}
		out.println("--------------");
		out.println("<h1>");
		out.println("<a href='/day_28/showbook'>购物车</a>");
		out.println("</h1>");
		
		out.println("<h1>");
		out.println("<a href='/day_28/resource'>查看商品信息</a>");
		out.println("</h1>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
