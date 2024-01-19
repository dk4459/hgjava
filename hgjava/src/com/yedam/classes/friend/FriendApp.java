package com.yedam.classes.friend;

// 등록기능, 수정기능, 삭제기능,목록, 단건조회 기능.

public class FriendApp {
    //필드 선언  :친구정보를 저장할 수 있는 배열
	public Friend[] friends;
	
	//생성자
	FriendApp(){
		friends = new Friend[10];
	}
	
	//등록
	public boolean add(Friend fd) {
		for(int i=0; i<friends.length; i++) {
		  if(friends[i]==null) {
			 fd= friends[i];
			  return true;
			               }
		}
		return false;}
	//수정기능
	public boolean modify(String name, String phone) {
		for(int i=0; i<friends.length; i++) {
			if(friends[i]!= null && friends[i].getName().equals(name)) {
				friends[i].setPhone(phone);
				return true;
			}
		}return false;
	}
	//삭제기능
	public boolean remove(String name) {
		for(int i=0; i<friends.length; i++) {
			if(friends[i]!= null && friends[i].getName().equals(name)) {
				friends[i]=null;
				return true;
			}
		}return false;
	}
	
	//단건조회 기능
	public Friend jo(String name) {
		for(int i=0; i<friends.length; i++) {
			if(friends[i]!= null && friends[i].getName().equals(name)) {
				return friends[i];
	}
} return null;
}
	}