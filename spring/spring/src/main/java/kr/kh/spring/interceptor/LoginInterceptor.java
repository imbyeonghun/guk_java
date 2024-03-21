package kr.kh.spring.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.MemberService;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	/*
	// 디스패쳐서블릿에서 컨트롤러로 들어가기 전 작업할 내용 : 컨트롤러 실행 전 동작
	// MemberFilter, GuestFilter 구현 가능
	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler) throws Exception {
		return true;
	}
	*/
	
	@Autowired
	MemberService memberService;
	
	// 컨트롤러에서 디스패쳐서블릿으로 가기 전 작업할 내용 : 컨트롤러 실행 후 동작
	// 로그인
	@Override
	public void postHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler, 
			ModelAndView modelAndView) throws Exception {
		
		// ModelAndView객체에서 model객체에 넣어준 user를 가져오는 코드
		MemberVO user = (MemberVO)modelAndView.getModel().get("user");
		if(user != null) {
			// 세션에 회원 정보를 추가
			request.getSession().setAttribute("user", user);
			
			// 자동 로그인을 체크했으면
			if(user.isAutoLogin()) {
				// 쿠키를 생성해서
				String value = request.getSession().getId();	// 세션의 id값을 가져옴
				Cookie cookie = new Cookie("loginCookie", value);
				cookie.setPath("/");

				// setMaxAge() => 단위가 초이기 때문 
				// 1주일 => 7(일) * 24(시간) * 60(분) * 60(초)
				int time = 7 * 24 * 60 * 60;
				cookie.setMaxAge(time);
				// 화면에 전송하고 
				response.addCookie(cookie);
			
				// DB에 관련 정보를 추가 => 세션 아이디와 만료시간
				// System.currentTimeMillis => 단위가 밀리세컨드이므로 구해놓은 초에서 1000을 곱한다
				user.setMe_cookie(value);
				Date date = new Date(System.currentTimeMillis() + time * 1000);
				user.setMe_cookie_limit(date);
				
				// 서비스에게 해당 정보를 주고 DB에 추가 요청
				memberService.updateMemberCookie(user);
			}
		}
	}
}