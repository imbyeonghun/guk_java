package kr.kh.spring3.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.model.vo.CommunityVO;
import kr.kh.spring3.model.vo.FileVO;
import kr.kh.spring3.pagination.Criteria;

public interface BoardDAO {

	ArrayList<BoardVO> selectPostList(@Param("cri")Criteria cri);

	int selectPostCount(@Param("cri")Criteria cri);

	boolean insertPost(@Param("board")BoardVO board);

	ArrayList<CommunityVO> selectCommunity();

	void insertFile(@Param("file")FileVO fileVo);

	BoardVO selectBoard(@Param("bo_num")int bo_num);

	ArrayList<FileVO> selectFile(@Param("bo_num")int num);

	void updateView(@Param("bo_num")int num);

}