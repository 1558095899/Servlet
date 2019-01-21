//通过获取相应的name 并存入list集合  后把集合存入session域中
package WorkDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddBook extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		/*
		 * //获取id值 即m.getKey() 1或者2 String id = request.getParameter("id");
		 * //通过key 获取map里对应的value值 即方法value=map.get(id) String
		 * book=Books.findBookById(id);
		 */
		String name = request.getParameter("name");
		// 把获得的value值 存入到list中 （点第二次时开始此处 保存上次的记录）
		List list = (List) session.getAttribute("car");
		if (list == null) {
			list = new ArrayList();
		}
		list.add(name);
		// 在域中存储list
		session.setAttribute("car", list);
		out.println("<font size='18' color='RED'>购买成功！！</font>");
		response.setHeader("refresh", "2;url=/day_28/show2");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
