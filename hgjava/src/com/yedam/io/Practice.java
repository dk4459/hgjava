package com.yedam.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Practice {
	public static void main(String[] args) {
		
	
	List<Student> storage = new ArrayList<>();
	try {
		FileReader fr = new FileReader("c:/temp/text.dat");
		BufferedReader br = new BufferedReader(fr);
		
		while(true) {
			String read= br.readLine();  //101 name 90
			if(read == null) {
				break;
			}
			String[] readAry = read.split(" ");
			Student std = new Student(  //
					Integer.parseInt(readAry[0]),//학생번호
					readAry[1],                 //학생이름
					Integer.parseInt(readAry[2]) //점수
	);
		storage.add(std);
		}
		br.close();
		fr.close();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	for(Student std : storage) {
		System.out.println(std.toString());
	}	
}
}
