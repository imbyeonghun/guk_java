package kr.kh.spring3.service;

import java.util.ArrayList;

import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.pagination.Criteria;

public interface BoardService {

	ArrayList<BoardVO> getPostList(Criteria cri);

	int getPostCount(Criteria cri);

	boolean insertPost(MemberVO user, BoardVO board);
}