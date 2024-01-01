package day14;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx2 {

	public static void main(String[] args) {
		// 정수를 5개 입력받아 입력받은 정수를 리스트에 저장하고,출력하는 코드를 작성
		
		// 스캐너 가져오기
		Scanner scan = new Scanner(System.in);
		
		// Integer 타입의 ArrayList 인스턴스 생성
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		// 입력받을 횟수를 가지는 변수
		int count = 5;
		
		// count회 만큼 반복해서 정수를 입력받는 코드
		for(int i =0; i < count; i++) {
			System.out.print("정수 입력 : ");
			int num = scan.nextInt();
			
			// Collection에서 제공하는 add메서드를 이용하여 리스트에 정수값을 추가
			// int인 tmp가 Integer로 박싱이 되면서 리스트에 추가
			list.add(num);
		}
		
		// 리스트에 있는 정수들을 반복문으로 가져와서 tmp에 저장
		// 가져온 Integer의 인스턴스를 int형으로 언박싱을 함
		for(int tmp : list) {
			// list 출력
			System.out.print(tmp);
		}
	}
}