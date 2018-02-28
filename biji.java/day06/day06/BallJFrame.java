package day06;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

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
	int px=150; int py=500;int pw=150;
	Ball ball;
	public BallJPanel(){
		ball=new Ball(100,Color.black,0,8,200,400);
		addMouseMotionListener(this);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		ball.drawBall(g);
		//强制转换:  等号的左右两边
		//两个类之间比大小前提 父子类的关系
		Graphics2D g2= (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		g.drawLine(px, py, px+pw, py);
	}
	public void moveBall(){
		new Thread(){
			public void run(){
				while(true){
					ball.move(px,py,pw);
					if(ball.gameover){	//表示游戏结束
						this.stop();
					}
					//每得分20分加球
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












