package com.yedam.collection;

import java.util.ArrayList;
import java.util.List;

public class BoxExe {
		public static void main(String[] args) {
	     Box<String> box = new Box<String>();
	     box.setObj("Hong");
	     String result = box.getObj();
	     
	     Box<Integer> boxi = new Box();
	     boxi.setObj(100);
	     Integer resulti = boxi.getObj();
	     
	     List<Integer> list = new ArrayList<>();
	     
	     
//	     box.setObj(100);
//	     box.setObj("Hong");
//	     Integer result = (Integer)box.getObj();  //
		}
}
