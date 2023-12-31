package day02;

public class ArithmeticOperatorEx1 {

	// 산술 연산자 예제
	public static void main(String[] agrs) {
		int num1 = 1,num2 = 2;
		
		// 잘못 된 예제
		System.out.println(num1 + " + " + num2 + " = " + num1 + num2);
		
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
		System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
		System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
		// 소수점 출력을 위해 형변환 예제 
		System.out.println(num1 + " / " + num2 + " = " + (num1 / (double)num2));
		System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
		
		// /와 %는 0으로 나눌 수 없다. 예외가 발생할 수 있다.
		num2 = 0;
		// 정수 / 0은 예외 발생
		// System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
		
		// 정수 / 0.0은 예외가 발생하지 않고, Infinity로 계산
		System.out.println(num1 + " / " + num2 + " = " + (num1 / (double)num2));
	}
}
