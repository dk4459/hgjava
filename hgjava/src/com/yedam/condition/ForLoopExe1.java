package com.yedam.condition;

public class ForLoopExe1 {

	public static void main(String[] args) {
		
		for(int j=1; j<=10; j+=2) {
			System.out.println(j);
			if(j > 5) {
				break;            // 5보다크면 끝냄
			}		
		}
		
		//1~10까지 합을 계산.
		int sum = 0;
		for(int i=1; i<=100; i++) {
			if(i % 3==0) 
			sum+=i;
		}
		System.out.printf("누적값은 %d \n", sum);
		
		//1~31까지 반복
		
		System.out.printf("Sun\tMon\tTue\tWed\tThr\tFri\tSa\n");
		System.out.printf("\t\t");
		for(int d =1; d<= 31; d++) {
			System.out.printf("%d\t", d);
			if(d%7 == 5) {
				System.out.printf("\n");
			}
		}
//		System.out.println(i);    반복문 안에서만 i 사용가능!
	}

}
