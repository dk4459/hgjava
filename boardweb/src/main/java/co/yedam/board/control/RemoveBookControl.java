package co.yedam.board.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.Book;
import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardServiceImpl;
import co.yedam.common.Control;

public class RemoveBookControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
      resp.setContentType("text/json;charset=utf-8");
      
      String bcode = req.getParameter("bcode");
      
      BoardService svc = new BoardServiceImpl();
      Book book = new Book();
	  book.setBookCode(bcode);
	  
	  try {
		 if(svc.removeBook(book)) {
			// {"retCode" : "OK"}
		    	resp.getWriter().print("{\"retCode\":\"OK\"}");
		 }
	  }catch (Exception e){
			e.printStackTrace();
	    	resp.getWriter().print("{\"retCode\" : \"NG\"}");
	  }
	}
}
