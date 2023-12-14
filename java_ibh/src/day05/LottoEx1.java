package day05;

import java.util.Arrays;

public class LottoEx1 {

	public static void main(String[] args) {

		/*
		1~45의 랜덤한 수 6개를 생성하여 출력하는 예제
		단, 정렬이 되도록
		*/
		
		int min = 1, max = 45;
		int arr[] = new int[6];
		int count = 0;
		
		while(count < arr.length) {
			
			// 랜덤한 수 생성
			int r = (int)(Math.random() * (max - min +1) + min);
			
			// 중복 확인
			int i;
			for(i = 0; i<count; i++) {
				if(arr[i] == r) {
					break;
				}
			}
			
			// 중복되지 않으면 저장 후 count 증가
			if(i == count) {
				arr[count++] = r;
			}
		}
		
		// 정렬
		Arrays.sort(arr);
		
		//출력
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}