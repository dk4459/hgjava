package todo;

import java.util.Scanner;

public class Todo117dab {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
     String[] strAry = new String[6];
     int idx = 0;
     for(int i=1; i<=3; i++) {
    	 System.out.println("이름>>>>");
    	 strAry[idx++] =scn.nextLine();
    	 System.out.println("연락처>>>");
    	 strAry[idx++]= scn.nextLine();  //0번방에서 바로 입력
     }
     for(int i=0; i < strAry.length; i++) {
    	 if(i%2 == 0) {//이름출력
    		 System.out.println("이름:"+strAry[i]);
    	 }else{
    		 System.out.println("연락처:"+strAry[i]);
    		 System.out.println("==============");
    	 }
     }
	}

}
