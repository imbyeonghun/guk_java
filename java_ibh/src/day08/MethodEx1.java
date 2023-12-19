package day08;

public class MethodEx1 {

	public static void main(String[] args) {
		// 재귀메서드를 이용하여 스택 오버플로우가 발생하는 예제
		recursive();
	}
	
	// recursive를 부르면 print문을 보여주고 다시 recursive를 부르기 때문에
	// 무한반복이다.
	public static void recursive(){
		System.out.println("재귀 메서드입니다");
		recursive();
	}
}