package kr.kh.spring3.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysql.cj.Session;

import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.service.MemberService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		log.info("안녕하세요. 스프링 메인입니다.");
		int count = memberService.getMemberCount();
		log.info("등록된 회원 수 : " + count);
		
		return "/main/home";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("title", "회원가입");
		return "/member/signup";
	}
	
	@PostMapping("/signup")
	public String signupPost(Model model, MemberVO member) {

		if(memberService.insertMember(member)) {
			model.addAttribute("msg","회원가입을 했습니다.");
			model.addAttribute("url","/");
		}else {
			model.addAttribute("msg","회원가입을 하지 못했습니다.");
			model.addAttribute("url","/signup");
		}
		return "message";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("title", "로그인");
		return "/member/login";
	}
	
	@PostMapping("/login")
	public String loginPost(Model model, MemberVO member) {
		MemberVO user = memberService.login(member);
		model.addAttribute("user",user);
		if(user != null) {
			model.addAttribute("msg","로그인을 했습니다.");
			model.addAttribute("url","/");
		}else {
			model.addAttribute("msg","로그인을 하지 못했습니다.");
			model.addAttribute("url","/login");
		}
		return "message";
	}
	
	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {
		
		session.removeAttribute("user");
		model.addAttribute("msg","로그아웃을 했습니다.");
		model.addAttribute("url","/");
		return "message";
	}

}