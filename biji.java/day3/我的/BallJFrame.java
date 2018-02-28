package day03;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.font.GraphicAttribute;

import javax.swing.JFrame;
import javax.swing.JPanel;

//继承窗口类,就变成了窗口类的儿子
public class BallJFrame extends JFrame {
	// BallJFrame这个类的构造方法
	public BallJFrame() {
		// this指代当前类自己的对象
		this.setBounds(50, 50, 400, 600);// 设置大小和位置
		this.setVisible(true);// 让窗口显示
		this.setResizable(false);// 禁止变大变小
		this.setTitle("球球大作战");// 设置标题
		// 点击X号默认关闭
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BallJPanel bj = new BallJPanel();// 创建出画布类的对象
		this.add(bj);
		bj.moveBall();
	}

	/* 主线程 */
	// 构造方法如何执行? 创建某个类的对象的时候就执行了
	public static void main(String[] args) {
		new BallJFrame();// 调用BallJFrame这个类的构造方法
	}
}

// 看到首字母为大写的就ctrl+shift+o
// 没事儿就按alt+/
class BallJPanel extends JPanel implements MouseMotionListener {
	int x = 100;
	int y = 200;
	int d = 80;
	// 定义一个变量用来控制球的移动方向
	int f = 3;
	int speed = 1;// 定义球的速度
	int score = 0;// 定义得分
	boolean flag = false; // 控制游戏结束的
	Color ballColor;// 球的颜色
	Color bgColor;// 背景色
	// 作用域就是大括号{}
	// Java当中尽量不要直接使用数字,而应该使用变量的形式
	// 定义横杆的坐标，横杆的长度
	int px = 50;
	int py = 550;
	int pw = 130;

	// 在游戏一开始的时候就开始监听(初始化)
	public BallJPanel() {
		addMouseMotionListener(this);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		setBackground(bgColor);// 设置背景颜色
		g.setColor(ballColor);// 设置球颜色
		g.fillOval(x, y, d, d);// 设置球大小和位置
		// 基本数据类型的大小比较,通过字节的大小
		// 4字节 < 8字节
		// int a=(int) (Math.random()*100);
		// 强制类型转换---->等号左右两边的大小不一样, 小=(小)大
		// 基本数据类型通过字节比大小 引用类型通过父子类比大小
		Graphics2D g2 = (Graphics2D) g;// 使用继承者的画笔
		g2.setStroke(new BasicStroke(5));// 把画笔变粗
		g.setColor(Color.black);//设置横杆颜色
		g.drawLine(px, py, px + pw, py);// 横杆的长度和位置
		// 得分
		g.setColor(Color.BLUE);
		Font f = new Font("黑体", Font.BOLD, 30);
		g.setFont(f); // 连接符
		g.drawString("得分:" + score, 20, 50);
		g.setColor(Color.RED);
		if (flag) {
			g.drawString("GAME_OVER", 120, 300);
		}
	}

	// 自定义一个方法用来创建线程
	public void moveBall() {
		new Thread() {
			public void run() {
				// 创建循环
				while (true) {
					if (f == 0) { // 左上
						x -= speed;
						y -= speed;
					}
					if (f == 1) { // 右上
						x += speed;
						y -= speed;
					}
					if (f == 2) { // 右下
						x += speed;
						y += speed;
					}
					if (f == 3) { // 左下
						x -= speed;
						y += speed;
					}
					if (x <= 0) { // 左边 //小球在哪条边上
						if (f == 0) {
							f = 1;
						} else {
							f = 2;
						}
					}
					if (x >= 400 - d) { // 右边
						if (f == 1) {
							f = 0;
						} else {
							f = 3;
						}
					}
					if (y <= 0) { // 上边
						if (f == 0) {
							f = 3;
						} else {
							f = 2;
						}
					}
					if (y >= py - d) { // 下边
						if (px < x + d / 2 && x + d / 2 < px + pw) {// 接到球
							if (f == 2) {
								f = 1;
							} else {
								f = 0;
							}
							speed++;// 接住每次速度加1直到加到15为止
							if (speed >= 15) {
								speed = 15;
							}
							pw -= 5;// 接住每次减5直到减到90为止
							if (pw <= 90) {
								pw = 90;
							}
							score += 5;
							if (score % 5 == 0) {
								pw += 10;
							}
							// 变色 //随机
							// r,b,g 红蓝绿 三原色
							int r = (int) (Math.random() * 256);
							int g = (int) (Math.random() * 256);
							int b = (int) (Math.random() * 256);
							ballColor = new Color(r, g, b);
							bgColor = new Color(b, r, g);
						} else {// 没接到球
							flag = true;
							// 让画布知道你改了flag这个值
							repaint();// 重新画
							// 线程类的对象
							this.stop(); // 游戏结束
						}
					}
					// 重复画
					repaint();
					// 让线程慢一点
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	// 拖动
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	// 移动
	@Override // 鼠标
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		px = e.getX() - pw / 2;// 把横杆的坐标换为鼠标的坐标
	}
}
