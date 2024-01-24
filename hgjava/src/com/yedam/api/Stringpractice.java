package com.yedam.api;

public class Stringpractice {
  public static void main(String[] args) {
	String oldStr = "가하지만가우리는가하나다";
	String newStr = oldStr.replace("가","나");
	System.out.println(newStr);
	String newStr1 = oldStr.substring(3);
	System.out.println(newStr1);
	String newStr2 = oldStr.substring(1,4);
	System.out.println(newStr2);
	String engb = "ABCDEFG";
	String engs = "abcdefg";
	String small = engb.toLowerCase();
	String big = engs.toUpperCase();
	System.out.println(small.equals(engs));
	System.out.println(big.equals(engb));
	System.out.println(small.equals(engb));
	System.out.println(small.equalsIgnoreCase(engb));
	
	String space = " 가나다  라마바  ";
	String space1 = "  가나";
	String space2 = "  다라마";
	String space3 = "   바사";
	String trim = space.trim();
	System.out.println(trim); //중간에 건 제외안됨
	String sum = space1.trim()+space2.trim()+space3.trim();
	System.out.println(sum);
	
	int a = 10;
	long b = 10L;
	float c = 10.0f;
	Double d = 10.0;
	boolean e = false;
	
	String str1 = String.valueOf(20);
	String str2 = String.valueOf(a);
	String str3 = String.valueOf(b);
	String str4 = String.valueOf(c);
	String str5 = String.valueOf(d);
	String str6 = String.valueOf(e);
	System.out.printf("(int:%s) (long:%sL) (float:%sf) (double:%s) (boolean:%s)"//
			            ,str2,str3,str4,str5,str6);   //다다른타입의 변수들을 문자열로 변환
	
	
			}
}
