package day02;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 月食 
 *
 */
public class MoonJFrame {
	public static void main(String[] args) {
		JFrame jf=new JFrame();
		jf.setSize(800,600);
		jf.setLocationRelativeTo(null);//让屏幕居中
		jf.setTitle("月食 ");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		jf.setResizable(false);
		MoonJPanel mj=new MoonJPanel();
		jf.add(mj);
		mj.moveMoon();
	}
}
class MoonJPanel extends JPanel{
	int x=500;//变量----x变量的名称
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		setBackground(Color.black);
		g.setColor(Color.WHITE);
		g.fillOval(300,200, 80, 80);
		g.setColor(Color.BLACK);
		g.fillOval(x,200, 80, 80);
	}
	public void moveMoon(){
		new Thread(){
			public void run(){
				//1.创建循环
				while(true){
					x--;
					if(x<=200){
						x=500;
					}
					//2.重画
					repaint();
					//3.线程休眠---->慢一点
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













