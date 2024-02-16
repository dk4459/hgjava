package board;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
	UserDAO udao = new UserDAO();
	BoardDAO bdao = new BoardDAO();
	DabsDAO ddao = new DabsDAO(); 
	boolean run = true;
	boolean ru = true;
	int menu = 0;
	int men = 0;
	String id = null;
	
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
		id =scn.nextLine();
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
		   id = scn.nextLine();
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
	    System.out.println("1.게시글 목록 2.게시글 등록 3.검색 4.게시글 수정 5.게시글 삭제  6.본인회원정보조회 7.회원정보 수정");
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
	    	    if(page == -2) {//종료
	    	    	break;
	    	    }else if(page == -1) { //내용검색
	    	    	System.out.println("원하는 내용의 글번호를 눌러주세요");
	    	    	while (true) { 
	    	    	int no = scn.nextInt(); scn.nextLine();
	    	    	List <Board> list1 = bdao.intoList(no);
	                List<Dabs> dabs =  ddao.getList(no);	 
	    	    	for(Board boa : list1) {
	    	    		
	    	    		System.out.println("====================================================================================================");
	    	    		System.out.println("제목: "+boa.getBoardTitle()+"                   닉네임: "+boa.getUserNic()+"   작성일자: "+boa.getBoardDate());
	    	    	    System.out.println("====================================================================================================");
	    	    		System.out.println("내용");
	    	    		System.out.println(boa.getBoardCon());
	    	    		System.out.println("====================================================================================================");
	    	    		System.out.println("댓글");
	    	    	}
	    	    	for(Dabs dao : dabs) {
	    	    	System.out.println("id: "+dao.getUserId()+"  ||  "+dao.getDap());
	    	    	}
	    	    	
	    	    	System.out.println("=========================================================================================");
	    	    	System.out.println("(나가기 -1) (댓글달기 1) (글수정 2) (해당글 삭제 3)");
	    	    		int dap = scn.nextInt(); scn.nextLine();
	    	    		if(dap == 1) { //댓글 만들기
	    	    			System.out.print("게시판 번호>>");
	    	    			int gae = scn.nextInt();scn.nextLine();
	    	    			System.out.print("\n 해당 아이디 \n");
	    	    			String id1 = scn.nextLine();
	    	    			System.out.println("댓글을 입력하세요");
	    	    			String nae = scn.nextLine();
	    	    		    try {
	    	    		    	Dabs dab = new Dabs(id1,gae,nae);
	    	    		    	if(ddao.insertDab(dab)) {
	    	    		    		System.out.println("등록완료");
	    	    		    		break;
	    	    		    	}else {
	    	    		    		System.out.println("등록에러");
	    	    		    		break;
	    	    		    	}
	    	    		    }catch(Exception e) {
	    	    		    	e.printStackTrace();
	    	    		    }
	    	    		      
	    	    		}else if(dap ==2 ){//게시글 수정
	    	    		   System.out.println("1.제목수정 2.내용수정");
	    	    		   int modify = scn.nextInt();scn.nextLine();
	    	    		   int cnt = 0;
    	    		       for(Board boa :list) {
    	    		    	   if(modify == 1) {
    	    		    	     if(id.equals(boa.getUserId())) {   
    	    		    		     System.out.println("수정할 제목을 작성해주세요");
    	    		    		     String title = scn.nextLine();
    	    		    		     Board boar = new Board();
    	    		    		     boar.setBoardNo(no);
    	    		    		     boar.setUserId(id);
    	    		    		     boar.setBoardTitle(title);
    	    		    		     if(bdao.updateTitle(boar)) {
    	    		    		    	 System.out.println("정상작동");
    	    		    		    	 cnt++;
    	    		    		    	 break;
    	    		    		     }
    	    		    	   }
    	    		    	  }else if(modify ==2) {
    	    		    		  if(id.equals(boa.getUserId())) {
    	    		    			  System.out.println("수정할 내용을 작성해주세요");
    	    		    			  String content =scn.nextLine();
    	    		    			  Board boar = new Board();
    	    		    			  boar.setBoardNo(no);
    	    		    			  boar.setUserId(id);
    	    		    			  boar.setBoardCon(content);
    	    		    			  if(bdao.updateContent(boar)) {
     	    		    		    	 System.out.println("정상작동");
     	    		    		    	 cnt++;
     	    		    		    	 break;
     	    		    		     }
    	    		    		  }
    	    		    	  }
    	    		      }if(cnt==0) {
    	    		       System.out.println("권한이 없는 사용자입니다.");
    	    		      }
    	    		       break;
    	    		       
    	    		    }else if( dap ==3 ) {
    	    		    	System.out.println("해당글을 삭제하시겠습니까? yes no");
    	    		    	String yes = scn.nextLine();
    	    		    	int cnt = 0;
    	    		    	for(Board boa :list) {
    	    		    	if(yes.equals(yes)) {
    	    		    		 if(id.equals(boa.getUserId())) {   
    	    		    		     if(bdao.removeBoard(no,id)) {
    	    		    		    	 System.out.println("정상작동");
    	    		    		    	 cnt++;
    	    		    		    	 break;
    	    		    		     }
    	    		    	   }
    	    		    	}
    	    		    	}if(cnt== 0) {
    	    		    		System.out.println("권한이 없는 사용자입니다.");
    	    		    	}break;
    	    		    }
	    	    		
	    	    		 else if(dap == -1) {//종료
	    	    			break;
	    	    		}
	    	     }
	    	 }
	    }//case 1문 전체 끝
	    break;	
	    case 2://게시글 작성
	    	System.out.println("글 제목을 입력하세요");
	    	String title =scn.nextLine();
	    	System.out.println("내용을입력하세요");
	    	String con = scn.nextLine();
	    	System.out.println("해당 카테고리를 입력하세요");
	    	String cate1 = scn.nextLine();
	    	Board board = new Board (id, title, con, cate1);
	    	
	       	if(bdao.insertBoard(board)) {
	       		System.out.println("정상등록");
	       	}else {
	       		System.out.println("등록에러");
	       	}
	    break;
	    
	    case 3: //검색
	    	System.out.println("찾고싶은신 글제목을말히세요");
	    	String title1 = scn.nextLine();
	        int page1 = 1;
	        while(true) {
	        System.out.println("게시글번호 제목 아이디 닉네임 카테고리");
    		System.out.println("======================================");
	    	List<Board> list = bdao.searchList(title1, page1);
	    	for(Board board1 : list) {
	    		System.out.println(board1.getBoardNo() + "   "
	    						  +board1.getBoardTitle() + " "	
	    	                      +board1.getUserId() +  "   "
	    	                      +board1.getUserNic() + "   "
	    	                      +board1.getCate());
	    	}
	    		int totalCnt = bdao.getTotalCnt(title1);
	    		int lastPage = (int) Math.ceil(totalCnt/5.0);
	    		for(int i = 1; i<=lastPage; i++) {
	    			System.out.printf("%3d", 1);
	    		}
	    		System.out.println();
	    		System.out.println("(-1 내용 검색) (-2 종료) (n 찾을페이지)");
	    		System.out.println("페이지 >>");
	    		page1 = scn.nextInt();scn.nextLine();
	    		if(page1 == -2) { //종료
	    			break;
	    		}else if(page1 == -1) {
	    			System.out.println("원하는 내용의 글번호를 눌러주세요");
	    			while (true) { 
		    	    	int no = scn.nextInt(); scn.nextLine();
		    	    	List <Board> list1 = bdao.intoList(no);
		                List<Dabs> dabs =  ddao.getList(no);	 
		    	    	for(Board boa : list1) {
		    	    		
		    	    		System.out.println("====================================================================================================");
		    	    		System.out.println("제목: "+boa.getBoardTitle()+"                   닉네임: "+boa.getUserNic()+"   작성일자: "+boa.getBoardDate());
		    	    	    System.out.println("====================================================================================================");
		    	    		System.out.println("내용");
		    	    		System.out.println(boa.getBoardCon());
		    	    		System.out.println("====================================================================================================");
		    	    		System.out.println("댓글");
		    	    	}
		    	    	for(Dabs dao : dabs) {
		    	    	System.out.println("id: "+dao.getUserId()+"  ||  "+dao.getDap());
		    	    	}
		    	    	
		    	    	System.out.println("=========================================================================================");
		    	    	System.out.println("(나가기 -1) (댓글달기 1) (글수정2)");
		    	    		int dap = scn.nextInt(); scn.nextLine();
		    	    		if(dap == 1) { //댓글 만들기
		    	    			System.out.print("게시판 번호>>");
		    	    			int gae = scn.nextInt();scn.nextLine();
		    	    			System.out.print("\n 해당 아이디 \n");
		    	    			String id1 = scn.nextLine();
		    	    			System.out.println("댓글을 입력하세요");
		    	    			String nae = scn.nextLine();
		    	    					
		    	    		    try {
		    	    		    	Dabs dab = new Dabs(id1,gae,nae);
		    	    		    	if(ddao.insertDab(dab)) {
		    	    		    		System.out.println("등록완료");
		    	    		    		break;
		    	    		    	}else {
		    	    		    		System.out.println("등록에러");
		    	    		    		break;
		    	    		    	}
		    	    		    }catch(Exception e) {
		    	    		    	e.printStackTrace();
		    	    		    }
		    	    		    
		    	    		}else if(dap ==2 ){//게시글 수정
			    	    		   System.out.println("1.제목수정 2.내용수정");
			    	    		   int modify = scn.nextInt();scn.nextLine();
			    	    		   int cnt = 0;
		    	    		       for(Board boa :list) {
		    	    		    	   if(modify == 1) {
		    	    		    	     if(id.equals(boa.getUserId())) {   
		    	    		    		     System.out.println("수정할 제목을 작성해주세요");
		    	    		    		     String title2 = scn.nextLine();
		    	    		    		     Board boar = new Board();
		    	    		    		     boar.setBoardNo(no);
		    	    		    		     boar.setUserId(id);
		    	    		    		     boar.setBoardTitle(title2);
		    	    		    		     if(bdao.updateTitle(boar)) {
		    	    		    		    	 System.out.println("정상작동");
		    	    		    		    	 cnt++;
		    	    		    		    	 break;
		    	    		    		     }
		    	    		    	   }
		    	    		    	  }else if(modify ==2) {
		    	    		    		  if(id.equals(boa.getUserId())) {
		    	    		    			  System.out.println("수정할 내용을 작성해주세요");
		    	    		    			  String content =scn.nextLine();
		    	    		    			  Board boar = new Board();
		    	    		    			  boar.setBoardNo(no);
		    	    		    			  boar.setUserId(id);
		    	    		    			  boar.setBoardCon(content);
		    	    		    			  if(bdao.updateContent(boar)) {
		     	    		    		    	 System.out.println("정상작동");
		     	    		    		    	 break;
		     	    		    		     }
		    	    		    		  }
		    	    		    	  }
		    	    		      }if(cnt==0) {
		       	    		       System.out.println("권한이 없는 사용자입니다.");
		    	    		      }
		    	    		       break;
		    	    		       
		    	    		    }
		    	    		else if(dap == -1) {
		    	    			break;
		    	    		}
		    	     }
	    		}
	        }
	    		break;
	    	
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
 }
}