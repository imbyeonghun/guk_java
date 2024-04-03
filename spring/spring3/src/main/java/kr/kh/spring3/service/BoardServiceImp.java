package kr.kh.spring3.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring3.dao.BoardDAO;
import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.pagination.Criteria;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDAO boardDao;

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
}