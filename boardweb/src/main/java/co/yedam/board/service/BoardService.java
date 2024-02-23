package co.yedam.board.service;

import java.util.List;

import co.yedam.board.Board;
import co.yedam.common.SearchVO;

public interface BoardService {
	List<Board> boardList(SearchVO search);
	int boardTotalCnt(SearchVO search);
	
	//단건조회.
	Board getBoard(int bno);
	
	//업데이트
	boolean modifyBoard(Board board);
	//삭제
	boolean removeBoard(int no);
	//게시글 넣기
	boolean addBoard(Board board);
}
