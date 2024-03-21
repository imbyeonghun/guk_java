package kr.kh.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.MemberVO;

public interface MemberDAO {
	boolean insertMember(MemberVO member);

	MemberVO selectMember(String me_id);
	
	void updatePassword(@Param("id")String id, @Param("pw")String encPw);
	
	boolean updateMember(@Param("me")MemberVO member);

	void updateMemberCookie(@Param("user")MemberVO user);

	MemberVO selectMemberByCookie(@Param("session_id")String sessionId);
}