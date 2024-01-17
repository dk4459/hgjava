package com.yedam.condition;

public class IFCondition {

	public static void main(String[] args) {
		boolean isTrue =true;
		isTrue = isTrue == true; //isTrue인 값과 true 값이 true인지 false인지 isTrue에담는다
		
		if(!isTrue) {
			//실행구문
			System.out.println("참값입니다.");
		}else {
		    System.out.println("거짓값입니다.");
		}
		
		int score = 95;
		if(score>= 90) {
			System.out.println("A학점");
		}if (score >=80) {
			System.out.println("B학점");
		}if(score >=70) {
			System.out.println("C학점");
		}                                    //if 3개
		
		int scor = 95;
		if(scor>= 90) {
			System.out.println("A학점");
		}else if(scor >=80) {
			System.out.println("B학점");
		}else {
			System.out.println("C학점");
		}
		System.out.println("end of prog");
	}

}
