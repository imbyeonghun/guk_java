package day04;

public class StarEx1 {

	public static void main(String[] args) {

		/* *****
		 * *****
		 * *****
		 * 위와 같이 출력이 되도록 코드를 작성하세요
		 * */
	
		char star = '*';
		
		for(int i = 1; i <=3; i++) {
			for(int count = 1; count <= 5; count++) {
				System.out.print(star);
				if(count == 5) {
					System.out.print("\n");
				}
			}
		}
	}
}