package com.yedam.interfaces;

//인터페이스를 구현하는 클래스.
public class MysqlDB implements DAO{
   
	
	@Override
	public void insert() {
		System.out.println("[Mysql] 입력.");
	}
	@Override
	public void update() {
		System.out.println("[Mysql] 수정.");
	}
	@Override
	public void delete() {
		System.out.println("[Mysql] 삭제.");
	}
}
