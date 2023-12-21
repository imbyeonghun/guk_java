package day10.word;

public class Word {
	// 변수
	// 번호, 영어, 뜻
	private static int count = 0; 
	private int num;
	private String engWord, korWord;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getEngWord() {
		return engWord;
	}
	public void setEngWord(String engWord) {
		this.engWord = engWord;
	}
	public String getKorWord() {
		return korWord;
	}
	public void setKorWord(String korWord) {
		this.korWord = korWord;
	}

	// 메서드
	// 저장된 목록 출력, 수정
	
	/**
	 * 단어 목록에서 단어를 출력하는 메서드
	 * 번호. 영어 뜻 순으로 출력
	 */
	public void printInfo() {
		System.out.print(num + ". ");
		System.out.print(engWord + " ");
		System.out.println(korWord + " ");
	}
	
	/**
	 *  수정할 영어와 뜻이 주어지면 영어와 뜻을 수정하는 메서드
	 * @param engWord 수정할 영어
	 * @param korWord 수정할 뜻
	 */
	public void update(String engWord, String korWord) {
		this.engWord = engWord;
		this.korWord = korWord;
	}
	
	// 생성자 : 영어,뜻이 주어진 생성자
	public Word(String engWord, String korWord) {
		this.num = ++count;
		this.engWord = engWord;
		this.korWord = korWord;
	}
}