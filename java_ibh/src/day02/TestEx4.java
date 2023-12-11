package day02;

import java.util.Scanner;

public class TestEx4 {

	// 성인 판별 예제
	public static void main(String[] args) {

		// 나이를 입력받아 나이가 20세 이상이면 성인으로 출력
		// 20세 미만이면 미성년자로 출력하는 코드 작성
		
		Scanner scan = new Scanner(System.in);
		System.out.println("판별할 나이를 입력하시오 : ");
		int age = scan.nextInt();
		
		if(age >= 20) {
			System.out.println("성인입니다.");
		}else {
			System.out.println("미성년자입니다.");
		}
		scan.close();
	}
}