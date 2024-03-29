package kr.kh.spring.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.dao.BoardDAO;
import kr.kh.spring.model.vo.BoardVO;
import kr.kh.spring.model.vo.CommunityVO;
import kr.kh.spring.model.vo.FileVO;
import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.model.vo.RecommendVO;
import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.utils.UploadFileUtils;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	private BoardDAO boardDao;
	
	@Resource
	private String uploadPath;

	private boolean checkString(String str) {
		return str != null && str.length() != 0;
	}
	
	private void uploadFile(int bo_num, MultipartFile file) {
		
		try {
			String originalFileName = file.getOriginalFilename();

			// 파일명이 없으면(UUID제외하고)
			if(originalFileName.length() == 0) {
				return;
			}
			
			// 서버에 업로드 후 업로드한 파일명(UUID포함)을 가져옴
			String fileName = UploadFileUtils.uploadFile
					(uploadPath, originalFileName,file.getBytes());

			// FileVO 객체를 생성
			FileVO fileVo = new FileVO(bo_num, fileName, originalFileName);
			// DB에 추가
			boardDao.insertFile(fileVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 게시글 수정에서도 사용하기 위해 따로 메서드 생성
	private void deleteFile(FileVO file) {
		if(file == null) {
			return;
		}
		// 서버에서 삭제
		// 서버 경로, 첨부파일 이름
		UploadFileUtils.deleteFile(uploadPath, file.getFi_name());
		// DB에서 삭제
		boardDao.deleteFile(file.getFi_num());
	}
	
	@Override
	public ArrayList<BoardVO> getBoardList(Criteria cri) {
		if(cri == null) {
			cri = new Criteria(1,5);
		}
		return boardDao.selectBoardList(cri);
	}

	@Override
	public int getBoardTotalCount(Criteria cri) {
		if(cri == null) {
			cri = new Criteria(1,5);
		}
		return boardDao.selectBoardTotalCount(cri);
	}

	@Override
	public ArrayList<CommunityVO> getCommunityList() {
		return boardDao.selectCommunityList();
	}

	@Override
	public boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] files) {
		// 작업 순서 : 게시글을 올리고 올려진 게시글에 첨부파일을 추가
		if(user == null || board == null) {
			return false;	
		}
		if(!checkString(board.getBo_title()) ||
			!checkString(board.getBo_content())) {
			return false;	
		}
		board.setBo_me_id(user.getMe_id());
		boolean res = boardDao.insertBoard(board);
		
		// 게시글 등록 실패
		if(!res) {
			return false;
		}
		
		// 첨부파일 업로드 작업
		// 첨부파일이 없는 경우
		if(files == null || files.length == 0) {
			return true;
		}
		for(MultipartFile file : files) {
			// 첨부파일을 서버에 업로드하고 DB에 추가하는 메서드
			uploadFile(board.getBo_num(), file);
		}
		return res;
	}

	@Override
	public BoardVO getBoard(int boNum) {
		return boardDao.selectBoard(boNum);
	}

	@Override
	public void updateView(int boNum) {
		boardDao.updateView(boNum);
	}

	@Override
	public ArrayList<FileVO> getFileList(int boNum) {
		return boardDao.selectFileList(boNum);
	}

	@Override
	public boolean deleteBoard(int num, MemberVO user) {
		if(user == null) {
			return false;
		}
		// 게시글 번호에 맞는 게시글을 가져옴
		BoardVO board = boardDao.selectBoard(num);
		
		// 게시글이 없거나 작성자가 맞으면 false를 리턴
		if(board == null ||
			!board.getBo_me_id().equals(user.getMe_id())) {
			return false;
			
		}
			
		// 맞으면 삭제 후 결과를 리턴
		// 서버에 첨부파일 삭제 및 DB에서 제거 => 게시글 번호에 맞는 첨부파일 리스트를 가져옴
		ArrayList<FileVO> fileList = boardDao.selectFileList(num); 
		
		// 첨부파일 리스트가 있으면 반복문으로 첨부파일을 삭제
		if(fileList != null) {
			for(FileVO file : fileList) {
				deleteFile(file);
			}
		}
		// 게시글 삭제
		return boardDao.deleteBoard(num);
	}

	@Override
	public boolean updateBoard(BoardVO board, MemberVO user, MultipartFile[] file, int[] delNums) {
		if(board == null ||
			!checkString(board.getBo_title()) ||
			!checkString(board.getBo_content())) {
			return false;
		}
		
		if(user == null) {
			return false;
		}
		
		// 작성자가 맞는지
		BoardVO dbBoard = boardDao.selectBoard(board.getBo_num());
		if(dbBoard == null ||
			!dbBoard.getBo_me_id().equals(user.getMe_id())) {
			return false;
		}
		
		// 게시글 수정
		boolean res = boardDao.updateBoard(board);

		if(!res) {
			return false;
		}
		
		// 새 첨부파일 추가
		if(file != null) {
			for(MultipartFile tmp : file) {
				uploadFile(board.getBo_num(), tmp);
			}
		}
		
		// 삭제할 첨부파일 삭제
		if(delNums == null) {
			return true;
		}
		for(int tmp : delNums) {
			FileVO fileVo = boardDao.selectFile(tmp);
			deleteFile(fileVo);
		}
		return true;
	}

	@Override
	public int recommend(RecommendVO recommend, MemberVO user) {
		if(recommend == null)
			return -2;
		if(user == null)
			return -2;
		// 기존 추천 정보가 있는지 확인
		recommend.setRe_me_id(user.getMe_id());
		RecommendVO dbRecommend = boardDao.selectRecommend(recommend);
		// 없으면 추가
		if(dbRecommend == null) {
			boardDao.insertRecommend(recommend);
		}else {
			// 있으면 수정
			if(recommend.getRe_state() == dbRecommend.getRe_state()) {
				// 취소
				recommend.setRe_state(0);
			}
			boardDao.updateRecommend(recommend);
		}
		return recommend.getRe_state();
	}
	
	@Override
	public int getUserRecommend(int num, MemberVO user) {
		if(user == null)
			return -2;

		RecommendVO recommend = 
			boardDao.selectRecommend(new RecommendVO(num, user.getMe_id()));
		return recommend == null ? -2 : recommend.getRe_state();
	}
}