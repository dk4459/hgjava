package com.yedam.thread;

import java.awt.Toolkit;

//Runnable 인터페이스의 구현객체를 통해서 쓰레드.
public class BeepTask implements Runnable{

	//메인쓰레드가 실행
	@Override
	public void run() {
		
		Thread thread = new Thread(new BeepTask());
		//Thread thread = new BeepThread(); 자식 메서드를 가지고 와서 작업 위에것과 기능은같다.
		thread.start(); //start호출하면 run()메소드 실행

		Toolkit toolkit =Toolkit.getDefaultToolkit();
   	 for(int i=0; i<5; i++) {
   		 toolkit.beep();
   		 try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
   	 }
	}
}
