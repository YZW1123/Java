package day03;

import javax.swing.JFrame;

public class QIU1 extends JFrame {
	public QIU1() {
		this.setTitle("球球大作战");// 设置窗口标题
		this.setVisible(true);// 让窗口显示
		this.setResizable(false);// 设置窗口不被拖动
		this.setBounds(40, 40, 660, 880);// 设置窗口大小和位置
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗口程序点击X关闭
	}

	public static void main(String[] args) {
		new QIU1();
	}

}
