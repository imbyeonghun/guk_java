package day04;

public class StarEx2 {

	public static void main(String[] args) {

		/* *
		 * **
		 * ***
		 * ****
		 * *****
		 * 위와 같이 출력이 되도록 코드를 작성하세요
		 * */
		
		for(int a = 1; a <= 5; a++) {
			for(int star = 1; star <= a; star++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
}