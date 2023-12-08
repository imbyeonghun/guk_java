package day01;

public class variableEx2 {

	// 정수형 변수 선언 예제
	public static void main(String[] args) {

		/*8bit  = 1byte
		 * byte  = -2의 7제곱 ~ 2의 7제곱 -1 
		 * short = 2byte = -2의 15제곱 ~ 2의 15제곱 -1 
		 * int   = 4byte = -2의 31제곱 ~ 2의 31제곱 -1 Max 200만
		 * long  = 8byte = -2의 63제곱 ~ 2의 63제곱 -1 */ 
		
		System.out.println("\n byte형");
		byte num1 = 1;
		System.out.println(num1);
		
		// byte : 128은 저장 못함
		// byte num2 = 128;
		
		// byte 양수 표현 범위를 넘어서 오버플로우 발생
		byte num3 = (byte)(127 + 1);
		System.out.println(num3);
		
		// byte 음수 표현 범위를 넘어서 언더플로우 발생
		byte num4 = (byte)(-128 - 1);
		System.out.println(num4);
		
		System.out.println("\n int형");
		
		int num5 = 128;
		System.out.println(num5);
		
		// int 양수 표현 범위를 넘어서 오버플로우 발생
		// int num6 = 123456789123;
		
		System.out.println("\n 8진수");
		
		// 8진수
		int num7 = 010;  // 8진수 10
		int num8 = 0x10; // 16진수 10 
		int num9 = 0b10; // 2진수 10
		
		System.out.println(num7);
		System.out.println(num8);
		System.out.println(num9);
		System.out.println();
		
		System.out.println("\n long형");
		
		// 평소에 수는 기본타입이 int
		// 뒤에 L, l 을 붙어야함
		long num10 = 123456789123L;
		System.out.println(num10);
	}

}
