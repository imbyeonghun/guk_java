package kr.kh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring.model.dto.TestDTO;

@Controller
public class HomeController {
	
	// value = url, method = 전송방식을 GET 또는 POST
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeGet(Model model) {
		
		// model을 이용해서 화면으로 전송
		// model.addAttribute("화면에서 사용할 이름", "보낼 데이터");
		model.addAttribute("name", "홍길동");
		
		return "home";	// home.jsp 파일로 연결
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homePost(Model model, TestDTO testDto /*String name, int age*/) {
		
		// jsp에서 name이랑 같은 이름의 변수를 매개변수로 보냄 => 자동으로 맵핑
		/*
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		TestDTO testdto = new TestDTO(name, age);
		*/
		System.out.println(testDto);	// 단 dto변수 이름과 jsp 파일에 name값이 동일해야 함
		
		
		return "home";	// home.jsp 파일로 연결
	}
	
	@RequestMapping(value = "/test/{num}", method = RequestMethod.GET)
	public String TestGet(Model model, @PathVariable("num")int num) {
		// @PathVariable("num")int num => url에 담긴 데이터 가져오기
		
		System.out.println("경로 데이터 : " + num);
		return "redirect:/";
	}
}
