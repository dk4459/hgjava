package com.yedam.io;

public class Student {
	private int sno;
	private String sname;
	private int score;
	
	public Student(int sno, String sname, int score) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.score = score;
	}
	
	
	public int getSno() {
		return sno;
	}


	public void setSno(int sno) {
		this.sno = sno;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", score=" + score + "]";
	}
	
}
