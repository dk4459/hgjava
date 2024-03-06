package co.yedam.reply.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Center;
import co.yedam.common.DataSource;
import co.yedam.common.SearchVO;
import co.yedam.reply.Reply;
import co.yedam.reply.mapper.ReplyMapper;

public class ReplyServiceImpl implements ReplyService{

	SqlSession session = DataSource.getInstance().openSession(true); //자동커밋 옵션 = (true)를 넣어야한다
	ReplyMapper mapper = session.getMapper(ReplyMapper.class);
	
	@Override
	public List<Reply> replyList(SearchVO search) {
		return mapper.selectList(search);
	}

	@Override
	public boolean addReply(Reply reply) {
		return mapper.insertReply(reply) == 1;
	}

	@Override
	public boolean removeReply(int rno) {
		return mapper.deleteReply(rno) == 1;
	}
     @Override
    public int totalCount(int bno) {
    	return mapper.selectCount(bno);
    }
     @Override
    public int addCenter(Center[] array) {
    	return mapper.insertCenter(array);
    }
     @Override
    public List<Map<String, Object>> getCntSido() {
    	// TODO Auto-generated method stub
    	return mapper.countPerSido();
    }
}
