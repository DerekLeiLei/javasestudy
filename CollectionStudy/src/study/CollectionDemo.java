package study;

import java.util.*;

/*#为什么会出现集合类?
 * 面向对象语言对事物的体现都是以对象的形式，所有为了方便对多个
 * 对象的操作，就对对象进行存储，集合就是存储对象最常用的一种方式
 * #数组和集合类都是容器，有何不同?
 * 数组虽然也可以存储对象，但长度是固定的；集合长度是可变的。数组
 * 中可以存储基本数据类型，集合只能存储对象
 * #集合类的特点:
 * 集合只用于存储对象，集合长度是可变的，集合可以存储不同类型的对象
 * 
 */

/*#Collection
 *     ---------List
 *              -------ArrayList
 *              -------LinkedList
 *              -------Vector
 *     ---------Set
 *              -------HashSet
 *              -------TreeSet
 */

/*注意:
 * 1,add方法的参数类型是Object，以便于接收任意类型的对象
 * 2,集合中存储的是对象的引用(地址)
 */

/*
 * 
 */

public class CollectionDemo {

	public static void main(String[] args) {
		//base_method();
		//retain_method();
		method_get();

	}
	
	public static void method_get(){
		ArrayList a1 = new ArrayList();
		a1.add("java01");
		a1.add("java02");
		a1.add("java03");
		a1.add("java04");
		//获取迭代器，用于取出元素
		/*Iterator it = a1.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}*/
	    for(Iterator it = a1.iterator(); it.hasNext();){
	    	System.out.println(it.next());
	    }
	}
	
	public static void retain_method(){
		ArrayList a1 = new ArrayList();
		a1.add("java01");
		a1.add("java02");
		a1.add("java03");
		a1.add("java04");
		System.out.println("a1:"+a1);
		ArrayList a2 = new ArrayList();
		a2.add("java01");
		a2.add("java02");
		a2.add("java07");
		a2.add("java08");
		System.out.println("a1:"+a2);
		//a1.retainAll(a2)保存于a1相同的元素
		//System.out.println("a1 retains a2:"+a1.retainAll(a2));
		//System.out.println("after a1:"+a1);
		//removeAll();
		System.out.println("a1 removeAll a2:"+a1.removeAll(a2));
		System.out.println("a1:"+a1);
	}

	public static void base_method() {
		// 创建一个集合容器,使用Collection接口的子类，ArrayList
		ArrayList al = new ArrayList<>();
		// 添加元素
		al.add("java01");
		al.add("java02");
		al.add("java03");
		al.add("java04");
		// 获取个数，集合长度
		System.out.println("size:" + al.size());
		// 删除元素
		// al.remove("java02");
		// 打印集合
		System.out.println(al);
		// 清除所有元素
		/*
		 * al.clear(); System.out.println(al);
		 */
		// 判断元素
		System.out.println("java03是否存在:" + al.contains("java03"));
		System.out.println("集合是否为空:" + al.isEmpty());
	}

}
