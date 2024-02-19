package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;


public class BoardDAO {
	Connection conn; 
	PreparedStatement psmt;
	PreparedStatement psmt1;
	ResultSet rs;
	String sql;
	
	void disconn() {
		try {
		  if(conn != null) {	
		   conn.close();
		} if(psmt != null) {
			 psmt.close();
		} if(rs != null) {
			rs.close();
		}
	   }
		catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	//게시글 목록
	public List<Board> getList(String cate, int page){
		conn = DAO1.getConn();
		List<Board> list = new ArrayList<>();
		sql = "select   b.board_no   , "
				+ "       b.board_title , "
				+ "       b.board_con , "
				+ "       u.user_id, "
				+ "       u.user_nic , "
				+ "       b.board_date , "
				+ "       b.cate "
				+ "from \r\n"
				+ "     (Select rownum rn, a.* "
				+ "      FROM "
				+ "          (Select * "
				+ "           FROM boards "
				+ "           WHERE cate = NVL(?,'자유') "
				+ "           ORDER BY board_date DESC) a) b join users u "
				+ "                                    ON (b.user_id = u.user_id) "
				+ "WHERE b.rn >  ( ? - 1 ) *5 "
				+ "And   b.rn <= ? * 5 ";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cate);
			psmt.setInt(2, page);
			psmt.setInt(3, page);
			rs = psmt.executeQuery();
			while(rs.next()) {
			Board board  = new Board();
			board.setBoardNo(rs.getInt("board_no"));
			board.setBoardTitle(rs.getString("board_title"));
			board.setBoardCon(rs.getString("board_con"));
			board.setUserId(rs.getString("user_id"));
			board.setUserNic(rs.getString("user_nic"));
			board.setBoardDate(rs.getDate("board_date"));
			board.setCate(rs.getString("cate"));
			list.add(board);
			
			}
		}catch(SQLException e) {
			
		}finally {
			disconn();
		}
		return list;
	}
	//페이지
    public int getTotalCnt(String cate) {
    	conn = DAO1.getConn();
    	sql = "select count(*) as cnt "
    			+ " from boards " 
    			+" where cate = nvl(?,'유머') ";
    	try {
    		psmt = conn.prepareStatement(sql);
    		psmt.setString(1, cate);
    		rs = psmt.executeQuery();
    		if(rs.next()) {
    			return rs.getInt(1); //첫번째 칼럼에 있는 값을 반한하겠다.
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}finally {
			  disconn();
		}
    	return -1;
    }
   //들어가서 내용보기
    public List<Board> intoList(int no){
    	conn = DAO1.getConn();
		List<Board> list = new ArrayList<>();

		sql = "SELECT b.board_no, "
				+ "        b.board_title, "
				+ "        b.board_con, "
				+ "        b.user_id, "
				+ "        u.user_nic, "
				+ "        b.board_date, "
				+ "        b.cate "
				+ "FROM boards b JOIN users u "
				+ "              ON(b.user_id = u.user_id) "        
				+ " WHERE b.board_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			rs = psmt.executeQuery();
			while(rs.next()) {
			Board board  = new Board();
			board.setBoardNo(rs.getInt("board_no"));
			board.setBoardTitle(rs.getString("board_title"));
			board.setBoardCon(rs.getString("board_con"));
			board.setUserId(rs.getString("user_id"));
			board.setUserNic(rs.getString("user_nic"));
			board.setBoardDate(rs.getDate("board_date"));
			board.setUserId(rs.getString("user_id"));
			board.setCate(rs.getString("cate"));
			list.add(board);
			
			}
		}
		catch(Exception e) {
			System.out.println("정확한 게시글번호를 적어주세요");
			

		}finally {
			disconn();
		}
		return list;
    }
    //게시글 작성
    public boolean insertBoard(Board board) {
		conn=DAO1.getConn();
		sql ="INSERT INTO boards(     board_no, "
				+ "                   user_id, "
				+ "                   board_title, "
				+ "                   board_con, "
				+ "                   board_date, "
				+ "                   cate) "
				+ "VALUES (board_seq.nextval,?,?,?,sysdate,?)";
	
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, board.getUserId());
			psmt.setString(2,board.getBoardTitle());
			psmt.setString(3, board.getBoardCon());
			psmt.setString(4, board.getCate());
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			disconn();
		}return false;
	}
    //검색
    public List<Board> searchList(String title, int page){
    	conn=DAO1.getConn();
    	List<Board> list = new ArrayList<>();
    	sql ="SELECT      b.board_no,\r\n"
    			+ "       b.board_title,\r\n"
    			+ "       u.user_id,\r\n"
    			+ "       u.user_nic,\r\n"
    			+ "       b.board_date,\r\n"
    			+ "       b.cate\r\n"
    			+ "FROM    (SELECT rownum rn, a.*\r\n"
    			+ "         FROM \r\n"
    			+ "            (SELECT *\r\n"
    			+ "             FROM boards\r\n"
    			+ "             WHERE board_title LIKE '%'||?||'%'\r\n"
    			+ "             ORDER BY board_no DESC)a)b join users u\r\n"
    			+ "                                    ON(b.user_id = u.user_id)\r\n"
    			+ "WHERE b.rn > ( ? - 1) *5 "
    			+ "AND b.rn <= ? * 5";
    	try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, title);
            psmt.setInt(2, page);
            psmt.setInt(3, page);
            rs=psmt.executeQuery();
            while(rs.next()) {
            	Board board = new Board();
            	board.setBoardNo(rs.getInt("board_no"));
            	board.setBoardTitle(rs.getString("board_title"));
            	board.setUserId(rs.getString("user_id"));
            	board.setUserNic(rs.getString("user_nic"));
            	board.setBoardDate(rs.getDate("board_date"));
            	board.setCate(rs.getString("cate"));
            	list.add(board);
            }
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			disconn();
		}
    	return list;
    	
    }
    //제목수정
    public boolean updateTitle(Board bor) {
    	conn = DAO1.getConn();
    	sql = "UPDATE boards\r\n "
    			+ "SET board_title = ?\r\n "
    			+ "WHERE user_id = ?\r\n "
    			+ "AND board_no = ?";
    	try {
    		psmt=conn.prepareStatement(sql);
    		psmt.setString(1, bor.getBoardTitle());
    		psmt.setString(2, bor.getUserId());
    		psmt.setInt(3, bor.getBoardNo());
    		int r = psmt.executeUpdate();
    		if(r>0) {
    			return true;
    		}
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}return false;
    }
    //내용수정
    public boolean updateContent(Board bor) {
    	conn = DAO1.getConn();
    	sql = "UPDATE boards   "
    			+ "SET board_con = ?  "
    			+ "WHERE user_id = ?  "
    			+ "AND board_no = ? ";
    	try {
    		psmt=conn.prepareStatement(sql);
    		psmt.setString(1, bor.getBoardCon());
    		psmt.setString(2, bor.getUserId());
    		psmt.setInt(3, bor.getBoardNo());
    		int r = psmt.executeUpdate();
    		if(r>0) {
    			return true;
    		}
    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}return false;
    }
    //게시글 삭제
    public boolean removeBoard(int no, String id) {
    	conn= DAO1.getConn();
    	String sql1 = "DELETE dabs "
    			+ "WHERE board_no = ? "
    			+ "OR user_id = ?  ";
    	sql ="DELETE boards "
    		+ "WHERE board_no = ?"
    		+ "AND user_id = ? ";
    	 try {
    		psmt1 = conn.prepareStatement(sql1);
    		psmt1.setInt(1, no);
    		psmt1.setString(2, id);
    		
    		int e = psmt1.executeUpdate();
			psmt =conn.prepareStatement(sql);
			psmt.setInt(1, no);
			psmt.setString(2, id);
			
			int r =psmt.executeUpdate();
			if(e<2) {
			   if(r>0) {
				return true;
			   }
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			disconn();
		}
		return false;
    }  
    	
  //자기글 조회
  		public List<Board> getMyList(String id, int page){
  			conn = DAO1.getConn();
  			List<Board> list = new ArrayList<>();
  			sql = "select   b.board_no   , \r\n"
  					+ "         b.board_title , \r\n"
  					+ "         b.board_con , \r\n"
  					+ "             u.user_id, \r\n"
  					+ "		     u.user_nic , \r\n"
  					+ "			     b.board_date , \r\n"
  					+ "			     b.cate \r\n"
  					+ "				from \r\n"
  					+ "			     (Select rownum rn, a.* \r\n"
  					+ "			    FROM \r\n"
  					+ "		         (Select * \r\n"
  					+ "			         FROM boards \r\n"
  					+ "		         WHERE user_id = ? \r\n"
  					+ "		         ORDER BY board_date DESC) a) b join users u \r\n"
  					+ "			                                  ON (b.user_id = u.user_id) \r\n"
  					+ "				WHERE b.rn >  ( ? - 1 ) *5 \r\n"
  					+ "				And   b.rn <= ? * 5  ";
  			
  			try {
  				psmt = conn.prepareStatement(sql);
  				psmt.setString(1, id);
  				psmt.setInt(2, page);
  				psmt.setInt(3, page);
  				rs = psmt.executeQuery();
  				while(rs.next()) {
  				Board board  = new Board();
  				board.setBoardNo(rs.getInt("board_no"));
  				board.setBoardTitle(rs.getString("board_title"));
  				board.setBoardCon(rs.getString("board_con"));
  				board.setUserId(rs.getString("user_id"));
  				board.setUserNic(rs.getString("user_nic"));
  				board.setBoardDate(rs.getDate("board_date"));
  				board.setCate(rs.getString("cate"));
  				list.add(board);
  				
  				}
  			}catch(SQLException e) {
  				
  			}finally {
  				disconn();
  			}
  			return list;
  		}
    
}
