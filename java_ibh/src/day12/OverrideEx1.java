package day12;

public class OverrideEx1 {

	public static void main(String[] args) {
		
		D d = new D();
		// 오버라이딩으로 재정의된 메서드 호출
		// print1()은 접근제어자가 protected이기 때문에 같은 패키지에서는 실행하지만,
		// 다른 패키지에서는 실행이 안됨
		d.print1();
		System.out.println("-------------");
		d.print2();		// 오버라이딩으로 재정의된 메서드 호출
		System.out.println("-------------");
		d.print1(20);	// 오버로딩으로 추가된 메서드 호출
	}
}

class C{
	protected int num1 = 1, num2 = 2;
	
	protected void print1() {
		System.out.println(num1);
		System.out.println(num2);
	}
	
	public void print2() {
		System.out.println(num1);
		System.out.println(num2);
	}
}

class D extends C{
	
	// 오버라이딩으로 인해 print1메서드 수정
	@Override
	/*
	//1. 매개변수가 부모 클래스에는 없음
	//2. 부모클래스에서는 접근제어자가 protected 였는데 여기선 default
	void print1(int num1) {
		
	}
	*/
	protected void print1() {
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
	}
	
	// 메서드 오버로드에 의해 print1이라는 새로운 메서드 추가
	public void print1(int num1) {
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
	}
	
	// 부모메서드를 행동 후 추가행동
	public void print2() {
		super.print2();
		System.out.println("B 클래스의 메서드입니다.");
	}
}