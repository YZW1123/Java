package day02;

class Person {
	public void eat() {
		System.out.println("吃饭...");
	}
}

class Student extends Person {
	public void eat() {
		System.out.println("学生在吃饭");
	}

	public void study() {
		System.out.println("学生在学习");
	}
}

class Teacher extends Person {
	public void eat() {
		System.out.println("教师在吃饭");
	}

	public void jiaoxue() {
		System.out.println("老师在上课");
	}
}

class Worker extends Person {
	public void eat() {
		System.out.println("工人在吃饭");
	}

	public void work() {
		System.out.println("工人在工作");
	}
}

public class Duotai1 {

	public static void main(String[] args) {
		fun(new Student());
		fun(new Teacher());
		fun(new Worker());
		//实例化对象new 类名称
	}

	public static void fun(Student a) {
		a.eat();
		a.study();
	}

	public static void fun(Teacher a) {
		a.eat();
		a.jiaoxue();
	}

	public static void fun(Worker a) {
		a.eat();
		a.work();
	}

}
