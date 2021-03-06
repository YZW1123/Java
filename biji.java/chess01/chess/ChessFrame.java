package chess;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
		min.addActionListener(this);
		close.addActionListener(this);
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
	}
}







