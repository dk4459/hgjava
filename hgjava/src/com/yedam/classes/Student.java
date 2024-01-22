package com.yedam.classes;

// 학생번호, 이름, 점수, 키:
// 소개(학생번호, 이름, 점수)
public class Student {
    //필드
	private String sno;   //null  private 자기클래스만 사용가능
	private String sname;
	private int score;    //0
	private double height;//0.0
    private boolean onSchool;  
	
	//생성자: 생성자를 선언 안하면 컴파일러가 자동으로 기본생성자(매개값x)를 만든다. 생성자는 반드시 있어야한다.
	
	public Student(String no, String name) {
		this.sno=no;
		this.sname= name;
	}
	public Student(String no, String name, int score) {
		this.sno=no;
		this.sname= name;      
		this.score = score;	
		}
	public Student(String no, String name, int score, double height) {
		this.sno=no;
		this.sname= name;      
		this.score = score;	
		this.height = height;
		}
	//메소드  //반환되는 값이 무조건 있어야함
	public void showInfo() {  //void는 반환하는 값이 없어도됌
		System.out.printf("번호는 %s, 이름은 %s, 점수는 %d입니다. \n",sno,sname,score);
	}
	String showInfoStr() {
		return "번호는" + sno;
	}
	
	//getter setter :private인 접근자에서 다른 사람도 볼수있게끔 할 수 있는 용도
	
	public void setHeight(double height) { //값을 담을때는 set을한다.
		this.height = height;
		if(height <0) {
			this.height = 160;
		}else {
			this.height = height;
		}
	}
	public double getHeight() {
		return this.height;
	}
	public void setSno(String sno) {
		this.sno = sno;
		if(sno.equals("")) {
			this.sno = "10";
		}else {
			this.sno = sno;
		}
	}
//	public boolean isOnSchool() {
//	return onSchool;            //불리언 타입이면 get set 아니라 is를쓴다.
//}
	public String getSno(){
		 return this.sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public void setScore(int score) {
		this.score = score;
		if(score <0) {
			this.score = 0;
		}else {
			this.score= score;
		}
	}
	public int getScore() {
		return this.score;
	}
	
	
}
