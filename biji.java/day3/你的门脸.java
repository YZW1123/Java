package day03;
					//加盟
public class 你的门脸  implements KFC{

	@Override
	public void 汉堡() {
	}

	@Override
	public void chicken() {
	}
	@Override
	public void 薯条() {
	}
	
}
interface KFC{
	public void 汉堡();
	public void chicken();
	public void 薯条();
}