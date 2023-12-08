package day01;

public class VariableNamingEx1 {
	
	// 변수명 작성 규칙(필수)
	public static void main(String[] args) {

		// 대소문자 구분
		int num;
		int NUM;
		
		// 예약어 사용 불가
		// int int;
		// int class;
		
		// 숫자로 시작 x
		// int 2num;
		int num2;
		
		// 특수기호 시작 x 단 _, $ 가능
		// int #num;
		// int n um;
		int _num;
		int $num;
		
		// 중복 선언 x
		// 위에서 선언되있음
		// int num;
	}
}
