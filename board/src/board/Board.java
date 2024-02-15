package board;

import java.util.Date;

public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardCon;
	private String userId;
	private Date boardDate;
	private String boardCom;
	private String cate;
	private String userNic;
	private String dap;
	
	public Board() {
		
	}

	public Board(int boardNo, String boardTitle, String boardCon, String userId, Date boardDate, String boardCom,
			String cate, String userNic) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardCon = boardCon;
		this.userId = userId;
		this.boardDate = boardDate;
		this.boardCom = boardCom;
		this.cate = cate;
		this.userNic = userNic;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardCon() {
		return boardCon;
	}

	public void setBoardCon(String boardCon) {
		this.boardCon = boardCon;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public String getBoardCom() {
		return boardCom;
	}

	public void setBoardCom(String boardCom) {
		this.boardCom = boardCom;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public String getUserNic() {
		return userNic;
	}

	public void setUserNic(String userNic) {
		this.userNic = userNic;
	}

	public String getDap() {
		return dap;
	}

	public void setDap(String dap) {
		this.dap = dap;
	}
	
	
	
}
