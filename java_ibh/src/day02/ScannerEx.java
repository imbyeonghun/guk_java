package day02;

import java.util.Scanner;

public class ScannerEx {

	// Scanner 예제
	public static void main(String[] args) {
		
		// 콘솔창에서 정수, 실수, 문자, 문자열을 입력받는 예제 
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int num1 = scan.nextInt();
		System.out.println("입력받은 정수 : " + num1);
		
		System.out.print("실수를 입력하세요 : ");
		double num2 = scan.nextDouble();
		System.out.println("입력받은 실수 : " + num2);
		
		// 한 단어만 입력받음
		System.out.print("문자를 입력하세요 : "); 
		String ch2 = scan.next();
		System.out.println("입력받은 문자 : " + ch2);

		// 한 줄을 입력받는 예제
		System.out.print("문자열을 입력하세요 : ");
		// scan.nextLine() : 한 번에 입력받은 값(spacebar,enter포함) 위에서 먼저 찾는 입력값을 출력한다
		scan.nextLine(); // 실수 다음에 입력한 엔터를 처리
 		String ch1 = scan.nextLine();
		System.out.println("입력받은 문자열 : " + ch1);

		// 문자를 입력받는 예제
		System.out.print("문자를 입력하세요 : "); 
		// "문자열".charAt(번지) : 번지째에 있는 문자를 가져옴
		char ch3 = scan.next().charAt(0);
		System.out.println("입력받은 문자 : " + ch3);
		
		scan.close();
	}
}