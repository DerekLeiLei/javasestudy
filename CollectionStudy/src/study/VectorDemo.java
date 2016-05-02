package study;
import java.util.*;
/*
 * 枚举就是Vector特有的取出方式
 * 发现枚举和迭代器很像，其实枚举和
 * 迭代器是一样的。
 * 因为枚举的名称以及方法的名称都过长
 * 所以被迭代器取代了。
 * 
 * 
 */
public class VectorDemo {

	public static void main(String[] args) {
		Vector v = new Vector();
		v.add("java01");
		v.add("java02");
		v.add("java03");
		v.add("java04");
		Enumeration elems = v.elements();
		while(elems.hasMoreElements()){
			System.out.println(elems.nextElement());
		}

	}

}
