package day02;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SnowJFrame {
	public static void main(String[] args) {
		JFrame jf=new JFrame();
		jf.setTitle("下雪");
//		jf.setBounds(50, 50, 800, 600);
		jf.setSize(800, 600);
		jf.setLocationRelativeTo(null);//让窗口居中
		jf.setVisible(true);
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SnowJPanel sj=new SnowJPanel();
		jf.add(sj);
		sj.moveSnow();//执行创建线程的方法
	}
}
class SnowJPanel extends JPanel{
	//变量:存储数据的地方,代词,指代你存的那个数据
	int []x=new int[500];
	int []y=new int[500];
	//构造方法:程序的初始化操作
	//构造方法:
	//			public+当前类的名称(参数){
	//				你想干嘛
	//			}
	//自定义方法:  public void 方法名称(参数){}
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
		Font f=new Font("楷体",Font.BOLD,30);
		g.setFont(f);
		for (int i = 0; i < x.length; i++) {
			g.drawString("*",x[i],y[i]);	
		}
		
	}
	
	public void moveSnow(){//自定义方法去创建出一条线程
		new Thread(){//匿名内部类的方式去创建出一条线程
			public void run(){//核心方法---->一定要有的方法
				while(true){
					for (int i = 0; i <y.length; i++) {
						y[i]++;
						if(y[i]>=600){//如果
							y[i]=0;
						}
					}
					
					repaint();//一直画
				try {//异常捕获的机制:帮助我们找错
					//因为CPU运行速度太快,只能让线程慢下来
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}












