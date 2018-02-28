package chess;

public class ArrDemo {
	//二维数组实际上就是一个表格的形式
	//二维数组:数组的数组
	public static void main(String[] args) {
		int []arr=new int[10];//默认是为0
		int arr2[][]=new int[18][18];//默认值为0
		//18*18=
		//二维数组里的所存的数字是由两个一维数组交接的地方
//		for (int i = 0; i < arr2.length; i++) {
//			//i=0;j=0~17
//			//i=1;j=0~17
//			//i=2;j=0~17
//			for (int j = 0; j < arr2.length; j++) {
//				
//			}
//		}
		arr2[0][2]=1;//当值为1 的时候下黑棋
		arr2[5][6]=2;//值为2的时候下白旗
		arr2[3][7]=1;//
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if(arr2[i][j]==1){
					System.out.print("黑棋,");
				}else if(arr2[i][j]==2){
					System.out.print("白棋,");
				}else if(arr2[i][j]==0){
					System.out.print("没下,");
				}
			}
			System.out.println();
		}
		
		
		
		
		
		
		
	}
}
