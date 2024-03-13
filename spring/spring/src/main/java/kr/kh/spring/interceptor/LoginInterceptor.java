package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.model.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	// 디스패쳐서블릿에서 컨트롤러로 들어가기 전 작업할 내용 : 컨트롤러 실행 전 동작
	// MemberFilter, GuestFilter 구현 가능
	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler) throws Exception {
		return true;
	}

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
		}
	}
}