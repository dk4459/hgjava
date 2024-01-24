package com.yedam.api;

public class ObjectExe {
     public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		
		
		System.out.println(obj1.equals(obj2));
		
		String str1 = "Hello";
		String str2 = "Hello";
		
		System.out.println(str1.equals(str2));
		
		Member mbr1 = new Member();
		Member mbr2 = new Member();
		mbr1.name = "김회원";
		mbr2.name = "김회원";
		mbr1.age = 20;
		mbr2.age = 21;
		
		System.out.println(mbr1.equals(mbr2));  //equals 메서드를 재정의하여 두개의값이 같으면
	}                                           //맞도록 설정
     
}
