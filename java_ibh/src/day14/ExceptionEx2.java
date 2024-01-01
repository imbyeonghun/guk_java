package day14;

public class ExceptionEx2 {

	public static void main(String[] args) {
		
		test();
	}

	public static void test(){
		int num1 = 1, num2 = 0;
		try {
			System.out.println(num1 / num2);
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌수없습니다.");
			return;
		}finally {	
			// 위에서 예외가 발생해서 처리하고, return으로 빠져나가도 실행
			System.out.println("finally 실행");
		}
		// 위에서 예외가 발생해서 return으로 빠져나가면 실행X
		System.out.println("메서드 종료");
	}
}