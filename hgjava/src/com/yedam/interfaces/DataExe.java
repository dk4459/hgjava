package com.yedam.interfaces;

public class DataExe {
   public static void main(String[] args) {
	  // Mysql vs. Oracle
	 // MysqlDB mysql = new MysqlDB();
	  //OracleDB oracle = new OracleDB();  //객체생성시 사용하면 변경할때 다 메서드를 바꿔야해서
	  DAO dao = new OracleDB(); 										//인터페이스를 사용한다.	
	  int menu =0;                       
	  if(menu ==1) {
//		  mysql.insert();
//		  oracle.add();
		  dao.insert();
	  }else if (menu==2) {
//		  mysql.update();
//		  oracle.modify();
		  dao.update();
	  }else if (menu == 3) {
//		  mysql.delete();   //인터페이스와 추상클래스의 차이점은 인터페이스는 메소드선언과 상수필드만 생성가능
//		  oracle.remove();  //추상클래스는 생성자와 필드생성이 가능하다
		  dao.delete();     //공통점은 둘 다 객체생성은 불가능하다. 
	  }
   }
}
