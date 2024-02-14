package com.yedam.phonebook;

//기능은 c:temp/userList.txt에 저장된 아이디 비번을 이용.
public class UserManager {
	private String id;
	private String pw;

	public UserManager(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	public UserManager() {
		
	}
	
	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

}
