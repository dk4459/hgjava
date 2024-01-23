package com.yedam.classes.abstracts;

public abstract class Animal {
    private String name;
    
    public Animal() {
    	
    }
    public Animal(String name) {
    	
    }
    
    public void eat() {
    	System.out.println("[Animal] 음식을 먹습니다.");
    }
    //추상메서드: 구현부분 X , 자식클래스에서 반드시 overriding.
    public abstract void sleep();
}
