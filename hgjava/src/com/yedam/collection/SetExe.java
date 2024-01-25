package com.yedam.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExe {
	public static void main(String[] args) {
		Set<String> names = new HashSet<>();
		names.add("홍길동");
		names.add("김길동");
		names.add("손흥민");
		
		names.remove("손흥민");              //set 인덱스값이 없기때문에 인덱스번호로 못가져옴
		
		System.out.println(names.size());
		
		Iterator<String> iter = names.iterator();
		while(iter.hasNext()) {  //대상이 있는지 체크
			String result=iter.next();      //선택해서 가져옴
			System.out.println(result);
		}
		
		//확장 for.
		for(String name : names) {
			System.out.println(name);
		}
		int[] numbers = { 10, 20, 30, 20 };
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<numbers.length; i++) {
			set.add(numbers[i]);
		}
		for(int sum : set) {
			System.out.println(sum);
		}
		
	}
}
