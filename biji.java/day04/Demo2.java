package day04;
/*
 * ��������֮���С��αȽ�
 * */
public class Demo2 {
	public static void main(String[] args) {
		Bbb b=new Bbb();
		b.show();
		b.add();
		Aaa a=new Aaa();
		a.show();
		//�Ⱥŵ��ұߴ�,�Ⱥŵ����С,������ǿ������ת��:����Ҫ�й�ϵ
		Bbb b2=(Bbb) a;
		b2.add();
		//����û��ǿ������ת��
		Aaa aa=b;
	}
}
class Aaa{
	public void show(){
		System.out.println("������������");
	}
}
//�̳�:���벻������д��,�ù�����ֱ����
class Bbb extends Aaa{
	public void add(){
		System.out.println("����ȥ�Ⱦ�");
	}
}






