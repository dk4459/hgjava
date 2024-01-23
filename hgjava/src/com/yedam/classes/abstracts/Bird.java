package com.yedam.classes.abstracts;

public class Bird extends Animal {

	public Bird(String name) {
		super(name);
	}
	
	@Override
	public void sleep() {
		System.out.println("[Bird]가 잠을 잡니다.");
	}

}
