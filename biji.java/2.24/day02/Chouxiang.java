package day02;

public class Chouxiang {
	/**
	 * 抽象类
	 * abstract
	 * adj.抽象的
	 * V.抽象化
	 * n.摘要，梗慨；抽象艺术作品；抽象的东西；理论思考
	 * 定义抽象类
	 * abstract class 类名称{}
	 * 定义一个抽象方法
	 * public abstract 返回类型 方法名称（参数类型 参数）；
	 * abstract 关键字
	 * 定义类的前面
	 * 定义方法返回值前面
	 * abstract 方法的前面 没有方法实现体{}
	 * 定义抽象类的意义
	 * 1、位子类提供一个公共的类型
	 * 2、封装子类中重复的内容
	 * 3、定义抽象方法，在子类中有不同的实现，但方法名称是一致的。
	 * 抽象要子类去实现，抽象需要继承。
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//抽象类总结
//1、抽象类不能被实例化，如果要实例化需要被子类继承。
//通过向上转型去实现实例化
//2、抽象类中可以没有抽象方法，但是抽象方法必须在抽象类中
//3、抽象类中的抽象方法没有现实体，只是定义了一个方法名称
//4、构造方法，有static修饰的地方不能出现abstract来修饰。
//5、抽象类全部方法，通过子类全部覆写。