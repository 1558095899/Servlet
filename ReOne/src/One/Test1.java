package One;

import java.util.Date;

public class Test1 {

	public static void main(String[] args) {
		Integer i=new Integer(129);
		Integer i1=new Integer(129);
		Integer i2=128;
		Integer i3=128;
		System.out.println(i1.equals(i));
		System.out.println(i==i1);
		System.out.println(i==i2);
		System.out.println(new Date().getTime());
	}

}
