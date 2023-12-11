package day02;

public class ConditionalOperatorEx1 {

	// 조건 선택 연산자
	public static void main(String[] args) {

		// 성적이 A인지 아닌지 판별
		// 성적이 100이하이고 90이상이면 A,아니면 A가 아니다
		int score = 100;
		String result = "";
		boolean re = !(score >= 0 && score <= 100);
		result = score >= 90 && score <= 100 ? "A학점입니다." : "A학점이 아닙니다.";
		if(re == true) {
			System.out.println("점수가 잘못 입력됬습니다.");
		}else {
			System.out.println(score + "점은 " + result);
		}
	}
}