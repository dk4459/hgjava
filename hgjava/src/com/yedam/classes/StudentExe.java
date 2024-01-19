package com.yedam.classes;


//실행하기 위한 클래스
public class StudentExe {
	
	public static void main(String[] args) {   //호출하지않아도 자동으로 실행되는 메서드(main)
		Student s1 = new Student("S001","홍길동",80,178.9); //인스턴스생성 생성자 호출 
//		s1.sno = "S001";
//		s1.sname = "홍길동";
//		s1.score = 80;                매개변수로 다 설정하였기 때문에 필드가 필요없음
//		s1.height = 178.9;      
		
//	   System.out.println(s1.sno);//같은패캐지안에서만 호출가능 아니면 임포트호출을해줘야함
	   s1.setHeight(-167);
	   System.out.println(s1.getHeight());
	   s1.showInfo();    //메서드 호출
       Student s2 = new Student("S002","김길동"); 
//       s2.score=85;
       s2.showInfo();
       
       Student s3 = new Student("S003","박길동",90);
    	System.out.println(s3.getScore());
    	s3.showInfo();	
	}
	
}
