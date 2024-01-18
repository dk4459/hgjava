package com.yedam.condition;

public class LoopExe4 {

	public static void main(String[] args) {
		for(int i=4; i>0; i--) {
		for(int j=1; j<=i; j++) {
		 System.out.printf("*");
		 }System.out.println();
	   }
	}


public static void method2() {
	for(int i=1; i<=9; i++) {
		
		//시작
 		   //2~9단정보
		for(int j=2; j<=9; j++) {
			
		System.out.printf("%d*%d=%d\t",j,i,(j*i)); 
			
		}System.out.println(); //줄바꿈
		//끝
		}
}
}