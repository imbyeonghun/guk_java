package day04;

public class StarEx3 {

	public static void main(String[] args) {

		/*     *
		 *    **
		 *   ***
		 *  ****
		 * *****
		 * 위와 같이 출력이 되도록 코드를 작성하세요
		 * */
		
		for(int a = 1; a <= 5; a++) {		// 1 2 3 4 5
			for(int j = 4; j >= a; j--) {	// 4 3 2 1 0
				System.out.print(" ");
			}
			for(int star = 1; star <= a; star++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}