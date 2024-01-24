package com.yedam.exceptions;

public class RuntimeExe {
		public static void main(String[] args) {
			
			//일반예외.
			try {
				Class.forName("java.lang.String");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			//실행예외.
			String str = null;                    //(NullPointerException) 참조값이 null일때 출력 과정에서           
			try {                                 //NullPointerException이 나온다.
			System.out.println(str.toString());
			}catch(NullPointerException e) {
				System.out.println("참조값이 없습니다.");
				str = "10";
			}
			
			try {
			    int num = Integer.parseInt(str);
		        System.out.println(num);          //NumberFormatException 숫자로 변환될수 없는 문자가 포함되어   
			}catch(NumberFormatException e) {     //있다면 NumberFormatException을 발생시키낟.
				System.out.println("숫자로 변경 불가");
			}
		    System.out.println("end of prog");
		}
}
