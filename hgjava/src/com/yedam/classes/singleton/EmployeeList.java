package com.yedam.classes.singleton;

import java.util.Scanner;

public class EmployeeList {
     //싱글톤
	private static EmployeeList instance = //필드
			new EmployeeList();
	
	Employee[] list; //사원배열
	int empNum; // 현재사원수
	Scanner scn = new Scanner(System.in);
	
	
	private EmployeeList() {}   //생성자
		
		public static EmployeeList getInstance() { //메서드
			return instance;
		}
		//사원수 입력 초기화.
		public void init() {
			System.out.println("사원수>>");
			int num = scn.nextInt();
			list = new Employee[num];
			
		}
		
		//사원정보 입력 => 배열추가.
		public void input() {
			if(empNum == list.length) {
				System.out.println("입력초과");
				return;
				
			}
			System.out.printf("%d 사번",empNum);
			int no = scn.nextInt();
			
			System.out.print("이름>");
			String name = scn.next();
			
			System.out.print("급여>");
			int sal = scn.nextInt();
			
			list[empNum++] = new Employee(no, name, sal); //★더하기 배열을 왼쪽에 넣으면 더하고 대입
		}												  //오른쪽에 넣으면 대입하고 더하기★
		//사번에 해당하는 이름 출력.
		public String search(int empId) {
			//해당사번이 있으면 이름 반환. 없으면 "".
		   for(int i=0; i<list.length; i++) {
			   if(empId==list[i].getEmployeeId() && list[i]!=null) {
				   
				   return list[i].getName();
				 }
		   }	
		   return "";
			
		}
	//전체 출력.
		public void print() {
			//사원번호, 이름, 급여
			for(int i=0; i<list.length; i++) {
				if(list[i]!=null) {
				System.out.printf("%4d %10s %7d\n",list[i].getEmployeeId(),list[i].getName(),list[i]. getSalary());
				}
			}
		}
	//총 급여의 합계
		public int sum() {
			int total = 0;
			for(int i=0; i<list.length; i++) {
				 total += list[i].getSalary();
			}
			return total;
		}
		
    //	
}
