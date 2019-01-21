//商品
package WorkDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Books {
	static Map<String,String> map=new HashMap<String,String>();
	static {
		map.put("1","斯卡哈");
		map.put("2","冲田总司");
		map.put("3", "玉藻前");
	}
	public static Map<String,String> getMap(){
		return map;
	}
	
	public static String findBookById(String id){
		return map.get(id);
	}
	
}
	
