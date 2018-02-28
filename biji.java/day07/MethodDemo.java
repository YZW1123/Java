package day07;

import java.awt.Color;

import javax.swing.JPanel;

public class MethodDemo {
	public static void main(String[] args) {
		MethodDemo m=new MethodDemo();
		m.show();//无参数无返回值,直接点儿
		m.action(50,50.0);//有参数无返回值
		int a=m.eat();	//无参数有返回值
		System.out.println(a);
		boolean flag=m.kan(2,3);//有参数有返回值
		System.out.println(flag);	
	System.out.println(5/2);	
	}
	//1.无参数无返回值
	public void show(){
		System.out.println("今天天气不错");		}
	//2.有参数无返回值
	public void action(int a,double b){
		System.out.println(a+b);			}
	//3.无参数有返回值:3个地方返回的类型一样
	public int eat(){
		return 2;							}
	//4.有参数有返回值
	public boolean kan(int a,int b){
		return a>b;							}
}








