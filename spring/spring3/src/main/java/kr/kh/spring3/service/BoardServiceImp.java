package kr.kh.spring3.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring3.dao.BoardDAO;
import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.pagination.Criteria;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDAO boardDao;

	private boolean CheckStr(String str) {
		return str.length() != 0 && str != null;
	}
	
	@Override
	public ArrayList<BoardVO> getPostList(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectPostList(cri);
	}

	@Override
	public int getPostCount(Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return boardDao.selectPostCount(cri);
	}

	@Override
	public boolean insertPost(MemberVO user, BoardVO board) {
		if( user == null ||
			board == null ||
			!CheckStr(board.getBo_title()) ||
			!CheckStr(board.getBo_content())) 
				return false;
		
		board.setBo_me_id(user.getMe_id());
		return boardDao.insertPost(board);
	}
}