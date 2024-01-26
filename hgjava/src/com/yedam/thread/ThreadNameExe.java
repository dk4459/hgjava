package com.yedam.thread;

class ThreadA extends Thread{
	
	ThreadA(){
		setName("Thread-A");
	}
	@Override
	public void run() {
		for(int i = 0; i<2; i++) {
			System.out.println("Thread이름 ->"+ getName());
		}
		
	}
}

class ThreadB extends Thread{
	ThreadB(){
		setName("Thread-B");
	}
	@Override
	public void run() {
		for(int i = 0; i<2; i++) {
			System.out.println("Thread이름"+ getName());
		}
		
	} 	
}

public class ThreadNameExe {
	public static void main(String[] args) {
		//main
		Thread mainThread = Thread.currentThread();
		System.out.println("시작 Thread이름-> "+ mainThread.getName());
		
		Thread threadA = new ThreadA();
		System.out.println("Thread이름-> "+threadA.getName());
		threadA.start();
		
		Thread threadB = new ThreadB();
		System.out.println("Thread이름-> "+threadA.getName());
		threadB.start();
		
		System.out.println("end of main");
	}
}
