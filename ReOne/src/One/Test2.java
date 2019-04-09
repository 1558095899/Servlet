package One;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Person{
	private String name;
	private int age;
	public Person(String name,int age){
		System.out.println(name+";"+age);
	}
	public Person(){
		
	}
	public void dowork(){
		System.out.println("-----------");
	}
}

public class Test2{
	public static void main(String agrs[]) throws Exception{
		Class<Person> clazz=Person.class;
		Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class,int.class);
		Person result = constructor.newInstance("zhangsan",18);
		Constructor<Person> constructor2 = clazz.getDeclaredConstructor();//获取构造器
		Person obj = constructor2.newInstance();//创建对象
		Method method = clazz.getMethod("dowork", null);//获取对应方法
		method.invoke(obj, null);//调用方法，不传递参数
		
		Field namefield = clazz.getDeclaredField("name");
		Field agefield = clazz.getDeclaredField("age");
		namefield.setAccessible(true);
		agefield.setAccessible(true);
		namefield.set(obj, "zhangsan");
		agefield.setInt(obj, 18);
		System.out.println(namefield.get(obj));
		System.out.println(agefield.get(obj));
	}
}
