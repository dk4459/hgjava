package todo;

import java.util.Scanner;

import com.sun.xml.internal.bind.v2.runtime.Name;

public class Todo117 {

	public static void main(String[] args) {
//친구 3명의 이름과 연락처를 입력하도록.. 메시지출력
		Scanner scn =new Scanner(System.in);
		Scanner scn1 =new Scanner(System.in);
		String name ;
		String phone;
		String name1 ="";	
		String phone1 ="";
		
//		String[] name2 = new String[5];
//		String[] phone2 = new String[5];
		String[]name2 = name1.split("");
		String[]phone2 = phone1.split("");
		//입력완료.
		
			  
		  for(int j=1; j<=3; j++) {
		  System.out.println("이름을 입력하세요");
		  name = scn.nextLine();
		  System.out.println("전화번호를 입력하세요");
		  phone = scn1.nextLine();
		  name1 +=name;
		  phone1 += name;
		  }
		  
//		for(int i=0; i<=name2.length; i++) {
//			System.out.println("이름 : "+name2[i]);
//			System.out.println("전화번호 : "+phone2[i]);
//			System.out.println("=================");
//		}
       System.out.println(name2[0]);
		//이름 홍길동
		//연락처 : 010-1111-2222
		//=====================
		//이름 김길동
		//연락처:010-2222-3333
		//===================
		//이름 박길동
		//연락처:010-3333-4444
		//===================
	

}
}

		
