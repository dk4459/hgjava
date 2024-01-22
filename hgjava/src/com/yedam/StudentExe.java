package com.yedam;

import com.yedam.classes.Student;

public class StudentExe {

	public static void main(String[] args) {
		
		Student std = new Student("S001","홍길동");  //public 접근 제한자에서만 사용가능 default접근제한자면 접근불가 
		std.setScore(80);
		
		std .showInfo(); //접근수준 default.
	}

}
