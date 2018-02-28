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

//1.�̳�JFrame2����������ĸ��дctrl+shift+o
public class Ball extends JFrame {
	// ���幹�췽��
	/*
	 * public + ��ǰ������(){ }
	 */
	public Ball() {
		// ��������
		this.setBounds(20, 20, 600, 800);// ���ô��ڴ�С��λ��
		this.setVisible(true);// �ô�����ʾ
		this.setTitle("����");// ���ô��ڱ���
		this.setResizable(false);// ���ô��ڲ�����С
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���ô��ڳ�����X�Źر�
		ballhuabu bh = new ballhuabu();
		this.add(bh);
		bh.moveqiu();
	}

	// ִ�й��췽��
	public static void main(String[] args) {
		// ���ִ�й��췽��������һ���� ��ʱ���ִ���˹��췽��
		new Ball();
	}
}

// ��һ���ļ��У�д��������������ʱ��һ��Ҫע����Ĵ����ţ�������Ĵ���������ȥд
// JFrame�Ǵ����� JPanel �ǻ�����
// ����������ʱ�򣬼���֪�⣺��������ֱ��ɶ��˼
// �̳л���JPanel
class ballhuabu extends JPanel implements MouseMotionListener {
	// ��������ֱ��ʹ������---->Ҫ���ñ�������ʽ
	// ����һ��Ҫд�ڴ��������棬�����Ĵ���������
	// ��������������ȷ��Բ�Ĵ�С��λ��
	int x = 60;
	int y = 60;
	int d = 90;
	// ��������������ȷ����˵�λ�ó���
	int px = 60;
	int py = 750;
	int pw = 150;
	// ����һ��������ȷ�����˶��ķ���
	int f = 0;
	// ����һ��������ȷ������
	int sp = 1;
	boolean flag = false; // ������Ϸ������
	Color bjColor;// ����һ��������ȷ������ɫ
	Color qiuColor;// ����һ��������ȷ��������ɫ
	// ����һ������
	int score = 0;

	// ����---->��������--->�����������͡������������͡�
	// ��������������ͣ����ҵȺţ��Ⱥ�ǰ����Ǳ��������Ϳ�������ǰ�����ĸ��ɫ
	// ��ɫΪ�����������ͣ�����Ϊ������������
	// int a= 10��������Ϊa��ǰ���Ǹ�����Ϊint int���ڻ����������� a�����ڻ�����
	// JFrame jf=new JFrame������jfΪ������ǰ���Ǹ����������������͡�
	// g.setColor(ballColor);�ȶ��������Ҫ��ֵ�Ǹ��Ⱥ�ballColor = new Color(r, g, b);
	// û�¾Ͱ�alt+/ �ҵ�����paint����
	public ballhuabu() {// ���췽������ʼ��
		addMouseMotionListener(this);// ������������ƶ�
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		setBackground(bjColor);// ���ñ�����ɫ
		g.setColor(qiuColor);// ��������ɫ
		g.fillOval(x, y, d, d);// �������������Ĵ�С��λ��
		Graphics2D g2 = (Graphics2D) g;// ǿ��ת���������ת����������
		g2.setStroke(new BasicStroke(5));// �ѻ��ʼӴ�
		g.setColor(Color.BLACK);// ���ú�˵���ɫ
		g.drawLine(px, py, pw + px, py);// ���ú�˵ĳ��Ⱥ�λ��
		g.setColor(Color.RED);//
		g.setFont(new Font("����", Font.BOLD, 60));
		g.drawString("�÷�:" + score, 30, 60);
		if (flag) {
			g.drawString("GAME_OVER", 140, 380);
		}

	}

	// ����һ�����ƶ��ķ������������߳�
	public void moveqiu() {
		new Thread() {// �����ڲ���ķ���������һ���߳�
			public void run() {// ���ķ���--->һ��Ҫ�еķ���
				while (true) {// һֱѭ��
					if (f == 0) {// ������
						x -= sp;
						y -= sp;
					}
					if (f == 1) {// ������
						x += sp;
						y -= sp;
					}
					if (f == 2) {// ������
						x += sp;
						y += sp;
					}
					if (f == 3) {// ������
						x -= sp;
						y += sp;
					}
					if (x <= 0) {// ײ�����
						if (f == 0) {
							f = 1;
						} else {
							f = 2;
						}
					}
					if (x >= 600 - d) {// ײ���ұ�
						if (f == 1) {
							f = 0;
						} else {
							f = 3;
						}
					}
					if (y <= 0) {// ײ�����
						if (f == 0) {
							f = 3;
						} else {
							f = 2;
						}
					}
					if (y >= py - d) {// ײ���±�
						if (px <= x + d / 2 && px + pw >= x + d / 2) {
							if (f == 3) {// �ӵ���
								f = 0;
							} else {
								f = 1;
							}
							sp++;// �ٶ�ÿ��סһ�ξ�Ҫ��1ֱ���ٶ�Ϊ20Ϊֹ
							if (sp >= 15) {
								sp = 20;
							}
							score += 5;// ���õ÷�ÿ�μ����ֱ��2000��ͷ��ʼ
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
							// ��ɫ //���
							// r,b,g ������ ��ԭɫ
							// �����
							int r = (int) (Math.random() * 256);
							int g = (int) (Math.random() * 256);
							int b = (int) (Math.random() * 256);
							qiuColor = new Color(r, g, b);// ����������ɫ
							bjColor = new Color(b, r, g);// ���ñ�����ɫ
						} else {// û�ӵ���
							flag = true;
							// �û���֪�������flag���ֵ
							repaint();// ���»�
							this.stop();// ���߳̽�������״̬
						}
					}
					repaint();// һֱ��

					try {
						Thread.sleep(10);// ���߳̽�������״̬
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}

		}.start();

	}

	@Override // ���ץȡ
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override // ����ƶ�
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		px = e.getX() - pw / 2;
	}
}