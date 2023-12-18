package day07;

public class MethodEx1 {

	public static void main(String[] args) {

		int a = 2, b = 7;
		int c = sum(a,b);
		System.out.println(c);

	}
	
	// 두 정수의 합을 알려주는 메서드
	// 매개변수 : 두 정수
	// 리턴타입 : int(정수의 합)
	// 메서드명 : sum
	
	public static int sum(int num1, int num2) {
		int result = num1 + num2; 
		
		return result;
	}

}