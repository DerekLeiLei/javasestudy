package study;

import java.util.LinkedList;

/*LinkedList特有的方法:
 * addFirst();
 * addLast();
 * 
 * getFirst();
 * getLast();
 * 获取元素，但不删除元素，如果集合中没有元素，会出现NoSuchElementException
 * 
 * removeFirst();
 * removeLast();
 * 获取元素，但是元素会被删除，如果集合中没有元素，会出现NoSuchElementException
 * 
 * 替代方法:
 * offerFirst();
 * offerLast();
 * 
 * peekFirst();
 * peekLast();
 * 获取元素，但不删除元素，如果集合中没有元素，会返回Null
 * 
 * pollFirst();
 * pollLast();
 * 获取元素，但是元素会被删除，如果集合中没有元素，会返回Null
 */

public class LinkedListDemo {

	public static void main(String[] args) {
		//older_method();
		new_method();

	}

	public static void older_method() {
		LinkedList link = new LinkedList();
		link.addFirst("java01");
		link.addFirst("java02");
		link.addFirst("java03");
		link.addFirst("java04");
		System.out.println(link);
		System.out.println("获取元素:");
		// 获取元素
		System.out.println("empty:" + link.isEmpty());
		while (!link.isEmpty()) {
			System.out.println(link.removeFirst());
		}
	}
	
	public static void new_method(){
		LinkedList link = new LinkedList();
		link.offerLast("java01");
		link.offerLast("java02");
		link.offerLast("java03");
		link.offerLast("java04");
		System.out.println("使用新的方法:");
		System.out.println(link);
		System.out.println(link.peekFirst());
		System.out.println(link.peekFirst());
		System.out.println(link.peekLast());
		System.out.println();
		System.out.println();
		//
		/*System.out.println(link.pollFirst());
		System.out.println(link.pollFirst());*/
		System.out.println("获取元素:");
		while(!link.isEmpty()){
			System.out.println(link.pollFirst());
		}
	}

}
