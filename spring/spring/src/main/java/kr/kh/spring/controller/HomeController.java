package kr.kh.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring.model.dto.LoginDTO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.MemberService;

@Controller
public class HomeController {
	
	@Autowired	// new MemberServiceImp()를 대신함
	private MemberService memberService;
	
	// value = url, method = 전송방식을 GET 또는 POST
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeGet(Model model) {
		// model을 이용해서 화면으로 전송
		// model.addAttribute("화면에서 사용할 이름", "보낼 데이터");
		
		return "/main/home";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupGet(Model model) {
		
		return "/member/signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(Model model, MemberVO member, String me_pw2) {
		
		if(memberService.insertMember(member)) {
			model.addAttribute("msg","회원 가입을 완료했습니다.");
			model.addAttribute("url","/");
		}else {
			model.addAttribute("msg","회원 가입을 하지 못했습니다.");
			model.addAttribute("url","/signup");
		}
		
		return "message";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet(Model model) {
		
		return "/member/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(Model model, LoginDTO loginDto) {
		MemberVO user = memberService.login(loginDto);
		if(user != null) {
			model.addAttribute("user",user);
			model.addAttribute("msg","로그인 했습니다.");
			model.addAttribute("url","/");
		}else {
			model.addAttribute("msg","로그인을 하지 못했습니다.");
			model.addAttribute("url","/login");
		}
		return "message";
	}
}