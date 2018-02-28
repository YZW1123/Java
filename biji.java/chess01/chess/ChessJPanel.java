package chess;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ChessJPanel extends JPanel{
	//����:���㲻��ı���
	static final int ROW_NUMBER=18;//��
	static final int COL_NUMBER=18;//��
	static final int ROW_SPACE=30;//�м��
	static final int COL_SPACE=30;//�м��
	static final int UP_SPACE=30;	//�ϼ��
	static final int LEFT_SPACE=30;	//����
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(new ImageIcon("case06/panel.png").getImage()
				,0,0,this);
		Graphics2D g2=(Graphics2D) g;
		g2.setStroke(new BasicStroke(2));
		for (int i = 0; i < ROW_NUMBER; i++) {
			g.drawLine(
					LEFT_SPACE, 
					UP_SPACE+ROW_SPACE*i,
					LEFT_SPACE+COL_SPACE*(COL_NUMBER-1),
					UP_SPACE+ROW_SPACE*i);
		}
		for (int i = 0; i < COL_NUMBER; i++) {
			g.drawLine(
					LEFT_SPACE+COL_SPACE*i, 
					UP_SPACE, 
					LEFT_SPACE+COL_SPACE*i,
					UP_SPACE+ROW_SPACE*(COL_NUMBER-1));
		}
		
	}
}








