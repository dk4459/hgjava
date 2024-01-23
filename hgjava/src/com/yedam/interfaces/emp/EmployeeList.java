package com.yedam.interfaces.emp;

public interface EmployeeList {
	
	//규칙. (배열 vs 컬렉션)
	public void init();
	public void input();
	public String search(int empId);
	public void print();
	public int sum();
	
}
