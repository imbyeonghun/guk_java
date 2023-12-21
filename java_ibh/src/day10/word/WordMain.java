package day10.word;

import java.util.Scanner;

public class WordMain {
	
	private static Scanner scan = new Scanner(System.in);
	private static Word word[] = new Word[5];
	private static int count = 0; 		// 현재 등록된 단어 개수
	private static int subMenu;
	private static int regame;
	private static int win;
	private static int lose;
	private static int max = count;
	private static int min = 1;
	
	/* 영어 단어장 프로그램을 만드세요
	 * 1. 기능 정리
	 * 	1. 단어추가 2. 검색 3. 프로그램 종료
	 * 입력 :
	 * 1) 
	 * 영단어 추가
	 *  영단어 입력 : 영어이고,공백이 없는
	 *  영단어 뜻 입력 : 한글이고, 한 문장,한 단어에 한개의 뜻이 있다고 가정
	 * 3) 프로그램 종료
	 * 
	 * 2. 틀 작성
	 * 
	 * 3. 필요한 메서드 구현
	 * 
	 */
	
	public static void main(String[] args) {
		int menu;
		
		do{
			// 메뉴 출력
			printMenu();
			// 메뉴 선택
			menu = scan.nextInt();
			// 선택한 기능 구현
			mainAction(menu);
		}while(menu != 4);		// do~while
	} 	// void

	
	/**
	 * 메뉴 출력
	 */
	private static void printMenu() {
		// 메뉴 출력
		System.out.println("------- 메뉴 -------");
		System.out.println("1. 영단어 목록 보기");
		System.out.println("2. 서브메뉴 보기");
		System.out.println("3. 영단어 맞추기");
		System.out.println("4. 프로그램 종료");
		System.out.println("-------------------");
		System.out.print("메뉴 선택 : ");
	}	// printMenu
	
	
	
	/**
	 * 선택한 기능 구현
	 */
	private static void mainAction(int menu) {
		switch(menu) {
		case 1:
			printList();
			break;
		case 2:
			subMenu();
			break;
		case 3:
			runGame();
			break;
		case 4:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}	// action
	
	
	/**
	 * 영단어 맞추기 게임
	 * 랜덤으로 등록된 단어에서 영어만 출력해서 해당 값에 맞는 뜻 입력
	 */
	private static void runGame() {
		
		do {
			int r = (int)(Math.random() * (max - min + 1) + 1);
			
			System.out.println("게임을 하시겠습니까?");
			System.out.println("1 : YES  2. NO");
			regame = scan.nextInt();
			
			if(regame == 1) {
				playGame(r);
			}else if(regame == 2) {
				System.out.println(win + "승, " + lose + "패");
				System.out.println("단어 맞추기 게임을 종료합니다.");
			}
		}while(regame == 1);
	}

	
	/**
	 * 영단어 맞추기의 내용코드
	 * @param r 랜덤한 정수
	 */
	private static void playGame(int r) {
		
		for(int i = 0; i < count; i++) {
			if(r == word[i].getNum()) {
				System.out.println(word[i].getEngWord());
				System.out.print("뜻 : ");
				scan.nextLine();
				String answer = scan.nextLine();
				
				if(word[i].getKorWord().equals(answer)) {
					win++;
					return;
				}else {
					System.out.println("해당 단어의 뜻은 " + word[i].getKorWord() + "입니다.");
					lose++;
					break;
				}
			}
		}
	}
	
	
	/**
	 * 영단어 목록 보기
	 */
	private static void printList() {
		for(int i = 0; i < count; i++) {
			word[i].printInfo();
		}
		
		if(count == 0) {
			System.out.println("등록된 단어가 없습니다.");
		}
	}	// printList
	
	/**
	 * 영단어 추가,수정,삭제
	 */
	private static void subMenu() {
		
		do {
			printSubMenu();
			subMenu = scan.nextInt();
			switch(subMenu) {
			case 1:
				// 추가
				addWord();
				break;
			case 2:
				// 수정
				modifyWord();
				break;
			case 3:
				// 삭제
				deleteWord();
				break;
			case 4:
				// 뒤로가기
				break;
			default:
				System.out.println("잘못된 선택입니다.");
			}
		}while(subMenu != 4);
	}	// runWord

	
	private static void printSubMenu() {
		System.out.println("------- 서브 메뉴 -------");
		System.out.println("1. 영단어 추가");
		System.out.println("2. 영단어 수정");
		System.out.println("3. 영단어 삭제");
		System.out.println("4. 뒤로 가기");
		System.out.println("-------------------");
		System.out.print("메뉴 선택 : ");
	}

	
	/**
	 * 단어 등록
	 */
	private static void addWord() {
		System.out.print("추가 할 단어 : ");
		String str = scan.next();
		
		System.out.print("추가 할 단어 뜻 : ");
		scan.nextLine();
		String strMeaning = scan.nextLine();
		
		Word createWord = new Word(str,strMeaning);
		word[count] = createWord;
		count++;
		
		if(count == word.length) {
			// word보다 크기가 5 큰 배열 생성
			Word wordCopy[] = new Word[word.length + 5];
			// word를 wordCopy에 복사
			System.arraycopy(word, 0, wordCopy, 0, count);
			word = wordCopy;
		}else {
			return;
		}
	}	// addWord

	
	/**
	 * 등록된 단어 수정
	 */
	private static void modifyWord() {
		System.out.print("수정 할 단어 번호 : ");
		int num = scan.nextInt();
		for(int i = 0; i <= count; i++) {
			if(num-1 == i) {
				System.out.print("수정 할 단어 : ");
				String str = scan.next();
				
				System.out.print("수정 할 단어 뜻 : ");
				scan.nextLine();
				String strMeaning = scan.nextLine();
				
				word[i].update(str, strMeaning);
			}
		}
	}	// modifyWord

	
	/**
	 * 등록된 단어 삭제
	 */
	private static void deleteWord() {
		
		// 삭제할 번호 입력
		System.out.print("삭제할 단어 번호 : ");
		int num = scan.nextInt();
		
		// word[i]
		for(int i = 0; i < count; i++) {
			if(num == word[i].getNum()) {
				// 같은 크기 배열 생성
				Word wordCopy[] = new Word[word.length];
				// 생성한 배열에 원하는 값-1만큼 복사
				System.arraycopy(word, 0, wordCopy, 0, num-1);
				// 나머지 복사
				System.arraycopy(word, i+1, wordCopy, i, word.length-i-1);
				// 복사한 배열과 원래 배열 연결
				word = wordCopy;
				// 단어 개수 감소
				count--;
				return;
			}
		}
		System.out.println("존재하지 않는 번호입니다.");
	}	// deleteWord
}	// class