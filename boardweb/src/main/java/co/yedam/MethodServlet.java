package co.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.Board;
import co.yedam.board.BoardDAO;

/**
 * Servlet implementation class MethodServlet
 */
@WebServlet(
		name = "methodServ", 
		urlPatterns = { 
				"/methodServ", 
				"/method"
		})
public class MethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MethodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    // init -> service -> destory 
    //요청방식: get방식요청(url 직접 입력, 링크)

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			//등록기능:제목 내용 작성자
			String title = request.getParameter("title"); //요청정보의 값중에서 title에 저장된 값을 읽음
			String content = request.getParameter("content");
			String writer = request.getParameter("writer");
			
			Board board = new Board();
			board.setTitle(title);
			board.setContent(content);
			board.setWriter(writer);
			
			BoardDAO dao = new BoardDAO();
			if(dao.insertBoard(board)) {
				response.getWriter().print("OK");
			}else {
				response.getWriter().print("NG");
			}
			
		
	}

	
	
    //post방식요청 form태그의 method = "post")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한굴처리를 할려면 인코딩을 해야함
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title"); 
		String content = request.getParameter("content");
		String writer = request.getParameter("writer");
		String bno = request.getParameter("bno");
		
		Board board= new Board();
		board.setBoardNo(Integer.parseInt(bno));
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		//파라미터 4개를 가지고와서 게시글번호 1번에대한 값을 변경하는 기능을 넣는다
		BoardDAO dao = new BoardDAO();
		if(dao.updateBoard(board)) {
			response.getWriter().print("OK");
		}else {
			response.getWriter().print("NG");
		}
	}

}
