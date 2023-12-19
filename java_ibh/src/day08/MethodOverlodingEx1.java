package day08;

public class MethodOverlodingEx1 {
	
	public static void main(String[] agrs) {
		System.out.println(sum(1, 2));
		System.out.println(sum(1.2, 2.3));
		System.out.println(sum(1, 2, 2));
	}
	
	// 두 정수의 합을 알려주는 메서드
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	
	// 두 실수의 합을 알려주는 메서드
	public static double sum(double num1, double num2) {
		return num1 + num2;
	}
	/*
	기존에 있는 메서드와 매개변수의 개수와 자료형 타입도 같기 때문에
	메서드 오버로딩이 발생 x  =>  오류
	public static double sum(int num1,int num2) {
		return num1 + num2;
	}
	*/
	
	// 세 정수의 합을 알려주는 메서드
	public static int sum(int num1,int num2,int num3) {
		return num1 + num2 + num3;
	}
}