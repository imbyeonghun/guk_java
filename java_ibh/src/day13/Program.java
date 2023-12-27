package day13;

public interface Program {
	
	// int num1 = 10;		// 변수 앞에 final static이 자동으로 추가
	// final static int num2 = 20;
	
	// 메서드 앞에 public abstract가 자동으로 추가
	void printMenu(); 
	public void runMenu(int menu);
	public abstract void printExit();
	void run();
}

abstract class TestA{
	
	// 클래스에서는 final static을 생략하면 멤버변수, 붙여주면 상수
	int num1 = 10;
	final static int num2 = 20;
	
	// 클래스에서는 추상메서드에 abstract가 자동으로 추가되지 않음
	// 따라서 abstract를 추가해야함
	// 추상메서드가 있는 클래스는 추상이므로 클래스에도 붙여야함
	abstract void printMenu();
}