package study;
import java.util.*;

import javax.jws.soap.SOAPBinding;

/*Collection
 *      --------List:元素是有序的，元素可以重复，因为该集合体系有索引
 *      --------Set:元素是无序的，元素不可以重复
 */

/*List特有方法:凡是可以操作角标的方法都是该体系的特有方法
 * 
 * 增:add(index,element);
 *    addAll(index,Collection);
 * 删:remove(index);
 * 改:set(index,element);
 * 查:get(index);
 *    subList(index_start,index_end);
 *    ListIterator();
 * 
 * List集合特有的迭代器。 ListIterator是Iterator的子接口
 * 在迭代时，不可以通过集合对象的方法操作集合中的元素，因为
 * 会发生并发异常所以，在迭代时只能使用迭代器的方法操作元素，
 * 可是Iterator方法是有限的，只能对元素进行判断，取出，删除
 * 的操作。如果想要进行其他操作如添加，修改等，就需要使用其
 * 子接口ListIterator。该接口只能通过List集合的 的ListIterator()
 * 获取
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
		System.out.println("原集合元素:"+al);
		//使用ListIterator遍历
		ListIterator lit = al.listIterator();
		while(lit.hasNext()){
			System.out.println(lit.next());
		}
		System.out.println();
		//使用ListIterator倒序遍历
		while(lit.hasPrevious()){
			System.out.println(lit.previous());
		}
		//使用ListIterator进行删除，修改，添加操作
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
		System.out.println("进行操作后的集合元素:");
		for(ListIterator it = al.listIterator(); it.hasNext();){
			System.out.println(it.next());
		}
	}
	
	public static void list_method(){
		ArrayList al = new ArrayList();
		//添加元素
		al.add("jaiyou01");
		al.add("jaiyou02");
		al.add("jaiyou03");
		al.add("jaiyou04");
		al.add("jaiyou05");
		System.out.println("原集合元素:"+al);
		//通过角标添加元素
		/*al.add(1, "jiayou06");
		System.out.println("通过角标添加元素:"+al);*/
		//通过角标删除元素
		/*al.remove(2);
		System.out.println("删除后:"+al);*/
		//通过修改元素
		/*al.set(4, "jiayou007");
		System.out.println("修改后:"+al);*/
		
		//通过角标获取元素
		/*for(int i=0 ;i<al.size(); i++){
			System.out.println("get("+i+"):"+al.get(i));
		}*/
		//获取子集合
		List list = al.subList(2, 5);
		System.out.println("sublist:"+list);
	}

}
