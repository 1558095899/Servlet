package junit;

import org.junit.Assert;
import org.junit.Test;
//测试 方法    选中test1 右键run
public class TestCalc {
	@Test
	public void test1(){
		Calc c = new Calc();
		Assert.assertEquals(9, c.add(3, 5));
	}
	
	@Test
	public void test2(){
		Calc c = new Calc();
		Assert.assertEquals(3, c.div(10, 3),0.3);
	}
}
