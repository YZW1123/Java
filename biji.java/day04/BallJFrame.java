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

//1.继承JFrame	2.看见首字母大写的ctrl+shift+o
public class BallJFrame extends JFrame{
	//3.定义构造方法
	/*
	 *  public +当前类的名称(){
	 *  	怎么怎么干
	 *  }
	 */
	public BallJFrame(){
		//设置窗口的属性
		this.setBounds(50, 50, 400, 600);//设置窗口的大小和位置
		this.setTitle("球球");//设置标题
		//点击X号默认关闭
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);//让窗口显示
		this.setResizable(false);//禁止窗口变大变小
		//老婆     小丽 =  新  老婆();
		BallJPanel bp=new BallJPanel();
		//当前的窗口类对象
		this.add(bp);
		//自定义方法moveBall要通过对象的名称点出来
		bp.moveBall();
	}
	public static void main(String[] args) {
		//如何执行构造方法:创建一个类的对象的时候就执行了构造方法
		new BallJFrame();
	}
}
//在一个类文件中,写两个类或者多个类的时候,一定要注意类的大括号,出了类的大括号外面去写
//JFrame是窗口类  			JPanel是画布类
//给类命名的时候,见名知意:看见名字就知道这是个啥
class BallJPanel extends JPanel implements MouseMotionListener{
	//尽量避免直接使用数字---->要使用变量的形式,
	//变量一定要写在类的大括号里面,方法的大括号外面
	int x=100;int y=100;int d=80;
	int f=0;//球的移动方向
	int px=100;int py=500;int pw=150;
	Color ballColor;
	int score=0;
	public BallJPanel(){
		//构造方法:初始化
		addMouseMotionListener(this);
	}
	//变量---->数据类型---->基本数据类型、引用数据类型
	//如何区分数据类型,先找等号,等号前面那个就是变量名,你就看变量名称前面的那个字母
	//int a=10;	变量名为a,前面那个单词为int   int属于基本数据类型  a就属于基本
	//JFrame jf=new JFrame();jf为变量名称,前面那个就是引用类型
	//没事就按按alt+/ 找到父类的paint方法
	//跟朋友出去吃饭,媳妇儿来没来,来了就是等号 	没来没等号
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(ballColor);
		g.fillOval(x, y, d, d);
		//子类当中有一个方法可以设置画笔的笔头变粗
		//	Graphics2D	<	Graphics
		//等号的右边大,等号的左边小,所以有强制类型转换:必须要有关系
		Graphics2D g2=(Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		g.drawLine(px, py, px+pw, py);
		Font f=new Font("微软雅黑",Font.BOLD,30);
		g.setFont(f);
		g.setColor(Color.BLUE);
						//连接符就是+,只和双引号一起使用
		g.drawString("得分:"+score,50, 40);
	}
	
	/*
	 * 自定义方法的格式
	 * 方法:根据这个方法名称知道这个方法能干什么事儿
	 * 参数:根据参数的名称知道这个参数是干这个事儿用到的东西
	 * public void 方法名称(参数){
	 * 
	 * }
	 */
	////自定义一个方法来创建线程,移动球的
	public void moveBall(){
		//1.新建一个线程
		new Thread(){
			//3.让CPU知道你这个线程的运行任务是什么---->执行run方法里的内容
			public void run(){
				//任务--->你到底想让这个线程干什么
				while(true){//一、创建一个死循环
					//四、在repaint上面写你想要写的逻辑代码
					//==判断两个数字是否相等
					if(f==0){	//写完左边大括号立马按回车
						x--;//自减1
						y--;
					}
					if(f==1){
						x++;//自增1
						y--;
					}
					if(f==2){
						x++; y++;
					}
					if(f==3){
						x--;y++;
					}
					if(x<=0){	//小球撞到左边了
						//有两种情况,直接使用if(){}else{}
						if(f==0){	//表示球按照0路线过来的
							f=1;		//反弹的方向
						}else{
							f=2;
						}
					}
					if(y<=0){	//小球撞到了上边
						if(f==0){//表示球按照0路线过来的
							f=3;//反弹的方向
						}else{
							f=2;
						}
					}
					if(x>=400-d){		//小球撞到右边
						if(f==1){
							f=0;
						}else{
							f=3;
						}
					}
					if(y>=py-d){			//小球撞到下边
						if(x+d/2>px&&x+d/2<px+pw){		//接到球
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
						}else{		//没接到球
							this.stop();//让线程进入死亡状态
						}
					}
					repaint();//二、重画
					try {
						Thread.sleep(10);//三、线程休眠,让线程慢一点
						//4.让线程进入到阻塞状态
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();//2.让线程进入到可运行状态
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		px=e.getX()-pw/2;
	}
}














