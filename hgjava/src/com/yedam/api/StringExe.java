package com.yedam.api;

public class StringExe {
	public static void main(String[] args) {
		String str = "Hello";
		str = new String("Hello");
		byte[] bytes = str.getBytes();
		for(byte b: bytes) {
			System.out.println(b);
		}
		str = new String(new byte[]{72,101,108,108,111});   //문자열을 유니코드롤 반환해서 만듬
		System.out.println(str);
		
		int pos = str.indexOf("a");                   //있는문자열을 인덱스값으로 나온다
		System.out.println("l은"+ pos +"위치에있음.");   //없으면 -1을 표현함
		
		char chr = str.charAt(0);                    //인덱스값 위치에 있는 문자열로 나온다
        System.out.println(chr);		 
	}
}
