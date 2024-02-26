package co.yedam.member.service;


import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.member.Member;
import co.yedam.member.mapper.MemberMapper;

public class MemberServiceImpl implements MemberService{
	SqlSession session = DataSource.getInstance().openSession(true); //이렇게하면 자동커밋을한다.
	MemberMapper mapper = session.getMapper(MemberMapper.class);//보드매퍼 객체를 만든다. BoardMapper.class
    
	
	public Member loginCheck(Member member) {
	// TODO Auto-generated method stub
	return mapper.selectMember(member);
    }
	public boolean addMember(Member member) {
		
		return mapper.insertMember(member) == 1;
	}
	public Member listMember(Member member){
       return mapper.listMember(member);
	}
}
