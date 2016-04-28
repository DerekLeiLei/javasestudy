package package1;

/*
 * String�������������ַ�������
 * һ����ʼ���Ͳ��ܱ�
 * 
 * ��������:
 * 
 * 1,��ȡ
 *   int length();��ȡ�ַ����ĳ���
 *   char charAt(int index);��ȡindexλ���ϵ��ַ�
 *   int indexOf(int ch);��ȡ�ַ�ch���ַ����е�λ��
 *   int indexOf(String str);��ȡstr���ַ����е�һ�γ��ֵ�λ��
 * 2,�ж�
 *   boolean contains(str);�ַ������Ƿ����str
 *   boolean isEmpty();�ַ����Ƿ�Ϊ��
 *   boolean startsWith(str);�ַ����Ƿ���str��ͷ
 *   boolean endsWith(str);�ַ����Ƿ���str��β
 *   boolean equals(str);�ж��ַ��������Ƿ���ͬ
 *   boolean equalsIgnoreCase();�ж��Ƿ���ͬ���Դ�Сд
 * 3,ת��
 *   String(char[]);
 *   char[] toCharArray();���ַ���ת��Ϊ�ַ�����
 *   static String valueOf(type);����������ת��Ϊ�ַ���
 * 4,�滻
 *   String replace(olderchar,newchar);
 * 5,�и�
 *   String[] split(regex);
 * 7,��ȡ���ַ���
 *   String subString(begin);
 *   String subString(begin,end);
 * 8,����
 *   String toUpperCase();
 *   String toLowerCase();
 *   String trim();
 *   String compareTo(str);
 *   
 */


/*
  StringBuffer���ַ�������������һ��������
  �ص�:
  1, �����ǿ��Ա仯��
  2�����Բ��������������
  3�����ջ�ͨ��toString��������ַ���
  
   1���洢
      StringBuffer append(); ��ָ��������Ϊ������ӵ��������ݽ�β��
      StringBuffer insert(index,����); ���Խ����ݲ��뵽ָ��indexλ��
   2, ɾ��
      StringBuffer delete(start,end); ɾ���������е����ݣ�����start��������end
      StringBuffer deleteCharAt(index); ɾ��ָ��λ�õ��ַ�
   3, ��ȡ
      char charAt(int index);
      int indexOf(String str);
      int lastIndexOf(String str);
      int length();
      String subString(int start, int end);
    4,�޸�
      StringBuffer replace(start,end,string);
      void setCharAt(int index, char ch);
    5,����
      StringBuffer reverse(); ��ת�ַ���
      
      StringBuffer�߳�ͬ��
      StringBuilder�̲߳�ͬ��
      
      �ַ���ת������������:
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
		sber.append("����,");
		sber.append("��Ҫ����!");
		sop(sber.toString());
		
	}
	
	public static void sop(String str){
		System.out.println(str);
	}

}
