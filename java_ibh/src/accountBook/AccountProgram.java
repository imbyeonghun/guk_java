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

	private AccountManager am = new AccountManager();
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
			runUpdate();
			break;
		case 3:
			// 내역 조회
			runSearch();
			break;
		case 4:
			exit();
			break;
		default:
			throw new InputMismatchException();
		}
	}

	private void runSearch() {
		int menu = 0;
		do {
			printSearchMenu();
			try {
				menu = scan.nextInt();
				runSearchAccount(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();
			}
		}while(menu != 3);
	}


	private void runSearchAccount(int menu) {
		switch(menu) {
		case 1:
			// 수입 내역 조회
			searchAccountIncome();
			break;
		case 2:
			// 지출 내역 조회
			searchAccount();
			break;
		case 3:
			// 돌아가기
			break;
		default:
			throw new InputMismatchException();
		}
	}


	private void searchAccountIncome() {
		am.printAccountIncome();
	}
	
	private void searchAccount() {
		am.printAccount();
	}


	private void printSearchMenu() {
		System.out.println("------------------");		System.out.println("1. 수입 내역 조회");
		System.out.println("2. 지출 내역 조회");
		System.out.println("3. 돌아가기");
		System.out.println("------------------");
		System.out.print("메뉴 선택 : ");	}


	private void runUpdate() {
		int menu = 0;
		do {
			printUpdateMenu();
			try {
				menu = scan.nextInt();
				runUpdateAccount(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();
			}
		}while(menu != 3);
		
	}
	
	private void runUpdateAccount(int menu) {
		switch(menu) {
		case 1:
			// 수입 내역 수정
			UpdateAccountIncome();
			break;
		case 2:
			// 지출 내역 수정
			UpdateAccount();
			break;
		case 3:
			// 돌아가기
			break;
		default:
			throw new InputMismatchException();
		}
	}


	private void UpdateAccount() {
		
	}


	private void UpdateAccountIncome() {
		
	}


	private void printUpdateMenu() {
		System.out.println("------------------");
		System.out.println("1. 수입 내역 수정");
		System.out.println("2. 지출 내역 수정");
		System.out.println("3. 돌아가기");
		System.out.println("------------------");
		System.out.print("메뉴 선택 : ");
	}


	private void runInsert() {
		int menu = 0;
		do {
			printInsertMenu();
			try {
				menu = scan.nextInt();
				runInsertAccount(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴입니다.");
				scan.nextLine();
			}
		}while(menu != 3);
	}


	private void runInsertAccount(int menu) {
		switch(menu) {
		case 1:
			// 수입 내역 추가
			insertAccountIncome();
			break;
		case 2:
			// 지출 내역 추가
			insertAccount();
			break;
		case 3:
			// 돌아가기
			break;
		default:
			throw new InputMismatchException();
		}
	}

	private void printInsertMenu() {
		System.out.println("------------------");
		System.out.println("1. 수입");
		System.out.println("2. 지출");
		System.out.println("3. 돌아가기");
		System.out.println("------------------");
		System.out.print("메뉴 선택 : ");
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
		System.out.print("품목 : ");
		String goods = scan.next();
		System.out.print("수량 : ");
		int amount = scan.nextInt();
		System.out.print("가격 : ");
		int price = scan.nextInt();
		
		Account ac = new Account(date, goods, amount, price);
		am.insertAccount(ac);
	}

	private void insertAccountIncome() {
		String pattern = "yyyy/MM/dd";
		DateFormat df = new SimpleDateFormat(pattern); 
		Date date = null;
		
		// 수입 정보 입력
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
		am.insertAccountIncome(ai);
	}


	private void exit() {
		System.out.println("--------------------");
		System.out.println("프로그램 종료합니다.");
		System.out.println("--------------------");
	}
}