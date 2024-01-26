package com.yedam.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StudentApp {

	// 초기화(text.dat) => 컬렉션에 저장.
	// 추가            => 컬렉션에 추가 
	// 목록 
	// 종료            =>  컬렉션 => 파일저장(text.dat).
	List<Student> storage = new ArrayList<>();
	
	public StudentApp() {
		init();
	}
	//초기화(파일 -> 컬렉션에 저장).
    public void init() {
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
    }// end of init
    //추가.
    public boolean add(Student std) {
    	return storage.add(std);     //추가가되면 add메서드가 true로 나온다
    }
    
    //목록반환
    public List<Student> list(){
    	return storage;
    } 
    //저장
    public void save() {
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
    }
	
}
