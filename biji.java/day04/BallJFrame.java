package day04;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

//1.�̳�JFrame	2.��������ĸ��д��ctrl+shift+o
public class BallJFrame extends JFrame{
	//3.���幹�췽��
	/*
	 *  public +��ǰ�������(){
	 *  	��ô��ô��
	 *  }
	 */
	public BallJFrame(){
		//���ô��ڵ�����
		this.setBounds(50, 50, 400, 600);//���ô��ڵĴ�С��λ��
		this.setTitle("����");//���ñ���
		//���X��Ĭ�Ϲر�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);//�ô�����ʾ
		this.setResizable(false);//��ֹ���ڱ���С
		//����     С�� =  ��  ����();
		BallJPanel bp=new BallJPanel();
		//��ǰ�Ĵ��������
		this.add(bp);
		//�Զ��巽��moveBallҪͨ����������Ƶ����
		bp.moveBall();
	}
	public static void main(String[] args) {
		//���ִ�й��췽��:����һ����Ķ����ʱ���ִ���˹��췽��
		new BallJFrame();
	}
}
//��һ�����ļ���,д��������߶�����ʱ��,һ��Ҫע����Ĵ�����,������Ĵ���������ȥд
//JFrame�Ǵ�����  			JPanel�ǻ�����
//����������ʱ��,����֪��:�������־�֪�����Ǹ�ɶ
class BallJPanel extends JPanel implements MouseMotionListener{
	//��������ֱ��ʹ������---->Ҫʹ�ñ�������ʽ,
	//����һ��Ҫд����Ĵ���������,�����Ĵ���������
	int x=100;int y=100;int d=80;
	int f=0;//����ƶ�����
	int px=100;int py=500;int pw=150;
	Color ballColor;
	int score=0;
	public BallJPanel(){
		//���췽��:��ʼ��
		addMouseMotionListener(this);
	}
	//����---->��������---->�����������͡�������������
	//���������������,���ҵȺ�,�Ⱥ�ǰ���Ǹ����Ǳ�����,��Ϳ���������ǰ����Ǹ���ĸ
	//int a=10;	������Ϊa,ǰ���Ǹ�����Ϊint   int���ڻ�����������  a�����ڻ���
	//JFrame jf=new JFrame();jfΪ��������,ǰ���Ǹ�������������
	//û�¾Ͱ���alt+/ �ҵ������paint����
	//�����ѳ�ȥ�Է�,ϱ������û��,���˾��ǵȺ� 	û��û�Ⱥ�
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(ballColor);
		g.fillOval(x, y, d, d);
		//���൱����һ�������������û��ʵı�ͷ���
		//	Graphics2D	<	Graphics
		//�Ⱥŵ��ұߴ�,�Ⱥŵ����С,������ǿ������ת��:����Ҫ�й�ϵ
		Graphics2D g2=(Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		g.drawLine(px, py, px+pw, py);
		Font f=new Font("΢���ź�",Font.BOLD,30);
		g.setFont(f);
		g.setColor(Color.BLUE);
						//���ӷ�����+,ֻ��˫����һ��ʹ��
		g.drawString("�÷�:"+score,50, 40);
	}
	
	/*
	 * �Զ��巽���ĸ�ʽ
	 * ����:���������������֪����������ܸ�ʲô�¶�
	 * ����:���ݲ���������֪����������Ǹ�����¶��õ��Ķ���
	 * public void ��������(����){
	 * 
	 * }
	 */
	////�Զ���һ�������������߳�,�ƶ����
	public void moveBall(){
		//1.�½�һ���߳�
		new Thread(){
			//3.��CPU֪��������̵߳�����������ʲô---->ִ��run�����������
			public void run(){
				//����--->�㵽����������̸߳�ʲô
				while(true){//һ������һ����ѭ��
					//�ġ���repaint����д����Ҫд���߼�����
					//==�ж����������Ƿ����
					if(f==0){	//д����ߴ����������س�
						x--;//�Լ�1
						y--;
					}
					if(f==1){
						x++;//����1
						y--;
					}
					if(f==2){
						x++; y++;
					}
					if(f==3){
						x--;y++;
					}
					if(x<=0){	//С��ײ�������
						//���������,ֱ��ʹ��if(){}else{}
						if(f==0){	//��ʾ����0·�߹�����
							f=1;		//�����ķ���
						}else{
							f=2;
						}
					}
					if(y<=0){	//С��ײ�����ϱ�
						if(f==0){//��ʾ����0·�߹�����
							f=3;//�����ķ���
						}else{
							f=2;
						}
					}
					if(x>=400-d){		//С��ײ���ұ�
						if(f==1){
							f=0;
						}else{
							f=3;
						}
					}
					if(y>=py-d){			//С��ײ���±�
						if(x+d/2>px&&x+d/2<px+pw){		//�ӵ���
							if(f==2){
								f=1;
							}else{
								f=0;
							}
							score+=200;
							int r=(int) (Math.random()*256);
							int g=(int) (Math.random()*256);
							int b=(int) (Math.random()*256);
							ballColor=new Color(r,g,b);
						}else{		//û�ӵ���
							this.stop();//���߳̽�������״̬
						}
					}
					repaint();//�����ػ�
					try {
						Thread.sleep(10);//�����߳�����,���߳���һ��
						//4.���߳̽��뵽����״̬
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();//2.���߳̽��뵽������״̬
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		px=e.getX()-pw/2;
	}
}














