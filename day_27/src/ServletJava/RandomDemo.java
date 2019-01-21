package ServletJava;

import java.util.Random;

public class RandomDemo {

	public static void main(String[] args) {
		for(int i=0;i<4;i++){
			int i1 = new Random().nextInt(10);
		
				System.out.print(i1);
		}
	}

}
