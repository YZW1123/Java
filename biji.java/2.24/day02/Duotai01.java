package day02;

public class Duotai01 {

	public static void main(String[] args) {
       //向上转型
		//父类 父类对象=子类实例;向上转型自动完成
		AA a=new BB();
		a.print();
		//向下转型
		//子类 子类对象=(子类)父类对象;向下转型强制转换
		BB b= (BB) a;
		b.printb();
		b.print();
	}

}
class AA{
	public void print(){
		System.out.println("----A----");
	}
}
class BB extends AA{
	public void print(){
		System.out.println("----B----");
	}
	public void printb(){
		System.out.println("----BB----");
	}
}