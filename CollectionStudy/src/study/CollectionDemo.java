package study;

import java.util.*;

/*#Ϊʲô����ּ�����?
 * ����������Զ���������ֶ����Զ������ʽ������Ϊ�˷���Զ��
 * ����Ĳ������ͶԶ�����д洢�����Ͼ��Ǵ洢������õ�һ�ַ�ʽ
 * #����ͼ����඼���������кβ�ͬ?
 * ������ȻҲ���Դ洢���󣬵������ǹ̶��ģ����ϳ����ǿɱ�ġ�����
 * �п��Դ洢�����������ͣ�����ֻ�ܴ洢����
 * #��������ص�:
 * ����ֻ���ڴ洢���󣬼��ϳ����ǿɱ�ģ����Ͽ��Դ洢��ͬ���͵Ķ���
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

/*ע��:
 * 1,add�����Ĳ���������Object���Ա��ڽ����������͵Ķ���
 * 2,�����д洢���Ƕ��������(��ַ)
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
		//��ȡ������������ȡ��Ԫ��
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
		//a1.retainAll(a2)������a1��ͬ��Ԫ��
		//System.out.println("a1 retains a2:"+a1.retainAll(a2));
		//System.out.println("after a1:"+a1);
		//removeAll();
		System.out.println("a1 removeAll a2:"+a1.removeAll(a2));
		System.out.println("a1:"+a1);
	}

	public static void base_method() {
		// ����һ����������,ʹ��Collection�ӿڵ����࣬ArrayList
		ArrayList al = new ArrayList<>();
		// ���Ԫ��
		al.add("java01");
		al.add("java02");
		al.add("java03");
		al.add("java04");
		// ��ȡ���������ϳ���
		System.out.println("size:" + al.size());
		// ɾ��Ԫ��
		// al.remove("java02");
		// ��ӡ����
		System.out.println(al);
		// �������Ԫ��
		/*
		 * al.clear(); System.out.println(al);
		 */
		// �ж�Ԫ��
		System.out.println("java03�Ƿ����:" + al.contains("java03"));
		System.out.println("�����Ƿ�Ϊ��:" + al.isEmpty());
	}

}
