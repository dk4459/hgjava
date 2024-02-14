package com.yedam.phonebook;

// 사용자메뉴를 비정상적으로 처리.
public class MenuChoiceException extends Exception{
	int wrongChoice;
	
	public MenuChoiceException(int wrongChoice) {
		super("없는 메뉴번호입니다.");
		this.wrongChoice = wrongChoice;
	}
	
	public void showWrongChoice() {
		System.out.println(wrongChoice + "는 없는 메뉴번호입니다.");
	}
}
