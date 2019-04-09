package One;

public class SecondThread implements Runnable{

	public static void main(String[] args){
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName()+i);
			if(i==10){
				SecondThread st=new SecondThread();
				new Thread(st,"线程").start();
				
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
		System.out.println(Thread.currentThread().getName()+i);
		}
	}

}
