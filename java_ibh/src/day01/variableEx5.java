package day01;

public class variableEx5 {

	// 문자열 변수 선언 예제
	public static void main(String[] args) {

		// String 클래스 : 문자열을 저장하는 클래스로 다양한 기능을 제공
		// 참조변수는 null 사용 가능
		String str1 = null;
		System.out.println(str1);
		
		// int는 null을 저장할 수 없음
		// int num1 = null;
		
		String str2 = "Hello";
		System.out.println(str2);
		
		// 문자는 저장할 수 없음
		// String str3 = 'A';
		String str4 = "A";
		System.out.println(str4);
		
		// 빈 문자열도 가능
		String str5 ="";
		System.out.println(str5);
		
		// 문자열에 정수, 실수, 문자, 논리값을 더하면 문자열이 됨
		// 빈문자열 'A'는 "A"가 됨
		String str6 = "" + 'A';
		System.out.println(str6);
	}
}
