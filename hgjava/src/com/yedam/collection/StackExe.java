package com.yedam.collection;

import java.util.Stack;

public class StackExe {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("홍길동");
		stack.push("김민석");
		stack.push("최만석");
		
		
	 
	    while(!stack.isEmpty()) {
	    	String result =stack.pop();
	    	System.out.println(result);
	    	//String result1 =stack.peek(); 객체에서 가져는 오는데 스택에서 제거를 안함. 
	    }
	    
	    //home -> product -> sell -> 시점. 역순으로 추적할때는 stack구조를 씀
		
	}
}
