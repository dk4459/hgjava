package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.control.AddBoard;
import co.yedam.board.control.AddForm;
import co.yedam.board.control.BoardControl;
import co.yedam.board.control.BoardListControl;
import co.yedam.board.control.ModifyBoard;
import co.yedam.board.control.RemoveBoard;
import co.yedam.board.control.RemoveForm;
import co.yedam.board.control.UpdateForm;
import co.yedam.member.control.AddMemberControl;
import co.yedam.member.control.AddMemberForm;
import co.yedam.member.control.LoginControl;
import co.yedam.member.control.LoginForm;
import co.yedam.member.control.LogoutControl;
import co.yedam.member.control.MemberListForm;

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
	    controls.put("/updateForm.do", new UpdateForm()); //수정화면으로 이동
	    controls.put("/modifyBoard.do", new ModifyBoard()); //수정처리후 목록
	    controls.put("/removeForm.do", new RemoveForm()); //삭제화명으로 이동
	    controls.put("/removeBoard.do", new RemoveBoard());//삭제처리후 목록
	    controls.put("/addForm.do", new AddForm());
	    controls.put("/addBoard.do", new AddBoard());
	    //회원관련
	    controls.put("/loginForm.do", new LoginForm());
	    controls.put("/login.do", new LoginControl());
	    controls.put("/logout.do", new LogoutControl());
	    
	    //회원등록.
	    controls.put("/addMember.do", new AddMemberControl());
	    controls.put("/addMemberForm.do", new AddMemberForm());
	    
	    //기타
	    controls.put("/memberList.do", new MemberListForm());
	    controls.put("/productList.do", new  ProductListControl());
	    controls.put("/cartList.do", new CartListControl());
	    
	    //자바스크립트 연습
	    controls.put("/userList.do", new UserListControl());
	}
   //service. 요청할때 마다 실행
	@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String uri = req.getRequestURI();  //현재페이지의 uri
		 String context = req.getContextPath();  //어플리케이션
		 String path = uri.substring(context.length());
		 Control control = controls.get(path);
		 control.exec(req, resp); //요청url과 실행컨트롤을 호출
 	}
}
