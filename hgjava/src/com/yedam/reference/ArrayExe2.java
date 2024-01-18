package com.yedam.reference;

import java.util.Scanner;

public class ArrayExe2 {

	public static void main(String[] args) {
	 Scanner scn = new Scanner(System.in);
	
	 boolean isExist = false;
	 
	  System.out.println("친구입력");
	  String name = scn.nextLine();
	  String[] friends = {"홍길동", "김민수", "박석민", "최홍만","신현욱"}	;
	  double [] dblAry = {72.5, 60.5, 88.3, 79.3, 90.4}; 
	  int[] scores = new int[5]; 
	    scores[0]= 78;
		scores[1]= 82;
		scores[2]= 95;
		scores[3]= 90;
		scores[4]= 91;
	 for(int i=0; i<friends.length; i++) {
		if(name.equals(friends[i])) {
			System.out.printf("%s는 %d번방있습니다.\n",name,i+1);
			System.out.printf("%s는 몸무게가 %.1f이고 점수는 %d점입니다.",name,dblAry[i],scores[i]);
			isExist= true;
		}
	}
	int max= 0;
	double weight = 0;
	for (int i= 0; i<scores.length; i++) {
		if(max<scores[i]) {
			name= friends[i];
			weight = dblAry[i];
			max = scores[i];
		}
	}
	 System.out.printf("점수가 제일 높은사람은 %s이고 무게는 %.1f이며 점수는 %d이다",name,weight,max);
	if(!isExist) {
		System.out.println("찾는친구가 없습니다.");
	}
	 
	
	
	}
	

	
	
	
	
	public static void method2(){
		double [] dblAry = {72.5, 60.5, 88.3, 79.3, 90.4};
		//배열의 값 중에서 제일 큰 값을 출력
		double max = 0;
		double min = 0;
		for(int i=0; i<dblAry.length; i++) {
			if(dblAry[0]<dblAry[i]) {
				max = dblAry[i];
			}else if(dblAry[0] > dblAry[i]) {
				min= dblAry[i];
			}
		}
		double avg =0;
		double sum =0;
		for(int i=0; i<dblAry.length; i++) {
			sum += dblAry[i];		
		}
		avg = sum / dblAry.length;
		
		
		System.out.printf("몸무게의 평균값은 %.1f입니다.\n",avg);
		System.out.println("가장 큰값은"+max+"입니다.");
		System.out.println("가장 작은값은"+min+"입니다.");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

		public static void method1() {
		
			int[] scores = new int[10];
			
			scores[3] = 40; //한배열에 한타입만 가능하기때문에 int만가능함
			scores[7] = 50;
			scores = new int[5];  //배열의크기가 설정이 되면 다 초기화값이 됨
			//배열의 크기가 벗어난 인뎃스번호에 설정하면 예외처리가 됨
			scores[0]= 78;
			scores[1]= 82;
			scores[2]= 77;
			scores[3]= 90;
			scores[4]= 80;
			
//			scores= new int[]{78, 82, 88, 90, 85};
			int cnt = 0;
			int cnt1 = 0;
			for(int i=0; i<scores.length; i++) {
				System.out.println("scores["+i+"]=>" + scores[i]);
				if(scores[i]>80) {
					System.out.println("인덱스:"+i);
					cnt++;
					break;
				}
				
				System.out.printf("80점 이상인학생: %d명입니다.",cnt);
				if(scores[i]>90) {
					cnt1++;
				}
				if(cnt1>0) {
					System.out.println("90점이 넘는 사람은"+cnt1+"입니다.");
				}
			}
		}
}
