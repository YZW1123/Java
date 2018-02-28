package day04;

public class Demo {
	public static void main(String[] args) {
		//1.创建方法所在类的对象   2.用对象名称点出来方法名称
		Person 赵强=new Person();
		赵强.打球();
		
	}
}
class Person{
	//类;拥有相同属性和共同行为的集合,抽象的概念
	//对象:某个类的实例,真实存在
	public void eat(){}
	public void drink(){}
	public void chou(){}
	public void du(){}
	public void  打球(){}
	public void 打游戏(){}
}
