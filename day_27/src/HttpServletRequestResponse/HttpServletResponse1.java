//使用字节流向网页输出图片
package HttpServletRequestResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletResponse1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/动漫.jpg");
		//此处图片放在子包里 不能引用path路径    可以放在项目下与子包同级                              
		System.out.println(path);//D:\Tomcat\webapps\day_27\WEB-INF\classes\动漫.jpg
		FileInputStream f=new FileInputStream("D:\\MyEclipseProfessional2014\\day_27\\WebRoot\\WEB-INF\\classes\\HttpServletRequestResponse\\动漫.jpg");
		ServletOutputStream out = response.getOutputStream();
		int len=1;
		byte[] b=new byte[1024];
		while((len=f.read(b))!=-1){
			out.write(b,0,len);
		
		}
//		先开后关
		out.close();
		f.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
