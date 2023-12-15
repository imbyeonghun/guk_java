package day06;

import java.util.Scanner;

public class ArithmeticEx2 {

	public static void main(String[] args) {
		// ArithmeticEx1 다른 방식
		
		Scanner scan = new Scanner(System.in);
		// 랜덤 수 2개
		int min = 1, max = 99;
		int r1 = (int)(Math.random() * (max - min - 1) + min);
		int r2 = (int)(Math.random() * (max - min - 1) + min);
		int user,answer = 0;
		
		// 랜덤 산수
		// 0~2랜덤
		int chnum = (int)(Math.random() * 3);
		
		// 산수를 가진 문자열
		String str = "+-*";
		
		char ch = str.charAt(chnum);
		
		System.out.println("" + r1 + ch + r2 + " = ");
		user = scan.nextInt();
		
		// 정답을 계산
		switch(ch) {
		case '+':
			answer = r1 + r2;
			break;
		case '-':
			answer = r1 - r2;
			break;
		case '*':
			answer = r1 * r2;
			break;
		default:
			System.out.println("잘못된 연산자입니다.");
		}
		
		// 맞췄는지 틀렸는지
		if(user == answer) {
			System.out.println("정답");
		}else {
			System.out.println("X");
		}
		scan.close();
	}
}