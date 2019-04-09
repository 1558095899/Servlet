package Two;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//代理模式
public class Test2 {
	public static void main(String[] args) {
		final Test1Parent tp=new Test1();
		Test1Parent proxy=(Test1Parent) Proxy.newProxyInstance(tp.getClass().getClassLoader(), tp.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				System.out.println("1111");
				Object o= method.invoke(tp, null);
				System.out.println("2222");
				return o;
			}
		});
		proxy.dowork2();
	}
}
