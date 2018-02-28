package chess;

import java.awt.Graphics;

import javax.swing.JPanel;

public class MethodDemo {
	//override  方法的重写
	//方法重写的格式:发生在父子类中,方法名称相同,参数个数相同,但是方法体不同{}
	public static void main(String[] args) {
		Bb b=new Bb();
		b.show();
	}
}
class Aa{
	public void show(){
		System.out.println("大家好");
	}
}
class Bb extends Aa{
	public void show(){
		super.show();//调用父类的某某方法
		System.out.println("你们好啊");
	}
}
interface D{
	public void mouseClick();
	public void move();
}
class Cc implements D{
	@Override
	public void mouseClick() {
	}

	@Override
	public void move() {
	}
}
