package kr.kh.spring3.service;

import kr.kh.spring3.model.vo.MemberVO;

public interface MemberService {

	int getMemberCount();

	boolean insertMember(MemberVO member);

	boolean getmember(MemberVO member);

}
