package day09.board;

public class Board {
	
	// 제목, 내용, 일자, 아이디, 조회수, 번호
	private int num, views;
	private String title, text,id,date;
	
	/* 메서드
	 * printInfoList : 게시글 목록 조회
	 * printInfo : 게시글 상세내용 조회
	 * printModify : 게시글 수정 
	 * printDelete : 게시글 삭제
	 * getter,setter
	 */
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * 게시글 목록에서 게시글 정보를 출력하는 메서드
	 * 번호. 제목 작성자 조회수 순으로 출력
	 */
	public void printInfo() {
		System.out.print(num + ". ");
		System.out.print(title + " ");
		System.out.print(text + " ");
		System.out.print(date + " ");
		System.out.print(id + " ");
		System.out.print(views + "\n");
	}
	
	/**
	 * 게시글 상세에서 게시글 정보를 자세히 출력하는 메서드
	 */
	public void printInfoDetail() {
		System.out.println("번호 :" + num);
		System.out.println("제목 :" + title);
		System.out.println("내용 :" + text);
		System.out.println("일자 :" + date);
		System.out.println("작성자 :" + id);
		System.out.println("조회수 :" + views);
		System.out.println("--------------");
	}
	
	/**
	 *  수정할 제목과 내용이 주어지면 게시글의 제목과 내용을 수정하는 메서드
	 * @param title1 수정할 제목
	 * @param text1 수정할 내용
	 */
	public void update(String title1, String text1) {
		title = title1;
		text = text1;
	}

	// 생성자 : 게시글 번호,제목,내용,작성자,게시일이 주어진 생성자
	
	public Board(int num, String title, String text, String id, String date) {
		super();
		this.num = num;
		this.title = title;
		this.text = text;
		this.id = id;
		this.date = date;
	}
}