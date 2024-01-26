package com.yedam.thread.synchronize;

public class Calculator {
	//user1, user2 작업공간.
	  private int memory;
	  
	 public int getMemory() {
		 return memory;
	 } 
	 
	 public synchronized void setMemory(int memory) {
		 System.out.println(Thread.currentThread().getName());
		 this.memory = memory;
		 
		 try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		 System.out.println(Thread.currentThread().getName()+ ">>"+ this.memory);
	 }
}
