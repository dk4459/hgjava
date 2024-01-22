package com.yedam.classes;

//담임선생님.
public class HighStudent extends Student {
    private String teacher;
    
//    public HighStudent() {
//    	super();
//    }
    
    public HighStudent(String sno, String name) {
    	super(sno, name);           //super는 부모를 가르킴
    }
    
    public HighStudent(String sno, String name, int score, String teacher) {
    	super(sno,name,score);
    	this.teacher = teacher;
    }

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
    
	//부모메서드를 재정의(overriding)
	public void showInfo() {
		//자식클래스:teacher 추가 출력.
		System.out.printf("번호는 %s, 이름은 %s, 점수는 %d 선생님의 이름은 %s입니다. \n", this.getSno(), getSname(),getScore(),teacher);
	}
    
}
