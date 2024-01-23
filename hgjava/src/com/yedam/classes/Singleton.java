package com.yedam.classes;

//전체 프로그램에서 인스턴스를 하나만 생성.
public class Singleton {
	//1. 생성자 private 선언.
	//2. Singleton 타입의 필드 선언.
	//3. 인스턴스를 반환하도록 getInstance() 제공.
	private static Singleton instance = new Singleton(); //2 
	
	private Singleton() {    //1
		
	}
	
	public static Singleton getInstance() {   //3
		 return instance;
	}
}
