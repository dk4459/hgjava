package com.yedam.api;

import java.util.HashSet;
import java.util.Set;

public class ObjectExe2 {
     public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("김길동");
		set.add("박길동");
		set.add("홍길동");
		set.add("박길동");           //set은 동일한 key는 안됨
		for(String name : set) {   //(자바스크립트 for of ) (자바 변수x : y )<- y의 갯수만큼 반복하겠다
			System.out.println(name);
		}
		System.out.println("---------------------------------------------------------");
		Set<Member> members = new HashSet<Member>();
		members.add(new Member("김길동",20));  //Member클래스에 equals를 재정의하여
		members.add(new Member("홍길동",22));  //set에 담더라도 중복된값이 그대로 나온다
		members.add(new Member("박길동",24));  //그래서 hashSet도 재정의 하여 다시끔 정의하였다.
		members.add(new Member("김길동",20));
		for(Member mem: members) {              
			System.out.println(mem.toString());
		}
	}
}
