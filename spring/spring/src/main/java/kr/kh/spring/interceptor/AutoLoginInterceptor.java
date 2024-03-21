package kr.kh.spring.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.MemberService;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	MemberService memberService;
	
	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler) throws Exception {
		
		// 오버라이드이기 때문에 원하는 대로 매개변수,리턴타입등을 변경 못하기 때문에 
		// 세션에서 회원 정보를 가져와야함
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		
		// 로그인이 안되어 있다면 자동로그인 체크를 해야 함
		if(user == null) {
			// loginCookie정보를 가져옴
			Cookie cookie = WebUtils.getCookie(request, "loginCookie");
			
			// loginCookie가 있으면 자동 로그인 진행
			if(cookie != null) {
				// 쿠키에 value로 넣었던 세션 아이디 값을 가져옴
				String sessionId = cookie.getValue();
				user = memberService.getMemberByCookie(sessionId);
				if(user != null) {
					request.getSession().setAttribute("user", user);
				}
			}
		}
			
		return true;
	}
}