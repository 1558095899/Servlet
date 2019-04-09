package One;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Student {
	private String name;
	private int age;
	public Student() {
		System.out.println("无参数构造器");
	}

	private Student(String name) {
		System.out.println("有参数构造器"+name);
	}

	public void dowork() {
		System.out.println("无参数方法");
	}

	public void dowork(String name) {
		System.out.println("有参数方法");
	}
}

public class ClassFive {

	public static void main(String[] args) throws Exception {
		Class<Student> clazz = Student.class;
		Student s=new Student();
		Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
		for (Constructor<?> constructor : declaredConstructors) {
			System.out.println(constructor);
		}
		Constructor<Student> constructor = clazz.getDeclaredConstructor(String.class);
		System.out.println(constructor);
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			System.out.println(method);
			
		}
		Method m=clazz.getMethod("dowork", String.class);
		System.out.println("d:"+m);
		Field declaredField = clazz.getDeclaredField("name");
		declaredField.setAccessible(true);
		declaredField.set(s, "lilith");
		Field field = clazz.getDeclaredField("age");
		field.setAccessible(true);
		field.setInt(s,18);
		System.out.println(declaredField);
		System.out.println(field);
		
	}
}