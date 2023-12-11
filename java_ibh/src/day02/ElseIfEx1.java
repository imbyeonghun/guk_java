package day02;

public class ElseIfEx1 {

	// else if 예제
	public static void main(String[] agrs) {
	
		// num가 0이면 0이라고 출력하고,num가 양수이면 양수라고 출력하고,num가 음수이면 음수라고 출력하는 코드 작성
		int num = 1;
		
		if(num == 0) {
			System.out.println(num + "는 0이다.");
		}else if(num > 0) {
			System.out.println(num + "는 양수이다.");
		}else {
			System.out.println(num + "는 음수이다.");
		}
	}
}
