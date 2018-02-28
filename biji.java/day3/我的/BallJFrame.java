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

//�̳д�����,�ͱ���˴�����Ķ���
public class BallJFrame extends JFrame {
	// BallJFrame�����Ĺ��췽��
	public BallJFrame() {
		// thisָ����ǰ���Լ��Ķ���
		this.setBounds(50, 50, 400, 600);// ���ô�С��λ��
		this.setVisible(true);// �ô�����ʾ
		this.setResizable(false);// ��ֹ����С
		this.setTitle("�������ս");// ���ñ���
		// ���X��Ĭ�Ϲر�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BallJPanel bj = new BallJPanel();// ������������Ķ���
		this.add(bj);
		bj.moveBall();
	}

	/* ���߳� */
	// ���췽�����ִ��? ����ĳ����Ķ����ʱ���ִ����
	public static void main(String[] args) {
		new BallJFrame();// ����BallJFrame�����Ĺ��췽��
	}
}

// ��������ĸΪ��д�ľ�ctrl+shift+o
// û�¶��Ͱ�alt+/
class BallJPanel extends JPanel implements MouseMotionListener {
	int x = 100;
	int y = 200;
	int d = 80;
	// ����һ������������������ƶ�����
	int f = 3;
	int speed = 1;// ��������ٶ�
	int score = 0;// ����÷�
	boolean flag = false; // ������Ϸ������
	Color ballColor;// �����ɫ
	Color bgColor;// ����ɫ
	// ��������Ǵ�����{}
	// Java���о�����Ҫֱ��ʹ������,��Ӧ��ʹ�ñ�������ʽ
	// �����˵����꣬��˵ĳ���
	int px = 50;
	int py = 550;
	int pw = 130;

	// ����Ϸһ��ʼ��ʱ��Ϳ�ʼ����(��ʼ��)
	public BallJPanel() {
		addMouseMotionListener(this);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		setBackground(bgColor);// ���ñ�����ɫ
		g.setColor(ballColor);// ��������ɫ
		g.fillOval(x, y, d, d);// �������С��λ��
		// �����������͵Ĵ�С�Ƚ�,ͨ���ֽڵĴ�С
		// 4�ֽ� < 8�ֽ�
		// int a=(int) (Math.random()*100);
		// ǿ������ת��---->�Ⱥ��������ߵĴ�С��һ��, С=(С)��
		// ������������ͨ���ֽڱȴ�С ��������ͨ��������ȴ�С
		Graphics2D g2 = (Graphics2D) g;// ʹ�ü̳��ߵĻ���
		g2.setStroke(new BasicStroke(5));// �ѻ��ʱ��
		g.setColor(Color.black);//���ú����ɫ
		g.drawLine(px, py, px + pw, py);// ��˵ĳ��Ⱥ�λ��
		// �÷�
		g.setColor(Color.BLUE);
		Font f = new Font("����", Font.BOLD, 30);
		g.setFont(f); // ���ӷ�
		g.drawString("�÷�:" + score, 20, 50);
		g.setColor(Color.RED);
		if (flag) {
			g.drawString("GAME_OVER", 120, 300);
		}
	}

	// �Զ���һ���������������߳�
	public void moveBall() {
		new Thread() {
			public void run() {
				// ����ѭ��
				while (true) {
					if (f == 0) { // ����
						x -= speed;
						y -= speed;
					}
					if (f == 1) { // ����
						x += speed;
						y -= speed;
					}
					if (f == 2) { // ����
						x += speed;
						y += speed;
					}
					if (f == 3) { // ����
						x -= speed;
						y += speed;
					}
					if (x <= 0) { // ��� //С������������
						if (f == 0) {
							f = 1;
						} else {
							f = 2;
						}
					}
					if (x >= 400 - d) { // �ұ�
						if (f == 1) {
							f = 0;
						} else {
							f = 3;
						}
					}
					if (y <= 0) { // �ϱ�
						if (f == 0) {
							f = 3;
						} else {
							f = 2;
						}
					}
					if (y >= py - d) { // �±�
						if (px < x + d / 2 && x + d / 2 < px + pw) {// �ӵ���
							if (f == 2) {
								f = 1;
							} else {
								f = 0;
							}
							speed++;// ��סÿ���ٶȼ�1ֱ���ӵ�15Ϊֹ
							if (speed >= 15) {
								speed = 15;
							}
							pw -= 5;// ��סÿ�μ�5ֱ������90Ϊֹ
							if (pw <= 90) {
								pw = 90;
							}
							score += 5;
							if (score % 5 == 0) {
								pw += 10;
							}
							// ��ɫ //���
							// r,b,g ������ ��ԭɫ
							int r = (int) (Math.random() * 256);
							int g = (int) (Math.random() * 256);
							int b = (int) (Math.random() * 256);
							ballColor = new Color(r, g, b);
							bgColor = new Color(b, r, g);
						} else {// û�ӵ���
							flag = true;
							// �û���֪�������flag���ֵ
							repaint();// ���»�
							// �߳���Ķ���
							this.stop(); // ��Ϸ����
						}
					}
					// �ظ���
					repaint();
					// ���߳���һ��
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	// �϶�
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	// �ƶ�
	@Override // ���
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		px = e.getX() - pw / 2;// �Ѻ�˵����껻Ϊ��������
	}
}
