package day04;

import java.util.Scanner;

public class RockPaperScissorsEx {

	public static void main(String[] args) {

		/* 다음 기능을 가진 가위바위보 프로그램을 작성하세요
		 * 1. 새게임
		 * 2. 기록
		 * 3. 프로그램 종료
		 * 
		 * - 새게임
		 *  - 컴퓨터가 랜덤으로 내는 가위바위보와 내가 입력한 가위바위보를
		 *    비교하여 이기면 승,지면 패,비기면 승
		 *  - 바위 : R  보 : P 가위 : S
		 *  - 기록
		 *   - 승,무,패를 순서대로 출력
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		int menu;
		int winScore = 0, loseScore = 0, muScore = 0;
		
		do {
			System.out.println("------------------");
			System.out.println("메뉴");
			System.out.println("1. 새 게임");
			System.out.println("2. 기록 확인");
			System.out.println("3. 프로그램 종료");
			System.out.println("------------------");
			System.out.print("메뉴 선택 : ");
			
			menu = scan.nextInt();
			
			switch(menu) {
			case 1:
				// 1~3까지 랜덤 숫자 입력
				int min = 1, max =3;
				char ch1 = (char)(Math.random() * (max-min+1) + min);
				
				// 1~3 숫자를 R,P,S로 변경
				if(ch1 == 1) {
					ch1 ='R';
				}else if(ch1 == 2){
					ch1 ='P';
				}else{
					ch1 ='S';
				}
				
				System.out.println("컴퓨터 : " + ch1);
				
				System.out.print("사용자 : ");
				char ch2 = scan.next().charAt(0);
				
				if(ch1 == 'R') {
					if(ch2 == 'p' || ch2 == 'p') {
						System.out.println("승");
						winScore++;
					}else if(ch2 == 'R' || ch2 == 'r') {
						System.out.println("무");
						muScore++;
					}else if(ch2 == 'S' || ch2 == 's') {
						System.out.println("패");
						loseScore++;
					}else {
						System.out.println("잘못 입력했습니다.");
					}
				}
				if(ch1 == 'P') {
					if(ch2 == 'p' || ch2 == 'p') {
						System.out.println("무");
						muScore++;
					}else if(ch2 == 'R' || ch2 == 'r') {
						System.out.println("패");
						loseScore++;
					}else if(ch2 == 'S' || ch2 == 's') {
						System.out.println("승");
						winScore++;
					}else {
						System.out.println("잘못 입력했습니다.");
					}
				}
				if(ch1 == 'S') {
					if(ch2 == 'p' || ch2 == 'p') {
						System.out.println("패");
						loseScore++;
					}else if(ch2 == 'R' || ch2 == 'r') {
						System.out.println("승");
						winScore++;
					}else if(ch2 == 'S' || ch2 == 's') {
						System.out.println("무");
						muScore++;
					}else {
						System.out.println("잘못 입력했습니다.");
					}
				}
				break;
				
			case 2:
				if(winScore == 0 && loseScore == 0 && muScore ==0) {
					System.out.println("플레이 기록이 없습니다.");
					break;
				}
				System.out.println("승 :" + winScore + "회");
				System.out.println("패 :" + loseScore + "회");
				System.out.println("무 :" + muScore + "회");
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				break;
			default :
				System.out.println("잘못된 메뉴를 선택했습니다.");
				break;
			}
		}while(menu != 3);
		
		/*
		44줄 ~ 100줄 다른 방법
		
		char com,user;
		int random;
		
		com = random == 1 ? 'R' : (random == 2 ? 'P' : 'S');
		if(user == com) {
			System.out.println("무승부");
			muScore++;
		}else if((user == 'R' && com == 'S') ||
				 (user == 'S' && com == 'P') ||
				 (user == 'P' && com == 'R')) {
			System.out.println("유저 승!");
			winScore++;
		}else {
			System.out.println("유저 패!");
			loseScore++;
		}
		*/
		scan.close();
	}
}