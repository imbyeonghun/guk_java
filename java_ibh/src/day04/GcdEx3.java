package day04;

import java.util.Scanner;

public class GcdEx3 {

	public static void main(String[] args) {
		
		// 두 정수의 최대 공약수를 구하는 코드 작성
		// 최대 공약수 중 가장 큰 수
		
		Scanner scan = new Scanner(System.in);
		
		int num1;
		System.out.print("첫 번째 정수를 입력하세요 : ");
		num1 = scan.nextInt();
		
		int num2;
		System.out.print("두 번째 정수를 입력하세요 : ");
		num2 = scan.nextInt();

		int total = 0;

		for(int i = 1; i <= num1; i++) {
			if(num1 % i == 0 && num2 % i == 0) {
				System.out.print( (i == 1? "" : ", ") + i);
				total = i;
			}
		}
		System.out.println("\n" + total);
		
		// num1부터 공약수를 구하고 처음값을 출력후 반복문 끝냄
		for(int i = num1; i >= 1; i--) {
			if(num1 % i == 0 && num2 % i == 0) {
				System.out.print(i);
				break;
			}
		}
		scan.close();
	}
}