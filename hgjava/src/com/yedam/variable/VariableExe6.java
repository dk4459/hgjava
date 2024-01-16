package com.yedam.variable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;


public class VariableExe6 {
	public static void main(String[] args) 
				throws FileNotFoundException{
		//표준입출력: 키보드(System.in), 모니터(System.out).
		InputStream is = new FileInputStream("test.txt");
		Scanner scn = new Scanner(is);
		
		String name = scn.nextLine();
		
		int age = Integer.parseInt(scn.nextLine());
		double height = Double.parseDouble(scn.nextLine());
		
		String str= "이름은 %s, 나이는 %d세 키는%.1f 입니다 \n";
		System.out.printf(str, name, age, height );
		System.out.println(": "+name);
		// 나이(int:age), 키(double:height)
		
		
		//이름은 홍길동, 나이는 20세, 키는 178.9입니다.
		System.out.printf("이름은 %s, 나이는 %7.1f","홍길동", 2000.0);// (%7.1f)  첫번째 7은 소수점까지 포함한
																// 총 7자리 숫자를 표현하라는 것이다 만약 표현할
																		//값이 6자리고 %1.1을 하더라도 6자리까지 다 표현한다.
	}
}
