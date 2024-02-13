package com.yedam.classes.nested;

class Parent{
	String name;
	void showName() {
		System.out.println("이름은"+name);
	}
}

interface Ruunable{
	void run();     //함수형 인터페이스.=>(구현해야할 메소드가 하나만 존재)
}

public class AnonymousExe {
	public static void main(String[] args) {
		//익명구현객체.
		Runnable runnable =new Runnable() {  

			@Override
			public void run() {
				System.out.println( "나는 달립니다.");
			}
		};
		 	
		runnable = () -> System.out.println("너는 달립니다."); //람다식 표현
		runnable.run();                                      //위에 4줄을 한줄로 표현
		
		
	   Parent parent = new Parent() {       //익명자식객체.
		   int age; 
		   void showInfo(String name, int age) {
			   this.name = name;
			   this.age = age;
			   System.out.println("이름은"+name+", 나이는"+age);
		   }
		   @Override
		void showName() {
//   		System.out.println("이름은"+ name +"입니다.");
			showInfo("홍길동",20);
		}
	   };
	   
	   parent.showName();
//	   parent.showInfo(); 자식메소드는 부모가 사용못함
	}
}
