package com.yedam.reference;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class RefExe1 {

	public static void main(String[] args) {
		int n1 = 100;
		int n2 = 100;
		System.out.println(n1 == n2);
	
		String str1 = new String("홍길동");
		String str2 = new String("홍길동");
        System.out.println(str1 == str2);  //서로 참조변수라 주소값이 달라 false가 나온다
        System.out.println(str1.equals(str2));//.equals를 사용해야 서로 값에대한 비교가나온다
         
        int[] intAry = new int[10];
        intAry = null;              
        System.out.println(intAry[0]); // intAry의배열에 null값을 하였기때문에 참조하는 값이 없어 0번방을찾아도 없기
        								//때문에 예외(Exception)이 나온다
        
	}

}
