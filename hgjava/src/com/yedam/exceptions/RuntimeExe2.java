package com.yedam.exceptions;

public class RuntimeExe2 {
   public static void main(String[] args) {
	
	   //실행예외
	   String str = "10";
	   
	   str = null;
	   try {
	   str = "ten";
	   System.out.println(str.toString());   //NullPointer 예외발생
	   int num = Integer.parseInt(str);      //NumberFormat 예외발생
	   }catch(NullPointerException ne) {
		   //ne.printStackTrace();
		   System.out.println("참조값이 없습니다.");
	   }catch(NumberFormatException ne2) {
		   //ne2.printStackTrace();
		   System.out.println("숫자값이 없습니다.");
	   }catch(Exception e) {                 //종류가리지 않고 해당하는 예외는 다 처리하는것  
		   System.out.println("알수없는예외");  //다른예외처리와 같이 사용하려면 Exception(최고조상)
	   }                                     //클래스가 제일 마지막에 있어야한다
	   System.out.println("end of prog");    //왜냐하면 위에서 Exception(최고조상)이
    }                                        //다처리하면 아래에서 처리할 내용이 없기 때문이다.
}
