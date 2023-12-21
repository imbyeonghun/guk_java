package day10;

public class StaticEx2 {

	public static void main(String[] args) {

		System.out.println(sum1(1,2));

		// 에러 발생
		// sum2는 static이 아니기 때문에 인스턴스 생성이 필수
		// System.out.println(sum2(1,2));
		// 아래 코드 방식으로 해야함
		StaticEx2 ex = new StaticEx2();  
		System.out.println(ex.sum2(1,2));
	}
	
	public static int sum1(int num1, int num2) {
		return num1 + num2;
	}
	
	public int sum2(int num1, int num2) {
		return num1 + num2;
	}
	
	// 객체(인스턴스) 메서드 : static x
	public void test() {
		System.out.println(sum1(1, 2));
		System.out.println(sum2(1, 2));
	}
	
	// 클래스 메서드 : static o
	public static void test1() {
		System.out.println(sum1(1, 2));
		// System.out.println(sum2(1, 2));  사용 x
	}
}