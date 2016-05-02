package test;
import java.util.*;

public class ArrayListTest1 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("java01");
		list.add("java02");
		list.add("java03");
		list.add("java04");
		list.add("java01");
		list.add("java01");
		list.add("java02");
		list.add("java03");
		list.add("java04");
		list.add("java011");
		list.add("java05");
		list.add("java07");
		System.out.println("原来集合的元素:"+list);
		list = onlyElement(list);
		System.out.println("处理后集合的元素:"+list);

	}
	
	public static ArrayList onlyElement(ArrayList al){
		ArrayList templist = new ArrayList();
		Iterator it = al.iterator();
		Object obj = null;
		while(it.hasNext()){
			obj = it.next();
			if(!templist.contains(obj)){
				templist.add(obj);
			}
		}
		return templist;
	}

}
