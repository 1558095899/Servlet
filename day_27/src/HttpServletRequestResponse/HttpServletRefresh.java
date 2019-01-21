package HttpServletRequestResponse;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletRefresh extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*Random r = new Random();
		response.setHeader("refresh", "3");
		response.getWriter().write(r.nextInt()+"");*/
		//告知客户端不缓存
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setDateHeader("expires", 0);

		//向浏览器提示编码方式
	
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().write("成功！3秒后跳转！");
		//刷新并跳转到refresh2
		response.setHeader("refresh", "3;url=/day_27/refresh2");
		response.getWriter().write("执行----");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
