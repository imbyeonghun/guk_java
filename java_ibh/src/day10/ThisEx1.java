package day10;

public class ThisEx1 {
	
	public static void main(String[] agrs) {
		
		Point pt1 = new Point();
		pt1.print();
		
		Point pt2 = new Point(1,2);
		pt2.print();
	}
}

// 점을 나타내는 Point클래스 생성
class Point{
	
	// 멤버변수는 자동으로 초기화가 됨
	private int x,y;

	public int getX() {
		// 여기서는 this를 생략 가능
		// 멤버변수 x가 다른 변수와 착각할 일이 없기 때문
		return x;
	}

	public void setX(int x) {
		// 여기서는 this를 반드시 써야함
		// 멤버변수 x와 매개변수 x를 구별하기 위함
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	// 밑의 생성자에서 this()생성자를 주석처리 한 이유
	// => 각자 생성자에서 다른 둘 중 하나를 부르기 때문에 무한 루프
	// 해당 경우같이 잘못 사용하면 객체 초기화가 완료되지 않을 수 있음
	public Point(int x, int y) {
		// this(x);
		this.x = x;
		this.y = y;
		System.out.println("매개변수 2개 생성자");
	}
	
	public Point() {
		this(0,0); // x = 0 y = 0으로 초기화하기 위해 Point(int x, int y) 생성자를 호출
		System.out.println("기본 생성자");
		// 아래 코드로 실행하면 오류 => this()생성자 앞에 코드가 존재하기 때문
		// this(0,0); // x = 0 y = 0으로 초기화하기 위해 Point(int x, int y) 생성자를 호출
	}
	
	public Point(int x) {
		// this();
		this.x = x;
	}
	
	public void print() {
		System.out.println("(" + x + " , " + y + ")");
	}
}