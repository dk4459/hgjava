package co.yedam.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.board.Board;
import co.yedam.board.Book;
import co.yedam.board.mapper.BoardMapper;
import co.yedam.common.DataSource;
import co.yedam.common.SearchVO;

//업무 로직을 담고 있는 프로세스.
//데이터처리는 mapper 기능.
public class BoardServiceImpl implements BoardService{

	SqlSession session = DataSource.getInstance().openSession(true); //이렇게하면 자동커밋을한다.
	BoardMapper mapper = session.getMapper(BoardMapper.class);//보드매퍼 객체를 만든다. BoardMapper.class
	//목록보여주기
	@Override
	public List<Board> boardList(SearchVO search) {
		System.out.println(search);
		return mapper.boardList(search);
	}
	
	//총 페이지수 갖고오기
	@Override
	public int boardTotalCnt(SearchVO search) {
		return mapper.getTotalCnt(search);
	}
	
	//한건조회하고 조회하면 조회수 증가하기
	@Override
	public Board getBoard(int bno) {
		mapper.updateCount(bno);
		return mapper.selectBoard(bno);
	}
	//업데이트 처리
	public boolean modifyBoard(Board board) {
	   if(mapper.updateBoard(board)) {
	      return true;
	   }return false;
	}
	//삭제
	public boolean removeBoard(int bno){
		if(mapper.removeBoard(bno)) {
			return true;
		}return false;
	}
	
	//추가
	public boolean addBoard(Board board) {
		return mapper.insertBoard(board) == 1;
	}
	@Override
	public List<Book> bookList() {
		return mapper.bookList();
	}
	@Override
	public boolean addBook(Book book) {
		return mapper.insertBook(book) == 1;
	}
	 public boolean removeBook(Book book) {
			
			return mapper.removeBook(book) == 1;
	}
}
