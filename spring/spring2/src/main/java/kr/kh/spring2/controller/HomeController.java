package kr.kh.spring2.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring2.model.dto.LoginDTO;
import kr.kh.spring2.model.dto.LoginDTOList;

@Controller
public class HomeController {
	
	/*
	 post방식은 반드시 get방식이 있어야 한다. (x)
	 - 화면없이 기능이 실행되는 경우	=> ex) 게시글 삭제, 로그아웃
	 	get방식을 사용하는 상황 => 보여줄 화면이 필요할 때
	 	post방식은 기능을 실행할 때(데이터가 url에 노출되지 않으면서 실행)
	 	첨부파일처럼 url에 데이터를 추가할 수 없을 때
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		/*
		서버에서 화면으로 데이터를 전송 : 화면에(jsp)에 서버에서 보낸 안녕하세요가 출력되도록 작성
			- model에 담아서 전송
			- 화면(jsp)에서 ${}를 이용해서 출력
		*/
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("text", "안녕하세요.");
		return "home";
	}
	
	@GetMapping("/id")
	public String id(Model model, String id) {
		
		System.out.println(id);
		return "redirect:/";
	}
	
	@GetMapping("/name")
	public String name(Model model, String name) {
		
		System.out.println(name);
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(Model model, LoginDTO member) {
		
		// 화면에 member를 전송하고, 화면에서 id와 pw를 출력하는 코드 작성
		System.out.println(member);
		
		model.addAttribute("user",member);
		return "test";
	}
	
	@GetMapping("/send/object")
	public String sendObject() {
		
		return "sendobject";
	}
	
	@PostMapping("/send/object")
	public String sendObjectPost(Model model, LoginDTOList list) {
		System.out.println(list);
		return "redirect:/send/object";
	}
	
	@GetMapping("/send/path/{num}")
	public String sendPath(@PathVariable("num") int num) {	// Mapping에 있는 {num}, @PathVariable("num")에 있는 변수명 일치
		System.out.println(num);
		return "redirect:/";
	}
	
	@GetMapping("/ajax")
	public String ajax() {
		return "ajax";
	}
	
}