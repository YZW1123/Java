package day05;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BallJFrame extends JFrame{
	public BallJFrame(){
		this.setBounds(50, 50, 800, 600);
		this.setTitle("������");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		BallJPanel bp=new BallJPanel();
		this.add(bp);
		bp.moveBall();
	}
	public static void main(String[] args) {
		new BallJFrame();
	}
}

class BallJPanel extends JPanel{
	Ball[] balls=new Ball[30];
	Ball ball=new Ball(50,Color.black,3,8,500,200);
	//ΪʲôҪ�ڹ��췽�����渳ֵ---->��ʼ��
	public BallJPanel(){
		for (int i = 0; i < balls.length; i++) {
			int d=(int) (Math.random()*100+20);
			int  speed=(int) (Math.random()*3+2);
			int direction=(int) (Math.random()*4);
			int x=(int) (Math.random()*800);
			int y=(int) (Math.random()*600);
			int r=(int) (Math.random()*256);
			int g=(int) (Math.random()*256);
			int b=(int) (Math.random()*256);
			Color ballColor=new Color(r,g,b);
			balls[i]=new Ball(d,ballColor,direction,speed,x,y);
		}
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		ball.drawBall(g);
		for (int i = 0; i < balls.length; i++) {
			//���������鵱�е����е���
		//balls[i]---->�����е����е���
			balls[i].drawBall(g);
		}
	}
	public void moveBall(){
		new Thread(){
			public void run(){
				while(true){
					ball.move();//��һ�����ƶ�
					for (int i = 0; i < balls.length; i++) {
						//�����鵱�е��������ƶ�
						//balls[i]   i--->0~29
						balls[i].move();
					}
//					balls[0].move();
//					balls[1].move();
//					balls[2].move();
					repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
					}
				}
				
			}
		}.start();
	}
}










