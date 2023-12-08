package day01;

public class TypeCastingEx2 {

	// 강제(명시적) 자료형 변환 예제
	public static void main(String[] args) {

		// int이므로 소수점이 사라짐
		// 실수인 값 3.14를 int로 변환
		int num1 = (int)3.14;
		System.out.println(num1);
		
		// num1에 3이 저장되있어서 byte에 바로 저장되는것처럼 보이지만
		// 값이 아닌 타입이 중요해서 저장안됨
		// 강제 형변환해야함
		byte num2 = (byte)num1;
		System.out.println(num2);
		// byte num3 = 3;
		
		byte num4 =(byte)128;
		System.out.println(num4);
		
		// 에러가 아니지만 필요에 의해 형변환하는 경우
		System.out.println(1/2);
		System.out.println((double)1/2);
		
		// 같은 타입의 변수를 여러개 선언하는 경우
		int num5, num6 = 4, num7 = 6;
		num5 = 2;
		System.out.println(num5);
		System.out.println(num6);
		System.out.println(num7);
	}
}
