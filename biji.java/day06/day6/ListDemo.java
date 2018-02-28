package day06;

import java.awt.Color;
import java.util.ArrayList;

//集合:存数据的容器
//数组:用来存储相同类型数据的容器,有固定的长度
public class ListDemo {
	/*
	 *    			Collection						Map
	 *    	List  				Set				HashMap
	 *    ArrayList			HashSet				TreeMap
	 *    LinkedList		TreeSet
	 *    					LinkedHashSet
	 */
	public static void main(String[] args) {
		//给你的集合要有一个规范
		//泛型:泛指的类型,尖括号里面写类的名字
		ArrayList<Boolean> arr=new ArrayList<Boolean>();
		//集合的长度,  带小括号的都叫方法
		System.out.println(arr.size());
		A a=new A();
		Ball ball=new Ball(100,Color.BLACK,50,4,245,534);
		//添加东西
		arr.add(0);	//int  Integer
		arr.add(5.0);//	double  Double
		arr.add("大家好");//String
		arr.add('c');	//char--->Character
		arr.add(false);
		arr.add(a);
		arr.add(ball);
		System.out.println(arr.size());
		System.out.println(arr.get(0));
		//删除东西
		arr.remove(0);
		//访问集合的下标
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
}
class A{
	
}











