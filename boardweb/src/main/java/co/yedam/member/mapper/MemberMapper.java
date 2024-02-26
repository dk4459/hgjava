package co.yedam.member.mapper;

import co.yedam.member.Member;

public interface MemberMapper {
   Member selectMember(Member member);
   //회원가입
   int insertMember(Member member);
   //회원조회
   Member listMember(Member member);
}
