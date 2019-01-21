//cookie会话  记录历史访问时间
//cookie 会在浏览器创建缓存
package CookieDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieAccessTime extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//请求获取cookie会话
		Cookie[] cookies = request.getCookies();
		for (int i = 0;cookies!=null && i < cookies.length; i++) {
			//判断获取的name是否与AccessTime相等
			if("AccessTime".equals(cookies[i].getName())){
				//获取的value值将 string 参数解析为有符号十进制 long
				long l=Long.parseLong(cookies[i].getValue());
				out.println("最后访问时间："+new Date(l).toLocaleString());
				out.println("<a href='/day_28/clear'>clear</a>");
				//out.println("<a href='"+request.getContextPath()+"/clear'></a>");
			}
		}
		//Cookie(String name, String value) 
		Cookie c = new Cookie("AccessTime", System.currentTimeMillis()+"");
		//设置缓存时间  以秒为单位
		c.setMaxAge(60*5);
		//设置路径  /day_28   目录下的子目录都可以访问  如  /day_28/aa/time 或 /day_28/time
		//c.setPath(request.getContextPath()); //虚拟目录 /day_28
		c.setPath("/");
		//想浏览器响应添加一个cookie name为AccessTime
		//在网页创建超链接
		response.addCookie(c);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
