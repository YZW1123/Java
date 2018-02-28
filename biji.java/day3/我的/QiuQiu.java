package day03;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class QiuQiu extends JFrame {
	public QiuQiu() {
		this.setBounds(20, 20, 400, 600);// 设置窗口大小和位置
		this.setTitle("球球大作战");// 设置窗口标题
		this.setVisible(true);// 让窗口显示
		this.setResizable(false);// 设置窗口不被拖动
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗口程序点击X关闭
		QiutiJPanel qj = new QiutiJPanel();// 调用QiutiJPanel的对象
		this.add(qj);// 把对象QiutiJPanel放到窗口中
		qj.moveqiu();
	}/* 主线程 */
	// 构造方法如何执行？创建某个类的对象的时候就执行。

	public static void main(String[] args) {
		new QiuQiu();
	}
}

// 看到首字母大写的就ctrl+shift+O
// 没事就按alt+/.
class QiutiJPanel extends JPanel implements MouseMotionListener {
	int x = 100;// 定义一个int变量
	int y = 200;// 定义一个int变量
	int d = 80;// 定义一个int变量
	int f = 0;// 定义一个变量用来控制球的方向
	int px = 120;
	int py = 550;
	int pw = 130;

	// 作用域就是大括号{}
	// Java当中尽量不要直接使用数字，而应该使用变量的形式
	public QiutiJPanel() {
		addMouseMotionListener(this);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.fillOval(x, y, d, d);// 设置内容
		Graphics2D g2 = (Graphics2D) g;// 把子体的方法拿给父体用
		g2.setStroke(new BasicStroke(5));// 字体变粗
		g.drawLine(px, py, px + pw, py);
	}

	public void moveqiu() {// 自定义方法创建出一条线程
		new Thread() {// 匿名内部类的方法创建出一条线程
			public void run() {// 核心方法--->一定要有的方法
				while (true) {// 循环
					if (f == 0) {// 向左上
						x--;
						y--;
					}
					if (f == 1) {// 向右上
						x++;
						y--;
					}
					if (f == 3) {// 向左下
						x--;
						y++;
					}
					if (f == 2) {// 向右下
						x++;
						y++;
					}
					if (x <= 0) {// 撞击左边
						if (f == 0) {
							f = 1;
						} else {
							f = 2;
						}
					}
					if (x >= 400 - d) {// 撞击右边
						if (f == 1) {
							f = 0;
						} else {
							f = 3;
						}
					}
					if (y <= 0) {// 撞击上边
						if (f == 0) {
							f = 3;
						} else {
							f = 2;
						}
					}
					if (y >= 600 - d - 30) {
						if (f == 2) {
							f = 1;
						} else {
							f = 0;
						}
					}
					repaint();// 一直画
					try {
						Thread.sleep(10);// 画慢点
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		px = e.getX() - pw / 2;

	}
}
