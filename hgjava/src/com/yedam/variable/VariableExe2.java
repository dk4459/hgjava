package com.yedam.variable;

import java.util.Scanner;

public class VariableExe2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("이름을 입력하세요 ");
		String name = scn.nextLine(); // 입력값을 문자열로 반환
		System.out.println("전화번호를 입력하세요 ");
		String phone = scn.nextLine();
		//영어 수학 합계 : scn.nextInt()
		System.out.println("영어성적을 입력하세요 ");
		int eng = scn.nextInt(); // 입력값을 정수로 반환
		System.out.println("수학성적을 입력하세요 ");
		int mat = scn.nextInt();
		int sum = eng+mat;
		//이름 홍길동 연락처 010-1111-2222
		//영어 80, 수학85 합계 165
		System.out.println("이름:"+name+", 연락처:" +phone);
		System.out.println("영어:"+eng+", 수학:"+mat+" 합계:"+(int)(eng+mat));//변수 sum을 만들어 놨으니 그걸로 써도 된다
		
		
	}

}
