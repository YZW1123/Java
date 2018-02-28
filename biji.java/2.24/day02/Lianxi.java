package day02;

public class Lianxi {

	public static void main(String[] args) {
		fun(new Manager());
		fun(new Programmer());
	}

	public static void fun(Empolyee em) {
		if(em instanceof Manager){
			Manager mm = (Manager)em;
			mm.money();
			mm.working();
			mm.print("小明", 21, 123456);
		}
		if(em instanceof Programmer){
			Programmer pm =(Programmer)em;
			pm.working();
			pm.print("小王", 18, 123457);
		}
	}
}
abstract class Empolyee{
	public String name;
	public int age;
	public int number;
	abstract void working();
	public void print(String name,int age,int number){
		System.out.println("姓名："+name+" 年龄："+age+" 工号"+number);
	}
}
class Manager extends Empolyee{
public void money(){
	System.out.println("项目经理在获取奖金");
}
	@Override
	void working() {
		System.out.println("项目经理做市场需求分析");
	}
}
class Programmer extends Empolyee{
	@Override
	void working() {
		System.out.println("程序员在写代码");
	}
}