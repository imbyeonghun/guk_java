package word;

public class WordMain {

	/* 영어 단어장을 관리하는 프로그램을 작성하세요.
	 * 기한은 1/5까지 github에 업로드 후 강사에게 공유(단톡방)
	 * 
	 * - 한 단어에 뜻이 여러개 있을 수 있음
	 * - 단어, 품사, 뜻을 관리
	 * 	- 품사는 뜻에 따라 달라짐
	 * - 단어 추가
	 * 	- 단어 하나와 품사 뜻을 여러개 입력해서 추가
	 * 	- 중복된 단어는 새 뜻으로 추가(뜻이 중복되지 않은 경우)
	 * 	- 중복되지 않으면 새 단어로 추가
	 * - 단어 수정
	 * 	- 수정할 단어와 수정될 단어를 입력해서 수정
	 * 	- 없으면 안내 문구
	 * - 단어 삭제
	 * 	- 삭제할 단어를 입력해서 단어를 삭제
	 *  - 없으면 안내 문구
	 * - 뜻 추가
	 * 	- 단어와 품사,뜻을 입력받아 단어가 있으면 뜻을 추가
	 *  - 없으면 새 단어로 추가
	 * - 뜻 수정
	 * 	- 단어와 수정할 뜻(번호), 새 품사, 새 뜻을 입력받아 품사와 뜻을 수정
	 *  - 없으면 안내 문구
	 * - 뜻 삭제
	 * 	- 단어와 뜻(번호)을 입력하면 뜻을 삭제
	 * - 단어 조회 
	 * 	- 전체 조회
	 * 	- 검색 조회
	 * 		- 검색어가 포함된 단어를 조회
	 * 	- 인기 단어 조회
	 * 		- 조회수가 높은 단어를 조회
	 * - 게임 
	 * 	- 등록된 단어 중에서 1개를 랜덤으로 뽑아서 뜻이 출력되면 단어를 맞추는 게임
	 * 	- 최대 등록된 단어 수만큼 진행 가능
	 *  - 맞춘 횟수, 틀린 횟수를 관리
	 * - 오답 노트
	 * 	- 게임에서 틀린 단어들을 관리
	 * 	- 한 번 틀리면 오답노트에 등록이 되고, 나중에 다시 맞추면 제거
	 * - 오답 노트 초기화
	 * 	- 오답 노트를 비워줌  
	 * 
	 * */
	
	public static void main(String[] args) {
		WordProgram wp = new WordProgram();
		wp.run();
	}
}