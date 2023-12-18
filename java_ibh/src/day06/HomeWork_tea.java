package day06;

import java.util.Scanner;

public class HomeWork_tea {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		// 컴퓨터가 랜덤으로 중복되지 않는 숫자 3개를 생성(1~9)
		int min = 1, max = 9;
		int com[] = new int[3];
		int count = 0;
		
		while(count < com.length) {
			
			// 랜덤한 수 생성
			int r = (int)(Math.random() * (max - min +1) + min);
			
			// 중복 확인
			int i;
			for(i = 0; i<count; i++) {
				if(com[i] == r) {
					break;
				}
			}
			
			// 중복되지 않으면 저장 후 count 증가
			if(i == count) {
				com[count++] = r;
			}
		}
		
		//출력
		for(int i = 0; i<com.length; i++) {
			System.out.print(com[i] + " ");
		}
		System.out.println();
		
		int strike, ball;
		int[] user = new int[com.length];
		
		// 반복문 : 맞출때까지 => 스트라이크의 개수가 3개 미만인 경우 반복
		do {
			// 중복되지 않은 숫자 3개 입력
			count = 0;
			while(count < user.length) {
				int input = scan.nextInt();
				int i;
				
				for(i = 0; i < count; i++) {
					if(user[i] == input) {
						break;
					}
				}
				
				// 중복되지 않으면 저장 후 count증가
				if(i == count) {
					user[count++] = input;
				}
			}
			
			// 스트라이크와 볼의 개수를 계산
			strike = 0;
			ball = 0;
			for(int i = 0; i < com.length; i++) { 		// com의 한개와
				for(int j = 0; j < user.length; j++) {  // user의 세개를 비교 반복
					if(com[i] == user[j]) {
						if(i == j) {  // i == j  => 위치가 같음
							strike++;
						}else {
							ball++;
						}
					}
				}
			}
			
			// 스트라이크와 볼의 개수에 따른 결과를 출력
			if(strike != 0) {
				System.out.print(strike + "S");
			}
			if(ball != 0) {
				System.out.print(ball + "B");
			}
			if(strike == 0 && ball == 0) {
				System.out.print("O");
			}
			System.out.println();
			
		}while(strike < 3);
		
		// 정답입니다.를 출력
		System.out.println("정답입니다.");
		scan.close();
	}
}