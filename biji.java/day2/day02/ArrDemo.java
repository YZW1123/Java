package day02;

import javax.swing.JFrame;

/*
 * ����:�����洢һ����ͬ���͵�����,��Ҫ�й̶��Ĵ�С
 * 
 * */
public class ArrDemo {
	public static void main(String[] args) {
		//��֪������Ҫ���������ʲô
						   //0 1 2 3 4 5 6 7 8 9 10 11 12
		int [] arr=new int[]{1,2,1,2,4,5,7,8,6,4,6,8,555};
		int [] arr2={1,2,1,2,4,5,7,8,6,4,6,8,555};
		//������һ���ܹ��洢10����������������
		JFrame []arr4=new JFrame[10];
		//������һ���ܹ��洢10������������,����һ������ʽ���������
		//Ĭ��ֵȫ����
		int [] arr3=new int[10];
		//������±�
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
					//����ĳ���=10
		for (int i = 0; i < arr3.length; i++) {
			//ǿ�а�С��ת��������
			arr3[i]=(int) (Math.random()*100);
		}
		System.out.println("��ֵ���������");
		for(int i=0;i<arr3.length;i++){
			System.out.println(arr3[i]);
		}
	}
}













