package day06;

import java.util.Scanner;

public class ArithmeticEx1 {

	public static void main(String[] args) {
		/*
		 랜덤으로 산수(+,-,*) 문제를 생성하여 맞추는 게임
		 단, 숫자 범위는 1~99, 연산자는 +,-,*만
		 1 + 2 = 3
		 정답입니다.
		*/
		
		// 424344
		
		Scanner scan = new Scanner(System.in);
		// 랜덤 수 2개
		int min = 1, max = 99;
		int r1 = (int)(Math.random() * (max - min - 1) + min);
		int r2 = (int)(Math.random() * (max - min - 1) + min);
		int user1,answer;
		
		// 랜덤 산수
		int ch = (int)(Math.random() * 3 + 1);
		
		switch(ch) {
			case 1:
				System.out.print(r1 + " + " + r2 + " = ");
				answer = r1 + r2;
				user1 = scan.nextInt();
				if(user1 == answer) {
					System.out.println("정답");
				}else {
					System.out.println("X");
				}
				break;
			case 2:
				if(r1 > r2) {
					answer = r1 - r2;
					System.out.print(r1 + " - " + r2 + " = ");
					user1 = scan.nextInt();
					if(user1 == answer) {
						System.out.println("정답");
					}else {
						System.out.println("X");
					}
				}else {
					answer = r2 - r1;
					System.out.print(r2 + " - " + r1 + " = ");
					user1 = scan.nextInt();
					if(user1 == answer) {
						System.out.println("정답");
					}else {
						System.out.println("X");
					}
				}
				break;
			case 3:
				System.out.print(r1 + " * " + r2 + " = ");
				answer = r1 * r2;
				user1 = scan.nextInt();
				if(user1 == answer) {
					System.out.println("정답");
				}else {
					System.out.println("X");
				}
				break;
		}
		scan.close();
	}
}