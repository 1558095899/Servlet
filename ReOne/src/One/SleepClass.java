package One;

import java.util.Date;

class person extends Thread{
	static int num=50;//加static后不会重复创建内存
	public person(String name){
		super(name);
	}
	public   void m(){
		synchronized(""){
		for(int i=0;i<50;i++){
			if(num>0){	//设置num值大于0
				System.out.println(super.getName()+"吃苹果"+num--);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	}
	public void run(){
		m();
	}
}
public class SleepClass {

	public static void main(String[] args) {
		new person("小A").start();
		new person("小B").start();
		new person("小C").start();
		
	}

}