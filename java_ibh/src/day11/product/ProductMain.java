package day11.product;

import java.util.Scanner;

public class ProductMain {

	/*
	 * 제품을 관리하는 프로그램을 주현하세요
	 * 메뉴
	 * 1. 제품 입고
	 *  - 제품을 판매하기 위해 다른 곳에서 제품을 구매
	 *  - 새 제품은 추가,기존에 있는 제품은 수량 추가
	 *  
	 * 2. 제품 판매
	 *  - 입고된 제품 판매
	 *  
	 * 3. 제품 수정 [가격]
	 * 
	 * 4. 매출 내역 조회
	 * - 일자별로 조회
	 * 
	 * 5. 제품 조회
	 * 6. 종료
	 */
	
	private static Scanner scan = new Scanner(System.in);
	private static Product product[] = new Product[10];
	private static Product list[] = new Product[10];
	private static int procount = 0; 		// 현재 등록된 제품 개수
	private static int salecount = 0; 		// 현재 제품 판매된 횟수
	
	public static void main(String[] args) {
		
		int menu;
		
		do {
			printmain();
			menu = scan.nextInt();
			runMain(menu);
		}while(menu != 6);
	}


	/**
	 * 메인메뉴에서 선택한 기능 실현
	 * @param menu 메인메뉴에서 입력받은 값
	 */
	private static void runMain(int menu) {
		
		switch(menu) {
		case 1:
			// 제품 등록
			productStore();
			break;
		case 2:
			// 제품 판매
			productsale();
			break;
		case 3:
			// 제품 가격 수정
			productModify();
			break;
		case 4:
			// 판매 내역 조회
			listSearch();
			break;
		case 5:
			// 현재 등록된 제품 조회
			printMenu();
			break;
		case 6:
			System.out.println("종료");
			break;
		default:
			System.out.println("잘못된 메뉴선택");
		}
	}

	
	/**
	 * 판매 내역 조회
	 */
	private static void listSearch() {
		for(int i = 0; i < salecount; i++) {
			
		}
		System.out.println("현재 판매액 : " + list[0].getSalesList() + "원");
	}


	/**
	 * 제품 가격 수정
	 */
	private static void productModify() {
		// 구매할 제품, 개수 입력
		System.out.print("수정할 제품명 : ");
		String modifyName = scan.next();
		
		int index = -1;
		// 반복문 : 전체
		for(int i = 0; i < procount; i++) {
			// 수정할 제품의 위치 찾기
			if(product[i].equals(modifyName)) {
				index = i;
				break;
			}
		}
		// 구매할 제품이 없으면
		if(index == -1) {
			System.out.println("해당 제품이 없습니다.");
		}else {
			// 구매할 제품이 있으면			
			System.out.print("수정할 가격 : ");
			int modifyPrice = scan.nextInt();
			product[index].priceModify(modifyPrice);
			System.out.println("수정됐습니다.");
		}
	}


	/**
	 * 제품 판매
	 */
	public static void productsale() {
		
		// 구매할 제품, 개수 입력
		System.out.print("구매할 제품명 : ");
		String saleName = scan.next();
		
		int index = -1;
		// 반복문 : 전체
		for(int i = 0; i < procount; i++) {
			// 구매할 제품의 위치 찾기
			if(product[i].equals(saleName)) {
				index = i;
				break;
			}
		}
		
		// 구매할 제품이 없으면
		if(index == -1) {
			System.out.println("해당 제품이 없습니다.");
		}else {
			// 구매할 제품이 있으면			
			System.out.print("구매할 개수 : ");
			int saleCount = scan.nextInt();
			
			System.out.print("구매할 일자 : ");
			String saleDate = scan.next();
			
			// 해당 제품 개수 - 구매할 개수
			list[index].countSub(saleCount);

			int sale = saleCount * product[index].getProductPrice();
			
			// 일자가 들어간 생성자 생성및 연결
			Product date = new Product(saleName,saleDate,saleCount,sale);
			list[saleCount] = date;
			
			// 매출 계산
			int salesum = product[index].getSalesList() + 
						 (saleCount * product[index].getProductPrice());
			
			// 매출 값 적용
			product[index].setSalesList(salesum);
			
			// 판매 횟수 증가
			saleCount++;
		}
	}
	

	/**
	 * 1. 제품 입고
	 *  - 제품을 판매하기 위해 다른 곳에서 제품을 구매
	 *  - 새 제품은 추가,기존에 있는 제품은 수량 추가
	 */
	private static void productStore() {
		
		System.out.print("등록할 제품명 : ");
		String name = scan.next();

		int index = -1;
		for(int i = 0; i < procount; i++) {
			if(product[i].equals(name)) {
				index = i;
				break;
			}
		}
		
		// 일치하는 제품이 없으면
		if(index == -1) {
			//이어서 등록
			System.out.print("등록할 수량 : ");
			int count = scan.nextInt();
			
			System.out.print("등록할 가격 : ");
			int price = scan.nextInt();
			
			Product pro = new Product(name, count, price);
			product[procount] = pro;
			
			// 제품 수 증가
			procount++;
			
			// 꽉 찼을 때 배열 크기 늘리기
			if(index == procount) {
				Product tmp[] = new Product[product.length + 10];
				System.arraycopy(product, 0, tmp, 0, procount);
				tmp = product;
			}
			return;
		}else {
			// 추가
			System.out.print("추가할 수량 : ");
			int count = scan.nextInt();
			product[index].countSum(count);
			return;
		}
	}


	/**
	 * 메인 메뉴 출력메서드
	 */
	public static void printmain() {
		
		System.out.println("----- 메뉴 -----");
		System.out.println("1. 제품 입고");
		System.out.println("2. 제품 판매");
		System.out.println("3. 제품 수정");
		System.out.println("4. 판매 내역 조회");
		System.out.println("5. 제품 조회");
		System.out.println("6. 종료");
		System.out.println("---------------");
		System.out.print("선택 : ");
	}

	
	/**
	 * 현재 등록된 제품의 메뉴 출력
	 */
	public static void printMenu() {
		if(procount == 0) {
			System.out.println("등록된 제품이 없습니다.");
			return;
		}
		
		for(int i = 0; i < procount; i++) {
		System.out.print("제품명 : " + product[i].getProductName());
		System.out.print(" 수량 : " + product[i].getProductCount());
		System.out.println(" 가격 : " + product[i].getProductPrice());
		}
	}
}