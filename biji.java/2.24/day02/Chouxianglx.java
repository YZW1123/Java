package day02;

public class Chouxianglx {

	public static void main(String[] args) {
		Computer com=new LiMing();
		LiMing lm=(LiMing)com;
		lm.chat();
		lm.play();
		lm.look();
		lm.si();
		lm.work();
		Computer com1=new WangEr();
		WangEr we=(WangEr)com1;
        we.aihao();
        we.chat();
        we.look();
        we.play();
        we.work();
	}

}

abstract class Computer {
	public abstract void play();

	public abstract void look();

	public abstract void work();

	public abstract void chat();
}

class LiMing extends Computer {
	@Override
	public void play() {
		System.out.println("李明在玩游戏");
	}
	@Override
	public void look() {
		System.out.println("李明在看电影");
	}
	@Override
	public void work() {
		System.out.println("李明在敲代码");
	}
	@Override
	public void chat() {
		System.out.println("李明在和朋友聊天");
	}
	public void si() {
		System.out.println("李明喜欢看直播");
	}
}
class WangEr extends Computer {
	@Override
	public void play() {
		System.out.println("王二正在玩游戏");
	}
	@Override
	public void look() {
		System.out.println("王二在看电视剧");
	}
	@Override
	public void work() {
		System.out.println("王二在直播");
	}
	@Override
	public void chat() {
		System.out.println("王二在和粉丝聊天");
	}
	public void aihao() {
		System.out.println("王二喜欢撩妹");
	}
}