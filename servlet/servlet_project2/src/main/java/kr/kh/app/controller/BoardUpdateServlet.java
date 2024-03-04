package kr.kh.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.service.BoardService;
import kr.kh.app.service.BoardServiceImp;

@WebServlet("/board/update")
public class BoardUpdateServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImp();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 번호를 가져옴
		int num;
		try {
			num = Integer.parseInt(request.getParameter("num"));
		}catch(Exception e) {
			e.printStackTrace();
			num = 0;
		}
		// 번호와 일치하는 게시글 가져옴
		BoardVO board = boardService.getBoard(num);
		// 게시판 리스트를 가져옴
		ArrayList<CommunityVO> list = boardService.getCommunityList();
		// 게시판,게시글을 화면에 전송
		request.setAttribute("board", board);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/board/update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 번호, 내용, 제목, 게시판 번호을 가져옴
		int num, co_num;
		try {
			num = Integer.parseInt(request.getParameter("num"));
			co_num = Integer.parseInt(request.getParameter("community"));
		}catch(Exception e) {
			e.printStackTrace();
			num = 0;
			co_num = 0;
		}
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 게시글 번호, 내용, 제목을 이용헤서 게시글 객체를 생성
		// 기존 생성자를 이용해서 객체 생성
		BoardVO board = new BoardVO(title, content, "", co_num);
		board.setBo_num(num);
		// 회원 가져옴
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		
		// 서비스에게 회원정보와 수정할 게시글 정보를 주면서 수정하라고 요청
		if(boardService.updateBoard(user,board)) {
			// 수정했으면 게시글을 수정했습니다.
			request.setAttribute("msg", "게시글을 수정했습니다.");
		}else {
			// 못했으면 게시글을 수정하지 못했습니다. 라고 알림
			request.setAttribute("msg", "게시글을 수정하지 못했습니다.");
		}
		// 게시글 상세로 이동
		request.setAttribute("url", "board/detail?num="+num);
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}
}