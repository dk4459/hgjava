package com.yedam.classes.friend;

import java.util.Scanner;

public class FriendExe {
   public static void main(String[] args) {
	       //메뉴: 1등록 2.목록 3.수정 4.삭제 9.종료
	       //사용자의 입력/ 처리결과 콘솔출력
	 FriendApp app = new FriendApp();
	 Scanner scn = new Scanner(System.in);
	 UserApp uapp = new UserApp();
	 while(true) {
	 System.out.println("id>>>");
	 String id = scn.nextLine();
	 System.out.println("pw >>>");
	 String pw = scn.nextLine();
	 
	 User user = uapp.login(id,pw);
	 
	 if(user!= null) {
		 System.out.printf("%s 님 환영합니다",user.getName());
		 break;
	 }
	 System.out.println("id와 pw를 확인!!");
   } 
 	boolean run = true;
	 
 	String name = "";
 	String phone = "";
 	int age = 0;
 	while(run) {
 		System.out.println("1.등록 2.목록 3.수정 4.삭제 9.종료");
 		int menu = Integer.parseInt(scn.nextLine());
 	switch(menu){
     
 	case 1: 
 		    System.out.println("이름을 입력하세요");
 		    name = (scn.nextLine());
 		   System.out.println("폰번을 입력하세요");
		    phone = (scn.nextLine());
		    System.out.println("나이를 입력하세요");
		    age = Integer.parseInt(scn.nextLine());
		    
		    Friend fr = new Friend(name,phone,age);
		    break;

     
 	case 2: //목록
 		System.out.println("조회할 이름");
 		name = scn.nextLine();
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
    
 		
 	}
 	     
 	}
 	
}
}
