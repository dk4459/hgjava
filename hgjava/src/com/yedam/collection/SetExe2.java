package com.yedam.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExe2 {

	public static void main(String[] args) {
		Set<Member> members = new HashSet<>();
			
		members.add(new Member(1,"홍길동"));
		members.add(new Member(2,"김길동"));
		members.add(new Member(3,"박길동"));
		members.add(new Member(1,"홍길동"));
		
		members.remove(new Member(2, "김길동"));
		System.out.println(members.size());
		
		//반복된 요소를 선택해서 가져오는 반복자로 출력.
		Iterator<Member> iter = members.iterator();
		while(iter.hasNext()) {
			Member member = iter.next();
			System.out.println(member);
		}
		
		//확장 for로 출력.
		for(Object id : members) {
			System.out.println(id);
		}
	}

}
