package day02;

public class PrefixIncrementOperatorEx1 {

	// 증감 연산자 예제
	public static void main(String[] args) {

		int num1 = 1, num2 = 1;
		// num1은 전위형 증가연산자, num2는 후위형 증감연산자
		System.out.println("증가전 num1 = " + num1 + ", num2 = " + num2);
		// num1은 1에서 2 증가 후에 "증가중 num1 = "문자열과 더해짐
		// num2는 ", num2 = "라는 문자열과 더하고 num2를 1에서 2로 증가
		System.out.println("증가중 num1 = " + ++num1 + ", num2 = " + num2++);
		System.out.println("증가후 num1 = " + num1 + ", num2 = " + num2);
		
		System.out.println("===========================");
		// 전위형과 후위형 동작이 이해가 되지않아 전위형 하나만을 이용해서 후위형도 구현
		num1 = 1;
		num2 = 1;
		System.out.println("증가전 num1 = " + num1 + ", num2 = " + num2);
		++num1;
		System.out.println("증가중 num1 = " + num1 + ", num2 = " + num2);
		++num2;
		System.out.println("증가후 num1 = " + num1 + ", num2 = " + num2);
	}

}
