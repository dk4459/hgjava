package com.yedam.thread;

import java.awt.Toolkit;

// 소리출력 & 문자출력
public class BeepPrintExe {
     public static void main(String[] args) {
    	 
    	 
		
    	 for(int i = 0; i<5; i++) {
    		 System.out.println("print");
    		 try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	 }
	}
}
