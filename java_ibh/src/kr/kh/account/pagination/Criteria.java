package kr.kh.account.pagination;

import lombok.Data;

@Data
public class Criteria {

	private int page;			// 페이지 수
	private int perPageNum;		// 페이지 당 컨텐츠 수 
	private String search;		// 검색어
	
	public Criteria() {
		page = 1;
		perPageNum = 10;
	}
	
	public Criteria(int page, int perPageNum) {
		this.page = page;
		this.perPageNum = perPageNum;
	}
	
	public int getPageStrart() {
		return (page - 1) * perPageNum;
	}
}