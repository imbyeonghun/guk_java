package day08;

public class Car {
	
	// - 정보 : 멤버변수
    //	- 무게 : 단위는 톤으로, 브랜드, 분류, 색상, 바퀴종류, 차명, 연식
	double weight;		// 무게 : 단위는 톤으로
	String brand;		// 브랜드
	
	// 0. 소형, 1. 중형 2.대형 등으로 해서 int로도 가능
	String category;	// 분류
	
	// 0xff0000 등으로해서 코드를 int로 가능
	String color;		// 색상
	String[] tires;		// 바퀴종류
	String carName;		// 차명
	int year;			// 연식
	boolean power;		// 시동 true : 켜기 false : 끄기
	int speed;			// 현재 속력
	boolean leftLight;	// 왼쪽 깜빡이
	boolean rightLight;	// 우쪽 깜빡이
	
	// - 기능 : 메서드
	//	- 시동ON/OFF, 가속, 감속, 좌측|우측 깜빡이 ON/OFF

	// 시동ON/OFF
	// 시동이 켜져있으면 끄고, 꺼져있으면 켜짐
	public void turn() {
		power = !power;
		if(power) {
			System.out.println("시동 켜짐");
		}else {
			System.out.println("시동 꺼짐");
		}
	}
	
	// 가속
	public void sppedUp(){
		speed++;
	}
	
	// 감속
	public void sppedDown(){
		speed--;
	}
	
	// 좌측|우측 깜빡이 ON/OFF, 위(우측) : 1, 가운데(끄기) : 0, 아래(좌측) : -1
	public void turnLight(int direction) {
		switch(direction) {
		case 1:  
			rightLight = true;
			leftLight = false;
			break;
			
		case -1: 
			rightLight = false;
			leftLight = true;
			break;
			
		case 0:  
			rightLight = false;
			leftLight = false;
			break;
		}
	}
	
	// 자동차 현재 상태 출력
	public void print() {
		System.out.println("---------------");
		System.out.println("시동 : " + power);
		System.out.println("속력 : " + speed);
		System.out.println("좌깜 : " + leftLight);
		System.out.println("우깜 : " + rightLight);
		System.out.println("---------------");
	}
}