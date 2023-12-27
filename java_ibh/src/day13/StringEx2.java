package day13;

import java.util.Scanner;

public class StringEx2 {

	private static Scanner scan = new Scanner(System.in);
	private static String[] strs = new String[5];
	private static int count = 0;
	
	public static void main(String[] args) {
		
		/*
		 * 문자열을 입력받아 배열에 저장하고, 
		 * 특정 단어가 들어가 있는 문장들을 출력하는 프로그램
		 * 메뉴
		 * 1. 문장 추가
		 * 2. 검색
		 * 3. 종료
		 */
		
		/*
		 * 안녕하세요.
		 * 테스트
		 * 만나서 반갑습니다.
		 * 나는 홍길동입니다.
		 * 
		 * 나로 검색
		 * 
		 * 만나서 반갑습니다.
		 * 나는 홍길동입니다.
		 */
		
		run();
	}
	
	public static void run() {
		int menu;
		do {
			printMenu();
			menu = scan.nextInt();
			runProgram(menu);
		}while(menu != 3);
	}
	
	public static void runProgram(int menu) {
		switch(menu) {
		case 1:
			addString();
			break;
		case 2:
			search();
			break;
		case 3:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("잘못된 메뉴");
		}
	}
	
	public static void addString() {
		System.out.print("추가할 문자열을 입력하세요 : ");
		scan.nextLine();
		strs[count] = scan.nextLine();
		System.out.println(strs[count]);
		count++;
		// 배열 늘리기
		if(count == strs.length) {
			String[] tmp = new String[strs.length + 5];
			System.arraycopy(strs, 0, tmp, 0, count);
			strs = tmp;
		}
	}
	
	public static void search() {
		// 문자열이 없을 때
		if(count == 0) {
			System.out.println("등록한 문자열이 없습니다.");
			return;
		}
		System.out.print("검색할 문자열을 입력하세요 : ");
		scan.nextLine();
		String select = scan.nextLine();
		for(int i = 0; i < count; i++) {
			if(strs[i].contains(select) == true) {
				System.out.println(strs[i]);
			}
		}
	}
	
	public static void printMenu() {
		System.out.println("--- 메뉴 ---");
		System.out.println("1. 문장 추가");
		System.out.println("2. 검색");
		System.out.println("3. 종료");
		System.out.println("-----------");
		System.out.print("메뉴 선택 : ");
	}
}