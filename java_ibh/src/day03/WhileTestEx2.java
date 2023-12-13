package day03;

public class WhileTestEx2 {

	// 5부터 1까지 거꾸로 출력하는 코드를 작성하세요.
	public static void main(String[] args) {
		
		int i = 5;
		int count = 1;
		
		while(i >= count) {
			System.out.println(i);
			i--;
		}
	}
}