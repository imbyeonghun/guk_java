package day12.protected2;

import day12.protected1.A;

public class B extends A{
	
	public void print() {
		// num1 : private라서 자식 클래스에서도 접근 불가
		// System.out.println("num1" + num1);
		// num2 : default여서 다른 패키지에 있는 클래스에서는 접근 불가
		// System.out.println("num2" + num2);
		// num3 : protected이여서 다른 패키지와 상관없이 자식클래스에서 접근 가능
		System.out.println("num3" + num3);
		// num4 : public이여서 접근 가능 
		System.out.println("num4" + num4);
	}
}