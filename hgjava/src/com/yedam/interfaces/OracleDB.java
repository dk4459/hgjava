package com.yedam.interfaces;

public class OracleDB implements DAO{

	 public void insert() {
		 System.out.println("[oracle] 입력");
	 }
	 public void update() {
		 System.out.println("[oracle] 수정");
	 }
	 public void delete() {
		 System.out.println("[oracle] 삭제");
	 }
}
