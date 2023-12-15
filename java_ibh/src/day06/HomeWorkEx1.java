package day06;

import java.util.Scanner;

public class HomeWorkEx1 {

	public static void main(String[] args) {
		// 숫자 야구게임을 구현해보세요
		/*
		1~9사이의 중복되지 않는 3개의 수를 랜덤으로 선택해서 해당 숫자를 맞추는 게임
		- S : 숫자가 있고,위치가 같은 경우
		- B : 숫자가 있지만, 위치가 다른 경우
		- O : 일치하는 숫자가 하나도 없는 경우
		- 3S가 되면 게임 종료
		*/
		
		Scanner scan = new Scanner(System.in);
		
		// 맞춰야하는 숫자 3개 랜덤으로 생성
		int min = 1, max = 9;
		int ran1 = (int)(Math.random() * (max - min + 1) - min);
		int ran2 = (int)(Math.random() * (max - min + 1) - min);
		int ran3 = (int)(Math.random() * (max - min + 1) - min);
		int count = 0;
		int S = 0, B = 0, O = 0;
		
		// 랜덤 3수를 배열에 넣고 입력받은 값도 배열에 넣고
		int[] pass = new int[] {ran1,ran2,ran3};
		int[] user = new int[3];
		
		while(count < pass.length) {
			// 랜덤 수 생성
			int r = (int)(Math.random() * (max - min + 1) + min);
			
			// 중복하지 않게
			int i;
			for(i = 0; i<count; i++) {
				if(r == pass[i]) {
					break;
				}
			}
			if(i == count) {
				pass[count++] = r;
			}
		}
		
		System.out.print(pass[0]);
		System.out.print(pass[1]);
		System.out.println(pass[2]);
		
		do{
			
			// 숫자 3개 입력받기
			System.out.print("숫자 3개를 입력하세요 : ");
			
			int num1 = scan.nextInt();
			int num2 = scan.nextInt();
			int num3 = scan.nextInt();
			
			user = new int[] {num1,num2,num3};
			
			// 입력받은 값을 초기화 해준다.
			S = 0;
			B = 0;
			O = 0;
			
			// 인자가 맞는지, 숫자가 맞는지 확인하고
			for(int i = 0; i < pass.length; i++) {
				if(pass[i] == user[i]) {
					System.out.println("S");
					S++;
					continue;
				}else if((pass[i] != user[i]) && ((user[i]) == pass[0] )) {
					System.out.println("B");
					B++;
					continue;
				}else if((pass[i] != user[i]) && ((user[i]) == pass[1] )) {
					System.out.println("B");
					B++;
					continue;
				}else if((pass[i] != user[i]) && ((user[i]) == pass[2] )) {
					System.out.println("B");
					B++;
					continue;
				}else {
					System.out.println("O");
					O++;
					continue;
				}
			} // for
			
			System.out.println(S + "S " + B + "B " +  O + "O");
			
		}while(S != 3); // while
		scan.close();
	} // main
} // class