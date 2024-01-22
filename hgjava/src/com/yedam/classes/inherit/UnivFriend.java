package com.yedam.classes.inherit;

import lombok.Data;

@Data
public class UnivFriend extends Friend {
    
	//학교,전공
	private String univ;
	private String major;
	
	@Override
	public void changeInfo(String info1, String info2) {
		super.changeInfo(info1, info2);
		this.univ = info1;
		this.major = info2;
	}	
	
//		 public String toString {
//			return super.toString()+",학교는"+ univ + "전공은" + major;
//		}
	
}
