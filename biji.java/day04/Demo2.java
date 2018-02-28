package day04;
/*
 * 引用类型之间大小如何比较
 * */
public class Demo2 {
	public static void main(String[] args) {
		Bbb b=new Bbb();
		b.show();
		b.add();
		Aaa a=new Aaa();
		a.show();
		//等号的右边大,等号的左边小,所以有强制类型转换:必须要有关系
		Bbb b2=(Bbb) a;
		b2.add();
		//这里没有强制类型转换
		Aaa aa=b;
	}
}
class Aaa{
	public void show(){
		System.out.println("今天天气不错");
	}
}
//继承:代码不用我再写了,拿过来就直接用
class Bbb extends Aaa{
	public void add(){
		System.out.println("晚上去喝酒");
	}
}






