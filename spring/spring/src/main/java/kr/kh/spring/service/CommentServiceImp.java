package kr.kh.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.CommentDAO;
import kr.kh.spring.model.vo.CommentVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.pagination.Criteria;
import lombok.Data;

@Service
public class CommentServiceImp implements CommentService {

	@Autowired
	CommentDAO commentDao;
	
	private boolean checkString(String str) {
		return str != null && str.length() != 0;
	}

	@Override
	public ArrayList<CommentVO> getCommentList(Criteria cri) {
		if(cri == null) {
			return null;
		}
		return commentDao.selectCommentList(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		if(cri == null) {
			return 0;
		}
		return commentDao.selectTotalCount(cri);
	}

	@Override
	public boolean insertComment(CommentVO comment, MemberVO user) {
		if(comment == null || !checkString(comment.getCm_content())) 
			return false;
		
		if(user == null || !checkString(user.getMe_id())) 
			return false;
		// 댓글 작성자로 로그인한 회원 아이디를 넣어줌
		comment.setCm_me_id(user.getMe_id());
		return commentDao.insertComment(comment);
	}

	@Override
	public boolean deleteComment(CommentVO comment, MemberVO user) {
		if(comment == null) 
			return false;
		
		if(user == null) 
			return false;
		CommentVO dbcomment = commentDao.selectComment(comment.getCm_num());
		
		if(dbcomment == null ||
			!dbcomment.getCm_me_id().equals(user.getMe_id()))
			return false;
		return commentDao.deleteComment(comment.getCm_num());
	}

	@Override
	public boolean updateComment(CommentVO comment, MemberVO user) {
		if(comment == null || !checkString(comment.getCm_content())) 
			return false;
		if(user == null) 
			return false;
		CommentVO dbcomment = commentDao.selectComment(comment.getCm_num());
		
		if(dbcomment == null ||
			!dbcomment.getCm_me_id().equals(user.getMe_id()))
			return false;
		return commentDao.updateComment(comment);
	}
}