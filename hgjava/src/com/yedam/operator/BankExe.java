package com.yedam.operator;

import java.util.Scanner;

//은행계좌. 최대금액 10만원
public class BankExe {
	public static void main(String[] args) {
		// 입금, 출금, 잔고, 종료
		Scanner scn = new Scanner(System.in);
		int balance = 0;
		boolean run = true;
		
		while(run) {
			System.out.println("1.입금 2.출금 3.잔고 4,종료");
			int menu = Integer.parseInt(scn.nextLine());
			switch(menu) {
			case 1: System.out.println("입금액 >>");
					int var = Integer.parseInt(scn.nextLine());						
					if(balance+var > 200000) {
				    System.out.println("입금액이 100,000원이 넘습니다..");
				    break;
					}
					balance += var;
					
				    System.out.println("입금성공!");
				    break;
			case 2:System.out.println("출금액 >>");
					int min = Integer.parseInt(scn.nextLine());
					if(balance-min < 0) {
					    System.out.println("출금 금액이 입금금액보다 넘었습니다..");
					    break;
						}
					balance -= min;
					System.out.println("출금성공!");
					break;
			case 3:System.out.println("잔고확인");
			       System.out.println(balance);
			       break;
			case 4:
					run=false;
					break;
			}
			
		}
		System.out.println("end of prog.");
	}

}
