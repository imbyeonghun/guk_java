package day04;

import java.util.Scanner;

public class TestEx1 {

	public static void main(String[] args) {
		// Scanner를 이용하여 국어,영어,수학 성적을 입력받고
		// 총점과 평균을 구하는 코드 작성
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("국어 점수를 입력하세요 : ");
		int koreaScore = scan.nextInt();
		
		System.out.print("영어 점수를 입력하세요 : ");
		int engScore = scan.nextInt();
		
		System.out.print("수학 점수를 입력하세요 : ");
		int mathScore = scan.nextInt();
		
		System.out.println("총점은 : " + (koreaScore + engScore + mathScore));
		System.out.println("평균은 : " + (koreaScore + engScore + mathScore) / (double)3);
		
		scan.close();
	}
}