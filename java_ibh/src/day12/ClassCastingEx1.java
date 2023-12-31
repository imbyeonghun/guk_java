package day12;

public class ClassCastingEx1 {

	public static void main(String[] args) {
		// 클래스 형변환 예제
		// 업캐스팅 : 묵시적 클래스 형변환
		
		Parent p1 = new Child(1,2);
		// print()는 부모클래스에도 존재하는 기능이기 때문에 호출 가능
		p1.print();
		// print2()는 자식클래스에만 존재하는 기능이기 때문에
		// 부모 인스턴스가 호출 할 수 없음
		// p1.print2();
		
		/*
		다운 캐스팅 : 명시적 클래스 형변환
		클래스 형변환을 반드시 표시	ex) (Child)
		Child c2 = (Child)new Parent(3);
		안되는 경우 : 부모 인스턴스를 자식 인스턴스에 저장하려고 할때
		c2.print2();
		*/
		
		/*
		 * 1. 다운캐스팅이 되려면 부모인스턴스에 자식 인스턴스가 저장되어야 함
		 * 2. 업캐스팅 된 부모 인스턴스를 자식 인스턴스에 저장  
		 */
		// 업캐스팅
		Parent p3 = new Child(10,20);
		// 다운캐스팅
		Child c3 = (Child)p3;
		c3.print();
		c3.print2();
		
		// 업캐스팅
		Parent p4 = new Child(11,12);
		// 일시적 다운캐스팅
		// 다운캐스팅을 통해 부모 인스턴스로 
		// 자식 인스턴스의 메서드인 print2를 호출
		((Child)p4).print2();
	}
}

class Parent{
	int num1;
	void print() {
		System.out.println("num1 : " + num1);
	}
	
	public Parent(int num1) {
		this.num1 = num1;
	}
}

class Child extends Parent{
	int num2;
	void print() {
		super.print();
		System.out.println("num2 : " + num2);
	}
	void print2() {
		System.out.println("자식 클래스 메서드입니다.");
	}
	public Child(int num1, int num2) {
		super(num1);
		this.num2 = num2;
	}
}