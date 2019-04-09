package JsonDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class JqueryAjaxRename extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		PrintWriter out = response.getWriter();
			/*Map map=new HashMap();
			if("tom".equals(name)){
				map.put("name", name);
				String s = JSONObject.fromObject(map).toString();
				out.println(s);
			}*/
		if("tom".equals(name)){
			out.print(1);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
