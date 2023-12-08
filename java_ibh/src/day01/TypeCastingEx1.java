package day01;

public class TypeCastingEx1 {

	// 자동 자료형 변환 예제
	// 작은 자료형을 큰 자료형으로 변환
	// 정수를 실수로 변환
	public static void main(String[] args) {

		// 리터럴 1은 타입이 int, num1 타입은 double
		// 자동형변환으로 인해 double로 저장
		double num1 = 1;
		System.out.println(num1);
		
		// 2 : int, num2 : long
		// 자동형변환으로 인해 long으로 저장
		long num2 = 2;
		System.out.println(num2);
		
		// 문자 a의 아스키코드값이 num3에 저장
		char ch = 'a';
		int num3 = ch;
		System.out.println(num3);
	}

}
