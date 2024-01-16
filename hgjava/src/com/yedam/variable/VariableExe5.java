package com.yedam.variable;



public class VariableExe5 {

	public static void main(String[] args) {
		
		double d1 = 10.0;
		double result =d1 + 20; //20은 자동형변환 20.0이 된다
		System.out.println(result);
		
		int sum = 60;
//		result = sum / 7;      int끼리 나누면 double로 변환하더라도 8.0이 나오기때문에
							//대입하기전에 형변환을 해야한다
		
		result = sum / 7.0; // 실수로 나눠야만 실수값이 나온다 
		System.out.println(result);
		
		sum = Integer.parseInt("1")+3+5 ; // 문자열을 정수로 바꾸어 처리한다
										//Integer.parseInt

		result = Double.parseDouble("1.234")+2.3;  //문자열을 실수로 바꾼다
												   //Double.parseDouble
		
		
		//char 65536개에
		for(int i=0; i<10; i++) {
		int temp =(int)(Math.random() * 24)+97;
		System.out.println((char)+temp);
		
	}
}
}