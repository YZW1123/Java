package chess;

public class Test3 {

	public static void main(String[] args) {
		// 8848.13  8848130 mm 
		double h=0.08; // ����һ��ֽ�ĸߵ�
		/**
		 * for(ѭ���ĳ�ʼ����;ѭ����������;
		 * �ı�ѭ��������){
		 *    // ִ��ѭ�������
		 * }
		 */
	/*	for(int i=1;;i++){
			h*=2; // �ȼ��� h=h*2;����
			if(h>=8848130){
				System.out.println(i);  // 27
				System.out.println(h); // 1.073741824E7
				break;
			}
		}*/
		
		//���� 1+1/2!+1/3!+...+1/20! =?
		
		 // ����һ�����洢��
		double sum =0;
		// ����һ������ĸ
		double aa=1;
		for(int i=1;i<=20;i++){
			aa*=i; // �������ĸ�Ľײ�
			sum+=1/aa;//1+1/2!+1/3!+...+1/20! =?
		}
		System.out.println(sum);
	}
}
