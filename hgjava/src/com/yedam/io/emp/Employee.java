package com.yedam.io.emp;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable{ // 직렬화 할 수 있는
	private int empNo;
	private String empName;
	private Date hireDate;
	private int salary;

	public Employee(int empNo, String empName, Date hireDate, int salary) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.hireDate = hireDate;
		this.salary = salary;
	}
	public void name(String empName) {
		this.empName = empName;
		}

	
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", hireDate=" + hireDate + ", salary=" + salary
				+ "]";
	}

}
