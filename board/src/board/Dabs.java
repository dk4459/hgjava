package board;

public class Dabs {

	private String userId ;
	private int boardNO;
	private String dap;
	
	public Dabs() {
		
	}
	public Dabs(String userId, int boardNO, String dap) {
		super();
		this.userId = userId;
		this.boardNO = boardNO;
		this.dap = dap;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getBoardNO() {
		return boardNO;
	}
	public void setBoardNO(int boardNO) {
		this.boardNO = boardNO;
	}
	public String getDap() {
		return dap;
	}
	public void setDap(String dap) {
		this.dap = dap;
	}
	
	
	
}
