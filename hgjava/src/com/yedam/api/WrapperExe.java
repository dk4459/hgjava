package com.yedam.api;

import java.util.ArrayList;
import java.util.List;

public class WrapperExe {
      public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(Integer.valueOf(1)); //기본타입 <-> 래퍼클래스
		
		Double d1 =Double.valueOf("2.3");
		
		System.out.println(Math.abs(-10)); //절대값 10으로 출력
		System.out.println(Math.ceil(2.1));//올림 3으로출력
		System.out.println(Math.round(2.1)); //반올림 2로 출력
		System.out.println(Math.max(2, 50)); //50으로 추력
	}
}
