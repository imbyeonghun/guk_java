package Project1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class HomworkProgram implements Program{

	private Scanner scan = new Scanner(System.in);
	private final int EXIT = 4;
	private List<Word> list = new ArrayList<Word>();
	
	@Override
	public void run() {
		int menu = 0;
		//반복
		do {
			//메뉴 출력
			printMenu();
			try {
				//메뉴 선택
				menu = scan.nextInt();
				//메뉼 실행
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();
			}
		}while(menu != EXIT);
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			//단어 메뉴
			break;
		case 2:
			//뜻 메뉴
			System.out.println("구현중");
			break;
		case 3:
			//단어조회
			System.out.println("구현중");
			break;
		case 4:
			printExit();
			break;
		default:
			throw new InputMismatchException();
		}
	}

	@Override
	public void printMenu() {
		System.out.println("-------- 메뉴 --------");
		System.out.println("1. 단어");
		System.out.println("2. 뜻");
		System.out.println("3. 단어 조회");
		System.out.println("4. 종료");
		System.out.println("---------------------");
		System.out.print("메뉴 선택 : ");
	}

	public void printExit() {
		System.out.println("-----------------------");
		System.out.println("프로그램을 종료합니다.");
		System.out.println("-----------------------");
	}

}