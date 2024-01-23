package com.yedam.interfaces;

public interface DAO {
	
	//상수필드 선언 
	int VER = 1; 
	//규칙.
	public void insert();
	public void update();
	public void delete();
}
