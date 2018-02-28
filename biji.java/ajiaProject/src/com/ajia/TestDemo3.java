package com.ajia;

// this.属性
// ctrl + d 刪除一行  内存中 
public class TestDemo3 {
	public static void main(String[] args) {
		Person1 per = new Person1("张三",23);
		System.out.println(per.infos());
        //  System.out.println 输出语句
	}
}
// 简单java类里面不要有输出 
class Person1 {
	// 属性 封装性
	private String name; // private 私有的 public 公有的 修饰符
	private int age;
	
	

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
	
	public Person1(String  name ,int age){
		this.name=name;
		this.age=age;
	}
	// 数据类型是可以自动
	public String  infos() {
        return "姓名："+name+"，年龄:"+age; // 1.0
	}
}