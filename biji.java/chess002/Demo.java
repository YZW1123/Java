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
		
		System.out.println("ĳ����������5������һ���");
				int i=6;	//Ԥ�е����ӵ�λ��
				int j=1;	
				int i1=i-1;
				//����ߵ�
				while(true){
				if(i1<0||arr[i][j]!=arr[i1][j]){
					break;//������ǰѭ����ɫ��һ��	,Ҫ������
				}
					i1--;
				}
				//������ȥ����
				i1++;
				count =0;//����
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
