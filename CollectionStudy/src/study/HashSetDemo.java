package study;

import java.util.*;
/*Set����:��ŵ�Ԫ���������(��ȡ˳��һ��)�������ظ�.
 *   -----HashSet:�ײ����ݽṹ�ǹ�ϣ��.
 *Set���ϵĹ��ܺ�Collectionһ��.
 * 
 * HashSet����α�֤Ԫ�ص�Ψһ��:��ͨ��Ԫ�ص���������,
 * hashCode��equals�����.���Ԫ�ص�HashCodeֵ��ͬ����
 * ���ж��ж�equals�Ƿ�Ϊtrue.���Ԫ�ص�HashCodeֵ��ͬ��
 * �������equals.
 * 
 * ע�⣬�����ж�Ԫ���Ƿ����(contains())���Լ�ɾ��(remove())�Ȳ����������ķ���
 * ��Ԫ�ص�hashCode��equals����
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
