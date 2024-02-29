package kr.kh.app.pagination;

import lombok.Data;

@Data
public class PageMaker {
	
	private int totalCount;		// 전체 컨텐츠 개수 => 마지막 페이지네이션의 마지막 페이지를 계산하기 위해
	private int startPage;		// 페이지네이션 시작 페이지번호
	private int endPage;		// 페이지네이션 마지막 페이지번호
	private boolean prev;		// 이전버튼 활성화 유무
	private boolean next;		// 다음버튼 활성화 유무
	private int displayPageNum;	// 한 페이지네이션에서 보여준 페이지의 최대 숫자 개수
	private Criteria cri;		// 현재 페이지 정보
	
	// totalCount, displayPageNum, perPageNum(cri)를 이용하여
	// endPage, startPage, prev, next를 계산하는 메서드
	// ex) 전체 게시글이 131개, 한 페이지에 게시글이 10개 => 14페이지
	public void Calculate(){
		// 현재 페이지에 대한 최대 페이지 번호 
		// 현재 페이지가 4페이지고, 한 페이지에 컨텐츠 개수가 10개이고 한 페이지네이션의 개수가 10개
		// endPage = (int)(Math.ceil(0.4) * 10);
		endPage = (int)(Math.ceil(cri.getPage() / (double)displayPageNum) * displayPageNum);
		
		startPage = endPage - displayPageNum + 1;
		
		// 컨텐츠 개수를 이용하여 계산한 최대 페이지 번호 : 14
		int tmpEndPage = (int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));

		// endPage는 10단위이기 때문에 12등등 정확한 마지막 페이지는 모르기 때문에
		// tmpEndPage로 마지막을 지정해줘야함
		if(endPage > tmpEndPage) {
			endPage = tmpEndPage;
		}
		// 첫번째 페이지네이션이면 false 아니면 true
		prev = startPage == 1 ? false : true;
		
		// 마지막 페이지네이션이면 false 아니면 true
		next = endPage == tmpEndPage ? false : true;
	}
	
	public PageMaker(int displayPageNum, Criteria cri, int totalCount) {
		this.displayPageNum = displayPageNum;
		this.cri = cri;
		this.totalCount = totalCount;
		Calculate();
	}
}
