package co.yedam;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.common.SearchVO;
import co.yedam.reply.Reply;
import co.yedam.reply.mapper.ReplyMapper;

public class MapperTest {
    public static void main(String[] args) {
		SqlSession session = DataSource.getInstance().openSession(true); //자동커밋 옵션 = (true)를 넣어야한다
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		
		Reply rep = new Reply();
		rep.setBoardNo(98);
		rep.setReply("98번 댓글입니다...");
		rep.setReplyer("newbie");
		mapper.insertReply(rep);
		//mapper.deleteReply(8);
		
		System.out.println(rep);
		
		SearchVO search = new SearchVO();
		search.setBno(98);
		search.setRpage(2);
		
		mapper.selectList(search) // List<Reply> 반환
	           .forEach(reply -> System.out.println(reply.toString()));
    }
}
