package day02;

import java.util.Scanner;

public class TestEx5 {

	public static void main(String[] args) {

		// 월을 입력받아서 월의 계절을 출력하세요
		// 3~5 : 봄 6~8 : 여름 9~11 : 겨울 12,1,2 : 겨울
		// 그 외 : 잘못된 월
		
		Scanner scan = new Scanner(System.in);
		System.out.print("월을 입력하시오 : ");
		int month = scan.nextInt();
		
		// if문
		if(month < 1 || month > 12) {
			System.out.println("잘못된 값입니다.");
		}else if(month <= 2 || month == 12){
			System.out.println("겨울");
		}else if(month <=5) {
			System.out.println("봄");
		}else if(month <=8) {
			System.out.println("여름");
		}else{
			System.out.println("가을");
		}
		
		// switch문
		/*
		 * switch (month) { case 3,4,5: { System.out.println("봄"); break; } case 6,7,8:
		 * { System.out.println("여름"); break; } case 9,10,11: {
		 * System.out.println("가을"); break; } case 1,2,12: { System.out.println("겨울");
		 * break; } default: System.out.println("잘못된 값입니다."); }
		 */
		
		scan.close();
	}
}