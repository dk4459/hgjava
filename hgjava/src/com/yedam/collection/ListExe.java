package com.yedam.collection;

import java.util.ArrayList;
import java.util.List;

public class ListExe {
     public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("홍길동");   
		//names.add("홍길동");  	  //중복허용 인정
		names.add("김민석");
		names.add(1,"이만수");     //도중에 들어오면 밀어내기 되서인덱스값이 (1)인 김민석은 (2)가 된다 
		names.add(1,"이만우");     // 홍길동 이만우 이만수 김민석 순으로된다
		
		names.set(1, "김만우");    //set을 하면 밀어내기가 아니라 그인덱스값이 수정되는것이다
		                         //홍길동 김만우 이만수 김민석		
		names.remove(1);         //그인덱스값을 삭제한다
		                         //홍길동 이만수 김민석
		//names.clear();           // 다삭제함  null
		
		System.out.println(names.size()); //클렉션 크기확인 size();
		
		//반복문.
		for(String name: names) {
			System.out.println(name);
		}
//		if(names.size()>2) {
//	    System.out.println(names.get(1));  //배열의 경우 names[1]
//		}
		
		List<Member> members = new ArrayList<>();
		members.add(new Member(1, "홍길동"));
		members.add(new Member(2,"김민석"));
		members.add(new Member(3,"이충희"));
		
		for(int i=0; i<members.size(); i++) {
			if(members.get(i).getName().equals("김민석")) {
				members.set(i, new Member(4,"김길동"));    //김민석의 이름을 찾아서 김길동으로 교체
			}
		}
		
//		for(Member member : members) {
//			System.out.println(member.getName());
//		}
		
		for(int i=0; i<members.size(); i++ ) {
			String name= members.get(i).getName();
			int id = members.get(i).getMid();
			System.out.printf("이름: %s, 아이디: %d\n",name, id);
			System.out.printf("%s\n",members.get(i).toString());
		}
	}
}
