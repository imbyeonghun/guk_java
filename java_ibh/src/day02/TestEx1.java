package day02;

public class TestEx1 {

	// 연산자 예제
	public static void main(String[] args) {
		/* 다음 코드를 이용하여 국어,영어,수학 성적의 평균을 구하여 콘솔에 출력하는 코드*/
		int korScore = 100, engScore = 50, mathScore = 92;
		int total = 0;
		double mean = 0.0;
		
		total = korScore + engScore + mathScore;
		mean = total / 3.0;
		System.out.println("합계는 " + total + "점이다");
		System.out.println("평균은 " + mean + "점이다");
	}

}
