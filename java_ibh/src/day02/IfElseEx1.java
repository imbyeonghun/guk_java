package day02;

public class IfElseEx1 {

	// if else 예제
	public static void main(String[] agrs) {
		
		// 정수가 0이면 0이라고 출력하고, 정수가 0이 아니면 아닙니다라고 출력하는 예제
		
		int a = 0;
		
		// if가 두번이면 조건식을 2번 확인해야함
		// if else를 쓰면 a가 0이면 1번 확인, a가 0이 아닐때만 2번 확인
		if(a == 0) {
			System.out.println("0입니다.");
		}
		else{
			System.out.println(a + "는 0이 아닙니다.");
		}
	}
}
