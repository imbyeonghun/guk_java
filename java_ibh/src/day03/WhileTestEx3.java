package day03;

public class WhileTestEx3 {

	// 1에서 10사이의 모든 짝수를 순서대로 출력하는 코드를 작성하세요.
	public static void main(String[] args) {

		int a;
		
		for(a=1; a<11; a++) {
			if(a % 2 == 0) {
				System.out.println(a);
			}
		}
	}
}