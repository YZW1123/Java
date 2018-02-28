package com.ajia;

public class TestDemo1 {

	/**
	 * this 关键字
	 * 1、this.属性   只得是当前类中的属性
	 * 2、this.方法();  // 普通方法  构造方法
	 * this() 当前类的构造方法
	 * 方法：
	 *   自定义方法    普通方法
 	 *   构造方法
 	 *  属性    成员变量
	 * @param args
	 */
	public static void main(String[] args) {
		// 实例化一个对象
		Person  per = new Person("张三",12);
		// 姓名：null,年龄：0
		System.out.println(per.info());
	}

}

/**
 * 类的定义
 *  class 列名称{
 *     
 *  }
 *  
 *  构造方法  
 *  public 类名称(参数类型   参数 ,参数类型   参数 ){
 *  
 *  }
 * 没有参数的叫做无参构造方法，默认存在的。构造方法的作用
 * 为类的属性初始化值
 * 
 * 方法的定义 
 * public 返回类型  方法名称(参数类型   参数 ,参数类型   参数  ....){
 * 
 * }
 * public void info(){
 * 
 * }
 * void :它是一个返回类型，但是什么都不返回
 * 返回类型：基本数据类型 8个 ,引用数据类型 
 * java数据类型中
 *   基本数据类型
 *     整形：byte 1个字节  short 2个字节
 *       int 4个字节   long 8个字节   默认：0
 *     浮点型： float   double  0.0
 *     字符型：char 默认值 '\u0000'
 *     布尔型  :boolean 默认值：（false）  true 
 *     
 *     定义方法
 *       基本数据类型   变量名 = 初始值 ;
 *   引用数据类型  默认 null
 *      1、类    String 
 *      2、接口
 *      3、数组
 *      
 *      方法的重载
 *      方法名称相同，参数个数，参数类型 ，返回类型不同
 *      
 *      定义
 *      1、类名称  对象名称 = new 类名称();
 *      
 *      2、
 *      类名称  对象名称 = null; // 声明对象
 *      对象名称 = new 类名称();  // 实例化对象
 *      
 *      3、调用属性和方法
 *      对象名称.属性;
 *      对象名称.方法();
 */

class Person{
	private  String name ; // 定义人类的属性 姓名
	private  int age ; // 定义一个人类的年龄
	
	// 
	public Person(String name ,int age){
		this.name=name;
		this.age=age;
	}
	
	/**
	 * 输出人类信息
	 * @return
	 */
	public String info(){
		return "姓名："+name +",年龄："+age;
	}
	
	/*public String[] infos(){
		return null;
	}*/
	
}
