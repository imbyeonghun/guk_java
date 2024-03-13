package kr.kh.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/list")
	public String BoardList(Model model, Criteria cri) {
		cri.setPerPageNum(5);	// 한 페이지에 게시글 5개 지정
		
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		
		model.addAttribute("list",list);
		return "/board/list";
	}
}