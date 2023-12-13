package day04;

import java.util.Scanner;

public class LcmEx1 {

	public static void main(String[] args) {

		// 두 정수의 최소 공배수를 구하는 코드를 작성하세요
		
		Scanner scan = new Scanner(System.in);
		
		int num1;
		System.out.print("첫 번째 정수를 입력하세요 : ");
		num1 = scan.nextInt();
		
		int num2;
		System.out.print("두 번째 정수를 입력하세요 : ");
		num2 = scan.nextInt();
		
		int total = num1 * num2;
		
		// i가 1부터 1씩 증가
		for(int i = 1; i <= total; i++) {
			if(i % num1 == 0 && i % num2 == 0) {
				System.out.println(num1 + "와 " + num2 + "의 최소공배수는 " + i);
				break;
			}
		}
		
		// i가 num1부터 num1씩 중가
		for(int i = num1; i <= total; i+=num1) {
			if(i % num2 == 0) {
				System.out.println(num1 + "와 " + num2 + "의 최소공배수는 " + i);
				break;
			}
		}
		
		scan.close();
	}
}