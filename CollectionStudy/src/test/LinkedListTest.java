package test;
import java.util.*;

class DuiLie{
	private LinkedList<Object> linkedList;

	public DuiLie() {
		super();
		linkedList = new LinkedList<Object>();
	}
	
	public void myAdd(Object obj){
		linkedList.offerLast(obj);
	}
	
	public boolean isNull(){
		return linkedList.isEmpty();
	}
	
	public Object getElement(){
		return linkedList.pollFirst();
	}
}
public class LinkedListTest {
     public static void main(String[] args) {
		DuiLie dl = new DuiLie();
		dl.myAdd("java01");
		dl.myAdd("java02");
		dl.myAdd("java03");
		dl.myAdd("java04");
		System.out.println("»ñÈ¡ÔªËØ:");
		while(!dl.isNull()){
			System.out.println(dl.getElement());
		}
	}
}
