package day02;

class Person1 {
	public void eat() {
		System.out.println("吃饭...");
	}
}

class Student1 extends Person1 {
	public void eat() {
		System.out.println("学生在吃饭");
	}

	public void study() {
		System.out.println("学生在学习");
	}
}

class Teacher1 extends Person1 {
	public void eat() {
		System.out.println("教师在吃饭");
	}

	public void jiaoxue() {
		System.out.println("老师在上课");
	}
}

class Worker1 extends Person1 {
	public void eat() {
		System.out.println("工人在吃饭");
	}

	public void work() {
		System.out.println("工人在工作");
	}
}

public class Duotai001 {

	public static void main(String[] args) {
		Person1 per = new Worker1();
		per.eat();
		Worker1 wor =(Worker1)per;
		wor.work();
		print(new Person1() );
		print(new Student1());
		print(new Teacher1());
	}
public static void print(Person1 per){
	per.eat();
	if(per instanceof Student1){
		Student1 stu = (Student1)per;
		stu.study();
	}
	if(per instanceof Teacher1){
		Teacher1 tea= (Teacher1)per;
		tea.jiaoxue();
	}
}
}
