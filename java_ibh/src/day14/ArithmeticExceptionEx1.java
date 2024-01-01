package day14;

import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArithmeticExceptionEx1 {

	public static void main(String[] args) {
		// 두 정수와 산술 연산자를 입력받아 산술연산하는 코드 작성
		// 단, 0으로 나눌 때 예외처리 적용
		
		/*
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 1 : ");
		int num1 = scan.nextInt();
		System.out.print("연산자 : ");
		String str = scan.next();
		System.out.print("정수 2 : ");
		int num2 = scan.nextInt();
		double res = 0;
		switch(str) {
		case "+":
			res = num1 + num2;
			break;
		case "-":
			res = num1 - num2;
			break;
		case "*":
			res = num1 * num2;
			break;
		case "/":
			try {
				res = num1 / num2;
			}catch(ArithmeticException e) {
				System.out.println("0으로 나누면 안됩니다.");
				return;
			}
			break;
		case "%":
			res = num1 % num2;
			break;
		}
		String pattern = "{0} {1} {2} = {3}";
		System.out.println(MessageFormat.format(pattern, num1,str,num2,res));
		*/
		
		// -----------------------------------------
		
		try {
		Scanner scan = new Scanner(System.in);
		System.out.print("계산식 (1 + 2) : ");
		int num1 = scan.nextInt();
		char str = scan.next().charAt(0);
		int num2 = scan.nextInt();
		double res = 0;
		switch(str) {
		case '+': res = num1 + num2; break;
		case '-': res = num1 - num2; break;
		case '*': res = num1 * num2; break;
		case '/': res = num1 / num2; break;
		case '%': res = num1 % num2; break;
		}
		String pattern = "{0} {1} {2} = {3}";
		System.out.println(MessageFormat.format(pattern, num1,str,num2,res));
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}catch(InputMismatchException e) {
			System.out.println("입력을 잘 못했습니다.");
		}
	}
}