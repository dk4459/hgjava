package co.yedam.board.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.Board;
import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardServiceImpl;
import co.yedam.common.Control;

public class ModifyBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		Board board = new Board();
		board.setBoardNo(Integer.parseInt(bno));
		board.setTitle(title);
		board.setContent(content);
		
		// boolean modifBoard(Board)
		BoardService svc = new BoardServiceImpl();
		
		if(svc.modifyBoard(board)) {
			resp.sendRedirect("boardList.do"); //★포워딩은 파라메타 값을 넘겨줄 수 있고 sendredirect는 파라메타값을 넘겨줄수 없음★
		}else {
			req.setAttribute("message", "수정중 에러가 발생했습니다.");
			String path = "board";
			req.getRequestDispatcher(path).forward(req, resp);
		}
	}

}
