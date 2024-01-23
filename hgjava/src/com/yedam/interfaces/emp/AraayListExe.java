package com.yedam.interfaces.emp;

import java.util.ArrayList;

public class AraayListExe {
 public static void main(String[] args) {
	 //배열
	 Employee[] employeeAry = new Employee[10];
	 employeeAry[0] = new Employee(101,"김민수");
	 employeeAry[1] = new Employee(102,"김하늘");
	 Employee emp = new Employee(103,"우후루루");
	 employeeAry[2] = emp;
	 employeeAry[2] = null;
	 for(int i=0; i<employeeAry.length; i++) {
		 if(employeeAry[i]!=null) {
			 System.out.println(employeeAry[i].getName());
		 }
	 }
	 System.out.println("-----------------------------");
	 //컬렉션
	 ArrayList<Employee> employeeAryList = new ArrayList<Employee>();      //ArrayList<> 는 employeeArraylist를 Employ
	 employeeAryList.add(new Employee(104,"최홍길"));
	 employeeAryList.add(new Employee(105,"이만기"));
	 employeeAryList.add(emp);
	 employeeAryList.remove(2); //  103번 삭제
	 for(int i = 0; i<employeeAryList.size();i++) {
		 System.out.println(employeeAryList.get(i).getName());
	 }
 }
}
