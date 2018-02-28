package day06;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BallJFrame extends JFrame{
	public BallJFrame(){
		this.setTitle("接球");
		this.setVisible(true);
		this.setBounds(50, 50, 400, 600);
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
								
class BallJPanel extends JPanel implements MouseMotionListener{
	int px=150; int py=500;int pw=500;
	ArrayList <Ball> balls=new ArrayList<Ball>();
	Ball ball;
	int socre=0;
	//当执行这个方法时,就往集合里面添加一个球
	public void addBall(){
		int d=(int) (Math.random()*100+20);
		int  speed=(int) (Math.random()*3+2);
		int direction=(int) (Math.random()*4);
		int x=(int) (Math.random()*400);
		int y=(int) (Math.random()*300);
		int r=(int) (Math.random()*256);
		int g=(int) (Math.random()*256);
		int b=(int) (Math.random()*256);
		Color ballColor=new Color(r,g,b);
		ball=new Ball(d, ballColor, direction, speed, x, y);
		//把产生的球放到集合里面去
		balls.add(ball);
	}
	public BallJPanel(){
		//在游戏一开始运行的时候,就应该有一个球
		addBall();
		addMouseMotionListener(this);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i <balls.size(); i++) {
			balls.get(i).drawBall(g);
		}
		//强制转换:  等号的左右两边
		//两个类之间比大小前提 父子类的关系
		Graphics2D g2= (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		g.drawLine(px, py, px+pw, py);
		Font f=new Font("黑体",Font.BOLD,30);
		g.setFont(f);
		g.setColor(Color.BLUE);
		g.drawString("得分:"+socre,20,50);
	}
	public void moveBall(){
		new Thread(){
			public void run(){
				while(true){
					for (int i = 0; i < balls.size(); i++) {
						balls.get(i).move(px,py,pw);
						if(balls.get(i).gameover){	//表示游戏结束
							this.stop();
						}
						//每得分20分加球
						if(balls.get(i).flag){//	flag=true
							balls.get(i).flag=false;
							socre+=5;
							if(socre%20==0){
								//加球
								addBall();
							}
						}
					}
					
					repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		px	=e.getX()-pw/2;
	}
	
}












