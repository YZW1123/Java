package day04;

public class MethodDemo {
	public static void main(String[] args) {
		//���췽�����ִ��
		//�����Ǵ���ĳ����Ķ����ʱ��,���Ѿ���ʼ��ִ����
		new Aa();
		//�Զ��巽�����ִ��
		//1.�������Զ��巽�����ڵ���Ķ���   	2.�ö������Ƶ�������ķ�������
		Aa a=new Aa();			a.show();
	}
}
class Aa{
	//���췽��	:���������ǹ̶���,���ǵ�ǰ�������
	public Aa(){
		System.out.println("����������ѩ��");
	}
	//�Զ��巽��:�����Լ���,��Ҫ����֪��
	public void show(){
		System.out.println("�����е���");
	}
}


