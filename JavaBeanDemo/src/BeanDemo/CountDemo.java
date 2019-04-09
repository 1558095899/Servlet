package BeanDemo;

public class CountDemo {
	private int count=0;
	public CountDemo(){
		System.out.println("-------------");
	}
	public int getCount(){
		return ++this.count;
	}
}
