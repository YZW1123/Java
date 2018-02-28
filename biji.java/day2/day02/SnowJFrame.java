package day02;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SnowJFrame {
	public static void main(String[] args) {
		JFrame jf=new JFrame();
		jf.setTitle("��ѩ");
//		jf.setBounds(50, 50, 800, 600);
		jf.setSize(800, 600);
		jf.setLocationRelativeTo(null);//�ô��ھ���
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SnowJPanel sj=new SnowJPanel();
		jf.add(sj);
		sj.moveSnow();//ִ�д����̵߳ķ���
	}
}
class SnowJPanel extends JPanel{
	//����:�洢���ݵĵط�,����,ָ�������Ǹ�����
	int []x=new int[500];
	int []y=new int[500];
	//���췽��:����ĳ�ʼ������
	//���췽��:
	//			public+��ǰ�������(����){
	//				�������
	//			}
	//�Զ��巽��:  public void ��������(����){}
	public SnowJPanel(){
		for (int i = 0; i < x.length; i++) {
			x[i]=(int) (Math.random()*800);//0-800
			y[i]=(int)(Math.random()*600);
		}
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		setBackground(Color.BLACK);
		g.setColor(Color.WHITE);
		Font f=new Font("����",Font.BOLD,30);
		g.setFont(f);
		for (int i = 0; i < x.length; i++) {
			g.drawString("*",x[i],y[i]);	
		}
		
	}
	
	public void moveSnow(){//�Զ��巽��ȥ������һ���߳�
		new Thread(){//�����ڲ���ķ�ʽȥ������һ���߳�
			public void run(){//���ķ���---->һ��Ҫ�еķ���
				while(true){
					for (int i = 0; i <y.length; i++) {
						y[i]++;
						if(y[i]>=600){//���
							y[i]=0;
						}
					}
					
					repaint();//һֱ��
				try {//�쳣����Ļ���:���������Ҵ�
					//��ΪCPU�����ٶ�̫��,ֻ�����߳�������
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}












