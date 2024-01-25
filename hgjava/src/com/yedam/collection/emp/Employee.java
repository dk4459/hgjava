package com.yedam.collection.emp;

import java.util.Date;

//empNo, empName, hireDate, salary.
public class Employee {
     private int empNo;
     private String empName;
     private Date hireDate;
     private int salay;
     
	public Employee(int empNo, String empName, Date hireDate, int salay) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.hireDate = hireDate;
		this.salay = salay;
	}

	Date getHireDate() {
		return hireDate;
	}
	
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", hireDate=" + hireDate + ", salay=" + salay
				+ "]";
	}
     
   
	
   
}
