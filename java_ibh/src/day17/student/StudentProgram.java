package day17.student;

import java.util.InputMismatchException;
import java.util.Scanner;
import program.Program;

public class StudentProgram implements Program {

	private StudentManager sm = new StudentManager();
	private Scanner scan = new Scanner(System.in);
	private final int EXIT = 3;
	
	@Override
	public void run() {
		int menu = 0;
		
		do {
			// 메뉴 출력
			printMenu();
			try {
			// 메뉴 선택
			menu = scan.nextInt();
			// 메뉴 실행
			runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("메뉴를 잘못 선택했습니다.");
				scan.nextLine();
			}
		}while(menu != EXIT);
	}

	@Override
	public void printMenu() {
		System.out.println("--- 학생 관리 ---");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 조회[전체]");
		System.out.println("3. 종료");
		System.out.println("---------------");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertStudent();
			break;
		case 2:
			sm.printAll();
			break;
		case 3:
			System.out.println("프로그램 종료");
			break;
		default:
			throw new InputMismatchException();
		}
	}

	private void insertStudent() {
		// 학생 정보 입력
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		System.out.print("이름 : ");
		String name = scan.next();
		
		// 학생 객체 생성
		Student std = new Student(grade, classNum, num, name);
		
		// 추가를 해서 성공하면 성공 알림
		if(sm.insertStudent(std)) {
			System.out.println("학생을 추가했습니다.");
			return;
		}
		// 실패하면 실패 알림
		System.out.println("이미 등록된 학생입니다.");
	}
}