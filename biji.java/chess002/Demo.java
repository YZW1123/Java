package chess;

public class Demo {
	public static void main(String[] args) {
		int [][]arr=new int[10][10];
arr[8][1]=1;arr[7][1]=1;arr[6][1]=1;
		int count=0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(arr[i][j]==0){
					System.out.print("*  ");
				}else if(arr[i][j]==1){
					System.out.print("-  ");
				}
			}
			System.out.println();
		}
		
		System.out.println("某列有棋子是5个连在一起的");
				int i=6;	//预判的棋子的位置
				int j=1;	
				int i1=i-1;
				//找最高点
				while(true){
				if(i1<0||arr[i][j]!=arr[i1][j]){
					break;//跳出当前循环颜色不一样	,要出界了
				}
					i1--;
				}
				//反方向去计数
				i1++;
				count =0;//计数
				while(true){
					if(i1>=10||arr[i1][j]!=arr[i][j]){
						break;
					}
					i1++;
					count++;
				}
				System.out.println(count);
		
	}
}
