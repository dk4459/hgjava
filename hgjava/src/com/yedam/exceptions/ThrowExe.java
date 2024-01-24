package com.yedam.exceptions;

public class ThrowExe {

	public static void main(String[] args) {
			try{
				method();
			}catch(ClassNotFoundException e) {
				System.out.println("존재하지 않는 클래스입니다.");
			}catch (Exception ee) {
				System.out.println("알수없는 예외");
			}
		
	}

	static void method() throws ClassNotFoundException{
//		try {
//	    Class.forName("java.lang.String");   이렇게 하나씩 다 예외처리하면되지만
//		}catch(ClassNotFoundException) {     여러개가 있을경우 중복되기때문에
//			System.out.println();             throws해서 메서드 호출한 곳에서 예외처리를 한다.
//		}
		
	    Class.forName("java.lang.String");
	    
	    Class.forName("java.lang.String");
	    
	    Class.forName("java.lang.String");
	}
}
