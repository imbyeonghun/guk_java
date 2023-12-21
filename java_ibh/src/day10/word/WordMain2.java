package day10.word;

import java.util.Scanner;

public class WordMain2 {
	
	private static Scanner scan = new Scanner(System.in);
	private static Word2[] list = new Word2[10];	// 단어장
	private static int count = 0;	// 저장된 단어 개수
	
	/* 영어 단어장 프로그램을 만드세요
	 * 1. 기능 정리
	 * - 단어는 영어 단어와 한글 뜻으로 구성
	 * - 영어단어는 영어이고, 공백이 없는 단어
	 * - 한글 뜻은 한글이고, 한 문장으로 되어 있다
	 * - 한 단어에 뜻이 한개만 있다고 가정
	 * 
	 * - 기능
	 * 	- 단어 등록
	 *  - 단어 검색
	 *  - 단어 수정
	 *  - 단어 삭제
	 * - Word 클래스
	 * 	 - word : 영단어
	 * 	 - meaning : 뜻
	 *   - 단어 출력,단어 수정,단어 확인 : 주어진 문자열과 같은 단어인지 확인
	 * 
	 * 2. 틀 작성
	 * 
	 * 3. 필요한 메서드 구현
	 * 
	 */
	
	public static void main(String[] args) {
		
		int menu;
		
		// 반복문
		do {
			//메뉴 출력
			printMenu();
			// 메뉴 선택
			menu = scan.nextInt();
			// 선택한 메뉴에 맞는 기능 실행
			runMenu(menu);
		}while(menu != 5);
	}	// main
	
	
	public static void printMenu() {
		System.out.println("------- 메뉴 -------");
		System.out.println("1. 단어 등록");
		System.out.println("2. 단어 검색");
		System.out.println("3. 단어 수정");
		System.out.println("4. 단어 삭제");
		System.out.println("5. 프로그램 종료");
		System.out.println("-------------------");
		System.out.print("메뉴 선택 : ");
	}
	
	
	private static void runMenu(int menu) {
		
		switch(menu){
			case 1:
				register();
				break;
			case 2:
				search();
				break;
			case 3:
				modify();
				break;
			case 4:
				delete();
				break;
			case 5:
				System.out.println("프로그램 종료!");
				break;
			default:
				System.out.println("잘못된 메뉴를 선택했습니다.");				
		}
	}

	
	/**
	 * 단어 삭제
	 */
	private static void delete() {
		/*
		 		내 코드
		if(count == 0) {
			System.out.println("삭제할 단어가 없습니다.");
			return;
		}
		
		System.out.print("삭제할 단어 검색 : ");
		String str = scan.next();
		
		for(int i = 0; i < count; i++) {
			if(list[i].equals(str) == true) {
				// 같은 크기의 배열 생성
				Word2 tmpWord[] = new Word2[list.length];
				// 삭제할 단어 전까지 tmpWord에 복사
				System.arraycopy(list, 0, tmpWord, 0, i);
				// 삭제할 단어 다음부터 tmpWord에 나머지 복사
				System.arraycopy(list, i+1, tmpWord, i, list.length-i-1);
				// 삭제할 단어 제외하고 저장한 tmpWord와 List연결
				list = tmpWord;
				count--;
			}
		}
		*/
		
		//단어를 입력
		System.out.print("단어 : ");
		String word = scan.next();
		// 단어장에서 단어를 삭제 
		// 삭제할 위치를 찾음
		// 반복문 : 저장된 개수만큼
		int index = -1;	// 음수로 초기화 => 배열의 번지는 0이상
		for(int i = 0; i < count; i++) {
			// 입력한 단어와 같으면
			if(list[i].equals(word)) {
				// 현재 위치를 index에 저장
				index = i;
				break;
			}
		}
		
		// 일치하는 단어가 없으면
		if(index == -1) {
			// 안내문구 출력후 종료
			System.out.println("일치하는 단어가 없습니다.");
			return;
		}
		
		// 저장된 단어의 개수를 1 줄임
		count--;
		System.out.println("삭제가 완료되었습니다.");
		// 일치하는 단어가 마지막 단어이면 => 더 이상 저장된 단어가 없다
		if(index == count) {
			// 종료
			return;
		}
		
		// 한 칸씩 당겨오기
		// 현재 배열과 같은 크기의 새 배열을 생성
		Word tmpList[] = new Word[list.length];
		
		// 새 배열에 현재 배열을 복붙
		System.arraycopy(word, 0, tmpList, 0, list.length);
		
		// 현재 배열에서 index+1번지부터 단어가 있는 마지막번지까지
		// 복사해서 새 배열에 index번지부터 복붙
		System.arraycopy(tmpList, index+1, list, index, count-index);
	}


	/**
	 * 단어 수정
	 */
	private static void modify() {

		if(count == 0) {
			System.out.println("수정할 단어가 없습니다.");
			return;
		}
		
		System.out.print("수정할 단어 검색 : ");
		String str = scan.next();
		
		for(int i = 0; i < count; i++) {
			if(list[i].equals(str) == false) {
				System.out.println("존재하지 않는 단어입니다.");
				return;
			}else {
				System.out.print("수정할 단어 뜻 : ");
				scan.nextLine();
				String str2 = scan.nextLine();
				list[i].update(str2);
			}
		}
	}


	/**
	 * 단어 검색
	 */
	private static void search() {
		
		if(count == 0) {
			System.out.println("검색할 단어가 없습니다.");
			return;
		}
		
		System.out.print("단어 검색 : ");
		String str = scan.next();
		
		for(int i = 0; i < count; i++) {
			// 단어장에 단어가 주어진 단어와 일치하면
			if(list[i].equals(str)) {
				// 해당 단어 출력
				list[i].print();
				return;
			}
		}
		System.out.println("해당 단어가 없습니다.");
	}


	/**
	 * 단어 등록
	 */
	private static void register() {
		
		System.out.print("등록할 단어 : ");
		String str = scan.next();
		
		for(int j = 0; j < count; j++) {
			if(list[j].equals(str) == true) {
				System.out.println("이미 존재하는 단어입니다.");
				return;
			}
		}
		
		System.out.print("등록할 단어 뜻 : ");
		scan.nextLine();
		String strMeaning = scan.nextLine();
		
		Word2 wordList = new Word2(str, strMeaning);
		list[count] = wordList;
		count++;
		
		if(count == list.length) {
			expandWordList();
		}else {
			return;
		}
	}
	
	
	/**
	 * 배열이 꽉 찼을 때 10개만큼 크기 늘리는 메서드
	 */
	public static void expandWordList() {
		
		// word보다 크기가 5 큰 배열 생성
		Word2 wordCopy2[] = new Word2[list.length + 10];
		// word를 wordCopy에 복사
		System.arraycopy(list, 0, wordCopy2, 0, count);
		list = wordCopy2;
	}
	
}	// class