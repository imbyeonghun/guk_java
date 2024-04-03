package kr.kh.spring3.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/post/list")
	public String signup(Model model) {
		
		ArrayList<BoardVO> postList = boardService.getPostList();
		model.addAttribute("title", "게시글 목록");
		model.addAttribute("postList",postList);
		return "/post/list";
	}
}