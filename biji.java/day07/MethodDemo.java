package day07;

import java.awt.Color;

import javax.swing.JPanel;

public class MethodDemo {
	public static void main(String[] args) {
		MethodDemo m=new MethodDemo();
		m.show();//�޲����޷���ֵ,ֱ�ӵ��
		m.action(50,50.0);//�в����޷���ֵ
		int a=m.eat();	//�޲����з���ֵ
		System.out.println(a);
		boolean flag=m.kan(2,3);//�в����з���ֵ
		System.out.println(flag);	
	System.out.println(5/2);	
	}
	//1.�޲����޷���ֵ
	public void show(){
		System.out.println("������������");		}
	//2.�в����޷���ֵ
	public void action(int a,double b){
		System.out.println(a+b);			}
	//3.�޲����з���ֵ:3���ط����ص�����һ��
	public int eat(){
		return 2;							}
	//4.�в����з���ֵ
	public boolean kan(int a,int b){
		return a>b;							}
}








