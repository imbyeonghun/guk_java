package day04;

public class MultipleTableEx1 {

	public static void main(String[] args) {
		
		// 구구단 2단부터 9단까지 출력하는 코드
		for(int b = 2; b <= 9; b++) {
			System.out.println(b + "단========");
			for(int i = 1; i <= 9; i++) {
				System.out.println(b + " * " + i + " = " + b*i );
			}
		}
	}
}