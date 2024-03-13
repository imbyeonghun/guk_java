package kr.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.MemberDAO;
import kr.kh.spring.model.dto.LoginDTO;
import kr.kh.spring.model.vo.MemberVO;

@Service	// 있어야 @Autowired 해당 코드가 실행됨
public class MemberServiceImp implements MemberService {

	@Autowired
	private MemberDAO memberDao;
	
	private boolean checkString(String str) {
		return str != null && str.length() != 0;
	}

	@Override
	public boolean insertMember(MemberVO member) {
		if( member == null ||
			!checkString(member.getMe_id()) ||
			!checkString(member.getMe_pw()) ||
			!checkString(member.getMe_email())) {
			return false;
		}
		// 아이디 중복 체크
		MemberVO user = memberDao.selectMember(member.getMe_id());
		if(user != null) {
			return false;
		}
		return memberDao.insertMember(member);
	}

	@Override
	public MemberVO login(LoginDTO loginDto) {
		if( loginDto == null || 
			!checkString(loginDto.getId()) ||
			!checkString(loginDto.getPw())) {
			return null;
		}
		
		// 아이디와 일치하는 회원 정보를 가져오고
		MemberVO member = memberDao.selectMember(loginDto.getId());
		// 회원정보가 없거나 입력한 비번과 DB에 저장된 비번이 다르면
		if(member == null || !member.getMe_pw().equals(loginDto.getPw())) {
			return null;
		}
		return member;
	}
}