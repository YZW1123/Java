package chargame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * ´ò×ÖÄ¸ÓÎÏ·
 */
public class CharGame extends JFrame{
	public CharGame(){
		this.setBounds(50,50, 800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CharJPanel cp=new CharJPanel();
		this.add(cp);
		cp.moveChar();
	}
	public static void main(String[] args) {
		new CharGame();
	}
}
class CharJPanel extends JPanel{
	MyChar mcs[]=new MyChar[10];
	public CharJPanel(){
		for (int i = 0; i < mcs.length; i++) {
			int x=(int) (Math.random()*700);
			int y=-50;
			int speed=(int) (Math.random()*6+2);
			int r=(int)(Math.random()*256);
			int g=(int)(Math.random()*256);
			int b=(int)(Math.random()*256);
			Color charColor=new Color(r,g,b);
			int size=(int) (Math.random()*50+10);
			char a=(char) (Math.random()*26+97);
			mcs[i]=new MyChar(x,y,size,charColor,a,speed);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < mcs.length; i++) {
			mcs[i].drawChar(g);
		}
	}
	public void moveChar(){
		new Thread(){
			public void run(){
				while(true){
				for (int i = 0; i < mcs.length; i++) {
					mcs[i].move();
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
}




