package LoadDemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoadClass extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
		/*
		 * 默认使用enctype="application/x-www-form-urlencoded"时  只能获得name 和文件名
		 * name    a.txt
		 * */
		/*String name = request.getParameter("name");
		String photo = request.getParameter("photo");
		System.out.println("name");
		System.out.println("photo");*/
		
		/*
		 *  如果更改了enctype="multipart/form-data" 使用字节流读取文件信息 并得到内容为
		 *  ------WebKitFormBoundaryP7kBQdZah1cRznDi
			Content-Disposition: form-data; name="name"

			tom
			------WebKitFormBoundaryP7kBQdZah1cRznDi
			Content-Disposition: form-data; name="photo"; filename="a.txt"
			Content-Type: text/plain

			aaaaaaaaaaaaaaa

			------WebKitFormBoundaryP7kBQdZah1cRznDi--
		 * 
		 * */
		ServletInputStream in = request.getInputStream();
		int len=0;
		byte[] b=new byte[1024];
		while((len=in.read(b))>0){
			System.out.println(new String(b,0,len));
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
