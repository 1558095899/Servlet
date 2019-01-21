//获取表单
package Request;

import java.beans.IntrospectionException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

import javax.persistence.PrePersist;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

/**
 * 
 * @author 18877545427
 *
 */
public class RequestForm extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
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
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//test1(request);
		
		//test2(request);
	
		//test3(request);
		
		//封装架包的方法：
		Person p=new Person();
		try {
			BeanUtils.populate(p, request.getParameterMap());
			System.out.println(p);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void test3(HttpServletRequest request) {
		//方法三：
		/* getParameterMap 到表单提交的所有值的方法   //做框架用，非常实用
		//获取map映射里的key和value值
		此处等于方法二
		 * Map<String, String[]> map = request.getParameterMap();
		 * for (Map.Entry<String, String[]> m: map.entrySet()) {
			String key = m.getKey();
			String[] value = m.getValue();
			for (int i = 0;value!=null && i < value.length; i++) {
				String string = value[i];
				System.out.println(key+":"+string);
			}
		}*/
		try{
			//表单数据存储到Map集合中
			Person person = new Person();
			Map<String, String[]> map = request.getParameterMap();
			for (Map.Entry<String, String[]> m : map.entrySet()) {
				String key = m.getKey();
				String[] value = m.getValue();
	
				//创建一个属性描述器
				PropertyDescriptor p= new PropertyDescriptor(key,Person.class);
				//得到setter属性
				Method setter = p.getWriteMethod();
				if(value.length==1){
					setter.invoke(person, value[0]);//给一个量赋值
				}else{
					setter.invoke(person, (Object)value);//复选框赋值
			}
		}System.out.println(person);
		}catch(Exception e){
			e.printStackTrace();
	}
}

	private void test2(HttpServletRequest request) {
		//方法二：*** getParameter(name) 根据表单中name属性的名，获取value属性的值方法 
		//*** getParameterValues（String name）专业为复选框取取提供的方法
	    //getParameterNames() 得到表单提交的所有name的方法 
		Enumeration<String> names = request.getParameterNames();//获取所以的name 返回枚举类
		while(names.hasMoreElements()){
			//html页面运行了才能获取name
			String element = (String)names.nextElement();
			//用数组获取对应element的value值  并遍历输出
			String[] values = request.getParameterValues(element);
			//遍历values
			for (int i = 0;values!=null && i < values.length; i++) {
				String value = values[i];
				//打印  name+values
				System.out.println(element+":"+value);
			}
		}
	}

	private void test1(HttpServletRequest request) {
		//方法一：*** getParameter(name) 根据表单中name属性的名，获取value属性的值方法 
		//*** getParameterValues（String name）专业为复选框取取提供的方法
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
		System.out.print("兴趣：");
		for (int i = 0;hobby!=null && i < hobby.length; i++) {
			System.out.print(hobby[i]+"\t");
		}
		System.out.println();
		System.out.println("城市："+city);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
