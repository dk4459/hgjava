package co.yedam.reply.service;

import java.util.List;

import co.yedam.common.SearchVO;
import co.yedam.reply.Reply;

public interface ReplyService {
    List<Reply> replyList(SearchVO search);
    boolean addReply(Reply reply);
    boolean removeReply(int rno);
    
     //페이지계산위한 전체건수
     int totalCount(int bno);
}
