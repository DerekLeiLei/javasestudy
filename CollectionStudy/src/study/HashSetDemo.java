package study;

import java.util.*;
/*Set集合:存放的元素是无序的(存取顺序不一致)，不能重复.
 *   -----HashSet:底层数据结构是哈希表.
 *Set集合的功能和Collection一致.
 * 
 * HashSet是如何保证元素的唯一性:是通过元素的两个方法,
 * hashCode和equals来完成.如果元素的HashCode值相同，才
 * 会判断判断equals是否为true.如果元素的HashCode值不同，
 * 不会调用equals.
 * 
 * 注意，对于判断元素是否存在(contains())，以及删除(remove())等操作，依赖的方法
 * 是元素的hashCode和equals方法
 * 
 */

class Student {
	private String name;
	private int age;

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		System.out.println(this.name+"---------hashCode()----------run");
		return name.hashCode()+age*39;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student){
			Student temp = (Student) obj;
			System.out.println(this.name+"------equals()-----run----"+temp.name);
			return (temp.name).equals(this.name) && temp.age == this.age;
		}else{
			return false;
		}
	}
	
	

}

public class HashSetDemo {

	public static void main(String[] args) {
		//base_method();
		super_method();

	}

	public static void base_method() {
		HashSet hs = new HashSet();
		hs.add("java01");
		hs.add("java02");
		hs.add("java03");
		hs.add("java04");
		hs.add("java01");
		Iterator it = hs.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public static void super_method() {
		HashSet hsHashSet = new HashSet();
		hsHashSet.add(new Student("java01", 19));
		hsHashSet.add(new Student("java02", 20));
		hsHashSet.add(new Student("java03", 40));
		hsHashSet.add(new Student("java01", 20));
		hsHashSet.add(new Student("java03", 40));
		hsHashSet.add(new Student("java02", 28));
		hsHashSet.add(new Student("java01", 19));
		Iterator it = hsHashSet.iterator();
		while(it.hasNext()){
			Student stu = (Student) it.next();
			System.out.println(stu.getName()+"::::::"+stu.getAge());
		}

	}
	
	

}
