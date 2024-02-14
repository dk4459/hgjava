package com.yedam.phonebook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

//생성자(초기화), 등록, 검색, 삭제, 종료(파일에저장)
public class PhoneBookManager {

	private File dataFile = new File("c:/temp/phonebook.dat");

	// 컬렌션 선언.
	HashSet<PhoneInfo> storage = new HashSet<>();
	HashSet<UserManager> store = new HashSet<>();

	// 싱글톤.
	private static PhoneBookManager instance; // 초기값: null;

	private PhoneBookManager() {
		// 초기화작업.
		readFromFile();
	}

	// 초기화
	public static PhoneBookManager getInstance() {
		if (instance == null) {
			instance = new PhoneBookManager();
		}
		return instance;
	}

	// 메소드 1, 2, 3
	private PhoneInfo getFriendInfo() {
		System.out.println("이름을 입력하세요");
		String name = MenuViewer.keyboard.nextLine();
		System.out.println("연락처 입력하세요");
		String phone = MenuViewer.keyboard.nextLine();
		return new PhoneInfo(name, phone);
	}

	private PhoneInfo getCompanyFriendInfo() {
		System.out.println("이름을 입력하세요");
		String name = MenuViewer.keyboard.nextLine();
		System.out.println("연락처 입력하세요");
		String phone = MenuViewer.keyboard.nextLine();
		System.out.println("회사정보 입력하세요");
		String company = MenuViewer.keyboard.nextLine();
		return new PhoneCompanyInfo(name, phone, company);
	}

	private PhoneInfo getUnivFriendInfo() {
		System.out.println("이름을 입력하세요");
		String name = MenuViewer.keyboard.nextLine();
		System.out.println("연락처 입력하세요");
		String phone = MenuViewer.keyboard.nextLine();
		System.out.println("전공 입력하세요");
		String univ = MenuViewer.keyboard.nextLine();
		System.out.println("학년 입력하세요");
		int year = MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		return new PhoneUnivInfo(name, phone, univ, year);
	}

	// 추가
	public void inputData() {
		System.out.println("구분");
		System.out.println("1.일반 2.회사 3.학교");
		System.out.print("선택>> ");
		int choice = MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine(); // 엔터처리 작업

		PhoneInfo info = null;
		switch (choice) {
		case InputSelect.NORMAL:
			info = getFriendInfo();
			break;
		case InputSelect.COMPANY:
			info = getCompanyFriendInfo();
			break;
		case InputSelect.UNIV:
			info = getUnivFriendInfo();
			break;
		}

		if (storage.add(info)) {
			System.out.println("등록완료");
		} else {
			System.out.println("등록오류");
		}

	}

	// 삭제
	public void deleteData() {
		System.out.println("삭제할 이름을 입력");
		String name = MenuViewer.keyboard.nextLine();

		Iterator<PhoneInfo> iter = storage.iterator();
		while (iter.hasNext()) {
			PhoneInfo info = iter.next();
			if (info.getName().equals(name)) {
				iter.remove();
			}
		}

		System.out.println("삭제가 완료되었습니다");
	}

	// 초기화.
	public void readFromFile() {
		if (dataFile.exists() == false) {
			return; // 메소드 종료.
		}
		try {
			// 있으면 파일읽기
			FileReader fr = new FileReader(dataFile);
			BufferedReader br = new BufferedReader(fr);
			String str = "";
			PhoneInfo info = null;
			while ((str = br.readLine()) != null) {
				String[] record = str.split(",");
				// 컬렉션에 저장.
				int type = Integer.parseInt(record[0]);
				switch (type) {
				case InputSelect.NORMAL:
					info = new PhoneInfo(record[1], record[2]);
					break;
				case InputSelect.COMPANY:
					info = new PhoneCompanyInfo(record[1], record[2], record[3]);
					break;
				case InputSelect.UNIV:
					info = new PhoneUnivInfo(record[1], record[2], record[3], Integer.parseInt(record[4]));
					break;
				}
				storage.add(info);
			} // while 끝

		} catch (Exception e) {
			e.printStackTrace();
		} // catch끝

	} // reaFromFile 메서드끝

	// 저장.
	public void storeToFile() {
		try {
			FileWriter fr = new FileWriter(dataFile);
			Iterator<PhoneInfo> iter = storage.iterator();
			while (iter.hasNext()) {
				PhoneInfo info = iter.next();
				// to.String 활용
				fr.write(info.toString() + "\n");
			}
			fr.flush();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 회원가입
	public void inputLogin() {
		System.out.println("id pw 를 설정하세요");
	    System.out.println("id");
		String id = MenuViewer.keyboard.nextLine();
		System.out.println("pw");
		String pw = MenuViewer.keyboard.nextLine();
	
		UserManager info = null;
		info = new UserManager(id, pw);

		if (store.add(info)) {
			System.out.println("등록완료");
		} else {
			System.out.println("등록오류");
		}

	}

	public boolean login() {
		System.out.println("아이디를 입력하세요");
		String id = MenuViewer.keyboard.nextLine();
		System.out.println("비밀번호를 입력하세요");
		String pw = MenuViewer.keyboard.nextLine();
		Iterator<UserManager> iter = store.iterator();
		int cnt = 0;
		while (iter.hasNext()) {
			UserManager info = iter.next();
			if (info.getId().equals(id)) {
				if (info.getPw().equals(pw)) {
					System.out.println("로그인이 완료되었습니다.");
					return true;
				}
			} else if (!info.getId().equals(id) || !info.getPw().equals(pw)) {
				System.out.println("정보가 맞지 않습니다.");
				break;
			} 

		}return false;
	}

} // 클래스 끝
