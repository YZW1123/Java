package day06;

import java.awt.Color;
import java.util.ArrayList;

//����:�����ݵ�����
//����:�����洢��ͬ�������ݵ�����,�й̶��ĳ���
public class ListDemo {
	/*
	 *    			Collection						Map
	 *    	List  				Set				HashMap
	 *    ArrayList			HashSet				TreeMap
	 *    LinkedList		TreeSet
	 *    					LinkedHashSet
	 */
	public static void main(String[] args) {
		//����ļ���Ҫ��һ���淶
		//����:��ָ������,����������д�������
		ArrayList<Boolean> arr=new ArrayList<Boolean>();
		//���ϵĳ���,  ��С���ŵĶ��з���
		System.out.println(arr.size());
		A a=new A();
		Ball ball=new Ball(100,Color.BLACK,50,4,245,534);
		//��Ӷ���
		arr.add(0);	//int  Integer
		arr.add(5.0);//	double  Double
		arr.add("��Һ�");//String
		arr.add('c');	//char--->Character
		arr.add(false);
		arr.add(a);
		arr.add(ball);
		System.out.println(arr.size());
		System.out.println(arr.get(0));
		//ɾ������
		arr.remove(0);
		//���ʼ��ϵ��±�
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
}
class A{
	
}











