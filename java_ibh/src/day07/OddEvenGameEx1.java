package day07;

import java.util.Scanner;

public class OddEvenGameEx1 {

	public static void main(String[] args) {
		/* 다음 기능을 가진 프로그램을 작성하세요 메서드 이용
		 * ------------
		 * 메뉴
		 * 1.새 게임
		 * 2. 결과 조회
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 1
		 * ------------
		 * 선택(홀 : 1, 짝 : 0) : 1
		 * 3 홀입니다.
		 * 성공!
		 * ------------
		 * 메뉴
		 * 1.새 게임
		 * 2. 결과 조회
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 2
		 * ------------
		 * 결과 : 1승 0패
		 * ------------
		 * 메뉴
		 * 1.새 게임
		 * 2. 결과 조회
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 3
		 * ------------
		 * 프로그램 종료
		 * */
		Scanner scan = new Scanner(System.in);
		
		int menu;
		int win = 0, lose = 0;
		do {
			// 메뉴 출력 : 메서드
			menuPrint();
			// 메뉴 선택
			menu = scan.nextInt();
			System.out.println("-----------------");
			
			// 선택한 메뉴에 따른 기능 실행
			switch(menu) {
			case 1:
				// 새 게임 : 메서드
				System.out.print("선택(홀 : 1, 짝 : 0) : ");
				int answer = scan.nextInt();   			    // 홀짝 선택
				
				// 입력받은 값과 홀짝 비교
				boolean result = Game(answer);
				
				if(result) {
					System.out.println("성공!");
					System.out.println("-----------------");
					win++;
				}else {
					System.out.println("실패!");
					System.out.println("-----------------");
					lose++;
				}
				break;
				
			case 2:
				// 기록 확인 : 메서드
				resultPrint(win,lose);
				break;
				
			case 3:
				System.out.println("프로그램을 종료합니다.");
				break;
				
			default:
				System.out.println("잘못된 메뉴 선택");
				break;
			}
		}while(menu != 3);
		scan.close();
	}
	
	/* 기능 : 메뉴를 출력하는 메서드
	 * 매개변수 : int menu
	 * 리턴타입 : void
	 * 메서드명 : menuPrint
	 * */
	public static void menuPrint() {
		
		System.out.println("메뉴");
		System.out.println("1. 새 게임");
		System.out.println("2. 기록 확인");
		System.out.println("3. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	
	/* 기능 : 홀짝 판별 게임
	 * 매개변수 : int num
	 * 리턴타입 : boolean
	 * 메서드명 : oddEven
	 * */
	public static boolean Game(int answer) {
		
		int r = random(1, 100);
		
		int evenResult;
		
		// 0또는 1이 아니면 0또는 1로 변환
		if(answer != 0 && answer != 1) {
			if(answer % 2 == 0) {
				answer = 0;
			}else {
				answer = 1;
			}
		}
		
		// 홀,짝 비교
		if(r % 2 == 0) {
			evenResult = 0;
		}else {
			evenResult = 1;
		}
		
		// 입력값과 홀,짝 비교
		if(evenResult == answer) {
			return true;
		}
		return false;
	}
	
	/* 기능 : 결과 조회
	 * 매개변수 : 승,패  int win, int lose
	 * 리턴타입 : void
	 * 메서드명 : resultPrint
	 * */
	public static void resultPrint(int win, int lose) {
		if(win == 0 && lose == 0) {
			System.out.println("플레이 기록이 없습니다.");
			System.out.println("-----------------");
		}else {
			System.out.println("결과 : " + win + "승 " + lose + "패");
			System.out.println("-----------------");

		}
	}
	
	public static int random(int min, int max) {
		// max가 min보다 작으면
		if(max < min) {
			int tmp = max;
			max = min;
			min = tmp;
		}
		int r = (int)(Math.random() * (max - min +1) + min);
		
		return r;
	}
}