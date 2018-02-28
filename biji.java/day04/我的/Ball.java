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

//1.继承JFrame2、看见首字母大写ctrl+shift+o
public class Ball extends JFrame {
	// 定义构造方法
	/*
	 * public + 当前类名称(){ }
	 */
	public Ball() {
		// 设置属性
		this.setBounds(20, 20, 600, 800);// 设置窗口大小和位置
		this.setVisible(true);// 让窗口显示
		this.setTitle("接球");// 设置窗口标题
		this.setResizable(false);// 设置窗口不变大变小
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗口程序点击X号关闭
		ballhuabu bh = new ballhuabu();
		this.add(bh);
		bh.moveqiu();
	}

	// 执行构造方法
	public static void main(String[] args) {
		// 如何执行构造方法：创建一个类 的时候就执行了构造方法
		new Ball();
	}
}

// 在一个文件中，写两个了类或多个类的时候，一定要注意类的大括号，除了类的大括号外面去写
// JFrame是窗口类 JPanel 是画布类
// 给类命名的时候，见名知意：看见名字直到啥意思
// 继承画布JPanel
class ballhuabu extends JPanel implements MouseMotionListener {
	// 尽量避免直接使用数字---->要是用变量的形式
	// 变量一定要写在大括号里面，方法的大括号外面
	// 定义三个变量来确定圆的大小及位置
	int x = 60;
	int y = 60;
	int d = 90;
	// 定义三个变量来确定横杆的位置长度
	int px = 60;
	int py = 750;
	int pw = 150;
	// 定义一个变量来确定球运动的方向
	int f = 0;
	// 定义一个变量来确定加速
	int sp = 1;
	boolean flag = false; // 控制游戏结束的
	Color bjColor;// 定义一个变量来确定背景色
	Color qiuColor;// 定义一个变量来确定球体颜色
	// 定义一个分数
	int score = 0;

	// 变量---->数据类型--->基本数据类型、引用数据类型。
	// 如何区分数据类型，先找等号，等号前面的是变量名，就看变量名前面的字母颜色
	// 红色为基本数据类型，其他为引用数据类型
	// int a= 10；变量名为a，前面那个单词为int int属于基本数据类型 a就属于基本类
	// JFrame jf=new JFrame（）；jf为变量名前面那个就是引用数据类型。
	// g.setColor(ballColor);先定义后引用要赋值是给等号ballColor = new Color(r, g, b);
	// 没事就按alt+/ 找到父类paint方法
	public ballhuabu() {// 构造方法：初始化
		addMouseMotionListener(this);// 画布监听鼠标移动
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		setBackground(bjColor);// 设置背景颜色
		g.setColor(qiuColor);// 设置球颜色
		g.fillOval(x, y, d, d);// 设置所画东西的大小及位置
		Graphics2D g2 = (Graphics2D) g;// 强制转换把子类的转换给父类用
		g2.setStroke(new BasicStroke(5));// 把画笔加粗
		g.setColor(Color.BLACK);// 设置横杆的颜色
		g.drawLine(px, py, pw + px, py);// 设置横杆的长度和位置
		g.setColor(Color.RED);//
		g.setFont(new Font("宋体", Font.BOLD, 60));
		g.drawString("得分:" + score, 30, 60);
		if (flag) {
			g.drawString("GAME_OVER", 140, 380);
		}

	}

	// 定义一个球移动的方法用来创建线程
	public void moveqiu() {
		new Thread() {// 匿名内部类的方法创建出一条线程
			public void run() {// 核心方法--->一定要有的方法
				while (true) {// 一直循环
					if (f == 0) {// 向左上
						x -= sp;
						y -= sp;
					}
					if (f == 1) {// 向右上
						x += sp;
						y -= sp;
					}
					if (f == 2) {// 向右下
						x += sp;
						y += sp;
					}
					if (f == 3) {// 向左下
						x -= sp;
						y += sp;
					}
					if (x <= 0) {// 撞击左边
						if (f == 0) {
							f = 1;
						} else {
							f = 2;
						}
					}
					if (x >= 600 - d) {// 撞击右边
						if (f == 1) {
							f = 0;
						} else {
							f = 3;
						}
					}
					if (y <= 0) {// 撞击左边
						if (f == 0) {
							f = 3;
						} else {
							f = 2;
						}
					}
					if (y >= py - d) {// 撞击下边
						if (px <= x + d / 2 && px + pw >= x + d / 2) {
							if (f == 3) {// 接到球
								f = 0;
							} else {
								f = 1;
							}
							sp++;// 速度每接住一次就要加1直到速度为20为止
							if (sp >= 15) {
								sp = 20;
							}
							score += 5;// 设置得分每次加五分直到2000重头开始
							if (score >= 2000) {
								score = 0;
							}
							if (score >= 40) {
								pw += 3;
								if (pw >= 250) {
									pw -= 4;
								}
								if (pw <= 180) {
									pw = 180;
								}
								if (score >= 100) {
									sp++;
									if (sp>=20) {
										sp=20;
									}
								}
							}
							// 变色 //随机
							// r,b,g 红蓝绿 三原色
							// 随机数
							int r = (int) (Math.random() * 256);
							int g = (int) (Math.random() * 256);
							int b = (int) (Math.random() * 256);
							qiuColor = new Color(r, g, b);// 设置球体颜色
							bjColor = new Color(b, r, g);// 设置背景颜色
						} else {// 没接到球
							flag = true;
							// 让画布知道你改了flag这个值
							repaint();// 重新画
							this.stop();// 让线程进入死亡状态
						}
					}
					repaint();// 一直画

					try {
						Thread.sleep(10);// 让线程进入阻塞状态
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}

		}.start();

	}

	@Override // 鼠标抓取
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override // 鼠标移动
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		px = e.getX() - pw / 2;
	}
}