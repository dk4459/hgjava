package board;

import java.util.Date;

public class User {
	private int userNum = 0 ;
	private String userId ;
	private String userPw ;
	private String userPhone ;
	private String userName;
	private Date userDate ;
	private String userNic ;
	
	public User() {
		
	}
	
	public User(int userNum, String userId, String userPw, String userPhone, String userName, Date userDate,
			String userNic) {
		super();
		this.userNum = userNum;
		this.userId = userId;
		this.userPw = userPw;
		this.userPhone = userPhone;
		this.userName = userName;
		this.userDate = userDate;
		this.userNic = userNic;
	}

	
	public User(String userId, String userPw, String userPhone, String userName, String userNic) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userPhone = userPhone;
		this.userName = userName;
		this.userNic = userNic;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getUserDate() {
		return userDate;
	}

	public void setUserDate(Date userDate) {
		this.userDate = userDate;
	}

	public String getUserNic() {
		return userNic;
	}

	public void setUserNic(String userNic) {
		this.userNic = userNic;
	}
	  
}
