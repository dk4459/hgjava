package com.yedam.classes.friend;


//친구이름, 연락처, 나이 :관리.
public class Friend {
		//필드
		public String sname;
		public String sphone;
		public int sage;
		
		public Friend(String name, String phone, int age ){
			this.sname= name;
			this.sphone= phone;
			this.sage = age;
		}
		
		void info() {
			System.out.printf("이름: %s 폰번호: %s 나이: %d세",sname,sphone,sage);
		}
		
		public void setName(String name) { //값을 담을때는 set을한다.
			this.sname = name;
			
		}
		public String getName() {
			return this.sname;
		}
		public void setPhone(String phibe) {
			this.sphone = sphone;
			
		}
		public String getPhone(){
			 return this.sphone;
		}
}
