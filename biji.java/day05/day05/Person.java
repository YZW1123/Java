package day05;
/*
 * �Լ�ȥ����һ����----->����һ������
 * ��:ӵ����ͬ����(����)�͹�ͬ��Ϊ(����)�ļ���
 * ����:���ʵ��,����Զ���
 * ����
 */
public class Person {
	//���������---->����ȥ������
	String name;
	String sex;
	String age;
	String high;
	//����Ҫƥ��
	public Person(String name, String sex, String age, String high) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.high = high;
	}
	//�������Ϊ---->����---->�ܸ�ʲô�¶�
	public void eat(){
	}
	public void drink(){
	}
	public static void main(String[] args) {
		//��������     ִ��Person��������4�������Ĺ��췽��
		Person ��ǿ=new Person("��ǿ","��","18","182");//��һ����
		System.out.println(��ǿ.name);
		System.out.println(��ǿ.high);
		Person ����=new Person("����","��","25","182");//�ڶ�����
		System.out.println(����.name);
		Person �޸�=new Person("�޸�","��","35","185");//��������
		System.out.println(�޸�.name);
	}
}










