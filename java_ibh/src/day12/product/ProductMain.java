package day12.product;

import java.util.Scanner;

public class ProductMain {

	/* 제품을 추가하는 프로그램을 작성하세요
	 * 제품은 tv,에어컨,노트북만 추가 가능
	 * 공통 : 브랜드,제품코드,제품명
	 * TV : 화면크기
	 * 에어컨 : 냉방면적
	 * 노트북 : CPU,RAM
	 * 
	 * TV,에어컨,노트북 클래스
	 * Product 클래스
	 * 
	 * 메뉴
	 * 1. 제품 추기
	 * 2. 제품 확인
	 * 3.종료
	 * 메뉴선택 : 1
	 * ----------
	 * 추가할 제품 
	 * 1. TV
	 * 2. 에어컨
	 * 3. 컴퓨터
	 * 제품 선택 : 1
	 * 
	 * 브랜드 : 삼성
	 * 제품코드 : KQ75QCE1-W1
	 * 제품명 : 2023 QLED 4K QCE1
	 * 화면크기(cm) : 189
	 * 등록이 완료됐습니다.
	 * ----------
	 * 메뉴
	 * 1. 제품 추기
	 * 2. 제품 확인
	 * 3.종료
	 * 메뉴선택 : 1
	 * ----------
	 * 추가할 제품 
	 * 1. TV
	 * 2. 에어컨
	 * 3. 노트북
	 * 제품 선택 : 2
	 * 
	 * 브랜드 : 삼성
	 * 제품코드 : KQ75QCE1-W1
	 * 제품명 : 에어컨 Q9000
	 * 냉방면적(m2) : 56.9
	 * 등록이 완료됐습니다.
	 * 
	 * 제품 확인 : 등록된 순서대로 출력
	 */
	
	static Scanner scan = new Scanner(System.in);
	static Product[] pro = new Product[30];
	static int count = 0;
	
	public static void main(String[] args) {
		
		int menu;
		do {
			printMenu();
			menu = scan.nextInt();
			run(menu);
		}while(menu != 3);
	}

	public static void run(int menu) {

		switch(menu) {
		case 1:
			insertProduct();
			break;
		case 2:
			printProduct();
			break;
		case 3:
			System.out.println("종료");
			break;
		default:
			System.out.println("잘못된 메뉴");
		}
	}

	private static void insertProduct() {
		// 제품 목록 출력
		subMenu();
		// 공통 정보
		int select = scan.nextInt();
		System.out.print("브랜드 : ");
		String brand = scan.next();
		System.out.print("제품코드 : ");
		String code = scan.next();
		System.out.print("제품명 : ");
		String name = scan.next();
		// 제품마다 추가 정보
		switch(select) {
		case 1:
			System.out.print("화면크기 : ");
			double size = scan.nextInt();
			/* 주석문 == pro[count++] = new Tv(brand,code,name,size);
			Tv tv = new Tv(brand,code,name,size);
			pro[count++] = tv;
			*/
			pro[count++] = new Tv(brand,code,name,size);
			break;
		case 2:
			System.out.print("냉방면적 : ");
			int area = scan.nextInt();
			pro[count++] = new Aircon(brand,code,name,area);
			break;
		case 3:
			System.out.print("cpu : ");
			double cpu = scan.nextInt();
			System.out.print("ram : ");
			int ram = scan.nextInt();
			pro[count++] = new Notebook(brand,code,name,cpu,ram);
			break;
		default:
			System.out.println("잘못된 메뉴");
			return;
		}
		System.out.println("등록이 완료됐습니다.");
	}

	public static void printProduct() {
		if(count == 0) {
			System.out.println("등록된 제품이 없습니다.");
			return;
		}
		for(int i = 0; i < count; i++) {
			pro[i].print();
		}		
	}

	public static void subMenu() {
		System.out.println("----------");
		System.out.println("추가할 제품");
		System.out.println("1. TV");
		System.out.println("2. 에어컨");
		System.out.println("3. 노트북");
		System.out.println("----------");
		System.out.print("메뉴 선택 : ");
	}

	public static void printMenu() {
		System.out.println("----------");
		System.out.println("메뉴");
		System.out.println("1. 제품 추가");
		System.out.println("2. 제품 확인");
		System.out.println("3. 종료");
		System.out.println("----------");
		System.out.print("메뉴 선택 : ");
		
	}
}