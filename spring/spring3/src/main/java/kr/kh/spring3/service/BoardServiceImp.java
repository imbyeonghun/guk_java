package kr.kh.spring3.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring3.dao.BoardDAO;
import kr.kh.spring3.model.vo.BoardVO;
import kr.kh.spring3.model.vo.CommunityVO;
import kr.kh.spring3.model.vo.FileVO;
import kr.kh.spring3.model.vo.MemberVO;
import kr.kh.spring3.pagination.Criteria;
import kr.kh.spring3.utils.UploadFileUtils;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDAO boardDao;

	@Resource
	private String uploadPath;
	
	private boolean CheckStr(String str) {
		return str.length() != 0 && str != null;
	}

	private void upload(int bo_num, MultipartFile file) {
		
		try {
			String originalFileName = file.getOriginalFilename();
			if(originalFileName.length() == 0) {
				return;
			}
			// 서버에 업로드 후 업로드한 파일명(UUID포함)을 가져옴
			String fileName = 
					UploadFileUtils.uploadFile(uploadPath, originalFileName, file.getBytes());
			
			FileVO fileVo = new FileVO(bo_num, fileName, originalFileName);
			boardDao.insertFile(fileVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	public boolean insertPost(MemberVO user, BoardVO board, MultipartFile[] files) {
		if( user == null ||
			board == null ||
			!CheckStr(board.getBo_title()) ||
			!CheckStr(board.getBo_content())) 
				return false;
		
		board.setBo_me_id(user.getMe_id());
		boolean res = boardDao.insertPost(board);
		
		if(!res) 
			return false;
			
		if(files == null || files.length == 0) 
			return true;
		
		for(MultipartFile file : files) 
			upload(board.getBo_num(), file);
		
		return res;
	}

	@Override
	public ArrayList<CommunityVO> getCommunityList() {
		return boardDao.selectCommunity();
	}

	@Override
	public BoardVO getBoard(int bo_num) {
		return boardDao.selectBoard(bo_num);
	}

	@Override
	public ArrayList<FileVO> getFile(int num) {
		return boardDao.selectFile(num);
	}

	@Override
	public void upView(int num) {
		boardDao.updateView(num);
	}
}