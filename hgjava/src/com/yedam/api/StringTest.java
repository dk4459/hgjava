package com.yedam.api;

public class StringTest {
	public static void main(String[] args) {
		String[] jumins = { "970101-1234567", "970101-2234567", "9701011234567", "970101 1234567", "970101 4234567",
				"4564879878979"

		};
		for (String ssn : jumins) {

			checkGender(ssn);
		}
		String[] names = { "김길동", "홍길동", "이상민", "김민수", "길동이" };
		int cnt = 0;
		for (String name : names) {
			if (name.indexOf("길동") > 0) {
				cnt++;
			}
		}
		System.out.printf("길동이란 이름을 가진사람은 %s 명입니다.", cnt);

	}

	public static String checkGender(String ssn) {
		ssn = ssn.replace("-", "");
		ssn = ssn.replace(" ", "");
		ssn = ssn.substring(6);
		if (ssn.charAt(0) == ('1') || ssn.charAt(0) == ('3')) {
			System.out.println("남자");
			return "남자";
		} else if (ssn.charAt(0) == ('2') || ssn.charAt(0) == ('4')) {
			System.out.println("여자");
			return "여자";
		}
		System.out.println("오류");
		return "오류";

	}
}
