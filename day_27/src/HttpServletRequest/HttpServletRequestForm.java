//创建获取用户填写的表单
package HttpServletRequest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletRequestForm extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*3、请求正文（重要）
		与获取表单数据相关的方法
		<input type="text" name="username" />
		*** getParameter(name) 根据表单中name属性的名，获取value属性的值方法 
		*** getParameterValues（String name）专业为复选框取取提供的方法
		    getParameterNames() 得到表单提交的所有name的方法 
		*** getParameterMap 到表单提交的所有值的方法   //做框架用，非常实用
		*解决post方式编码
*****request.setCharacterEncoding("UTF-8"); //告诉服务器客户端什么编码,只能处理post请求方式

*/		//向服务器提示编码方式
		request.setCharacterEncoding("UTF-8");
		
		//方法一：
		System.out.println("用户信息如下：");
		String user = request.getParameter("user");
		String username = request.getParameter("username");
		String sex = request.getParameter("sex");
		//复选框使用的方法为getParameterValues()
		String[] hobby = request.getParameterValues("hobby");
		String city = request.getParameter("city");
		System.out.println("用户名："+user);
		System.out.println("密码："+username);
		System.out.println("性别："+sex);
		for (int i = 0;hobby!=null && i < hobby.length; i++) {
			System.out.print("爱好："+hobby[i]);
		}
		System.out.println();
		System.out.println("城市："+city);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
