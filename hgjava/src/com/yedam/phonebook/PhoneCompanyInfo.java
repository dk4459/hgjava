package com.yedam.phonebook;

public class PhoneCompanyInfo extends PhoneInfo {
	String company;
	
	public PhoneCompanyInfo(String name, String phone, String company) {
		super(name,phone);       //부모생성자.
		this.company = company;
	}
	
	@Override
	public void showPhoneInfo() {
		super.showPhoneInfo();
		System.out.println("compnay:"+ company);
	}
	
	//getter 추가
	
	@Override
	public String toString() {
		//1,홍길동,010-1111
		return InputSelect.COMPANY +"," + getName() + "," + getPhone()+"," + company;
	}
}
