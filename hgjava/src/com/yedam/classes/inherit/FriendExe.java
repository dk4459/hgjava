package com.yedam.classes.inherit;

import java.util.Scanner;

public class FriendExe {
	//사용자 입력/처리결과 출력 => 컨트롤
    public static void main(String[] args) {
    	Scanner scn = new Scanner(System.in);
    	boolean run = true;
    	FriendApp app= new FriendApp();
    	
    	while(run) {
    		System.out.println("1.등록 2.조회 3.수정 4.삭제 9.종료");
    		int menu = Integer.parseInt(scn.nextLine());
    		
    		switch(menu) {
    		case 1: //등록  1)이름연락처 2)학교친구 3)회사친구
    			System.out.println("1.친구 2.회사 3.학교");
    			int subMenu = Integer.parseInt(scn.nextLine());
    			System.out.println("이름>>");
    			String name= scn.nextLine();
    			System.out.println("연락처>>");
    			String phone= scn.nextLine();
    			
    			Friend friend = null;
    			if(subMenu == 1) {
    				friend=new Friend();
    				friend.setName(name);
    				friend.setPhone(phone);
    				
    			}else if (subMenu == 2) {
    				
    			ComFriend cfriend=new ComFriend();
    				cfriend.setName(name);
    				cfriend.setPhone(phone);
    				System.out.println("회사>>");
        			String company= scn.nextLine();
        			System.out.println("부서>>");
        			String dept= scn.nextLine();
    				cfriend.setCompany(company);
    				cfriend.setCompany(dept);
    				
    				friend = cfriend;
    				
    			}else if(subMenu ==3) {
    				UnivFriend ufriend=new UnivFriend();
    				ufriend.setName(name);
    				ufriend.setPhone(phone);
    				System.out.println("학교>>");
        			String univ= scn.nextLine();
        			System.out.println("전공>>");
        			String major= scn.nextLine();
    				ufriend.setUniv(univ);
    				ufriend.setMajor(major);
    				
    				friend = ufriend;
    			}
    			
    			
    			if(app.add(friend)) {
    				System.out.println("정상등록");
    			}else {
    				System.out.println("등록 안됨");
    			}
    			break;
    		case 2://목록(이름)
    			System.out.println("조회할 이름>>>");
    			String fname = scn.nextLine();
    			Friend[] list = app.list(fname);
    			for(int i=0; i<list.length; i++) {
    				if(list[i] != null) {
    					System.out.println(list[i].toString());
    				}
    			}
    			
    		break;
    		
    		case 3: //수정
    			System.out.println("수정할 전화번호>>>");
    			String fphone = scn.nextLine();
    			Friend frnd = app.getFriend(fphone);
    			String info1 = "", info2="";
    			if (frnd instanceof UnivFriend) {
    				System.out.println("학교>>");
    				info1 = scn.nextLine();
    				System.out.println("전공>>");
    				info2 = scn.nextLine();
    			}else if(frnd instanceof ComFriend) {
    				System.out.println("회사>>");
    				info1= scn.nextLine();
    				System.out.println("부서>>");
    				info2 = scn.nextLine();
    			}
    			
    			if(app.modify(fphone, info1, info2)) {
    				System.out.println("수정완료");
    			}else {
    				System.out.println("잘못입력");
    			}
    			break;
    			
    		case 4://삭제
    			System.out.println("삭제할 전화번호>>>");
    			String rphone = scn.nextLine();
    			
    			
    			if(app.remove(rphone)) {
    				System.out.println("삭제가 완료되었습니다.");
    			}else{
    				System.out.println("삭제하지못하였습니다.");
    			}
    			break;
    		}
    	}//end of while
    	System.out.println("end of prog.");
    	
	}
}
