package day14;

import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ArithmeticExceptionEx2 {

	public static void main(String[] args) {
		// 두 정수와 산술 연산자를 입력받아 산술연산하는 코드 작성
		// 메서드 이용, throw와 throws를 이용
		
		Scanner scan = new Scanner(System.in);
		System.out.print("계산식 (1 + 2) : ");
		
		try {
			int num1 = scan.nextInt();
			char str = scan.next().charAt(0);
			int num2 = scan.nextInt();
			double res = print(num1,str,num2);
			String pattern = "{0} {1} {2} = {3}";
			System.out.println(MessageFormat.format(pattern, num1,str,num2,res));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public static double print(int num1, char str, int num2) throws RuntimeException {
		double res = 0;
		switch(str) {
		case '+': return res = num1 + num2;
		case '-': return res = num1 - num2;
		case '*': return res = num1 * num2;
		case '%': 
			if(num2 == 0) {
				throw new ArithmeticException("0으로 나눌 수 없습니다.");
			}
			return res = num1 / num2;
		case '/': 
			if(num2 == 0) {
				throw new ArithmeticException("0으로 나눌 수 없습니다.");
			}
			return res = num1 % (double)num2;
		default:
			throw new RuntimeException(str + "는 산술연산자가 아닙니다.");
		}
	}
}