package chess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
//二维数组
//棋盘的窗口类
public class ChessFrame extends JFrame implements ActionListener{
	//布局的容器		背景图片
	JLabel mainLabel=new JLabel(new ImageIcon("case06/back.png"));
	//	3.玩家的图片
	JLabel player=new JLabel(new ImageIcon("case06/blackmsg.png"));
	JLabel comp=new JLabel(new ImageIcon("case06/whitemsg.png"));
	// 创建出所有的按钮
	JButton huiqi,close,min,start;
	//创建菜单  需要三个类
	JMenuBar bar;//告诉界面在某个区域内我是要放菜单的
	JMenu game;	//这个才是我们真正的菜单
	JMenuItem saveGame,loadGame;	//这两个是主菜单的子菜单
	//创建出画布类的对象
	ChessJPanel panel=new ChessJPanel();
	//用来控制下子的先后顺序
	boolean isBlack=false;
	//用来控制游戏的输赢
	boolean isWin=false;
	public ChessFrame(){
		//将画布放到背景图片上
		panel.setBounds(170,100, 592, 592);
		panel.setOpaque(false);//去掉画布的白底
		mainLabel.add(panel);
		//设置菜单的区域
		bar=new JMenuBar();
		bar.setBounds(10,10, 100, 36);
		mainLabel.add(bar);
		//在区域内放入主菜单
		game=new JMenu();
		game.setIcon(new ImageIcon("case06/bar.png"));
		game.add(saveGame=new JMenuItem("保存游戏...."));
		game.add(loadGame=new JMenuItem("加载游戏...."));
		bar.add(game);
		//悔棋
		huiqi=new JButton(new ImageIcon("case06/huiqi.png"));
		huiqi.setContentAreaFilled(false);//去掉白底
		huiqi.setBorderPainted(false);//去掉边框线
		huiqi.setBounds(30,420,100, 42);
		mainLabel.add(huiqi);
		//关闭
		close=new JButton(new ImageIcon("case06/close.png"));
		close.setContentAreaFilled(false);//去掉白底
		close.setBorderPainted(false);//去掉边框线
		close.setBounds(850,20,14, 14);
		mainLabel.add(close);
		//最小化
		min=new JButton(new ImageIcon("case06/min.png"));
		min.setContentAreaFilled(false);//去掉白底
		min.setBorderPainted(false);//去掉边框线
		min.setBounds(830,20,14, 14);
		mainLabel.add(min);
		//重置
		start=new JButton(new ImageIcon("case06/start.png"));
		start.setContentAreaFilled(false);//去掉白底
		start.setBorderPainted(false);//去掉边框线
		start.setBounds(420,15,34, 34);
		mainLabel.add(start);
		
		//  3.加载玩家图片
		player.setBounds(30,90,110, 110);
		mainLabel.add(player);
		comp.setBounds(770,500,110,110);
		mainLabel.add(comp);
		//	2.将背景图片放到窗口上
		this.add(mainLabel);
		this.setUndecorated(true);//隐藏窗口的边框
		this.setBounds(50,30, 900, 700);
		//	1.设置程序运行时的小图标	
		//setIconImage(new new ImageIcon("case06/icon.jpg").getImage());
		this.setIconImage(new ImageIcon("case06/icon.jpg").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//给画布添加鼠标点击事件同时添加监听
		//MouseAdapter这个类它自己本身实现了
		//MouseListener和MouseMotionListerner
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(isWin){
					return;
				}
				//获得鼠标的X,y坐标
				int x=e.getX();
				int y=e.getY();
				//对鼠标的点进行处理  将像素转换成数组的下标
				int i=Math.round((float)(y-ChessJPanel.LEFT_SPACE)/ChessJPanel.COL_SPACE);
				int j=Math.round((float)(x-ChessJPanel.UP_SPACE)/ChessJPanel.ROW_SPACE);
				panel.boradX=i;
				panel.boradY=j;
				//判断是否有棋子 	
				if(panel.chess[i][j]!=0){
					JOptionPane.showMessageDialog(ChessFrame.this,
							"此处有棋子,禁止下棋");
					return;//1.返回值	2.结束后面的代码执行
				}
				//三目云算法
				panel.chess[i][j]=isBlack?1:2;
				//当我的鼠标点击一下之后,就记录步数
				String step=i+":"+j+":"+(isBlack?1:2);
				System.out.println(step);
				//往集合当中去添加
				panel.stepchess.add(step);
				panel.repaint();
				//判断输赢
				if(panel.isWin(i, j)){
					JOptionPane.showMessageDialog(ChessFrame.this,
							(isBlack?"黑方胜利":"白方胜利"));
					isWin=true;
				}
				isBlack=!isBlack;
			
			}
		});
		
		
		min.addActionListener(this);
		close.addActionListener(this);
		start.addActionListener(this);
		saveGame.addActionListener(this);
		loadGame.addActionListener(this);
		huiqi.addActionListener(this);
	}
	public static void main(String[] args) {
		new ChessFrame();
	}
	//接口名称:ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==min){
			ChessFrame.this.setState(1);
		}
		if(e.getSource()==close){
			System.exit(0);
		}
		if(e.getSource()==start){
			for (int i = 0; i < panel.chess.length; i++) {
				for (int j = 0; j < panel.chess.length; j++) {
					panel.chess[i][j]=0;
				}
			}
			panel.boradX=-1;
			panel.boradY=-1;
			isWin=false;
			panel.repaint();
		}
		if(e.getSource()==saveGame){
			//1.弹出一个保存文件的对话框
			JFileChooser jfc=new JFileChooser();
			jfc.showSaveDialog(this);
		}
		if(e.getSource()==loadGame){
			JFileChooser jfc=new JFileChooser();
			jfc.showOpenDialog(this);
		}
		if(e.getSource()==huiqi){
			ArrayList<String> step=panel.stepchess;
			if(step.size()==0){
				return;
			}
			String s=step.get(step.size()-1);
			//split返回值为String类型的数组
			String str[]=s.split(":");
			//将字符串转换成整数Integer.parseInt
			int i=Integer.parseInt(str[0]);
			int j=Integer.parseInt(str[1]);
			//悔棋第一步把二维数组的值变为0
			panel.chess[i][j]=0;
			
			if(step.size()==1){
				panel.boradX=-1;
				panel.boradY=-1;
				panel.repaint();
				//删除集合中的最后一位
				step.remove(step.size()-1);
				return;
			}
			//挪动红点到倒数第二位
			String hd=step.get(step.size()-2);
			String []strs=hd.split(":");
			panel.boradX=Integer.parseInt(strs[0]);
			panel.boradY=Integer.parseInt(strs[1]);
			//删除集合中的最后一位
			step.remove(step.size()-1);
			panel.repaint();
		}
	}
}







