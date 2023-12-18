package day06;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWorkEx2 {

	public static void main(String[] args) {
		/* 
		 숫자 야구게임을 구현하세요.
		  - 기록은 최대 5개. 이전 기록은 삭제
		  - 1~9사이의 중복되지 않은 3개의 수를 랜덤으로 선택해서 해당 숫자를 맞추는 게임
		  - S : 숫자가 있고, 위치가 같은 경우
		  - B : 숫자가 있지만 위치가 다른 경우
		  - O : 일치하는 수자가 하나도 없는 경우
		  - 3S가 되면 게임이 종료
		  
		  메뉴
		  1. 새게임
		  2. 기록확인
		  3. 프로그램 종료
		  메뉴 선택 : 1
		  
		  (랜덤으로 생성된 숫자 : 3 9 1)
		  입력 : 1 2 3
		  결과 : 2B
		  입력 : 4 5 6
		  결과 : O
		  입력 : 7 9 8
		  결과 : 1S
		  입력 : 3 1 9
		  결과 : 1S2B
		  입력 : 3 9 1
		  결과 : 3S
		  정답입니다.
		  도전 횟수 : 5
		  현재 1등입니다. 이름을 기록하세요.
		  이름 : JIK
		 
		  메뉴
		  1. 새게임
		  2. 기록확인
		  3. 프로그램 종료
		  메뉴 선택 : 2
		  --기록--
		  1. JIK : 5회
		  */
		
		Scanner scan = new Scanner(System.in);
		
		int menu;

		// 맞춰야하는 숫자 3개 랜덤으로 생성
		int min = 1, max = 9;
		int ran1 = (int)(Math.random() * (max - min + 1) - min);
		int ran2 = (int)(Math.random() * (max - min + 1) - min);
		int ran3 = (int)(Math.random() * (max - min + 1) - min);
		int record = 0;				 // 기록
		int coin = 0;
		int S = 0, B = 0, O = 0; 	 // s,b,o 초기화
		
		int[] bestRecord = new int[6];   // 상위 기록 5개 + 새로 추가할 배열 1개
		String[] naming = new String[6]; // 상위기록 이름 5개 + 새로 추가할 배열 1개 
		
		// 랜덤 3수를 배열에 넣고 입력받은 값도 배열에 넣고
		int[] pass = new int[] {ran1,ran2,ran3};
		int[] user = new int[3];
		
		// records를 가장 큰 값으로 초기화
		for(int i = 0; i < bestRecord.length; i++) {
			bestRecord[i] = Integer.MAX_VALUE;		// Integer.MAX_VALUE : int 중에 가장 큰 값 
		}
		
		int count = 0;
		while(count < pass.length) {
			// 랜덤 수 생성
			int r = (int)(Math.random() * (max - min + 1) + min);
			
			// 중복하지 않게
			int i;
			for(i = 0; i<count; i++) {
				if(r == pass[i]) {
					break;
				}
			}
			if(i == count) {
				pass[count++] = r;
			}
		}
		
		//반복문 선택한 메뉴가 프로그램 종료가 아닐때까지
		do {
			//메인 메뉴출력
			System.out.println("메뉴");
			System.out.println("1.새 게임");
			System.out.println("2.기록 확인");
			System.out.println("3.프로그램 종료");
			System.out.print("메뉴 선택 : ");
			
			//메인메뉴를 선택
			menu = scan.nextInt();
			
			//선택한 메인메뉴에 따른 기능 실행
			switch(menu) {
			case 1:
				do{
					// 숫자 3개 입력받기
					System.out.print("숫자 3개를 입력하세요 : ");
					
					int num1 = scan.nextInt();
					int num2 = scan.nextInt();
					int num3 = scan.nextInt();
					
					user = new int[] {num1,num2,num3};
					
					System.out.print(pass[0]);
					System.out.print(pass[1]);
					System.out.println(pass[2]);
					
					// 입력받은 값을 초기화 해준다.
					S = 0;
					B = 0;
					O = 0;
					
					// 인자가 맞는지, 숫자가 맞는지 확인하고
					for(int i = 0; i < pass.length; i++) {
						if(pass[i] == user[i]) {
							System.out.println("S");
							S++;
							continue;
						}else if((pass[i] != user[i]) && ((user[i]) == pass[0] )) {
							System.out.println("B");
							B++;
							continue;
						}else if((pass[i] != user[i]) && ((user[i]) == pass[1] )) {
							System.out.println("B");
							B++;
							continue;
						}else if((pass[i] != user[i]) && ((user[i]) == pass[2] )) {
							System.out.println("B");
							B++;
							continue;
						}else {
							System.out.println("O");
							O++;
							continue;
						}
					} // for
					
					System.out.println(S + "S " + B + "B " +  O + "O");
					record++;
					
				}while(S != 3); // end do
				
				/*
				nextLine() 주의 
				이전 scan에서 next,nextint,nextLine에서 enter를 저장하고 있기 때문에 
				next,nextint는 엔터를 버리지만 nextLine은 엔터를 가져오기 때문에 조심
				*/
				
				System.out.println("도전 횟수 : " + record);
				System.out.println("이름을 기록하세요.");
				System.out.print("이름 : ");
				String name = scan.next(); // 기록할 이름
				
				System.out.println("---------");
				
				coin++;		  // 한게임 끝나면 플레이 수 증가		
				
				if(bestRecord[0] == 0) {
					bestRecord[0] = record; 	// 첫 게임이면 0번째 인자에 넣음
				}else {
					// 새로운 기록을 6번째 인자에 넣고 해당 배열을 오름차순으로 정렬
					bestRecord[5] = record;
					Arrays.sort(bestRecord);
				}
				
				naming[5] = name;
				
				for(int j = 0; j < naming.length; j++) {
					if(bestRecord[j] == record) {
						naming[j] = naming[5];
					}
				}
				
				int index = 0;		// 새 게임의 기록이 들어갈 위치 저장할 변수
				for(int i = 0; i < coin; i++) {
					/*
					 * 1 3 5 7 0
					 * 1 3 3 5 7
					 * 1 2 3 5 7
					 */
					
					// 현재 게임의 기록이 들어갈 위치를 찾음
					if(coin < bestRecord[i]) {
						index = i;
						break;
					}
				}
				
				coin = coin < 5 ? coin + 1 : coin;
				for(int i = coin - 1; i > index; i--) {
					naming[i] = naming[i -1];
				}
				naming[index] = name;
				
				record = 0;
				break;
				
			case 2:
				if(coin == 0) {
					System.out.println("기록이 없습니다.");
				}else {
					for(int i = 0; i < coin; i++) {
						System.out.println((i + 1) + "등 : " + bestRecord[i] + "회 -" + naming[i]);
					}
				}
				break;
				
			case 3:
				System.out.println("프로그램을 종료합니다.");
				break;
				
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}while( menu != 3);
		
		scan.close();
	} // main
} // class