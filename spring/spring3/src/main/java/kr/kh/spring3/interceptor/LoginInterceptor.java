package kr.kh.spring3.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring3.model.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {

		// 구현   
		MemberVO user = (MemberVO)modelAndView.getModel().get("user");	// 1번
		if(user == null)
			return;
		
		request.getSession().setAttribute("user", user);	// 2번
		// 1번에 있는 user는 컨트롤러에서 보낸 user와 이름 일치
		// 2번에 있는 user는 세션에 저장되어 있는 user와 이름 일치
	}

	
}