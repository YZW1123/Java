package day03;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
//�̳д�����,�ͱ���˴�����Ķ���
public class BallJFrame extends JFrame{
	//BallJFrame�����Ĺ��췽��
	public BallJFrame(){
		//thisָ����ǰ���Լ��Ķ���
		this.setBounds(50, 50, 400, 600);//���ô�С��λ��
		this.setVisible(true);//�ô�����ʾ
		this.setResizable(false);//��ֹ����С
		this.setTitle("�������ս");//���ñ���
		//���X��Ĭ�Ϲر�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BallJPanel bj=new BallJPanel();//������������Ķ���
		this.add(bj);
		bj.moveBall();
	}
	/*���߳�*/
	//���췽�����ִ��?  ����ĳ����Ķ����ʱ���ִ����
	public static void main(String[] args) {
		new BallJFrame();//����BallJFrame�����Ĺ��췽��
	}
}
//��������ĸΪ��д�ľ�ctrl+shift+o
//û�¶��Ͱ�alt+/
class BallJPanel extends JPanel{
	int x=100;int y=200;int d=80;
	//����һ������������������ƶ�����
	int f=3;
	//��������Ǵ�����{}
	//Java���о�����Ҫֱ��ʹ������,��Ӧ��ʹ�ñ�������ʽ
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.fillOval(x, y, d, d);
	}
	//�Զ���һ���������������߳�
	public void moveBall(){
		new Thread(){
			public void run(){
				//����ѭ��
				while(true){
					if(f==0){	//����
						x--;	y--;
					}
					if(f==1){	//����
						x++;	y--;
					}
					if(f==2){	//����
						x++;	y++;
					}
					if(f==3){	//����
						x--; 	y++;
					}
					if(x<=0){	//���	//С������������
						if(f==0){
							f=1;
						}else{
							f=2;
						}
					}
					if(x>=400-d){		//�ұ�
						if(f==1){
							f=0;
						}else{
							f=3;
						}
					}
					if(y<=0){				//�ϱ�
						if(f==0){
							f=3;
						}else{
							f=2;
						}
					}
					if(y>=600-d-30){				//�±�
						if(f==2){
							f=1;
						}else{
							f=0;
						}
					}
					//�ظ���
					repaint();
					//���߳���һ��
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}

















