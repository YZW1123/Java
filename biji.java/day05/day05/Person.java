package day05;
/*
 * 自己去创建一个类----->创造一个物种
 * 类:拥有相同属性(变量)和共同行为(方法)的集合
 * 对象:类的实例,万物皆对象
 * 人类
 */
public class Person {
	//人类的属性---->看上去的样子
	String name;
	String sex;
	String age;
	String high;
	//类型要匹配
	public Person(String name, String sex, String age, String high) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.high = high;
	}
	//人类的行为---->方法---->能干什么事儿
	public void eat(){
	}
	public void drink(){
	}
	public static void main(String[] args) {
		//创建对象     执行Person这个类的有4个参数的构造方法
		Person 赵强=new Person("赵强","男","18","182");//第一个人
		System.out.println(赵强.name);
		System.out.println(赵强.high);
		Person 杨龙=new Person("杨龙","男","25","182");//第二个人
		System.out.println(杨龙.name);
		Person 罗刚=new Person("罗刚","男","35","185");//第三个人
		System.out.println(罗刚.name);
	}
}










