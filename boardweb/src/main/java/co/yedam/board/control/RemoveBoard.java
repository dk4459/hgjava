package co.yedam.board.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.Board;
import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardServiceImpl;
import co.yedam.common.Control;

public class RemoveBoard implements Control{
    @Override
    public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	//service -> boolean removeBoard(int)
    	//mapper -> int deleteBoard(int)
    	//정상삭제되면 목록이동, error페이지로이동.
    	String bno = req.getParameter("bno");
    	
    	
    	BoardService svc = new BoardServiceImpl();
    	if(svc.removeBoard(Integer.parseInt(bno))) {
    		resp.sendRedirect("boardList.do"); 
    	}else {
    		req.setAttribute("message","수정중에러가발생");
    		String path = "board/board.tiles";
    		req.getRequestDispatcher(path).forward(req, resp);
    	}
    }  
}
