package com.yedam.classes;

public class HighStudentExe {

	public static void main(String[] args) {
		HighStudent hiStd = new HighStudent("T001","홍길동",90,"김쌤");
		
		System.out.println(hiStd.getSno());     //highschool의 부모생성자School까지 가져올수 있음.
		System.out.println(hiStd.getTeacher());
		hiStd.showInfo();                       //부모클래스의 멤버
		
		//부모클래스의 참조변수에 자식클래스의 인스턴스를 대입
		System.out.println("------------------------------");
		Student std = new HighStudent("T2002","박길동",80,"김쌤");  //부모=자식간은 자동 형병환이 가능함;
		if(std instanceof HighStudent) {
		HighStudent hstd = (HighStudent) std; //Student타입.  자식 = 부모 강제형변환
		System.out.println(hstd.getTeacher());    //부모의 참조변수의 선언은 가능하지만 Student 생성자에 getTeacher라는 기능을 담지 안했기 
		}                                          //때문에 사용은 불가능
		Student std1 = new Student("S003","박석민",80);
		if(std1 instanceof HighStudent) {
		HighStudent hstd1 = (HighStudent) std1;  //담겨진게 부모의 인스턴스는 highstudent로 안담았기때문에
		System.out.println(hstd1.getTeacher());   //형병환 불가능하다
		}
		
		System.out.println("-------------------------------------");
		Student[] students = new Student[10];
//		HighStudent[] hiStudents = new HighStudent[10];
		students[0] = new Student("S001","김민석",90);
		students[1] = hiStd;            //HistStudent
		for(int i=0; i<students.length; i++) {
			if(students[i]!=null) {
				students[i].showInfo();
			}
		}
		
		long lnl= 10;   //큰범위의 변수 - (큰 범위변수)적은범위 값 자동형병환
		int n1 = (int) lnl; //강제형병환
	}

}
