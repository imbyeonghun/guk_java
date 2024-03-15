package kr.kh.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/list")
	public String BoardList(Model model, Criteria cri) {
		cri.setPerPageNum(5);	// 한 페이지에 게시글 5개 지정
		
		// 한 페이지에 해당하는 정보를 주고 게시글을 가져옴
		ArrayList<BoardVO> list = boardService.getBoardList(cri);
		
		// 페이지 정보를 주면서 전체 게시글의 총 개수를 가져온다
		int totalCount = boardService.getBoardTotalCount(cri);
		
		// (한 번에 몇 페이지를 보여줄지, 페이지 정보, 게시글 개수)
		PageMaker pm = new PageMaker(3, cri, totalCount);
		
		model.addAttribute("list",list);
		model.addAttribute("pm",pm);
		return "/board/list";
	}
}