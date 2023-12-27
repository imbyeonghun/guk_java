package day13;

public class WrapperEx1 {

	public static void main(String[] args) {
		int num1 = 1;
		Integer num2 = 1;
		num2 = null;	// Integer는 null값이 가능함
		num2 = num1;
		System.out.println(num2);
		
		// Integer값을 int에 저장 가능
		num2 = 20;
		num1 = num2;
		System.out.println(num1);
		
		/*
		 단, Integer에 null이 있을 경우 => 에러
		 num2 = null;
		 num1 = num2;
		*/
		
		// 문자열을 정수로 변환
		String str = "12345";
		int num3 = Integer.parseInt(str);
		System.out.println(num3 * 10);
	}
}