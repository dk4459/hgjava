package com.yedam.variable;

public class VariableExe1 {
	public void sum() {
		int n2; // 전에 long타입에 선언하였더라고 다른 메서드에서 int바꿔도 변수값이 전혀 다르기때문에 상관없음
	}
	public static void main(String[] args) {
		//let n = '10';
		//const obj = {name:"홍길동", age:20, showInfo(){  }}
		int n1 = 100000; //int (기본데이터타입) wrapper 클래스 : Integer.
		n1 = -2147483648;// Integer 저장할 수 있는 최소값
		System.out.println(Integer.MAX_VALUE); //Integer 저장할 수 있는 최댓값
		
		long n2 = 2147483648L;
		n2 = -2147483648L; //long 이라는것을 알려야하기 때문에 L을 꼭넣어야함
		
		double n3 =Math.random(); // 0~1임의 실수
		
		int n4 = (int)(Math.random()*10); // 0~10 임의실수
		
		String str = "홍길동";
		
//		int n2; 전에 선언에 long이라고 선언 하였기 때문에 두번 선언이 불가
		byte b1 = 127; //바이트의 범위는 -128~127까지
		
		short s3 = (short)(b1-30);  //30은 int로 나눠지기 때문에 형변환후 사용가능
		//왼쪽항 = 오른쪽항 : 항상타입이 동일
		double d1 = 40;   //왼쪽이 더 큰 타입이니 오른쪽은 자동형변환하여 계산해준다
		
		
		
	}
}
