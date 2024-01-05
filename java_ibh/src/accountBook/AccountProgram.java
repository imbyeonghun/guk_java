package accountBook;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class AccountProgram implements Program {

	private List<Account> list = new ArrayList<Account>();
	private List<AccountIncome> listIncome = new ArrayList<AccountIncome>();
	private final int EXIT = 4;
	private Scanner scan = new Scanner(System.in);
	
	@Override
	public void run() {
		int menu = 0;
		do {
			printMenu();
			try {
				menu = scan.nextInt();
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();
			}
		}while(menu != EXIT);
	}
		

	@Override
	public void printMenu() {
		System.out.println("--- 메뉴 ---");
		System.out.println("1. 내역 등록");
		System.out.println("2. 내역 수정");
		System.out.println("3. 내역 조회");
		System.out.println("4. 종료");
		System.out.println("-----------");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			// 내역 등록 메뉴
			runInsert();
			break;
		case 2:
			// 내역 수정
			break;
		case 3:
			// 내역 조회
			break;
		case 4:
			exit();
			break;
		default:
			throw new InputMismatchException();
		}
	}


	private void runInsert() {
		int menu = 0;
		do {
			printInsertMenu();
			try {
				menu = scan.nextInt();
				runInsertAccount(menu);
			}catch(InputMismatchException e) {
				
			}
		}while(menu != 3);
	}


	private void runInsertAccount(int menu) {
		switch(menu) {
		case 1:
			insertAccount();
			break;
		case 2:
			// 내역 수정
			break;
		case 3:
			break;
		default:
			throw new InputMismatchException();
		}
	}


	private void printInsertMenu() {
		System.out.println("1. 수입");
		System.out.println("2. 지출");
		System.out.println("3. 돌아가기");
	}


	private void insertAccount() {
		String pattern = "yyyy/MM/dd";
		DateFormat df = new SimpleDateFormat(pattern); 
		Date date = null;
		
		// 학생 정보 입력
		System.out.print("날짜 " + pattern + "형식으로 입력 : ");
		scan.nextLine();
		while(scan.hasNextLine()) {
			try {
				date = df.parse(scan.nextLine());
				break;
			}catch (Exception e){
				System.out.print(pattern + "형식으로 다시 입력해주세요");
			}
		}
		System.out.print("수입 : ");
		int income = scan.nextInt();
		System.out.print("품목 : ");
		String goods = scan.next();
		AccountIncome ai = new AccountIncome(date, income,goods);
		listIncome.add(ai);
	}


	private void exit() {
		System.out.println("--------------------");
		System.out.println("프로그램 종료합니다.");
		System.out.println("--------------------");
	}
}