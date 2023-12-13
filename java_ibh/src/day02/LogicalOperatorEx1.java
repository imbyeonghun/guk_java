package day02;

public class LogicalOperatorEx1 {

	// 논리연산자 예제
	public static void main(String[] args) {

		/* && : ~하고,~이고
		 * A && B : A는 참/거짓을 판별할 수 있는 식 또는 변수
		 * 성적이 100이하이고 90이상이면 A, 성적이 95 => true
		 * 100이고,90이다 A, 성적이 95 => false > 무엇이 100이고 90인지 정해지지 않아서 판별할 수없음 
		 * 
		 * - 진리표
		 * A && B
		 * F && F => F
		 * F && T => F
		 * T && F => F
		 * T && T => T(둘다 참일때만 참)
		 * 
		 * ===========================
		 * 
		 * || :  ~이거나,~하거나
		 * A || B : A는 참/거짓을 판별할 수 있는 식 또는 변수
		 * 
		 * - 진리표
		 * A || B
		 * F || F => F
		 * F || T => T(하나라도 참일때면 참)
		 * T || F => T(하나라도 참일때면 참)
		 * T || T => T(하나라도 참일때면 참)
		 * 
		 * ===========================
		 * 
		 * ! : ~아닌, 반대
		 * !A 
		 * 	F => T
		 * 	T => F
		 * */
		
		int score = -10;

		// 성적이 올바른지 확인, 올바른 성적 => 0이상 100이하
		// 성적이 0이상이고, 성적이 100이하이다
		// 성적 >= 0 && 성적 <= 100
		System.out.println(score + "점은 올바른 성적입니까? " + (score <= 100 && score >= 0));
		// 위 결과 반대
		System.out.println(score + "점은 올바른 성적이 아닌가? " + !(score <= 100 && score >= 0));
		// 성적이 100초과이거나 성적이 0미만
		System.out.println(score + "점은 올바른 성적이 아닌가? " + (score > 100 || score < 0));
	}

}