//获取局部配置信息
package day_27.FirstWebJava;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigDemo extends HttpServlet {
	/*private ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config=config;
	}*/
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	/*	获取配置文件中的信息  即web.xml中的<init-param>
  	<param-name>encoding</param-name>
    <param-value>GBK</param-value>
    </init-param>
    //获取配置文件方法一：
			String s = config.getInitParameter("encoding");
			System.out.println(s);*/
	//获取配置文件方法二(推荐)：
		String two = super.getInitParameter("encoding");//-->this.getInitParameter()
		System.out.println(two);
	//获取配置文件方法三：
		/*String three = super.getServletConfig().getInitParameter("encoding");
		System.out.println(three);*/
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
