package day02;

import java.util.Scanner;

public class TestEx3 {

	public static void main(String[] agrs) {
		// 정수를 입력받아 0인지 양수인지 음수인지 판별하는 코드 작성
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("값을 입력하세요 : ");
		
		int a = scan.nextInt();
		
		if(a == 0) {
			System.out.println("0입니다");
		}else if(a > 0) {
			System.out.println("양수");
		}else {
			System.out.println("음수");
		}
		
		scan.close();
	}
}
