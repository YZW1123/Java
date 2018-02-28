package chess;

public class Test3 {

	public static void main(String[] args) {
		// 8848.13  8848130 mm 
		double h=0.08; // 定义一张纸的高低
		/**
		 * for(循环的初始条件;循环跳出条件;
		 * 改变循环的条件){
		 *    // 执行循环的语句
		 * }
		 */
	/*	for(int i=1;;i++){
			h*=2; // 等价于 h=h*2;对折
			if(h>=8848130){
				System.out.println(i);  // 27
				System.out.println(h); // 1.073741824E7
				break;
			}
		}*/
		
		//计算 1+1/2!+1/3!+...+1/20! =?
		
		 // 定义一个数存储和
		double sum =0;
		// 定义一个数分母
		double aa=1;
		for(int i=1;i<=20;i++){
			aa*=i; // 结算出分母的阶层
			sum+=1/aa;//1+1/2!+1/3!+...+1/20! =?
		}
		System.out.println(sum);
	}
}
