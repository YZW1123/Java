package day02;

public class Duotai0001 {
	public static void main(String[] args) {
		fun(new A1());
		fun(new B1());
		fun(new C1());
	}
	public static void fun(A1 a){
		a.print();//调用父类的方法
		if (a instanceof B1) {//判断实例化是否是B1这个类实例化的
			B1 b = (B1)a;//向下转型
			b.printb();//调用子类特有的方法
		}
		if(a instanceof C1){//判断实例化是否是C1这个类实例化的
			C1 c=(C1)a;//向下转型
			c.printc();//调用子类特有的方法
		}
	}
}
class A1{
	public void print (){
		System.out.println("---A1---");
	}
}
class B1 extends A1{
	public void print (){
		System.out.println("---B1---");
	}
	public void printb (){
		System.out.println("---B1b---");
	}
}
class C1 extends A1{
	public void print (){
		System.out.println("---C1---");
	}
	public void printc (){
		System.out.println("---C1c---");
	}
}