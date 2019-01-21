//请求转发
package Request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestForward extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*操作非表单数据相关的方法(request也是一个域对象)
		*** void setAttribute(String name, Object value);
		*** Object getAttribute(String name);
		Void removeAttribute(String name);

		与请求转发相关的方法
		//得到请求转发或请求包含的协助对象
		RequestDispatcher getRequestDispatcher(String path)
		*** forward(ServletRequest request, ServletResponse response) 
*/		//向服务器提示编码方式
		request.setCharacterEncoding("UTF-8");//解决post乱码方式
		
		//解决get方式编码
		//String name = new String(name.getBytes(“iso-8859-1”),”UTF-8”);

	
		//向浏览器提示编码方式
		response.setContentType("text/html;charset=utf-8");
		//转发的方法
		System.out.println("浏览器：有事请求帮忙--");
		System.out.println("request:没空！找人帮你做--");
		
		//操作非表单数据 要在请求转发之前
		String str="非表单";
		//把数据存储到request域对象中
		request.setAttribute("s", str);
		//请求包含  即 包含forward2所有
		//request.getRequestDispatcher("/forward2").include(request, response);
		RequestDispatcher fd = request.getRequestDispatcher("/forward2");
		fd.forward(request, response);
		System.out.println("request:做完事了---");
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
