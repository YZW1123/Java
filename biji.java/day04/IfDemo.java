package day04;

import java.util.Scanner;

public class IfDemo {
	//if(){}һ�����
	//if(){}else{}�������
	/*
	 * if(){}else if(){}else if(){}.....�������
	 */
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("���������ļ۸�");
		double total=scan.nextDouble();
		if(total>0&&total<=200){
			System.out.println(total*1);
		}else if(total>200&&total<300){
			System.out.println(total*0.98);
		}else if(total>=300&&total<=500){
			System.out.println(total*0.88);
		}else if(total>500&&total<=700){
			System.out.println(total*0.8);
		}else if(total>700&&total<=1000){
			System.out.println(total*0.7);
		}else if(total>1000){
			System.out.println(total*0.5);
		}
	}
	
}




