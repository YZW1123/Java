package chess;

import java.awt.Graphics;

import javax.swing.JPanel;

public class MethodDemo {
	//override  ��������д
	//������д�ĸ�ʽ:�����ڸ�������,����������ͬ,����������ͬ,���Ƿ����岻ͬ{}
	public static void main(String[] args) {
		Bb b=new Bb();
		b.show();
	}
}
class Aa{
	public void show(){
		System.out.println("��Һ�");
	}
}
class Bb extends Aa{
	public void show(){
		super.show();//���ø����ĳĳ����
		System.out.println("���Ǻð�");
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
