package day04;

public interface 菜单 {
	//抽象方法
	int EXIT_ON_CLOSE=10;//常量－－－－＞变量的一种
	public void 宫保鸡丁();
	public void 辣子鸡();
	public void 烧耳塊();
	public void 酸菜鱼();
}
			//做菜
class 四川厨子1 implements 菜单{
	@Override
	public void 宫保鸡丁() {
		System.out.println("多放辣");
	}

	@Override
	public void 辣子鸡() {
		System.out.println("多放辣");
	}

	@Override
	public void 烧耳塊() {
		System.out.println("多放辣");
	}

	@Override
	public void 酸菜鱼() {
		System.out.println("多放辣");
	}
}
class 广东厨子2 implements 菜单{
	@Override
	public void 宫保鸡丁() {
		System.out.println("多放糖");
	}

	@Override
	public void 辣子鸡() {
		System.out.println("多放糖");
	}

	@Override
	public void 烧耳塊() {
		System.out.println("多放糖");
	}

	@Override
	public void 酸菜鱼() {
		System.out.println("多放糖");
	}
	
}

