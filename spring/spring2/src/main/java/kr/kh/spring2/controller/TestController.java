package kr.kh.spring2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/test")
	public String home(Model model) {

		return "test";
	}
	
	@GetMapping("/hobby")
	public String hoddy(String[] hobby) {
		if(hobby != null) {
			for(String tmp : hobby) {
				System.out.println(tmp);
			}
		}
		
		return "redirect:/";
	}
	
}