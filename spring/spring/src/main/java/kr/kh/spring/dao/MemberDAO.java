package kr.kh.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.model.vo.MemberVO;

public interface MemberDAO {
	//@Param("member") 
	boolean insertMember(MemberVO member);

	MemberVO selectMember(String me_id);

}