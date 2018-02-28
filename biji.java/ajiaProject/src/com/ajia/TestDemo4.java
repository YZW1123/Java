package com.ajia;

// this.方法()  只得是当前类中的方法 
// this.构造方法()
public class TestDemo4 {
	public static void main(String[] args) {
		Person2 per = new Person2("张三",12);
		System.out.println(per.info()); // *********
		// 姓名：张三，年龄:23
 
	}
}

class Person2{
	// 在类中调用方法 ，直接用方法名称
	private String  name;
	private int age;
	
	public Person2(String  name,int age){
		this.name = name;
		this.age = age;
	}
	
	public void print(){
		System.out.println("*************");
	}
	
	public String info(){
		this.print();
		return "姓名："+name+",年龄："+age;
	}
}



