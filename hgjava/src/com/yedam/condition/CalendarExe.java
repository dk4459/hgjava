package com.yedam.condition;

import java.util.Scanner;

public class CalendarExe {

	public static void main(String[] args) {
		System.out.println("월 수를 말해보세요");
		Scanner scn = new Scanner(System.in) ;
		int month = scn.nextInt();
		  //month = 1; 한번 스캐너 사용해서 해봄 //4월달가지 
		//변수 : 월의 마지막 날짜.
		int lastDate =31;
				
		//변수: 월의 1이 위치
		int pos = 1;
		
		switch(month){
		case 1: pos = 1; break;
		case 2: pos = 4; break;
		case 3: pos = 5; break;
		case 4: pos = 1; break;
		}
		//수정... 월의 변경될때마다 마지막날 계산.
        switch(month) {
        case 1:lastDate = 31;break;
        case 2:lastDate = 29;break;
        case 3:lastDate = 31;break;
        case 4:lastDate = 30;break;
        }
		
		System.out.println("\t    "+month+"월");
				String[] days = {"sun","mon","tue","wed","Thr","Fri","Str"};
				for(int i=0; i < 7; i++) {
				System.out.printf("%3s",days[i],"\n");}
				System.out.println("");
				for(int i=0; i < pos; i++) {
					System.out.printf("%3s"," "); 
				}
				
				for(int d =1; d<= lastDate; d++) {
					System.out.printf("%3d", d);
					if(d%7 == 7-pos) {
						System.out.printf("\n");
					}
				}
	}

}
