package chess;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ChessJPanel extends JPanel{
	//常量:永恒不变的变量
	static final int ROW_NUMBER=18;//行
	static final int COL_NUMBER=18;//列
	static final int ROW_SPACE=30;//行间距
	static final int COL_SPACE=30;//列间距
	static final int UP_SPACE=30;	//上间距
	static final int LEFT_SPACE=30;	//左间距
	int [][]chess=new int[ROW_NUMBER][COL_NUMBER];	//棋盘
	static final int CHESS_RADIO=13;	//棋子的半径
	//定义一个集合用来存储步数
	ArrayList<String> stepchess=new ArrayList<String>();
	//标记的坐标(数组当中的下标)
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
		//画棋子:现在二维数组里的每一个值为0
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess.length; j++) {
				if(chess[i][j]==0){
					continue;//程序继续执行
				}else if(chess[i][j]==1){//画黑棋
					g.drawImage(
					new ImageIcon("case06/black.png").getImage(), 
							j*COL_SPACE+LEFT_SPACE-CHESS_RADIO, 
							i*ROW_SPACE+UP_SPACE-CHESS_RADIO, 
							this);
				}else if(chess[i][j]==2){//画白棋
					g.drawImage(
					new ImageIcon("case06/white.png").getImage(), 
							j*COL_SPACE+LEFT_SPACE-CHESS_RADIO, 
							i*ROW_SPACE+UP_SPACE-CHESS_RADIO, 
							this);
				}
			}
		}
		if(boradX!=-1){	//不为-1表示圆心的坐标被修改了
			g.setColor(Color.RED);
			g.fillOval(boradY*COL_SPACE+LEFT_SPACE-5, 
					boradX*ROW_SPACE+UP_SPACE-5, 10, 10);
		}
		
	}
	public boolean isWin(int i,int j){
		return isUpAndDown(i, j)||isLeftAndRight(i, j)
||isLeftUpAndRightDown(i, j)||isRightUpAndLeftDown(i, j);
	}
	
	//判断输赢
	public boolean isUpAndDown(int i,int j){
		int i1=i-1;
		//反方向先走一步//判断是否到顶部了
		while(true){
			if(i1<0||chess[i][j]!=chess[i1][j]){
				break;//跳出循环
			}
			i1--;
		}//向下计数
		i1++;
		int count=0;
		while(true){
			if(i1>=ROW_NUMBER||chess[i1][j]!=chess[i][j]){
				break;
			}
			i1++;	
			count++;//颜色一样
		}
		return count>=5;
	}
	
	public boolean isLeftAndRight(int i,int j){
		int j1=j-1;
		//反方向先走一步//判断是否到顶部了
		while(true){
			if(j1<0||chess[i][j]!=chess[i][j1]){
				break;//跳出循环
			}
			j1--;
		}//向下计数
		j1++;
		int count=0;
		while(true){
			if(j1>=COL_NUMBER||chess[i][j1]!=chess[i][j]){
				break;
			}
			j1++;	
			count++;//颜色一样
		}
		return count>=5;
	}
	
	public boolean isLeftUpAndRightDown(int i,int j){
		int j1=j-1;  int i1=i-1;
		//反方向先走一步//判断是否到顶部了
		while(true){
			if(i1<0||j1<0||chess[i][j]!=chess[i1][j1]){
				break;//跳出循环
			}
			j1--; i1--;
		}//向下计数
		j1++;	i1++;
		int count=0;
		while(true){
			if(i1>=ROW_NUMBER||j1>=COL_NUMBER||chess[i1][j1]!=chess[i][j]){
				break;
			}
			j1++;	i1++;
			count++;//颜色一样
		}
		return count>=5;
	}
	
	public boolean isRightUpAndLeftDown(int i,int j){
		int j1=j+1;  int i1=i-1;
		//反方向先走一步//判断是否到顶部了
		while(true){
			if(i1<0||j1>=COL_NUMBER||chess[i][j]!=chess[i1][j1]){
				break;//跳出循环
			}
			j1++; i1--;
		}//向下计数
		j1--;	i1++;
		int count=0;
		while(true){
			if(i1>=ROW_NUMBER||j1<0||chess[i1][j1]!=chess[i][j]){
				break;
			}
			j1--;	i1++;
			count++;//颜色一样
		}
		return count>=5;
	}
}








