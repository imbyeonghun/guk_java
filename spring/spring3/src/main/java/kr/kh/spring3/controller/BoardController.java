package kr.kh.spring3.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.pagination.Criteria;
import kr.kh.spring3.pagination.PageMaker;
import kr.kh.spring3.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/post/list")
	public String signup(Model model, Criteria cri) {
		
		ArrayList<BoardVO> postList = boardService.getPostList(cri);
		
		int postCount = boardService.getPostCount(cri);
		PageMaker pm = new PageMaker(2, cri, postCount);
		
		model.addAttribute("title", "게시글 목록");
		model.addAttribute("postList",postList);
		model.addAttribute("pm",pm);
		return "/post/list";
	}
}