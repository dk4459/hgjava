package com.yedam.classes.nested;

import java.util.Map;

public class NestedExe {
    public static void main(String[] args) {
    	//outer 클래스의 기능을 활용
		Outer outer = new Outer();
		outer.method1();
		
		Outer.NestClass nest = outer.new NestClass();
		nest.field2 ="반갑습니다.";
		System.out.println(nest.field2);
		
		nest.method2();
		
		Map.Entry<String, Integer> entry;
		
		Outer.StaticClass.method3();
	}
}
