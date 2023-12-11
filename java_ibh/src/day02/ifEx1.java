package day02;

public class ifEx1 {
	
	// if문 예제
	public static void main(String[] args) {
		
		// 정수가 0이면 0이라고 출력하고, 정수가 0이 아니면 아닙니다라고 출력하는 예제
		// ...이면 ~이다 : 조건문
		// ... : 조건식, ~ : 실행문
		
		int a = 5;
	
		if(a == 0) {
			System.out.println("0입니다.");
		}
		if(a != 0) {
			System.out.println(a + "는 0이 아닙니다.");
		}
	}
}