package day06;

import java.util.Scanner;

public class OddEvenGameEx1 {

	public static void main(String[] args) {
		// 홀짝 맞추기 게임

		Scanner scan = new Scanner(System.in);
		
		int num;
		int min = 1, max = 100;
		int totalMoney = 10000;
		
		// 아래 코드를 현재 금액이 0이 될때까지 반복하도록 작성 
		while(totalMoney > 0){
			// num 1~100사이의 랜덤한 수를 생성하는 코드를 작성
			num = (int)(Math.random() * (max - min + 1) + min);
			
			// 사용자가 게임에 투입할 금액을 입력하는 코드를 작성(1~현재 금액까지)
			System.out.print("게임에 투입할 금액을 입력하세요(1~" + totalMoney + ") : ");
			int money = scan.nextInt();
			
			if(money >= 1 && money <= totalMoney) {
				// money가 totaMoney를 안넘으면
				// 정상 실행
			}else {
				// money가 totaMoney를 넘으면 
				// totalMoney로 변경해서 실행
				money = totalMoney;
			}
			
			// money가 totaMoney 다른예제 조건문 활용
			// money = money > totalMoney ? totalMoney : money;
			
			// 사용자가 0또는 1을 입력받는 코드를 작성
			System.out.print("홀(1),짝(0)을 맞춰보세요 :");
			int user = scan.nextInt();
			
			if(num % 2 == 0) {
				System.out.println(num + "은 짝수");
			}else {
				System.out.println(num + "은 홀수");
			}
			
			if(user == num % 2) {
				System.out.println("정답입니다.");
				totalMoney += money;
			}else {
				System.out.println("틀렸습니다.");
				totalMoney -= money;
			}
			
			System.out.println("현재 남은 금액은 : " + totalMoney);
			System.out.println("=======");
		} // while
		System.out.println("배팅금액이 없어서 게임을 종료합니다.");
		scan.close();
	} // main
} // OddEvenGame