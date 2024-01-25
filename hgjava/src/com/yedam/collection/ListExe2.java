package com.yedam.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExe2 {
   public static void main(String[] args) {
	 List<String> list1 = new ArrayList<>();
	 	Long start = System.currentTimeMillis();
	 	for(int i=0; i<10000; i++) {
	 		list1.add(0,String.valueOf(i));
	 	}
	 	long end = System.currentTimeMillis();
	 	System.out.println("결과1:"+(end -start));
	 
	 List<String> list2 = new LinkedList<>();
	 start = System.currentTimeMillis();
	 for(int i=0; i<10000; i++) {
		  list2.add(0,String.valueOf(i));
	 	}
	 	end = System.currentTimeMillis();              // 순서대로집어넣는 과정은 ArrayLIst가 더빠름
	 	System.out.println();                          // 뒤에넣는 과정이거나 도중에 넣는것은
	 	System.out.println("결과2:"+(end -start));      // LinkedList가 더빠름
  }
}
