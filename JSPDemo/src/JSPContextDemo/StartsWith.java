package JSPContextDemo;

public class StartsWith {
	public static void main(String[] args){
		String s="**55";
		//判断是否是**开头   startWith
		//判断是否是什么结尾用  endsWith
		if(s.startsWith("**")){
			System.out.println(s);
		}else{
			System.out.println("--------");
		}
	}
}
