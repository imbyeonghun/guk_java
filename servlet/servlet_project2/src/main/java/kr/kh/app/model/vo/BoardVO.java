package kr.kh.app.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardVO {
	
	private int bo_num;
	private int bo_co_num; 
	private String bo_me_id; 
	private String bo_title; 
	private String bo_content; 
	private int bo_view;
	private int bo_report_count;
	
	private CommunityVO community;	// 게시판명을 조회하기 위해 게시판VO클래스인 커뮤니티 추가

	public BoardVO(int bo_co_num, String bo_me_id, String bo_title, String bo_content) {
		this.bo_co_num = bo_co_num;
		this.bo_me_id = bo_me_id;
		this.bo_title = bo_title;
		this.bo_content = bo_content;
	}
	
}