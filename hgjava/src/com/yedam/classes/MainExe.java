package com.yedam.classes;

import java.util.Scanner;

public class MainExe {

	static Scanner scn = new Scanner(System.in);
	static String sno = "";
	static String sname = "";
	static int score = 0;
	static double height = 0.0;

	// 등록메서드.
	public static void insert() {
		System.out.println("학생의번호를 입력하세요");
		sno = scn.nextLine();
		System.out.println("학생이름를 입력하세요");
		sname = scn.nextLine();
		System.out.println("학생점수를 입력하세요");
		score = Integer.parseInt(scn.nextLine());
		System.out.println("학생키를 입력하세요");
		height = Double.parseDouble(scn.nextLine());

		// 매개값으로 사용.
		Student std = new Student(sno, sname, score, height);

		if (StudentApp.add(std)) {
			System.out.println("입력성공");
		} else {
			System.out.println("입력실패");
		}
	}

	public static void list() {
		Student[] list = StudentApp.list();
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null) {
				list[i].showInfo();

			}
		}
	}

	public static void update() {
		System.out.println("변경할 번호를 입력하세요");
		sno = scn.nextLine();
		// 정상 학번 체크.
		if (StudentApp.get(sno) == null) {
			System.out.println("학생번호 확인해주세요");
			return;
		}
		// 정상 점수 입력.
		while (true) {
			System.out.println("변경할 점수를 입력하세요");
			score = Integer.parseInt(scn.nextLine());
			if (score < 0) {
				System.out.println("점수를 확인하세요");
				continue;
			}
			break;
		}

		if (StudentApp.modify(sno, score)) {
			System.out.println("수정완료");
		} else {
			System.out.println("잘못된 학번입니다.");
		}
	}

	public static void delete() {
		System.out.println("삭제할 번호를 입력하세요");
		sno = scn.nextLine();
		if (StudentApp.remove(sno)) {
			System.out.println("삭제완료");
		} else {
			System.out.println("잘못된학번입니다.");
		}
	}

	public static void search() {
		System.out.println("조회할 학생번호>>>");
		sno = scn.nextLine();
		Student s1 = StudentApp.get(sno);
		if (s1!=null) {
			s1.showInfo();
		} else {
			System.out.println("학생번호 없음");
		}
	}
	// end of prog

	public static void main(String[] args) {

		StudentApp app = new StudentApp(); // 인스턴스

		boolean run = true;

		while (run) {
			System.out.println("1등록 2.목록 3.수정 4.삭제 5.검색  9.종료");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				insert();
				break;
			case 2: // 목록출력
				list();
				break;
			case 3: // 수정
				update();
				break;
			case 4:// 삭제
				delete();
				break;
				
			case 5:// 삭제
				search();
				break;
			case 9: // 종료.
				run = false;
				System.out.println("종료합니다.");
			}
		}
		System.out.println("end of prog");
	}
}
