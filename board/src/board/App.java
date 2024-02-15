package board;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
	UserDAO udao = new UserDAO();
	BoardDAO bdao = new BoardDAO();
	boolean run = true;
	boolean ru = true;
	int menu = 0;
	int men = 0;
	
	while(run) {
		System.out.println("1.로그인 2.회원가입");
		menu = scn.nextInt();
		scn.nextLine();
		if(menu == 1) {
		System.out.println("로그인 해주세요");
		//로그인
		int cnt= 0;
		while(run) {
		System.out.println("id를 입력하세요");
		String id =scn.nextLine();
		System.out.println("pw를 입력하세요");
		String pw =scn.nextLine();
		if(udao.login(id,pw) == 0) {
			System.out.println("환영합니다");
			run = false;
			
		}else if(udao.login(id,pw) == -1 ) {
			System.out.println("입력하신 정보가 맞지 않습니다.");
			cnt++;
			
	       if(cnt==3) {
				System.out.println("계정찾기를 하시겠습니까. 'yes''no'로 입력해주세요") ;
				String yes = scn.nextLine();
				if("yes".equalsIgnoreCase(yes)) {
					
					//아이디 비밀번호계정찾기
					cnt= 0;
					
					while(run) {
					System.out.println("이름을 입력하세요");
					String name =scn.nextLine();
					System.out.println("전화번호 입력하세요");
					String phone =scn.nextLine();
					if(udao.serchInf(name,phone) == true) {
						System.out.println("조회 성공 하셨습니다.");
						break;
					}else if(udao.serchInf(name,phone) == false ) {
						System.out.println("입력하신 정보가 맞지 않습니다.");
						cnt++;
				       if(cnt==3) {
							System.out.println("횟수초과");
							break;
						}				
					}
				 }
				}//yesif문 끝
				else if ("no".equalsIgnoreCase(yes)){
					break;
				}else {
					System.out.println("잘못입력해 처음으로 돌아갑니다");
					break;
				}
			}	//cnt ifans끝			
		}
		} ////로그인끝
	}else if(menu == 2){ //회원 가입
	       //회원가입	
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
		}
	}//로그인 아예 끝
	if(run == false) {//접속
		while(ru) {
	    System.out.println("1.게시글 목록 2.검색 3.게시글 등록 4.게시글 삭제 5.게시글 수정 6.본인회원정보조회 7.회원정보 수정");
	    System.out.print("선택");
	    menu = scn.nextInt();
	    scn.nextLine();
	    switch(menu) {//게시글 목록
	    case 1 : //게시글목록
	    	System.out.println("조회할 카테고리를 입력하세요");
	    	String cate = scn.nextLine();
	    	
	    	int page = 1;
	    	while (true) {
	    		System.out.println("게시글번호 제목 아이디 닉네임 카테고리");
	    		System.out.println("======================================");
	    		List<Board> list = bdao.getList(cate, page);
	    		for(Board boa : list) {
	    			System.out.println(boa.getBoardNo()+"     "+boa.getBoardTitle()+ " "+
	    			boa.getUserId()+ " " + boa.getUserNic() +"   "+ boa.getCate());
	    			
	    		}
	    	    int totalCnt = bdao.getTotalCnt(cate);
	    	    int lastPage = (int)Math.ceil(totalCnt/5.0);
	    	    for(int i = 1; i <=lastPage; i++) {
	    	    	System.out.printf("%3d",i);
	    	    }
	    	    System.out.println();
	    	    System.out.println("(-1 내용 검색) (-2 종료) (n 찾을페이지)");
	    	    System.out.print("페이지 >>");
	    	    page = scn.nextInt(); scn.nextLine();
	    	    if(page == -2) {
	    	    	break;
	    	    }else if(page == -1) {
	    	    	System.out.println("원하는 내용의 글번호를 눌러주세요");
	    	    	while (true) {
	    	    	int title = scn.nextInt(); scn.nextLine();
	    	    	List <Board> list1 = bdao.intoList(title);
	    	    	for(Board boa : list1) {
	    	    		System.out.println("제목: "+boa.getBoardTitle()+"                   닉네임: "+boa.getUserNic()+"작성일자: "+boa.getBoardDate());
	    	    	    System.out.println();
	    	    		System.out.println("내용");
	    	    		System.out.println(boa.getBoardCon());
	    	    		System.out.println();
	    	    		System.out.println("                 댓글");
	    	    		System.out.println("                  "+boa.getBoardCom());
	    	    		
	    	    		System.out.println("댓글달기 1 나가기 2");
	    	    		int dap = scn.nextInt(); scn.nextLine();
	    	    		if(dap == 1) {
	    	    			
	    	    		}else if(dap == 2) {
	    	    			break;
	    	    		}
	    	    	}
	    	     }
	    	   }
	    }
	       		
	    
	    
//	    case 6 ://정보 조회 
//			int cnt = 0;
//			while(true) {
//			System.out.println("id를 입력하세요");
//			String id =scn.nextLine();
//			System.out.println("pw를 입력하세요");
//			String pw =scn.nextLine();
//			List<User> list = udao.userInf(id,pw);
//			
//			try{
//				if(udao.userInf(id,pw)== null) {
//					System.out.println("회원정보가 맞지 않습니다");
//					cnt++;
//					if(cnt == 3) {
//						System.out.println("3회초과하여 프로그램이 종료됩니다");
//						break;
//					}
//				}else {
//					System.out.println("아이디   비밀번호    연락처      이름    가입일자   닉네임");
//				    System.out.println("============================================");
//				    for(User user : list) {
//					System.out.println(user.getUserId()+" "+ user.getUserPw()+" "+
//							user.getUserPhone()+" "+user.getUserName()+"   "+ 
//							user.getUserDate()+" "+user.getUserNic()+" ");
//				     
//				     }
//				  }
//			}catch(NullPointerException e) {
//				System.out.println("아");
//			}break;
//		  }
	    }//case 6 끝)
	  }
	}
       ////회원가입	
//	   System.out.println("id>>");
//	   String id = scn.nextLine();
//	   System.out.println("pw>>");
//	   String pw = scn.nextLine();
//	   System.out.println("phone>>");
//	   String phone = scn.nextLine();
//	   System.out.println("name>>");
//	   String name = scn.nextLine();
//	   System.out.println("nic>>");
//	   String nic = scn.nextLine();
//	try {
//		User user = new User(id, pw, phone, name, nic);
//		if(udao.userAdd(user)) {
//	    	System.out.println("정상적 등록");
//	    }else {
//	    	System.out.println("등록 에러");
//	    }
//	   }catch(Exception e) {
//		   e.printStackTrace();
//	   }
	
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
//    //회원정보 조회   
//	   int cnt= 0;
//		boolean run = true;
//		while(run) {
//		System.out.println("id를 입력하세요");
//		String id =scn.nextLine();
//		System.out.println("pw를 입력하세요");
//		String pw =scn.nextLine();
//		List<User> list = udao.userInf(id,pw);
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
//				System.out.println("아이디   비밀번호    연락처      이름    가입일자   닉네임");
//			    System.out.println("============================================");
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