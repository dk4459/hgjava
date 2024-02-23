package co.yedam.member.service;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.member.Member;
import co.yedam.member.mapper.Membermapper;

public class MemberServiceImpl implements MemberService{
	SqlSession session = DataSource.getInstance().openSession(true); //이렇게하면 자동커밋을한다.
	Membermapper mapper = session.getMapper(Membermapper.class);//보드매퍼 객체를 만든다. BoardMapper.class
    
	
	public Member loginCheck(Member member) {
	// TODO Auto-generated method stub
	return null;
    }
}
