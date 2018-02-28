package day03;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Qiu extends JFrame {
	public Qiu() {
		this.setBounds(20, 20, 600, 800);// 设置窗口大小和位置
		this.setTitle("球球");// 设置窗口标题
		this.setVisible(true);// 让窗口显示
		this.setResizable(false);// 设置窗口不被拖动
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗口程序点击X关闭程序
		QiuJPanel qp = new QiuJPanel();
		this.add(qp);
		qp.Moveqiu();
	}

	public static void main(String[] args) {
		new Qiu();

	}

}

class QiuJPanel extends JPanel {
	int x = 60;
	int y = 60;
	int d = 90;
	int f = 0;

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.fillOval(x, y, d, d);
	}

	public void Moveqiu() {
		new Thread() {
			public void run() {
				while (true) {
					if (f == 0) {
						x--;
						y--;
					}
					if (f == 1) {
						x++;
						y--;
					}
					if (f == 2) {
						x++;
						y++;
					}
					if (f == 3) {
						x--;
						y++;
					}
					if (x <= 0) {
						if (f == 0) {
							f = 1;
						} else {
							f = 2;
						}
					}
					if (y <= 0) {
						if (f == 0) {
							f = 3;
						} else {
							f = 2;
						}
					}
					if (x >= 600 - d) {
						if (f == 2) {
							f = 3;
						} else {
							f =0 ;
						}
					}
					if (y >= 800 - d - 30) {
						if (f == 3) {
							f = 0;
						} else {
							f = 1;
						}
					}
					repaint();// 一直画
					try {
						Thread.sleep(1);// 画慢点
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}