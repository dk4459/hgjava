package co.yedam.board.mapper;

import java.util.List;

import co.yedam.board.Board;
import co.yedam.board.Book;
import co.yedam.common.SearchVO;

public interface BoardMapper {
	 List<Board> boardList(SearchVO search);
	 int getTotalCnt(SearchVO search);
	 
	 //상세화면 사용될 데이터.
	 Board selectBoard(int bno);
	 
	 // 조회수 증가
	 int updateCount(int bno);  //update delete insert 무조건 반환 값이 int다
	 
	 //글수정
	 boolean updateBoard(Board board);
	 
	 //글삭제
	 boolean removeBoard(int bno);
	 //글등록
	 int insertBoard(Board board);
	 
	 // 도서목록.
	 List<Book> bookList();
	 //도서 등록
	 int insertBook(Book book);
	 //도서 삭제
	 int removeBook(Book book);
}
