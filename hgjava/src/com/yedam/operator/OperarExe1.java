package com.yedam.operator;

import java.util.Scanner;

public class OperarExe1 {
	public static void main(String[] args) {
		int result = 0;
		Scanner scn = new Scanner(System.in);
		
		//사용자 값을 입력 : 정수입력.
		while(true) {
			
			System.out.println("정수를 입력하세요");
			String inp = scn.nextLine();
			if(inp.equals("quit")) {
					break;
			}
			try {
			  result += Integer.parseInt(inp);
			}catch (Exception e) {
				System.out.println("잘못된 값을 입력.");  //정수가 아닌 문자열로 들어와서 예외가 나오니
			}                                          //예외를 설정해서 한다.
		}
		
			System.out.printf("누적값은 %d입니다.\n", result);
			System.out.println("end of prog");
		}
		
		
		
		
	

	
	
	
	public static void method1() {
		int sum = (1 + 2) * 3;
		sum = sum + 5;
		sum += 5;
		
		String str = "";
		Scanner scn = new Scanner(System.in);
		while (true) {
			
				System.out.println("문자열을 입력하세요");
				String input = scn.nextLine();
				if(input.equals("quit")) {
					break;
					
				}
		  str += input + " ";	
		}
		System.out.printf("누적내용: %s\n", str);
	}
}
