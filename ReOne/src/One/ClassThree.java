package One;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

public class ClassThree {
	public static void main(String[] args) throws Exception{
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
//		System.out.println(list.size());
		List<Integer> c=new ArrayList<>();
		c.addAll(list);
		c.remove(0);
		System.out.println(c);
		c.add(4);
		list.retainAll(c);
		System.out.println(list);
		Iterator<Integer> it=list.iterator();
		while(it.hasNext()){
			Integer next = it.next();
			System.out.println(next);
			if(next.equals(3)){
				it.remove();
			}
			System.out.println(list);
		}
		for (Integer i : c) {
			System.out.println(i);
		}
		System.out.println("============================================");
		Set set=new HashSet();
		set.add("JAVA");
		set.add("JAVAEE");
		set.add("JAVASE");
		System.out.println(set);
		LinkedHashSet ls=new LinkedHashSet();
		ls.add("a");
		ls.add("b");
		ls.add("c");
		System.out.println(ls);
		TreeSet ts=new TreeSet();
		ts.add(5);
		ts.add(2);
		ts.add(10);
		ts.add(1);
		System.out.println(ts);
		System.out.println(ts.first());
		System.out.println(ts.last());
		System.out.println(ts.subSet(0,6));
		System.out.println(ts.headSet(5));
		List l=new ArrayList();
		l.add("疯狂JAVA");
		l.add("疯狂android");
		l.add(2);
		System.out.println(l);
		l.add(0, 1);
		System.out.println(l);
		int indexOf = l.indexOf(1);
		System.out.println(indexOf);
		l.remove(1);
		System.out.println(l);
		l.set(1, 3);
		System.out.println(l);
		List li=new ArrayList();
		li=l.subList(0, 1);
		System.out.println(li);
		ArrayDeque ad=new ArrayDeque<>();
		ad.push(7);
		ad.push(8);
		ad.push(6);
		ad.addLast(5);
		System.out.println(ad);
		System.out.println(ad.peekFirst());
		LinkedList ll=new LinkedList<>();
		ll.offer(7);
		ll.push(8);
		ll.offerFirst(9);
		for (int i=0;i<ll.size();i++) {
			System.out.println(ll.get(i));
		}
		HashMap hm=new HashMap<>();
		hm.put("语文", 90);
		hm.put("数学", 99);
		hm.put("英语", 98);
		System.out.println(hm);
		System.out.println(hm.keySet());
		System.out.println(hm.values());
		System.out.println(hm.entrySet());
		for (Object ob : hm.keySet()) {
			System.out.println(ob+"==="+hm.get(ob));
		}
		Properties pr = new Properties();
		pr.setProperty("username", "u");
		pr.setProperty("password","123");
		pr.store(new FileOutputStream("a.txt"),"comment line");
		Properties pr1=new Properties();
		pr1.setProperty("数学", "99");
		pr1.load(new FileInputStream("a.txt"));
		System.out.println(pr1);
		ArrayList al=new ArrayList();
		al.add(1);
		al.add(5);
		al.add(6);
		System.out.println(al);
		Collections.reverse(al);
		System.out.println(al);
		Collections.sort(al);
		System.out.println(al);
		Collections.shuffle(al);
		System.out.println(al);
		System.out.println(Collections.max(al));
		Collections.replaceAll(al, 1, 9);
		System.out.println(al);
		Collection oc=Collections.synchronizedCollection(new ArrayList());
		Set se=Collections.synchronizedSet(new HashSet());
		List lis=Collections.synchronizedList(new ArrayList());
		Map m=Collections.synchronizedMap(new HashMap());
		
		
	}
}
