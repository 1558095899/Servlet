package One;

import java.util.Arrays;

/***
 * 
 * @author 18877545427
 *
 */
public class ClassOne {
	public static void main(String[] args){
		String s=5>3? "是":"否";
		int i=1;
		if (i>30) {
			System.out.println("---------");
		}
		else{
			System.out.println("________________");
		}
		String str="明月";
		switch(str){
		case "明":System.out.println("no");
					break;
		case "明月":System.out.println("yes");
					break;
		default:System.out.println("noproble");
		}
		int sum=0;
		while(i<=100){
			sum+=i;
			i++;
		}System.out.println(sum);
		int b=sum++;
		System.out.println(b);
		int c=++sum;
		System.out.println(c);
		int a=0;
		int sum1=0;
		while(a<20){
			if(a%2==0){
				sum1+=a;
			}
			a++;
		}System.out.println(sum1);
		for (int j = 0; j < 10; j++) {
			
			if(j==4){
				continue;//结束本次循环，进行下次循环
//				break;  结束循环   执行循环外部程序
//				return;结束所有循环   包括循环外部程序
			}System.out.println(j);
		}System.out.println("finish!");
		String arr[]={"JAVA","JAVASE","JAVAEE"};
		for (int j = 0; j < arr.length; j++) {
			System.out.println(arr[j]);
			System.out.println(arr.length);
		}
		for (String string : arr) {
			System.out.println(string);
		}
		int[] in=new int[]{1,3,2,4,5};
		String s1=new String("60");
		String s2=new String("60");
		System.out.println(s1.equals(s2));
		System.out.println(s1==s2);
		System.out.println(Arrays.binarySearch(in,1));
		int[] copyOf = Arrays.copyOf(in, 4);
		System.out.println(Arrays.toString(copyOf));//[1,3, 2, 4]
		int[] copyOfRange = Arrays.copyOfRange(in, 1, 4);
		System.out.println(Arrays.toString(copyOfRange));//[3, 2, 4]
		Arrays.fill(in, 0,1,6);
		System.out.println(Arrays.toString(in));
		Arrays.sort(in);
		System.out.println(Arrays.toString(in));
		String srt1=new String("abcdef");
		String substring = srt1.substring(1, 4);
		System.out.println(substring);
		
	}
}



