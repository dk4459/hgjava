package com.yedam.exceptions;

import java.util.Scanner;

public class RuntimeExe3 {
      public static void main(String[] args) {
	    Scanner scn = new Scanner(System.in);
	    
	    while(true) {
	    	
	    	int menu = 0;
	    	
	    	while(true) {
	    		System.out.println("1.실행 2.종료");
	    	try {
	    	    menu = Integer.parseInt(scn.nextLine());
	    	    break;                            
	    	}catch(NumberFormatException ne) {
	    		System.out.println("정확한 값을입력하세요");
	    	}
	    	}
	    	if(menu ==1) {
	    		System.out.println("실행합니다.");
	    	}else if(menu ==2) {
	    		System.out.println("종료합니다");
	    		break;
	    	}
	    }
	    System.out.println("end of prog.");
	}
}
