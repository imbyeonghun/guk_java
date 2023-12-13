package day04;

import java.util.Scanner;

public class UpDownGame {

	public static void main(String[] args) {
		/* up down 게임 구현
		 * - 다음과 같은 메뉴를 가져야 합니다.
		 * 1. 새게임
		 * 2. 최고기록 확인
		 * 3. 프로그램 종료
		 * 
		 * - 새 게임 UpDown게임 시작
		 * 	- 랜덤으로 생성된 수를 맞추는 게임
		 *  - 맞췄을 때 맞춘 회수를 출력하고 메뉴로 돌아감 
		 * - 최고기록 확인 업다운게임을 하면서 맞춘 횟수 중 가장 적은 횟수를 알려줌
		 * - 프로그램 종료 
		 * */
		
		int count =0;
		int menu;
		int sum = 0;
		
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println("------------------");
			System.out.println("메뉴");
			System.out.println("1. 새게임");
			System.out.println("2. 최고기록 확인");
			System.out.println("3. 프로그램 종료");
			System.out.println("------------------");
			System.out.print("메뉴 선택 : ");
			menu = scan.nextInt();
			switch(menu) {
			case 1: 
				int min = 1, max = 100;
				int r = (int)(Math.random() * (max-min+1) + min);
				int num = min - 1;
				
				//반복문 : 조건식만 입력
				for( ; num != r; ) {
					//정수 입력
					System.out.print("정수 : ");
					num = scan.nextInt();
					count++;
					
					//정수와 랜덤한 수를 비교 후 결과를 출력
					if(num > r) {
						System.out.println("Down!");
					}else if(num < r) {
						System.out.println("Up!");
					}else {
						System.out.println("정답입니다!!");
						System.out.println("도전 횟수는 " + count + "회 입니다.");
						if(sum == 0 || count < sum) {
							sum = count;
						}
						count = 0;
					}
				}
				break;
			case 2:
				if(sum == 0) {
					System.out.println("게임을 실행하지 않았습니다.");
				}else {
				System.out.println("현재 최고기록은 " + sum + "회 입니다.");
				}
				break;
			}
		}while(menu != 3);
		System.out.println("프로그램을 종료합니다.");
		
		scan.close();
	}
}