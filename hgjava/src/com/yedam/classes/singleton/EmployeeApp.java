package com.yedam.classes.singleton;

import java.util.Scanner;

public class EmployeeApp {

	public static void main(String[] args) {
		EmployeeList app = EmployeeList.getInstance();
		
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int menu = 0;
		
		while(run) {
			 System.out.println("1.사원수 2.사원입력 3.사원리스트 4.검색 5.급여합계 9.종료");
			 System.out.println("선택>");
			 menu = scn.nextInt();
			 
			 if(menu==1) {          //사원수
				 app.init();
			 } else if(menu == 2) {  //사원입력
				 app.input();
			 }else if (menu == 3) {
				 app.print();
			 }else if (menu == 4) {
				 System.out.println("조회할 사번>>>");
				 int no = scn.nextInt();
				 if(app.search(no).equals("")) {					  
					 System.out.println("해당사번은 없습니다.");
				 }else{
					 System.out.println("해당 사번의 이름은"+app.search(no));
				 }
			 }else if (menu == 5) {
				 System.out.printf("급여의 합계는 %d 입니다\n.",app.sum());
			 }else if (menu == 9) {
				 run = false;
			 }else {
				 System.out.println("잘못된 번호입니다.");
			 }
			 
			 
		}
		System.out.println("end of prog");
	}

}
