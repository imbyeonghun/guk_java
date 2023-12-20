package day09;

public class SwitchEx1 {
	
	public static void main(String[] args) {
		// switch문 안에 지역변수를 선언하는 경우 발생할 수 있는 문제점
		
		for(int i = 0; i <5; i++) {
			System.out.println(i + " ");
		}
		System.out.println();
		int menu = 1;
		int num;
		switch (menu) {
		case 1: 
			// 여기서 선언된 num이 break문이 없으면  case2까지
			// 갈 수 있기 때문에 여기서 선언된 num은 이후 switch
			// 아래 코드에서 사용할 수 있음
			
			// int num = 10;
			num = 10;
			System.out.println(num);
			break;
		case 2:
			// int num = 20;
			// int num =20하면 위에서 선언된 num = 10이랑 중복이라 에러발생
			num = 20;
			System.out.println(num);
			break;
		}
	}
}