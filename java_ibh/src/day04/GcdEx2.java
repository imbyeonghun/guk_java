package day04;

import java.util.Scanner;

public class GcdEx2 {

	public static void main(String[] args) {

		// 두 정수의 공약수를 출력하는 예제를 작성하세요.
		// 약수 : 나누어서 떨어지는 수
		// 공약수 : 공통으로 있는 수 
		
		Scanner scan = new Scanner(System.in);
		int num1;
		System.out.print("첫 번째 정수를 입력하세요 : ");
		num1 = scan.nextInt();
		int num2;
		System.out.print("두 번째 정수를 입력하세요 : ");
		num2 = scan.nextInt();

		// num1 약수
		for(int i = 1; i <= num1; i++) {
			if(num1 % i == 0) {
				System.out.print(i+ (i == num1? "\n" : ", "));
			}
		}
		
		// num2 약수
		for(int a = 1; a <= num2; a++) {
			if(num2 % a == 0) {
				System.out.print(a+ (a == num2? "\n" : ", "));
			}
		}
		
		// num1,num2 공약수
		for(int i = 1; i <= num1; i++) {
			if(num1 % i == 0 && num2 % i == 0) {
				System.out.print( (i == 1? "" : ", ") + i);
			}
		}
		scan.close();
	}
}