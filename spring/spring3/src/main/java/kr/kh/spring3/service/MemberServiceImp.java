package kr.kh.spring3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring3.dao.MemberDAO;
import kr.kh.spring3.model.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberDAO memberDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	private boolean CheckStr(String str) {
		return str.length() != 0 && str != null;
	}
	
	@Override
	public int getMemberCount() {
		return memberDao.selectMemberCount();
	}

	@Override
	public boolean insertMember(MemberVO member) {
		if(!CheckStr(member.getMe_id()) ||
			!CheckStr(member.getMe_email()) ||
			!CheckStr(member.getMe_pw())) 
			return false;
		MemberVO res = memberDao.selectMemberById(member.getMe_id());
		
		if(res != null) {
			return false;
		}
		System.out.println(member);
		// 해당 코드는 입력받은 비밀번호를 암호화해주는 코드이다
		String encPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPw);
		
		return memberDao.insertMember(member);
	}

	@Override
	public boolean getmember(MemberVO member) {
		if(!CheckStr(member.getMe_id()) ||
			!CheckStr(member.getMe_pw())) 
				return false;
		
		// 해당 아이디의 DB에 저장된 비밀번호와 입력된 비밀번호를 확인 
		MemberVO user = memberDao.selectMemberById(member.getMe_id());
		if(!passwordEncoder.matches(member.getMe_pw(), user.getMe_pw()))
			return false;
		
		return true;
	}
}