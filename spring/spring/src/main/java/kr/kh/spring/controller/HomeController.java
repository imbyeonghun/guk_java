package kr.kh.spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@GetMapping(value = "/logout")
	public String logout(Model model, HttpSession session) {
		
		// 로그아웃 작업 => 세션에 회원 정보를 제거
		session.removeAttribute("user");
		
		model.addAttribute("msg", "로그아웃 했습니다.");
		model.addAttribute("url", "/");
		return "message";
	}
	
	@ResponseBody
	@GetMapping("/id/check/dup")
	public Map<String, Object> 메서드명(@RequestParam("id") String id){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean res = memberService.idCheck(id);
		map.put("result", res);
		return map;
	}
	
	@GetMapping("/find/pw")
	public String findPw() {
		return "/member/findpw";
	}
	@ResponseBody
	@PostMapping("/find/pw")
	public Map<String, Object> findPwPost(@RequestParam("id") String id){
		Map<String, Object> map = new HashMap<String, Object>();
		boolean res = memberService.findPw(id);
		map.put("result", res);
		return map;
	}
}