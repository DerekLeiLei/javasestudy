package study;
import java.util.*;

import javax.jws.soap.SOAPBinding;

/*Collection
 *      --------List:Ԫ��������ģ�Ԫ�ؿ����ظ�����Ϊ�ü�����ϵ������
 *      --------Set:Ԫ��������ģ�Ԫ�ز������ظ�
 */

/*List���з���:���ǿ��Բ����Ǳ�ķ������Ǹ���ϵ�����з���
 * 
 * ��:add(index,element);
 *    addAll(index,Collection);
 * ɾ:remove(index);
 * ��:set(index,element);
 * ��:get(index);
 *    subList(index_start,index_end);
 *    ListIterator();
 * 
 * List�������еĵ������� ListIterator��Iterator���ӽӿ�
 * �ڵ���ʱ��������ͨ�����϶���ķ������������е�Ԫ�أ���Ϊ
 * �ᷢ�������쳣���ԣ��ڵ���ʱֻ��ʹ�õ������ķ�������Ԫ�أ�
 * ����Iterator���������޵ģ�ֻ�ܶ�Ԫ�ؽ����жϣ�ȡ����ɾ��
 * �Ĳ����������Ҫ����������������ӣ��޸ĵȣ�����Ҫʹ����
 * �ӽӿ�ListIterator���ýӿ�ֻ��ͨ��List���ϵ� ��ListIterator()
 * ��ȡ
 */

public class ListDemo {

	public static void main(String[] args) {
		//list_method();
		list_iterator();

	}
	
	public static void list_iterator(){
		ArrayList al = new ArrayList();
		al.add("jaiyou01");
		al.add("jaiyou02");
		al.add("jaiyou03");
		al.add("jaiyou04");
		al.add("jaiyou05");
		System.out.println("ԭ����Ԫ��:"+al);
		//ʹ��ListIterator����
		ListIterator lit = al.listIterator();
		while(lit.hasNext()){
			System.out.println(lit.next());
		}
		System.out.println();
		//ʹ��ListIterator�������
		while(lit.hasPrevious()){
			System.out.println(lit.previous());
		}
		//ʹ��ListIterator����ɾ�����޸ģ���Ӳ���
		while (lit.hasNext()) {
			String object = (String) lit.next();
			if (object.equals("jaiyou01")) {
				lit.add("jaiyou01 add");
			}
			if (object.equals("jaiyou02")) {
				lit.remove();
			}
			if(object.equals("jaiyou05")){
				lit.set("jaiyou007");
			}
			
		}
		System.out.println("���в�����ļ���Ԫ��:");
		for(ListIterator it = al.listIterator(); it.hasNext();){
			System.out.println(it.next());
		}
	}
	
	public static void list_method(){
		ArrayList al = new ArrayList();
		//���Ԫ��
		al.add("jaiyou01");
		al.add("jaiyou02");
		al.add("jaiyou03");
		al.add("jaiyou04");
		al.add("jaiyou05");
		System.out.println("ԭ����Ԫ��:"+al);
		//ͨ���Ǳ����Ԫ��
		/*al.add(1, "jiayou06");
		System.out.println("ͨ���Ǳ����Ԫ��:"+al);*/
		//ͨ���Ǳ�ɾ��Ԫ��
		/*al.remove(2);
		System.out.println("ɾ����:"+al);*/
		//ͨ���޸�Ԫ��
		/*al.set(4, "jiayou007");
		System.out.println("�޸ĺ�:"+al);*/
		
		//ͨ���Ǳ��ȡԪ��
		/*for(int i=0 ;i<al.size(); i++){
			System.out.println("get("+i+"):"+al.get(i));
		}*/
		//��ȡ�Ӽ���
		List list = al.subList(2, 5);
		System.out.println("sublist:"+list);
	}

}
