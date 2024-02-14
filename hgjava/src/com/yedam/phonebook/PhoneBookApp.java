package com.yedam.phonebook;

// 연락처 app.
public class PhoneBookApp {

	public static void main(String[] args) {
		PhoneBookManager manager = PhoneBookManager.getInstance();

		// 사용자 권한 체크
		// UserManager => userCheck (아이디, 비번)
		// 3번 연속으로 인증이 실해할 경우 프로그램 종료
		boolean run = true;
		int cnt = 0;
		while (run) {
			manager.inputLogin();

			if (manager.login() == false) {
				System.out.println("다시한번 입력하세요");
				cnt++;
			}else if(cnt == 3){
				System.out.println("시스템을 종료합니다.");
				run = false;
			}
		}

		int menu = 1;
		while (run) {
			try {
				MenuViewer.showMenu();
				menu = MenuViewer.keyboard.nextInt();
				MenuViewer.keyboard.nextLine();

				if (menu < InitMenu.INPUT || menu > InitMenu.EXIT) {
					throw new MenuChoiceException(menu); // 예외를 일부러 발생시킬려면
				} // throw new를 해야한다.

				if (menu == InitMenu.INPUT) {
					manager.inputData();
				} else if (menu == InitMenu.SEARCH) {
//					manager.searchData();
				} else if (menu == InitMenu.DELETE) {
					manager.deleteData();
				} else if (menu == InitMenu.EXIT) {
					System.out.println("종료");
					manager.storeToFile();
					break;
				}
			} catch (MenuChoiceException e) {
				e.showWrongChoice();
			}
		}
		System.out.println("end of prog");
	}

}
