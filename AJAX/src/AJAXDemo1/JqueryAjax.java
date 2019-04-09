package AJAXDemo1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class JqueryAjax extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		
		PrintWriter out = response.getWriter();
		Map map=new HashMap();
		map.put("name", "tom");
		map.put("age", "18");
		if("tom".equals(name)){
			String s = JSONObject.fromObject(map).toString();
			//System.out.println(s);//{"age":"18","name":"tom"}
			out.println(s);
		}
		/*response.getWriter().write("success...");*/
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
