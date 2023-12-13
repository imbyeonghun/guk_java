package day04;

public class PrimeNumberEx1 {

	public static void main(String[] args) {

		// 2부터 100사이의 모든 소수를 출력하는 코드를 작성
		
		int num;
		int i,count;
		
		for(num = 2; num <=100; num++) {
			for(i = 1,count = 0; i <= num; i++) {
				if(num % i == 0) {
					count++;
				}
			}
			if(count == 2) {
				System.out.print(num + " ");
			}
		}
	}
}