package board;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
	UserDAO udao = new UserDAO();
       ////회원가입	
	   System.out.println("id>>");
	   String id = scn.nextLine();
	   System.out.println("pw>>");
	   String pw = scn.nextLine();
	   System.out.println("phone>>");
	   String phone = scn.nextLine();
	   System.out.println("name>>");
	   String name = scn.nextLine();
	   System.out.println("nic>>");
	   String nic = scn.nextLine();
	try {
		User user = new User(id, pw, phone, name, nic);
		if(udao.userAdd(user)) {
	    	System.out.println("정상적 등록");
	    }else {
	    	System.out.println("등록 에러");
	    }
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	
	//로그인
//	int cnt= 0;
//	boolean run = true;
//	while(run) {
//	System.out.println("id를 입력하세요");
//	String id =scn.nextLine();
//	System.out.println("pw를 입력하세요");
//	String pw =scn.nextLine();
//	if(udao.login(id,pw) == 0) {
//		System.out.println("환영합니다");
//		break;
//	}else if(udao.login(id,pw) == -1 ) {
//		System.out.println("입력하신 정보가 맞지 않습니다.");
//		cnt++;
//       if(cnt==3) {
//			System.out.println("횟수초과");
//			run = false;
//		}				
//	}
//  }
//  //아이디 비밀번호
//		int cnt= 0;
//		boolean run = true;
//		while(run) {
//		System.out.println("이름을 입력하세요");
//		String name =scn.nextLine();
//		System.out.println("전화번호 입력하세요");
//		String phone =scn.nextLine();
//		if(udao.serchInf(name,phone) == true) {
//			System.out.println("조회 성공 하셨습니다.");
//			break;
//		}else if(udao.serchInf(name,phone) == false ) {
//			System.out.println("입력하신 정보가 맞지 않습니다.");
//			cnt++;
//	       if(cnt==3) {
//				System.out.println("횟수초과");
//				run = false;
//			}				
//		}
//	 }
    //회원정보 조회   
//	   int cnt= 0;
//		boolean run = true;
//		while(run) {
//		System.out.println("id를 입력하세요");
//		String id =scn.nextLine();
//		System.out.println("pw를 입력하세요");
//		String pw =scn.nextLine();
//		List<User> list = udao.userInf(id,pw);
//		User user1 = new User();
//		
//		try{
//			if(udao.userInf(id,pw)== null) {
//				System.out.println("회원정보가 맞지 않습니다");
//				cnt++;
//				if(cnt == 3) {
//					System.out.println("3회초과하여 프로그램이 종료됩니다");
//					run= false;
//				}
//			}else {
//				System.out.println("아이디     비밀번호     연락처      이름    가입일자            닉네임");
//			    System.out.println("=========================================");
//			    for(User user : list) {
//				System.out.println(user.getUserId()+" "+ user.getUserPw()+" "+
//						user.getUserPhone()+" "+user.getUserName()+"   "+ 
//						user.getUserDate()+" "+user.getUserNic()+" ");
//			}break;
//			  }
//		}catch(NullPointerException e) {
//			System.out.println("아");
//		}
//	}
 }
}