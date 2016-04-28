package study;

import java.util.LinkedList;

/*LinkedList���еķ���:
 * addFirst();
 * addLast();
 * 
 * getFirst();
 * getLast();
 * ��ȡԪ�أ�����ɾ��Ԫ�أ����������û��Ԫ�أ������NoSuchElementException
 * 
 * removeFirst();
 * removeLast();
 * ��ȡԪ�أ�����Ԫ�ػᱻɾ�������������û��Ԫ�أ������NoSuchElementException
 * 
 * �������:
 * offerFirst();
 * offerLast();
 * 
 * peekFirst();
 * peekLast();
 * ��ȡԪ�أ�����ɾ��Ԫ�أ����������û��Ԫ�أ��᷵��Null
 * 
 * pollFirst();
 * pollLast();
 * ��ȡԪ�أ�����Ԫ�ػᱻɾ�������������û��Ԫ�أ��᷵��Null
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
		System.out.println("��ȡԪ��:");
		// ��ȡԪ��
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
		System.out.println("ʹ���µķ���:");
		System.out.println(link);
		System.out.println(link.peekFirst());
		System.out.println(link.peekFirst());
		System.out.println(link.peekLast());
		System.out.println();
		System.out.println();
		//
		/*System.out.println(link.pollFirst());
		System.out.println(link.pollFirst());*/
		System.out.println("��ȡԪ��:");
		while(!link.isEmpty()){
			System.out.println(link.pollFirst());
		}
	}

}
