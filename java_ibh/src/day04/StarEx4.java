package day04;

public class StarEx4 {

	public static void main(String[] args) {

		/*      *
		 *     ***
		 *    *****
		 *   *******
		 *  *********
		 * 위와 같이 출력이 되도록 코드를 작성하세요
		 * */
		
		int rows =5;
		
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= rows-i; j++) {
				System.out.print(" ");
			}
			for(int j = 1; j <= 2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		// 다른 방법
		
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= rows-i; j++) {
				System.out.print(" ");
			}
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			for(int j = 1; j <= i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}
}