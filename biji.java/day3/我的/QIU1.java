package day03;

import javax.swing.JFrame;

public class QIU1 extends JFrame {
	public QIU1() {
		this.setTitle("�������ս");// ���ô��ڱ���
		this.setVisible(true);// �ô�����ʾ
		this.setResizable(false);// ���ô��ڲ����϶�
		this.setBounds(40, 40, 660, 880);// ���ô��ڴ�С��λ��
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���ô��ڳ�����X�ر�
	}

	public static void main(String[] args) {
		new QIU1();
	}

}
