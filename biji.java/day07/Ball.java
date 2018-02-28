package day07;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	//����--->��������ȥ������
	int d;	//���ֱ��
	Color ballColor;//�����ɫ
	int direction;	//��ķ���
	int speed;		//����ٶ�
	int x;		//���X����
	int y;		//���Y����
	public Ball(int d,Color ballColor,int direction,int speed,int x,int y){
		this.d=d;
		this.ballColor=ballColor;
		this.direction=direction;
		this.speed=speed;
		this.x=x;
		this.y=y;
	}
	//��Ϊ
	public void move(){//����ƶ�
		if(direction==0){//����
			x-=speed;
			y-=speed;
			if(x<=0){	//С��ײ�������
				direction=1;
			}
			if(y<=0){	//С��ײ���ϱ�
				direction=3;
			}
		}
		if(direction==1){	//����
			x+=speed;
			y-=speed;
			if(x>=800-d){	//�ұ�
				direction=0;
			}
			if(y<=0){			//�ϱ�
				direction=2;
			}
		}
		if(direction==2){	//����
			x+=speed;
			y+=speed;
			if(x>=800-d){
				direction=3;
			}
			if(y>=600-d){
				direction=1;
			}
		}
		if(direction==3){	//����
			x-=speed;
			y+=speed;
			if(x<=0){
				direction=2;
			}
			if(y>=600-d){
				direction=0;
			}
		}
	}
	//�Զ��巽��?�ȴ���������������Ķ���,Ȼ���ö����������
	public void drawBall(Graphics g){	//���ǻ�������
		g.setColor(ballColor);//ͨ����������ʵ�ֻ���
		g.fillOval(x, y, d, d);
	}
}











