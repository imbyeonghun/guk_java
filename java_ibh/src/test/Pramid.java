package test;

public class Pramid {
	public static void main(String[] args) {
		
		// 별표 하나 시작으로 5개까지 1개 증가식으로 출력
		int sum;   		 	// 몇번 실행할지 변수
		char star;  		// 별표개수 변수

		for(sum = 1; sum <= 5; sum++) {
			for(star=1; star <= sum; star++) {
				System.out.print(" ");
			}
			for(star = 5; star >= sum; star--) {
			System.out.print("*");
			}
			System.out.println("");
		}
	}// void main
}// class Pramid