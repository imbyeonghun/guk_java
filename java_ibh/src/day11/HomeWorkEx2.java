package day11;

public class HomeWorkEx2 {

	/*
	 * 두 정수와 산술 연산자를 입력받아 결과를 콘솔에 출력하는 코드를 작성하세요
	 * 메서드를 생성(메서드 사용)
	 */
	
	public static void main(String[] args) {

		int num1 = 1, num2 = 2;
		char operator = '/';
		double res = arithmeticCaculator(num1, operator, num2);
		System.out.println("" + num1 + operator + num2 + " = " + res);
	}
	
	/**
	 * 두 정수와 산술 연산자가 주어지면 산술 연산 결과를 알려주는 메서드
	 * @param num1 정수1
	 * @param num2 정수2
	 * @param operator 산술연산자
	 * @return double 정수1과 정수2를 산술연한한 결과 => double(나누기 때문에)
	 */
	public static double arithmeticCaculator(int num1, char operator, int num2) {
		switch(operator) {
		case '+': return num1 + num2;
		case '-': return num1 - num2;
		case '*': return num1 * num2;
		case '/': return num1 / (double)num2;
		case '%': return num1 % (double)num2;
		}
		// 산술연산자가 아닌경우, 예외처리를 안배워서 0으로 리턴
		// 0이 리턴되는 경우 결과가 0인지 아니면 잘못된 연산자로 인해 0인지 구분 불가
		return 0;
	}
}