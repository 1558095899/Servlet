package One;

public class ClassSix extends Thread{
	public ClassSix(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}
	public void run(){
		for(int i=0;i<20;i++){
			System.out.println(Thread.currentThread().getName()+""+i);
		}
	}
	public static void main(String[] args) {
		new ClassSix("XIN").start();
		for(int i=0;i<30;i++){
			System.out.println(Thread.currentThread().getName()+i);
			if(i==10){
				ClassSix cs=new ClassSix("JOIN");
				cs.start();
				try {
					cs.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
