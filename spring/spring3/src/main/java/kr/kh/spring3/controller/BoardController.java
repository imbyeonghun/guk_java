package kr.kh.spring3.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.model.vo.CommunityVO;
import kr.kh.spring3.model.vo.FileVO;
import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.pagination.Criteria;
import kr.kh.spring3.pagination.PageMaker;
import kr.kh.spring3.service.BoardService;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/post/list")
	public String list(Model model, Criteria cri) {
		
		ArrayList<BoardVO> postList = boardService.getPostList(cri);
		
		int postCount = boardService.getPostCount(cri);
		PageMaker pm = new PageMaker(2, cri, postCount);
		
		model.addAttribute("title", "게시글 목록");
		model.addAttribute("postList",postList);
		model.addAttribute("pm",pm);
		return "/post/list";
	}
	
	@GetMapping("/post/insert")
	public String insert(Model model) {
		
		ArrayList<CommunityVO> community = boardService.getCommunityList();
		model.addAttribute("community",community);
		model.addAttribute("title", "게시글 등록");
		return "/post/insert";
	}
	
	@PostMapping("/post/insert")
	public String insertPost(Model model, BoardVO board, HttpSession session, MultipartFile[] file) {
		
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = boardService.insertPost(user, board, file);
		
		if(res) {
			model.addAttribute("msg","게시글을 등록했습니다.");
			model.addAttribute("url","/post/list");
		}else {
			model.addAttribute("msg","게시글을 등록하지 못했습니다.");
			model.addAttribute("url","/post/insert");
		}
		return "message";
	}
	
	@GetMapping("/post/detail")
	public String detail(Model model, int num) {
		
		boardService.upView(num);
		BoardVO board = boardService.getBoard(num);
		ArrayList<FileVO> file = boardService.getFile(num);
		
		model.addAttribute("board", board);
		model.addAttribute("file", file);
		model.addAttribute("title", "게시글 상세");
		return "/post/detail";
	
	}
}