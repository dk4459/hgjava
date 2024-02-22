package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.control.BoardControl;
import co.yedam.board.control.BoardListControl;

//init -> service -> destroy.
public class FrontController extends HttpServlet{
   
  //Map타입으로 url과 실행할 클래스.
	Map<String, Control> controls;
	
	public FrontController(){
		controls = new HashMap<>();	
	}
  //init. 최초한번 실행
	@Override
	public void init(ServletConfig config) throws ServletException {
		controls.put("/resume.do", new ResumeForm());
		controls.put("/main.do", new MainControl());
		//게시글 목록 이동컨트롤
		controls.put("/boardList.do", new BoardListControl());
		controls.put("/board.do", new BoardControl());
		
	}
	
   //service. 요청할때 마다 실행
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String uri = req.getRequestURI();
		 String context = req.getContextPath();
		 String path = uri.substring(context.length());
		 Control control = controls.get(path);
		 control.exec(req, resp); //요청url과 실행컨트롤을 호출
 	}
}
