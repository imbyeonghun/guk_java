package day04;

import java.util.Scanner;

public class InfiniteLoopEx2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int num;
		// 조건식에 사용하는 변수가 증감하지 않아서 무한루프 발생
		for(int i =10; i > 0; ) {
			System.out.println("정수 입력 : ");
			num = scan.nextInt();
			System.out.println("정수 출력 : " + num);
		}
		
		// i에 따라 조건식이 무조건 true가 아니기 때문에 에러가 안뜸
		System.out.println("프로그램 종료");
		
		// 위 코드와 차이는 무한루프이고, 이 코드는 무수히 많이 실행
		// 왜 무한루프가 아닌지? : i가 증가하다가 변수타입인 int의 표현범위를 넘어가면
		// 오버플로우가 발생해서 i가 음수로 바뀌기 때문에 음수이면 반복문이 종료됨
		for(int i =10; i > 0; i++) {
			System.out.println("정수 입력 : ");
			num = scan.nextInt();
			System.out.println("정수 출력 : " + num);
		}
		scan.close();
	}
}