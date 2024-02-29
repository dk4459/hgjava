package co.yedam.member.service;

import co.yedam.board.Book;
import co.yedam.member.Member;

public interface MemberService {
        Member loginCheck(Member member);
        //회원가입
        boolean addMember(Member member);
       }
  
