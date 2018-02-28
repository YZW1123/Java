package chess;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	int [][]chess=new int[ROW_NUMBER][COL_NUMBER];	//����
	static final int CHESS_RADIO=13;	//���ӵİ뾶
	//��ǵ�����(���鵱�е��±�)
	int boradX=-1;
	int boradY=-1;
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
		//������:���ڶ�ά�������ÿһ��ֵΪ0
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess.length; j++) {
				if(chess[i][j]==0){
					continue;//�������ִ��
				}else if(chess[i][j]==1){//������
					g.drawImage(
					new ImageIcon("case06/black.png").getImage(), 
							j*COL_SPACE+LEFT_SPACE-CHESS_RADIO, 
							i*ROW_SPACE+UP_SPACE-CHESS_RADIO, 
							this);
				}else if(chess[i][j]==2){//������
					g.drawImage(
					new ImageIcon("case06/white.png").getImage(), 
							j*COL_SPACE+LEFT_SPACE-CHESS_RADIO, 
							i*ROW_SPACE+UP_SPACE-CHESS_RADIO, 
							this);
				}
			}
		}
		if(boradX!=-1){	//��Ϊ-1��ʾԲ�ĵ����걻�޸���
			g.setColor(Color.RED);
			g.fillOval(boradY*COL_SPACE+LEFT_SPACE-5, 
					boradX*ROW_SPACE+UP_SPACE-5, 10, 10);
		}
		
	}
	
	
	//�ж���Ӯ
	public boolean isUpAndDown(int i,int j){
		int i1=i-1;
		//����������һ��//�ж��Ƿ񵽶�����
		while(true){
			if(i1<0||chess[i][j]!=chess[i1][j]){
				break;//����ѭ��
			}
			i1--;
		}//���¼���
		i1++;
		int count=0;
		while(true){
			if(i1>=ROW_NUMBER||chess[i1][j]!=chess[i][j]){
				break;
			}
			i1++;	
			count++;//��ɫһ��
		}
		return count>=5;
	}
	
	public boolean isLeftAndRight(int i,int j){}
	
	public boolean isLeftUpAndRightDown(int i,int j){}
	
	public boolean isRightUpAndLeftDown(int i,int j){}
}








