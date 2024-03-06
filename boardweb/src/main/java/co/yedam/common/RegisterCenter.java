package co.yedam.common;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.yedam.reply.service.ReplyService;
import co.yedam.reply.service.ReplyServiceImpl;

public class RegisterCenter implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
        // byte stream => 객체.(id,centerName,sido,.....) => 객체[]
		ServletInputStream sis = req.getInputStream();
		String json = StreamUtils.copyToString(sis, StandardCharsets.UTF_8);
		System.out.println(json);
		ObjectMapper mapper = new ObjectMapper(); //제이슨문자열을 객체로 변경해주는 작업
		Center[] list =mapper.readValue(json, Center[].class);
		
		
		
		ReplyService svc = new ReplyServiceImpl();
		int cnt = svc.addCenter(list);
		System.out.println(cnt);
		
		//처리된 건수.
		 resp.getWriter().print(cnt);
	}

}
