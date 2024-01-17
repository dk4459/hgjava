package com.yedam.condition;

import java.util.Scanner;

public class WhileLoopExe2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		//어떤 조건일 동안만 반복
		int random = (int) (Math.random()*100)+1; //1 ~ 10 정수.
		while(true) {
			System.out.println("값입력>> ");
			int val = scn.nextInt();
			if(random == val) {
				System.out.printf("임의값 %d\n",random);
				break;
			}
			if(random > val) {
				System.out.println("입력한 값보다 큽니다");
				continue;                                 //입력값이 맞으면 continue문을 만나 다시 처음으로 돌아간다.
			}
				System.out.println("입력한값보다 작습니다.");
				
			}
			
			System.out.println("틀린값");
			System.out.println("end of prog.");
		}
	}


