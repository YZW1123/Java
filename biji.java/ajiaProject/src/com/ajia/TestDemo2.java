package com.ajia;

public class TestDemo2 {

	public static void main(String[] args) {
         char a1 = '张';
         int  a2 = a1;
         
         char a3 = 'A';
         int a4 = a3 ;
         char a5 = 'a' ;
         int a6 = a5;
         char b1 ='b';
         
         // 先获取字符编码值
         int b2=b1;
         // 同过编码值运算
         b2=b2-32;
         // 在把编码值转换为字符
         char  b3=(char)b2;
         
         System.out.println(a1);
         System.out.println(a2);
         System.out.println(a3);
         System.out.println(a4);
         System.out.println(a6);
         System.out.println(b3);
         
         
	}

}
