package day16.student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentProgram implements StudentInterface {

	private final int EXIT = 3;
	private Scanner scan = new Scanner(System.in);
	private List<Student> list = new ArrayList<Student>();
	
	int menu = 0;
	String fileName = "src/day16/student/StudentList.txt";
	
	@Override
	public void run() {
		load(fileName);
		
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
		
		save(fileName);
	}

	public void load(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(list);
		} catch (IOException e) {
			System.out.println("저장에 실패했습니다.");
		}
	}
	
	public void save(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)){

			list = (List<Student>)ois.readObject();
			System.out.println("학생 정보를 불러왔습니다.");
				
		}catch (Exception e) {
			System.out.println("불러오기에 실패했습니다.");
		}
	}
	
	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			addStudent();
			break;
		case 2:
			printStudent();
			break;
		case 3:
			System.out.println("프로그램 종료");
			break;
		default:
			throw new InputMismatchException();
		}
	}
	
	private void printStudent() {
		list.stream().forEach(s->System.out.println(s));
	}

	private void addStudent() {
		System.out.print("추가할 학생 학년 : ");
		int grade = scan.nextInt();
		System.out.print("추가할 학생 반 : ");
		int classNum = scan.nextInt();
		System.out.print("추가할 학생 번호 : ");
		int num = scan.nextInt();
		System.out.print("추가할 학생 이름 : ");
		String name = scan.next();
		Student std = new Student(grade, classNum, num, name);
		
		if(!list.contains(std)) {
			list.add(std);
			System.out.println("학생이 등록됐습니다.");
			return;
		}
		System.out.println("해당 학생은 이미 등록돼있습니다.");
	}

	@Override
	public void printMenu() {
		System.out.println("--- 학생 관리 ---");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 전체 조회");
		System.out.println("3. 종료");
		System.out.println("--------------");
		System.out.print("메뉴 선택 : ");
	}
}