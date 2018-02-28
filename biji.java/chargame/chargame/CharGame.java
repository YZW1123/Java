package chargame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 打字母游戏
 */
public class CharGame extends JFrame{
	public CharGame(){
		this.setBounds(50,50, 800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CharJPanel cp=new CharJPanel();
		this.add(cp);
		cp.moveChar();
		this.addKeyListener(cp);
	}
	public static void main(String[] args) {
		new CharGame();
	}
}
class CharJPanel extends JPanel implements KeyListener{
	int score=0;
	MyChar mcs[]=new MyChar[10];
	Timer timer;
	int second=60;
	public CharJPanel(){
		for (int i = 0; i < mcs.length; i++) {
			int x=(int) (Math.random()*700);
			int y=-50;
			int speed=(int) (Math.random()*6)+2;
			int r=(int)(Math.random()*256);
			int g=(int)(Math.random()*256);
			int b=(int)(Math.random()*256);
			Color charColor=new Color(r,g,b);
			int size=(int) (Math.random()*30)+40;
			char a=(char) (Math.random()*26+97);
			mcs[i]=new MyChar(x,y,size,charColor,a,speed);
		}
		timer=new Timer();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < mcs.length; i++) {
			mcs[i].drawChar(g);
		}
		g.setColor(Color.BLACK);
		g.setFont(new Font("黑体",Font.BOLD,50));
		g.drawString("得分："+score, 50, 50);
	}
	public TimerTask daojishi(){
		new TimerTask() {
			@Override
			public void run() {
				second--;
			}
		};
	}
	public void moveChar(){
		new Thread(){
			public void run(){
				while(true){
				for (int i = 0; i < mcs.length; i++) {
					mcs[i].move();
					if(mcs[i].y>=580){
						mcs[i].addChar();
						score-=20;
					}
				}
				timer.schedule(arg0, arg1);
				daojishi();
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
	public void keyPressed(KeyEvent e) {
		int index=-1;
		for (int i = 0; i < mcs.length; i++) {
			if(e.getKeyChar()==mcs[i].a){
				index=i;
			}
			
		}
		if(index!=-1){
			mcs[index].addChar();
			score+=10;
		}else{
			score-=20;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}





