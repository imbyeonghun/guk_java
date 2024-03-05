package kr.kh.app.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.http.Part;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.BoardDAO;
import kr.kh.app.model.vo.BoardVO;
import kr.kh.app.model.vo.CommunityVO;
import kr.kh.app.model.vo.FileVO;
import kr.kh.app.model.vo.MemberVO;
import kr.kh.app.pagination.Criteria;
import kr.kh.app.utils.FileUploadUtils;

public class BoardServiceImp implements BoardService {

	private BoardDAO boardDao;
	private String uploadPath = "D:\\uploads";
	
	public BoardServiceImp() {
		String resource = "kr/kh/app/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			boardDao = session.getMapper(BoardDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// uploadPath에 저장된 경로에 지정한 폴더가 없으면 생성
		File file = new File(uploadPath);
		if(!file.exists()) {
			file.mkdir();
		}
	}

	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		//현재 페이지정보 null 처리 
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectBoardList(cri);
	}

	@Override
	public boolean insertBoard(BoardVO board, ArrayList<Part> partList) {
		if( board == null || 
			!checkString(board.getBo_title()) || 
			!checkString(board.getBo_content())) {
			return false;
		}
		boolean res = boardDao.insertBoard(board);

		// 게시글 등록에 실패한 경우
		if(!res) {
			return false;
		}
		// 첨부파일이 없는 경우
		if(partList == null || partList.size() == 0) {
			return true;
		}
		for(Part part : partList) {
			uploadFile(part, board.getBo_num());
		}
		return res;
	}
	
	//문자열이 null이거나 빈 문자열이면 false, 아니면 true를 반환하는 메서드
	public boolean checkString(String str) {
		if(str == null || str.length() == 0) {
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<CommunityVO> getCommunityList() {
		return boardDao.selectCommunityList();
	}

	@Override
	public int getTotalCount(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectTotalCount(cri);
	}

	@Override
	public boolean updateView(int num) {
		return boardDao.updateView(num);
	}

	@Override
	public BoardVO getBoard(int num) {
		return boardDao.selectBoard(num);
	}

	@Override
	public boolean deleteBoard(int num, MemberVO user) {
		if(user == null) {
			return false;
		}
		//게시글을 가져옴
		BoardVO board = boardDao.selectBoard(num);
		//게시글이 없거나 작성자가 아니면 false를 리턴
		if(board == null || !board.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		//게시글을 삭제 요청
		return boardDao.deleteBoard(num);
	}

	@Override
	public boolean updateBoard(MemberVO user, BoardVO board) {
		// 게시글 null 체크
		if( board == null || 
			!checkString(board.getBo_title()) || 
			!checkString(board.getBo_content())) {
			return false;
		}
		// 회원 null 체크
		if(user == null) {
			return false;
		}
		// 게시글이 없거나 게시글 작성자가 회원이 아니면 false를 리턴
		BoardVO board2 = boardDao.selectBoard(board.getBo_num());
		if(board2 == null || !user.getMe_id().equals(board2.getBo_me_id())) {
			return false;
		}
		// 서비스에게 게시글을 주면서 수정하라고 요청
		return boardDao.updateBoard(board);
	}
	
	private void uploadFile(Part part, int bo_num) {
		if(part == null || bo_num == 0) {
			return;
		}
		// 서버에 업로드
		String fi_ori_name = FileUploadUtils.getFileName(part);
		if(!checkString(fi_ori_name)) {
			return;
		}
		// FileUploadUtils.upload(서버폴더 경로 , part);
		String fi_name = FileUploadUtils.upload(uploadPath, part);

		// DB에 추가
		FileVO file = new FileVO(bo_num, fi_name, fi_ori_name);
		boardDao.insertFile(file);
	}
}