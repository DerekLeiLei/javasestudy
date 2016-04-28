package package1;

/*
 * String类适用于描述字符串事物
 * 一旦初始化就不能变
 * 
 * 常见操作:
 * 
 * 1,获取
 *   int length();获取字符串的长度
 *   char charAt(int index);获取index位置上的字符
 *   int indexOf(int ch);获取字符ch在字符串中的位置
 *   int indexOf(String str);获取str在字符串中第一次出现的位置
 * 2,判断
 *   boolean contains(str);字符串中是否包含str
 *   boolean isEmpty();字符串是否为空
 *   boolean startsWith(str);字符串是否以str开头
 *   boolean endsWith(str);字符串是否以str结尾
 *   boolean equals(str);判断字符串内容是否相同
 *   boolean equalsIgnoreCase();判断是否相同忽略大小写
 * 3,转换
 *   String(char[]);
 *   char[] toCharArray();将字符串转化为字符数组
 *   static String valueOf(type);将基本类型转化为字符串
 * 4,替换
 *   String replace(olderchar,newchar);
 * 5,切割
 *   String[] split(regex);
 * 7,获取子字符串
 *   String subString(begin);
 *   String subString(begin,end);
 * 8,其他
 *   String toUpperCase();
 *   String toLowerCase();
 *   String trim();
 *   String compareTo(str);
 *   
 */


/*
  StringBuffer是字符串缓冲区，是一个容器。
  特点:
  1, 长度是可以变化的
  2，可以操作多个数据类型
  3，最终会通过toString方法变成字符串
  
   1，存储
      StringBuffer append(); 将指定数据作为参数添加到已有数据结尾处
      StringBuffer insert(index,数据); 可以将数据插入到指定index位置
   2, 删除
      StringBuffer delete(start,end); 删除缓冲区中的数据，包含start，不包含end
      StringBuffer deleteCharAt(index); 删除指定位置的字符
   3, 获取
      char charAt(int index);
      int indexOf(String str);
      int lastIndexOf(String str);
      int length();
      String subString(int start, int end);
    4,修改
      StringBuffer replace(start,end,string);
      void setCharAt(int index, char ch);
    5,其他
      StringBuffer reverse(); 反转字符串
      
      StringBuffer线程同步
      StringBuilder线程不同步
      
      字符串转基本数据类型:
      int num = Integer.parseInt(str);
 */
public class StringBufferDemo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //method_delete();
		method_update();
	}
	
	public static void method_update(){
		StringBuffer sber = new StringBuffer("abcdefg");
		//sber.replace(2, 4, "ha");
		//sber.setCharAt(0, 'l');
		sber.reverse();
		sop(sber.toString());
	}
	public static void method_delete(){
		StringBuffer sber = new StringBuffer("abcdedfg");
		//sber.delete(1, 3);
		sber.deleteCharAt(2);
		sop(sber.toString());
	}
	
	
	public static void method_add(){
		StringBuffer sber = new StringBuffer();
		sber.append("雷磊,");
		sber.append("你要加油!");
		sop(sber.toString());
		
	}
	
	public static void sop(String str){
		System.out.println(str);
	}

}
