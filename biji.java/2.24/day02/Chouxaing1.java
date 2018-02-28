package day02;

public class Chouxaing1 {

	public static void main(String[] args) {
		//向上转换
		Demo d= new Demo1();
		d.print();
		d.print1();
		d.print1();
		Demo1 D=(Demo1)d;//向下转换 
		D.print3();
		D.print();
		D.print4(911);
	}

}
//定义了一个抽象类
abstract class Demo{
	public int number;//定义了一个属性
	public final static double PI=3.1415926;//定义了一个常量
	public void  print (){
		System.out.println("π;"+PI);
	}//定义了一个方法
	public Demo(){
		
	}//定义了一个构造方法
	public abstract void print1();//定义了一个抽象方法，抽象方法没有方法体。
	public abstract void print2();
}
 class Demo1 extends Demo{
//子类继承了抽象类，那么必须要覆写父类全部抽象方法
	@Override//annotation 注解//Overloading 重载
	public void print1() {
		System.out.println("124578");
	}

	@Override
	public void print2() {
		System.out.println("369");
	}
	public void print3(){
		System.out.println("123456789");
	}
	public void print4(int number){
		System.out.println("号码："+number);
	}
	
}