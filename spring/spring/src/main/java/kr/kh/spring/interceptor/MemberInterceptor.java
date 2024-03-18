package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.model.vo.MemberVO;

public class MemberInterceptor extends HandlerInterceptorAdapter {

	/*
	 preHandle에서 리턴값이 true이면 기존 작업을 이어서 함 
	 리턴값이 false이면 접근을 못함, sendRedirect가 있으면 해당 경로로 이동
	 */
	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler) throws Exception {
		
		// 오버라이드이기 때문에 원하는 대로 매개변수,리턴타입등을 변경 못하기 때문에 
		// 세션에서 회원 정보를 가져와야함
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		if(user == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return false;
		}
		return true;
	}
}