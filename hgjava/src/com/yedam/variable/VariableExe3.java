package com.yedam.variable;

import java.util.Scanner;

public class VariableExe3 {

	public static void main(String[] args) {
     //true false
		boolean isTrue = true; //10 > 20;
		
		isTrue = update(10);
		
		if(isTrue) {
			System.out.println("참값");
		}else {
			System.out.println("거짓값");
		}
		
		Member m1 = new Member();
		m1.name = "홍길동";
		m1.age = 20;
		m1.height = 167.8;      //다른클래스 변수를 객체로 만들어 설정하였음
		System.out.println("name:"+m1.name+"나이:"+m1.age);
		
		Member m2 = new Member();
		m2.name = "김민수";
		m2.age = 23;
		m2.height = 172.5;
		
		isTrue = m1.height > m2.height;
		isTrue = m1.age == m2.age;
		isTrue = m1 == m2;  //이름 나이 몸무게 같더라도 false로 답한다
							//왜냐하면 서로 다른객체 다른주소값이기 때문이다.
		System.out.println(isTrue);
		
		byte a = 10;
		int b = a;  //자동으로 (int)으로 형변환하여 int b에 넣음
		            //왜냐하면 왼쪽이 더큰값이고 오른쪽이 더작은값이라 가능하다.
		float d = 10L;
		float c = d;
		System.out.println(c); //long(8byte) float (4byte)
							  //비록 long이 바이트가 더크지만 float로 자동형변환 되는 이유는
							// float가 표현할수 있는 수가 더많기 때문이다.
		
		
	} 
	
	public static boolean update(int arg) {
		return arg % 2 == 0; // 짝수면 true 홀수면 false
	}
}

