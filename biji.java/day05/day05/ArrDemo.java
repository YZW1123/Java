package day05;

import java.awt.Color;

//����:�����洢һ����ͬ�������ݵ�����,�й̶��ĳ���
public class ArrDemo {
	//()���� 	 {}��Χ	[]����
	public static void main(String[] args) {
		//������һ���ܹ��洢10�������ĳ��ȵ�һ������
		int []arr=new int[1000];
		//������һ���ܹ��洢20��С���ĳ��ȵ�һ������
		double []arr2=new double[20];
		Ball[] balls=new Ball[20];
		//��������Ҫ��һ������ĵ��ĸ�����--->ͨ�����������+[]д�±�
		System.out.println(arr[3]);
		//��������Ҫ���ʵڶ�������ĵ�12������
		System.out.println(arr2[11]);
		//��������Ҫ���ʵ���������ĵ�18����
		System.out.println(balls[17]);
		//ֻҪ�Ǻ�������صĲ���,ȫ���Ҽ���forѭ��
		for(int i=0;i<arr.length;i++){
			arr[i]=(int) (Math.random()*1000);
		}
		for (int i = 0; i < arr2.length; i++) {
			arr2[i]=Math.random()*1000;
		}
		//������һ���ܹ��洢20�����һ������
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



















