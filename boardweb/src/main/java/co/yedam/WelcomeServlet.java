package co.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import co.yedam.board.Board;
import co.yedam.board.BoardDAO;

// 서블릿 실행 : http://localhost:8080/boardweb/welcome.do
// 프로젝트의 환경파일 web.xml에 등록.
// 서블릿 컨테이너 : 서블릿의 생명주기(init -> service -> destroy) 관리.
// init() : 최초 요청때 한번 실행
// service() : 요청이 있을 때 마다..
// destroy() : 서비스 종료...
//서비스 요청이 없으면 doget dopost가 있어햐한다. 서비스가 있으면 doget dopost가 있다하더라도 서비스만 실행된다.
public class WelcomeServlet extends HttpServlet{
	public WelcomeServlet() {
		System.out.println("WelcomeServlet 실행.");
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 실행");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset = utf-8"); //웹브라우저에 전송되는 컨텐츠 타입.
		System.out.println("service 실행");
		
		String html = "<h3>여기는 servlet</h3>";
		html += "<a href= 'index.html'>인덱스로 이동 </a>";
		//글목록 출력추가
		BoardDAO dao = new BoardDAO();
		List<Board> list = dao.boardList();
		
		html += "<table border='1'>";
		html += "<thead><tr><th>글번호</th><th>제목</th><th>작성자</th></tr></thead>";
		html += "<tbody>";
		for(Board board: list) {
			html += "<tr><td>"+board.getBoardNo()+"</td>"
					+"<td>"+board.getTitle()+"</td>"+
					"<td>"+board.getWriter()+"</td>"
					+"</tr>";
		}
		html += "</tbody></table>";
		PrintWriter out =res.getWriter(); //클라이언트 쪽으로 출력스트림
		out.print(html);
		
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy 실행");
	}
	//project 안에 있는 clean을 누르면 지금 project 
	//explorer에 있는 파일만 다시 설정되고 없는것들은 다 삭제된다
}
