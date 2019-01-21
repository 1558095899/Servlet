//请求重定向
package HttpServletRequestResponse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletRedirect extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//执行完redirect后才跳转到redirect2
		System.out.println("redirect:没钱--");
		System.out.println("redirect:找redirect2去");
		//请求重定向   （重新定位访问对象）
		response.sendRedirect("/day_27/redirect2");
		System.out.println("浏览器:好--");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
