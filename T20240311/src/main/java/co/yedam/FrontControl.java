package co.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FrontControl extends HttpServlet{
       
	Map<String, Control> controls;
	
	public FrontControl() {
		controls = new HashMap<>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		controls.put("/bookList.do", new BookListControl());
	}
	
	//service. 요청할때 마다 실행
		@Override
			protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			
			String uri = req.getRequestURI();  
			 String context = req.getContextPath();  
			 String path = uri.substring(context.length());
			 Control control = controls.get(path);
			 control.exec(req, resp); 
	 	}
}
