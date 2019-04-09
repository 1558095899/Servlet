package ServletDemo1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo1 extends HttpServlet {

	@SuppressWarnings("deprecation")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//request.setCharacterEncoding("utf-8");
		//PrintWriter out = response.getWriter();
		/*String initParameter = this.getInitParameter("encoding");
		System.out.println(initParameter);
		this.getServletContext().setAttribute("name", "lilith");
		System.out.println("A:没钱");
		response.sendRedirect("/ServletDemo/servlet/Demo2");
		System.out.println("hao");
		System.out.println("-------------------");*/
		/*System.out.println("A:没钱");
		request.getRequestDispatcher("/servlet/Demo2").forward(request, response);
		System.out.println("好");*/
//		request.setAttribute("name", "lilith");
//		request.getRequestDispatcher("/servlet/Demo2").forward(request, response);
		/*Random random = new Random();
		response.setHeader("refresh", "2");
		out.println(random.nextInt(10)+"");*/
		/*out.println("2秒跳转");
		response.setHeader("refresh", "2;url=/ServletDemo/servlet/Demo2");*/
		/*String contextPath = request.getContextPath();
		System.out.println(contextPath);*/
		/*ServletOutputStream outputStream = response.getOutputStream();
		FileInputStream f=new FileInputStream("D:\\MyEclipseProfessional2014\\ServletDemo\\src\\ServletDemo1\\5.jpg");
		byte[] b=new byte[1024];
		int len=0;
		while((len=f.read(b))>0){
			outputStream.write(b, 0, len);
			}
		f.close();
		outputStream.close();*/
//		request.getRealPath("/");
		/*String realPath = this.getServletContext().getRealPath("/");
		System.out.println(realPath);//D:\Tomcat\webapps\ServletDemo\
*/		
		/*Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()){
			String nextElement = headerNames.nextElement();
			System.out.println(headerNames+":"+request.getHeaders(nextElement));
		}*/
		request.setCharacterEncoding("utf-8");
		/*String username = request.getParameter("user");
		System.out.println("用户名："+username);
		String pass = request.getParameter("pass");
		System.out.println("密码："+pass);
		String dept = request.getParameter("dept");
		System.out.println("部门："+dept);
		String[] hobby = request.getParameterValues("in");
		for (String string : hobby) {
			System.out.println("爱好："+string);
		}*/
		Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()){
			String nextElement = parameterNames.nextElement();
			System.out.println(nextElement+":"+request.getParameter(nextElement));
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
