package day08;

public class CarMain {

	public static void main(String[] args) {
		
		/* Scanner 			   : 클래스명
		 * scan    			   : 인스턴스명
		 * Scanner(System.in)  : 표준입력을 이용하여 초기화하는 생성자
		 * Scanner("123/nabc") : 문자열을 이용하여 초기화하는 생성자
		 * */
		// Scanner scan = new Scanner("123/nabc");
		
		/* Car   : 클래스명
		 * car   : 인스턴스명
		 * new 	 : 인스턴스를 생성하는 연산자
		 * Car() : 생성자.  멤버변수를 초기화 
		 * */
		
		Car car = new Car();
		
		car.turn();		   // 시동 킴
		car.print(); 
		car.turnLight(-1); // 좌측 깜빡이 킴
		car.print();
		car.turnLight(1);  // 우측 깜빡이 킴
		car.print();
		car.turnLight(0);  // 깜빡이 끔
		car.print();
		
		for(int i = 0; i < 10; i++) {
			car.sppedUp();
		}
		car.print();
		
		for(int i = 0; i < 10; i++) {
			car.sppedDown();
		}
		car.print();
		
		car.turn();
		car.print();
	}
}