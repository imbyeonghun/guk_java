package day02;

import java.util.Scanner;

public class TestEx6 {

	public static void main(String[] args) {

		// 산술연산자와 두 정수를 입력받아 
		// 산술연산자에 맞는 연산결과를 출력하는 코드
		// 두 정수와 연산자 입력
		
		int total = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("첫 번째 정수를 입력하세요 : ");
		int num1 = scan.nextInt();
		
		System.out.print("산술연산자를 입력하세요 : ");
		String ch = scan.next();
		
		/* equals함수가 아닌 비교연산자로 하는 법 
		 * 
		 * System.out.print("산술연산자를 입력하세요 : ");
		 * char ch2 = scan.next().charAt(0); 
		 * else if(ch2 == '%') { 
		 * total = num1 % num2;
		 * System.out.println(num1 + " % " + num2 + " = " + total); 
		 * }
		 */
		
		System.out.print("두 번째 정수를 입력하세요 : ");
		int num2 = scan.nextInt();
		
		if(ch.equals("+")) {
			total = num1 + num2;
			System.out.println(num1 + " + " + num2 + " = " + total);
		}else if(ch.equals("-")) {
			total = num1 - num2;
			System.out.println(num1 + " - " + num2 + " = " + total);
		}else if(ch.equals("*")) {
			total = num1 * num2;
			System.out.println(num1 + " * " + num2 + " = " + total);
		}else if(ch.equals("/")) {
			System.out.println(num1 + " / " + num2 + " = " + (num1 / (double)num2));
		}else if(ch.equals("%")) {
			total = num1 % num2;
			System.out.println(num1 + " % " + num2 + " = " + total);
		}else {
			System.out.println("입력받은 문자는 산술연산자가 아닙니다.");
		}
		
		scan.close();
	}
}