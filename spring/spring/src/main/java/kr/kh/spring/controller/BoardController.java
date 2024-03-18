package kr.kh.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.model.vo.FileVO;
import kr.kh.spring.model.vo.MemberVO;
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
	
	@GetMapping("/board/insert")
	public String boardInsert(Model model) {
		
		// 커뮤니티 리스트를 가져와서 화면에 전송
		ArrayList<CommunityVO> list = boardService.getCommunityList();
		model.addAttribute("list",list);
		return "/board/insert";
	}
	
	@PostMapping("/board/insert")
	public String boardInsertPost(Model model, BoardVO board, 
			HttpServletRequest request, MultipartFile[] file) {

		// 회원 정보 가져옴
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		
		if(boardService.insertBoard(board, user, file)) {
			model.addAttribute("msg", "게시글을 등록했습니다.");
			model.addAttribute("url", "/board/list");
		}else {
			model.addAttribute("msg", "게시글을 등록하지 못했습니다.");
			model.addAttribute("url", "/board/insert");
		}
		return "message";
	}
	
	@GetMapping("/board/detail")
	public String boardDetail(Model model, int boNum, Criteria cri, HttpSession session) {
		
		// 조회수 증가
		boardService.updateView(boNum);
		
		// 게시글을 가져옴
		BoardVO board = boardService.getBoard(boNum);
		
		// 첨부파일을 가져옴
		ArrayList<FileVO> fileList = boardService.getFileList(boNum);

		// 화면에 게시글, 첨부파일, 검색 정보를 전송
		model.addAttribute("board",board);
		model.addAttribute("fileList",fileList);
		model.addAttribute("cri",cri);
		
		return "/board/detail";
	}
	
	@GetMapping("/board/delete")
	public String boardDelete(Model model, int boNum, HttpSession session) {
		
		// HttpServletRequest 대신 HttpSession으로 바로 session으로 접근
		// 회원 정보를 가져옴
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		// 서비스에게 게시글 번호와 회원 정보를 주면서 삭제하라고 요청
		boolean res = boardService.deleteBoard(boNum, user);
		
		if(res) {
			// 삭제 성공시 성공 처리
			model.addAttribute("url","/board/list");
			model.addAttribute("msg", "게시글을 삭제했습니다.");
		}else {
			// 삭제 실패시 실패 처리
			model.addAttribute("url","/board/detail?boNum="+boNum);
			model.addAttribute("msg", "게시글을 삭제하지 못했습니다.");
		}
		return "message";
	}
}