package com.ajia;

public class TestDemo5 {

	public static void main(String[] args) {
        Person3 per = new  Person3();
       /* per.setName("张三");
        per.setAge(12); 
        // 通过setter 赋值 
        System.out.println(per.info());
        System.out.println(per.getName());
        System.out.println(per.getAge());*/
        Person3 per1 = new  Person3("张三");
        System.out.println(per1.info());
        
        Person3 per2 = new  Person3(12);
        System.out.println(per1.info());
        
	}

}
class Person3{
	private String name ;
	private int age;
	// ... 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person3(){
		System.out.println("今天昆明下雪了");
	}
	
	public Person3(String  name){
		System.out.println("今天昆明下雪了");
		this.name=name;
	}
	
	public Person3(int age){
		System.out.println("今天昆明下雪了");
		this.age = age;
	}
	
	public Person3(String  name ,int age){
		System.out.println("今天昆明下雪了");
		this.name= name ;
		this.age=age;
	}
	public  String  info(){
		return "姓名："+name+"年龄:"+age;
	}
}
