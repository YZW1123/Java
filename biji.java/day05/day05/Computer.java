package day05;
//����(����)����Ϊ(����)
public class Computer {
	//����
	String �Կ�;
	String ����;
	String ��ʾ��;
	public Computer(String �Կ�,String ����,String ��ʾ��){
		this.�Կ�=�Կ�;
		this.����=����;
		this.��ʾ��=��ʾ��;
	}
	//��Ϊ
	public void play(){}
	public void music(){}
	public static void main(String[] args) {
		Computer ������Խȼ=new Computer("MX150 2G����","��֪��","��֪��");
		System.out.println(������Խȼ.�Կ�);
		Computer ��˶=new Computer("940MX 2G����","��֪��2","��֪��2");
		System.out.println(��˶.�Կ�);
	}
}







