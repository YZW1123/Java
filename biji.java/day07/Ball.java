package day07;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	//属性--->变量看上去的样子
	int d;	//球的直径
	Color ballColor;//球的颜色
	int direction;	//球的方向
	int speed;		//球的速度
	int x;		//球的X坐标
	int y;		//球的Y坐标
	public Ball(int d,Color ballColor,int direction,int speed,int x,int y){
		this.d=d;
		this.ballColor=ballColor;
		this.direction=direction;
		this.speed=speed;
		this.x=x;
		this.y=y;
	}
	//行为
	public void move(){//球会移动
		if(direction==0){//左上
			x-=speed;
			y-=speed;
			if(x<=0){	//小球撞到了左边
				direction=1;
			}
			if(y<=0){	//小球撞到上边
				direction=3;
			}
		}
		if(direction==1){	//右上
			x+=speed;
			y-=speed;
			if(x>=800-d){	//右边
				direction=0;
			}
			if(y<=0){			//上边
				direction=2;
			}
		}
		if(direction==2){	//右下
			x+=speed;
			y+=speed;
			if(x>=800-d){
				direction=3;
			}
			if(y>=600-d){
				direction=1;
			}
		}
		if(direction==3){	//左下
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
	//自定义方法?先创建出方法所在类的对象,然后用对象名点出来
	public void drawBall(Graphics g){	//球是画出来的
		g.setColor(ballColor);//通过参数传递实现画球
		g.fillOval(x, y, d, d);
	}
}











