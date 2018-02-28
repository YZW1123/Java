package day05;

import java.awt.Color;

//数组:用来存储一堆相同类型数据的容器,有固定的长度
public class ArrDemo {
	//()方法 	 {}范围	[]数组
	public static void main(String[] args) {
		//定义了一个能够存储10个整数的长度的一个数组
		int []arr=new int[1000];
		//定义了一个能够存储20个小数的长度的一个数组
		double []arr2=new double[20];
		Ball[] balls=new Ball[20];
		//我现在想要第一个数组的第四个数字--->通过数组的名称+[]写下标
		System.out.println(arr[3]);
		//我现在想要访问第二个数组的第12个数字
		System.out.println(arr2[11]);
		//我现在想要访问第三个数组的第18个球
		System.out.println(balls[17]);
		//只要是和数组相关的操作,全给我加上for循环
		for(int i=0;i<arr.length;i++){
			arr[i]=(int) (Math.random()*1000);
		}
		for (int i = 0; i < arr2.length; i++) {
			arr2[i]=Math.random()*1000;
		}
		//定义了一个能够存储20个球的一个数组
		balls[0]=new Ball(100,Color.black,3,8,500,200);
		for (int i = 0; i < balls.length; i++) {
			int d=(int) (Math.random()*100+20);
			int  speed=(int) (Math.random()*10+2);
			int direction=(int) (Math.random()*4);
			int x=(int) (Math.random()*800);
			int y=(int) (Math.random()*600);
			int r=(int) (Math.random()*256);
			int g=(int) (Math.random()*256);
			int b=(int) (Math.random()*256);
			Color ballColor=new Color(r,g,b);
			balls[i]=new Ball(d,ballColor,direction,speed,x,y);
		}
		
		
		
	}
}



















