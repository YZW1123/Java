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
		this.setBounds(20, 20, 400, 600);// ���ô��ڴ�С��λ��
		this.setTitle("�������ս");// ���ô��ڱ���
		this.setVisible(true);// �ô�����ʾ
		this.setResizable(false);// ���ô��ڲ����϶�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���ô��ڳ�����X�ر�
		QiutiJPanel qj = new QiutiJPanel();// ����QiutiJPanel�Ķ���
		this.add(qj);// �Ѷ���QiutiJPanel�ŵ�������
		qj.moveqiu();
	}/* ���߳� */
	// ���췽�����ִ�У�����ĳ����Ķ����ʱ���ִ�С�

	public static void main(String[] args) {
		new QiuQiu();
	}
}

// ��������ĸ��д�ľ�ctrl+shift+O
// û�¾Ͱ�alt+/.
class QiutiJPanel extends JPanel implements MouseMotionListener {
	int x = 100;// ����һ��int����
	int y = 200;// ����һ��int����
	int d = 80;// ����һ��int����
	int f = 0;// ����һ����������������ķ���
	int px = 120;
	int py = 550;
	int pw = 130;

	// ��������Ǵ�����{}
	// Java���о�����Ҫֱ��ʹ�����֣���Ӧ��ʹ�ñ�������ʽ
	public QiutiJPanel() {
		addMouseMotionListener(this);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.fillOval(x, y, d, d);// ��������
		Graphics2D g2 = (Graphics2D) g;// ������ķ����ø�������
		g2.setStroke(new BasicStroke(5));// ������
		g.drawLine(px, py, px + pw, py);
	}

	public void moveqiu() {// �Զ��巽��������һ���߳�
		new Thread() {// �����ڲ���ķ���������һ���߳�
			public void run() {// ���ķ���--->һ��Ҫ�еķ���
				while (true) {// ѭ��
					if (f == 0) {// ������
						x--;
						y--;
					}
					if (f == 1) {// ������
						x++;
						y--;
					}
					if (f == 3) {// ������
						x--;
						y++;
					}
					if (f == 2) {// ������
						x++;
						y++;
					}
					if (x <= 0) {// ײ�����
						if (f == 0) {
							f = 1;
						} else {
							f = 2;
						}
					}
					if (x >= 400 - d) {// ײ���ұ�
						if (f == 1) {
							f = 0;
						} else {
							f = 3;
						}
					}
					if (y <= 0) {// ײ���ϱ�
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
					repaint();// һֱ��
					try {
						Thread.sleep(10);// ������
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
