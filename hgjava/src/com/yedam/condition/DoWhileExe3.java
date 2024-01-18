package com.yedam.condition;

public class DoWhileExe3 {

	public static void main(String[] args) {

		boolean run = true;
		int cnt = 1;
		
		do {
			System.out.println(cnt+"번 출력합니다.cnt:"+cnt);
			run = true;           //한번만 실행하는거지만 do문에서 무한루트로 하면 무한 실행한다.
			if(cnt++ > 3) {
				run =false;
			}
		}while(run); { 
		}
		System.out.println("end of porg.");
	}

}
