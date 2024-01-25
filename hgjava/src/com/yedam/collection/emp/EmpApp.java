package com.yedam.collection.emp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EmpApp {
	public static void main(String[] args) {
		List<Employee> storage = new ArrayList<>();

		Scanner scn = new Scanner(System.in);
		boolean run = true;
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");

		while (run) {
			System.out.println("1.등록 2.조회(입사일자) 9.종료");
			// "사용자가 입력했을때 "23-03-01" 문자열을 Date값으로 바꿔주는 작업을 해야함
			Integer menu = Integer.parseInt(scn.nextLine());
			switch (menu) {
			case 1: // 등록
				System.out.println("사번 이름 입사일 급여를 입력해주십시오");
				String input = scn.nextLine();
				String[] inputs = input.split(" ");
                boolean isOk = true;
				try {
					storage.add(new Employee(Integer.parseInt(inputs[0]), inputs[1], sdf.parse(inputs[2]),
							Integer.parseInt(inputs[3])));
				} catch (ParseException e) {
                     System.out.println("날짜 포맷이 부정확합니다.");
                     isOk = false;
				}
				if(isOk) {
				System.out.println("추가되었습니다.");
				}
				break;
			case 2:// 조회
				System.out.println("조회 할 입사날을 입력하세요");
				Date searchCondition = null;
				while (true) {
					System.out.println("조회일 입력");
					try {
						searchCondition = sdf.parse(scn.nextLine());
						break;
					} catch (Exception e) {
						System.out.println("날짜포맷이 부정확");
					}
				}
				for (int i = 0; i < storage.size(); i++) {
					if (storage.get(i).getHireDate().after(searchCondition) || //
							storage.get(i).getHireDate().equals(searchCondition)) {
						System.out.println(storage.get(i).toString());

					}
				}
					break;
			}

		}
		System.out.println("end of prog");
	}

	void method() {
		// "101 홍길동 23-05-08 100"
		String val = "101 홍길동 23-05-08 100";
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM=dd");
		String[] valAry = val.split(" ");
		for (String value : valAry) {
			System.out.println(value);
		}
		try {
			new Employee(Integer.parseInt(valAry[0]), // 사번(Integer)
					valAry[1], // 이름(String)
					sdf.parse(valAry[2]), // 입사일(Date)
					Integer.parseInt(valAry[3]) // 급여(Integer)
			);
		} catch (Exception e) {

		}

	}
}
