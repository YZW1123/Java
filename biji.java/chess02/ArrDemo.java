package chess;

public class ArrDemo {
	//��ά����ʵ���Ͼ���һ��������ʽ
	//��ά����:���������
	public static void main(String[] args) {
		int []arr=new int[10];//Ĭ����Ϊ0
		int arr2[][]=new int[18][18];//Ĭ��ֵΪ0
		//18*18=
		//��ά������������������������һά���齻�ӵĵط�
//		for (int i = 0; i < arr2.length; i++) {
//			//i=0;j=0~17
//			//i=1;j=0~17
//			//i=2;j=0~17
//			for (int j = 0; j < arr2.length; j++) {
//				
//			}
//		}
		arr2[0][2]=1;//��ֵΪ1 ��ʱ���º���
		arr2[5][6]=2;//ֵΪ2��ʱ���°���
		arr2[3][7]=1;//
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if(arr2[i][j]==1){
					System.out.print("����,");
				}else if(arr2[i][j]==2){
					System.out.print("����,");
				}else if(arr2[i][j]==0){
					System.out.print("û��,");
				}
			}
			System.out.println();
		}
		
		
		
		
		
		
		
	}
}
