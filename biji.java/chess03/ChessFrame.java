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
//��ά����
//���̵Ĵ�����
public class ChessFrame extends JFrame implements ActionListener{
	//���ֵ�����		����ͼƬ
	JLabel mainLabel=new JLabel(new ImageIcon("case06/back.png"));
	//	3.��ҵ�ͼƬ
	JLabel player=new JLabel(new ImageIcon("case06/blackmsg.png"));
	JLabel comp=new JLabel(new ImageIcon("case06/whitemsg.png"));
	// ���������еİ�ť
	JButton huiqi,close,min,start;
	//�����˵�  ��Ҫ������
	JMenuBar bar;//���߽�����ĳ������������Ҫ�Ų˵���
	JMenu game;	//����������������Ĳ˵�
	JMenuItem saveGame,loadGame;	//�����������˵����Ӳ˵�
	//������������Ķ���
	ChessJPanel panel=new ChessJPanel();
	//�����������ӵ��Ⱥ�˳��
	boolean isBlack=false;
	//����������Ϸ����Ӯ
	boolean isWin=false;
	public ChessFrame(){
		//�������ŵ�����ͼƬ��
		panel.setBounds(170,100, 592, 592);
		panel.setOpaque(false);//ȥ�������İ׵�
		mainLabel.add(panel);
		//���ò˵�������
		bar=new JMenuBar();
		bar.setBounds(10,10, 100, 36);
		mainLabel.add(bar);
		//�������ڷ������˵�
		game=new JMenu();
		game.setIcon(new ImageIcon("case06/bar.png"));
		game.add(saveGame=new JMenuItem("������Ϸ...."));
		game.add(loadGame=new JMenuItem("������Ϸ...."));
		bar.add(game);
		//����
		huiqi=new JButton(new ImageIcon("case06/huiqi.png"));
		huiqi.setContentAreaFilled(false);//ȥ���׵�
		huiqi.setBorderPainted(false);//ȥ���߿���
		huiqi.setBounds(30,420,100, 42);
		mainLabel.add(huiqi);
		//�ر�
		close=new JButton(new ImageIcon("case06/close.png"));
		close.setContentAreaFilled(false);//ȥ���׵�
		close.setBorderPainted(false);//ȥ���߿���
		close.setBounds(850,20,14, 14);
		mainLabel.add(close);
		//��С��
		min=new JButton(new ImageIcon("case06/min.png"));
		min.setContentAreaFilled(false);//ȥ���׵�
		min.setBorderPainted(false);//ȥ���߿���
		min.setBounds(830,20,14, 14);
		mainLabel.add(min);
		//����
		start=new JButton(new ImageIcon("case06/start.png"));
		start.setContentAreaFilled(false);//ȥ���׵�
		start.setBorderPainted(false);//ȥ���߿���
		start.setBounds(420,15,34, 34);
		mainLabel.add(start);
		
		//  3.�������ͼƬ
		player.setBounds(30,90,110, 110);
		mainLabel.add(player);
		comp.setBounds(770,500,110,110);
		mainLabel.add(comp);
		//	2.������ͼƬ�ŵ�������
		this.add(mainLabel);
		this.setUndecorated(true);//���ش��ڵı߿�
		this.setBounds(50,30, 900, 700);
		//	1.���ó�������ʱ��Сͼ��	
		//setIconImage(new new ImageIcon("case06/icon.jpg").getImage());
		this.setIconImage(new ImageIcon("case06/icon.jpg").getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//���������������¼�ͬʱ��Ӽ���
		//MouseAdapter��������Լ�����ʵ����
		//MouseListener��MouseMotionListerner
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(isWin){
					return;
				}
				//�������X,y����
				int x=e.getX();
				int y=e.getY();
				//�����ĵ���д���  ������ת����������±�
				int i=Math.round((float)(y-ChessJPanel.LEFT_SPACE)/ChessJPanel.COL_SPACE);
				int j=Math.round((float)(x-ChessJPanel.UP_SPACE)/ChessJPanel.ROW_SPACE);
				panel.boradX=i;
				panel.boradY=j;
				//�ж��Ƿ������� 	
				if(panel.chess[i][j]!=0){
					JOptionPane.showMessageDialog(ChessFrame.this,
							"�˴�������,��ֹ����");
					return;//1.����ֵ	2.��������Ĵ���ִ��
				}
				//��Ŀ���㷨
				panel.chess[i][j]=isBlack?1:2;
				//���ҵ������һ��֮��,�ͼ�¼����
				String step=i+":"+j+":"+(isBlack?1:2);
				System.out.println(step);
				//�����ϵ���ȥ���
				panel.stepchess.add(step);
				panel.repaint();
				//�ж���Ӯ
				if(panel.isWin(i, j)){
					JOptionPane.showMessageDialog(ChessFrame.this,
							(isBlack?"�ڷ�ʤ��":"�׷�ʤ��"));
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
	//�ӿ�����:ActionListener
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
			//1.����һ�������ļ��ĶԻ���
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
			//split����ֵΪString���͵�����
			String str[]=s.split(":");
			//���ַ���ת��������Integer.parseInt
			int i=Integer.parseInt(str[0]);
			int j=Integer.parseInt(str[1]);
			//�����һ���Ѷ�ά�����ֵ��Ϊ0
			panel.chess[i][j]=0;
			
			if(step.size()==1){
				panel.boradX=-1;
				panel.boradY=-1;
				panel.repaint();
				//ɾ�������е����һλ
				step.remove(step.size()-1);
				return;
			}
			//Ų����㵽�����ڶ�λ
			String hd=step.get(step.size()-2);
			String []strs=hd.split(":");
			panel.boradX=Integer.parseInt(strs[0]);
			panel.boradY=Integer.parseInt(strs[1]);
			//ɾ�������е����һλ
			step.remove(step.size()-1);
			panel.repaint();
		}
	}
}







