package com.yedam.reference;

import java.util.Scanner;

//친구의 정보를 저장하고 변경하고... 관리.
//Create, Read, Update, Delete
public class FriendExe {
	
		public static void main(String[] args) {
			Scanner scn = new Scanner(System.in);
			boolean run = true;
			Friend[] friends = new Friend[5]; // {null,null,null,null,null}
			int score = 0;
			
			double weight = 0;
			while(run) {
				System.out.println("1.등록 2.조회 3.수정 4.삭제 5.점수조회 6.분석 9.종료");
																//5번 입력점수 이상인친구.
															    //6번 평균점수:85, 최고점수: 90점
				int menu = Integer.parseInt(scn.nextLine());
				switch(menu) {
				case 1: //등록
					
					score = -1;
					weight = 0.0;
					System.out.print("이름>>>");
					String name = scn.nextLine();
					if(name.equals("")) {
						System.out.println("이름을입력해주세요");
						break;
					}
					System.out.print("몸무게>>>");
					weight = Double.parseDouble(scn.nextLine());
					if(weight==0.0) {
						System.out.println("몸무게를 입력해주세요");
						break;
					}
					System.out.print("점수>>>");	
					score = Integer.parseInt(scn.nextLine());
					if(score == -1) {
						System.out.println("점수를입력해주세요");
						break;
					}
					Friend friend = new Friend();
					friend.name = name;
					friend.weight = weight;
					friend.score = score;
					
					//비워있는 위치 찾아서 한건입력 종료
					for(int i=0; i<friends.length; i++) {
						if(friends[i]==null) {
							friends[i] = friend;
						}	
					}
					
					System.out.println("정상적으로 입력되었습니다.");
					break;
						
				case 2: //조회
					//전체목록.. 이름:홍길동, 몸무게: 77.2kg 점수:80점.
					System.out.println("찾을 친구 >>>");
					String fname= scn.nextLine();
					for(int i=0; i<friends.length; i++) {
						if(friends[i]!=null && friends[i].name.equals(fname)) {
							System.out.printf("%s의 몸무게는%.1f이고 성적은 %d점입니다.\n",friends[i].name,friends[i].weight,friends[i].score);
							break;
					 }
					}
					break;
				case 3: //점수 수정
					boolean exist = false;
					weight = -1;
					score = -1;
					System.out.print("이름>>>");
					name = scn.nextLine();
					System.out.print("수정 몸무게>>>");
					String sweight = scn.nextLine();
					if(!sweight.equals("")) {
						weight = Double.parseDouble(sweight);
					}
					System.out.print("점수>>>");
					String sscore= scn.nextLine();
					if(!sscore.equals("")) {
						score = Integer.parseInt(sscore);
					}
					for(int i=0; i<friends.length; i++) {
						if(friends[i] != null && friends[i].name.equals(name)) {
							friends[i].score = (score != -1) ? score : friends[i].score;
							friends[i].weight = (weight != -1) ? weight : friends[i].score;
							exist = true;
						}
					}
					if(!exist) {
						System.out.println("찾지못하였습니다.");
					}
					
					System.out.println("수정완료");
					break;
				case 4: //삭제
					System.out.print("삭제할 이름>>>");
					name = scn.nextLine();
					 for (int i=0; i<friends.length; i++) {
						 if(friends[i] != null && friends[i].name.equals(name));{
						     friends[i] =null;
						     break;
	                       }
					 }
					 System.out.println("삭제완료가 되엇습니다.");
					 break;
				case 5: 	
					System.out.println("몇점이상하시겠습니까");
					int wja = Integer.parseInt(scn.nextLine());				             
					int cnt = 0;
					for(int i=0; i<friends.length; i++) {
						if(friends[i]!=null && friends[i].score>wja){
						    cnt += friends[i].score; 
							System.out.printf("80점이 넘는 사람은 %s입니다\n",friends[i].name);
						}
						}
						if(cnt==0) {
							System.out.println("80점이상인 사람이 없습니다.");
						}break;
				case 6:
					double avg = 0;
					int max = 0;
					int sum = 0;
				    String str ="";
				    int cnt1 = 0;
					for(int i=0; i < friends.length; i++) {
						if( friends[i] != null ) {
						sum += friends[i].score;
						cnt1++;
						avg = (double)sum/cnt1; 
						}
					}
					for(int i=0; i < friends.length; i++) {
						if (friends[i] !=null && max<friends[i].score) {
							max = friends[i].score;
							str = friends[i].name;
						}
					}
					System.out.printf("학생들의 총점은 %d이고평균점수는 %.1f이다\n",sum ,avg);
					System.out.printf("최고점수의 학생은 %s 이며 최고점은 %d 이다\n",str, max);
					 break;
				case 9: //종료
					run = false;
					System.out.println("프로그램 종료");
				}
			}
			System.out.println("end of prog.");
		}
}
