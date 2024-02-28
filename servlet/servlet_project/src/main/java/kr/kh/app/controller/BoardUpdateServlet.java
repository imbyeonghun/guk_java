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
		// 게시글을 가져와서 화면에 전달
		// 화면에서 전송한 게시글 번호를 가져옴
		int num;
		try{
			num = Integer.parseInt(request.getParameter("num"));
		}catch(Exception e) {
			num = 0;
		}
		// 서비스에게 게시글 번호를 주면서 게시글을 가져오라고 시킴 : 구현 완료
		BoardVO board = boardService.getBoard(num);
		// 가져온 게시글을 화면에 전송
		request.setAttribute("board", board);
		
		// 작성자가 맞는지 확인
		// 세션에서 회원 정보를 가져옴
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
	
		// 게시글 작성자와 회원아이디가 같은지 확인
		if(board == null ||
			user == null ||
			!board.getBo_me_id().equals(user.getMe_id())) {
			
			// 다르면 게시글 상세로 보내고, 작성자가 아닙니다라고 메시지를 띄움 : message.jsp
			request.setAttribute("msg", "작성자가 아닙니다.");
			request.setAttribute("url", "board/detail?num="+num);
			request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
			return;
		}else {		// 같으면 
			// 서비스에게 게시판 리스트를 가져오라고 시킴
			ArrayList<CommunityVO> list = boardService.getCommunityList();
			// 게시판을 가져와서 화면에 전달
			request.setAttribute("list", list);
			// 게시판 리스트를 화면에 전송
			request.getRequestDispatcher("/WEB-INF/views/board/update.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인한 회원 정보를 가져옴 => 세션에 있는 회원 정보를 가져옴
		// 중간에 로그인이 풀렸을 가능성이 있기 때문에 다시 가져옴
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		
		// 화면에서 전송한 제목, 내용, 번호, 게시판을 가져옴
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int num , coummunity;
		try {
			num = Integer.parseInt(request.getParameter("num"));
			coummunity = Integer.parseInt(request.getParameter("coummunity"));
		}catch(Exception e) {
			num = 0;
			coummunity = 0;
		}
		// 게시글 객체로 생성
		BoardVO board = new BoardVO(num, title, content, coummunity);
		// 서비스에게 게시글과 회원 정보를 주면서 게시글 수정하라고 요청
		if(boardService.updateBoard(board, user)) {
			// 	성공하면 성공했다고 알리고 게시글 상세로 이동
			request.setAttribute("msg", "게시글을 수정했습니다.");
		}else {
			// 실패하면 실패했다고 알리고 게시글 상세로 이동
			request.setAttribute("msg", "게시글을 수정하지 못했습니다.");
		}
		request.setAttribute("url", "board/detail?num="+num);
		request.getRequestDispatcher("/WEB-INF/views/message.jsp").forward(request, response);
	}
}