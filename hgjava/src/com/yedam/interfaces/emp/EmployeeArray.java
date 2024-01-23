package com.yedam.interfaces.emp;

import java.util.Scanner;

import com.yedam.classes.singleton.Employee;

//배열: Employee[]
public class EmployeeArray implements EmployeeList{
	//싱글턴.
	private static EmployeeArray instance = new EmployeeArray();
	int empNum; // 현재사원수
	Employee[] list;
    private EmployeeArray() {
    }
	public static EmployeeArray getInstance() {
		return instance;
	}
	Scanner scn = new Scanner(System.in);
    
	@Override
	public void init() {
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
		
		list[empNum++] = new Employee(no, name, sal);
	}

	@Override
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
		
		list[empNum++] = new Employee(no, name, sal);
	}

	@Override
	public String search(int empId) {
		
		for(int i=0; i<list.length; i++) {
			   if(empId==list[i].getEmployeeId() && list[i]!=null) {
				   
				   return list[i].getName();
				 }
		   }	
		   return "";
	}

	@Override
	public void print() {
		//사원번호, 이름, 급여
		for(int i=0; i<list.length; i++) {
			if(list[i]!=null) {
			System.out.printf("%4d %10s %7d\n",list[i].getEmployeeId(),list[i].getName(),list[i]. getSalary());
			}
		}
	}

	@Override
	public int sum() {
		int total = 0;
		for(int i=0; i<list.length; i++) {
			 total += list[i].getSalary();
		}
		return total;

}
}