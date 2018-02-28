package day02;

import javax.swing.JFrame;

/*
 * 数组:用来存储一组相同类型的数据,还要有固定的大小
 * 
 * */
public class ArrDemo {
	public static void main(String[] args) {
		//你知道你想要存的数据是什么
						   //0 1 2 3 4 5 6 7 8 9 10 11 12
		int [] arr=new int[]{1,2,1,2,4,5,7,8,6,4,6,8,555};
		int [] arr2={1,2,1,2,4,5,7,8,6,4,6,8,555};
		//定义了一个能够存储10个窗口类对象的数组
		JFrame []arr4=new JFrame[10];
		//定义了一个能够存储10个整数的数组,所有一这样形式定义的数组
		//默认值全是零
		int [] arr3=new int[10];
		//数组的下标
//		System.out.println(arr3[0]);
//		System.out.println(arr3[1]);
//		System.out.println(arr3[2]);
//		System.out.println(arr3[3]);
//		System.out.println(arr3[4]);
//		System.out.println(arr3[5]);
//		System.out.println(arr3[6]);
//		System.out.println(arr3[7]);
//		System.out.println(arr3[8]);
//		System.out.println(arr3[9]);
					//数组的长度=10
		for (int i = 0; i < arr3.length; i++) {
			//强行把小数转换成整数
			arr3[i]=(int) (Math.random()*100);
		}
		System.out.println("赋值成随机数字");
		for(int i=0;i<arr3.length;i++){
			System.out.println(arr3[i]);
		}
	}
}













