package com.yedam.condition;

public class ArrayExe {

	public static void main(String[] args) {
		int[] intAry = {10, 20, 30};     //int intAry
		intAry[2]= 40;
		
		intAry = new int[]{10, 20,30,40,50}; //있는것을 아예 바꾸고싶을때 new int[]를 써야함
		intAry = new int[10];               //방 주소가 10개를 넣는다
		
		System.out.println(intAry[0]+" 크기:"+intAry.length);
		intAry[0] = 100;
		System.out.println(intAry[0]);  //초기는 0이었다가 100으로 바꿨다.
		
		String[] strAry  = {"Hong","Park", "kim","20"}; // 20을 문자열로 넣는것은 가능 하지만 정수로는 불가능
		for(int i=0; i<10; i++) {
			intAry[i] = (int)(Math.random()*10)+1;
		}
		//2,3의 배수의 값을 각각 int sum2, sum3에저장
		int sum2, sum3;
		sum2 = sum3 = 0;
		
		
		for (int i=0; i<9; i++) {
			System.out.println(intAry[i]);
			if(intAry[i]%2==0 && intAry[i]%3==0) {
				sum2 += intAry[i];
				sum3 += intAry[i];
			}else if(intAry[i]%2==0) {
				sum2 += intAry[i];
			}else if(intAry[i]%3==0) {
				sum3 += intAry[i];
			}//코드작성...
		}
		//각각출력 ...6
		System.out.printf("2의 배수합: %d, 3의배수합: %d\n",sum2,sum3);
		System.out.printf("");
		
		//문자열배열ㄴ
		String[] strAry1= {"hong","park","kim","20"};
		for (int i=0; i<=4; i++) {
			System.out.println(strAry1[0]);
		}
	}

}
