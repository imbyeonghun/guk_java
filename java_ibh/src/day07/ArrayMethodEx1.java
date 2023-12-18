package day07;

import java.util.Scanner;

public class ArrayMethodEx1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// 1~45 사이의 중복되지 않은 랜덤한 수 6개를 만드는 코드를 작성(메서드 이용)
		int abc[] = randomNumber(1, 45);
		for(int i = 0; i < 6; i++) {
			System.out.print(abc[i] + " ");
		}
		
		System.out.println("\n-------------");
		
		int array[] = new int[] {1,2,2,3,0};
		System.out.println(contians(array, 2, 0));
		
		System.out.println("-------------");
		
		int arr[] = new int[6];
		int min = 1, max = 45;

		if(createRandomArray(min, max, arr)) {
			System.out.println("배열 생성 성공!");
			for(int tmp : arr) {
				System.out.print(tmp + " ");
			}
			System.out.println();
		}else {
			System.out.println("배열 생성 실패!");
		}
		
		System.out.println("-------------");
		
		// 1 ~ 45 사이의 중복되지 않은 6개를 입력하는 코드를 작성(메서드 이용)
		
		int ar[] = new int[6];
		int count = 0;
		System.out.println("정수 6개 입력(중복 x, 1 ~ 45) : ");
		while(count < ar.length) {
			int num = scan.nextInt();
			if(!contians(ar, count, num) && (num >= min && num <= max)) {
				ar[count] = num;
				count++;
			}
		}
		for(int tmp : ar) {
			System.out.print(tmp + " ");
		}
		
		scan.close();
		
	}
	
	// 기능 : min ~ max사이의 중복되지 않은 랜덤한 수를 배열에 만들어주고 생성여부를 알려주는 메서드
	// 매개변수 : int min, int max, int arr[]
	// 리턴타입 : boolean
	// 메서드명 : createRandomArray
	
	public static boolean createRandomArray(int min, int max, int arr[]) {

		// 배열 생성이 안됬거나 크기가 0이면
		if(arr == null || arr.length == 0) {
			return false;
		}
		
		// max가 min보다 작으면
		if(max < min) {
			int tmp = max;
			max = min;
			min = tmp;
		}
		
		// 배열의 크기가 min ~ max사이의 정수개수보다 클때 
		if(arr.length > max - min +1) {
			return false;
		}
		
		int count = 0;
		// 반복문 : 저장된 숫자의 개수가 배열의 크기보다 작을 때 반복
		while(count < arr.length) {
			
			// 랜덤한 수 생성
			int r = random(min, max);
			
			// 중복 확인
			if(!contians(arr, count, r)) {
				// 중복되지 않으면 배열에 저장
				arr[count] = r;
				// 저장된 숫자의 개수를 1 증가
				count++;
			}
		}
		return true; 
	}
	
	
	// 기능 : min ~ max사이의 중복되지 않은 랜덤한 수를 배열에 만들어주고 생성여부를 알려주는 메서드
	// 매개변수 : int min, int max
	// 리턴타입 : int[]
	// 메서드명 : randomNumber
	
	public static int[] randomNumber(int min, int max) {
		// max가 min보다 작으면
		if(max < min) {
			int tmp = max;
			max = min;
			min = tmp;
		}
		
		int user[] = new int[6];
		int count = 0;
		
		while(count < user.length) {
			
			// 랜덤한 수 생성
			int r = (int)(Math.random() * (max - min +1) + min);
			
			// 중복 확인
			int i;
			for(i = 0; i<count; i++) {
				if(user[i] == r) {
					break;
				}
			}
			
			// 중복되지 않으면 저장 후 count 증가
			if(i == count) {
				user[count++] = r;
			}
		}
		return user;
	}
	
	// [1, 2, 0, 0, 0] => 배열에서 0번지부터 2개 중에 0과 일치하는 값이 있나? false
	// 기능 : 배열이 주어지고 배열의 0번지부터 n개 중에서 num와 같은 값이 있는지 없는지를 알려주는 메서드
	// 매개변수 : 주어진 배열, 검사할 배열의 개수,비교할 정수 => int array, int n, int num
	// 리턴타입 : 같은 값이 있는지 없는지 => boolean
	// 메서드명 : contions
	
	public static boolean contians(int array[], int n, int num) {
		// 배열 생성이 안됬거나 크기가 0이면
		if(array == null || array.length == 0) {
			return false;
		}
		
		// array보다 n이 더 크면 array.length로 수정
		if(array.length < n) {
			n = array.length;
		}
		
		for(int i = 0; i < n; i++) {
			if(array[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	
	// 기능 : min ~ max 사이의 랜덤한 수를 생성해서 알려주는 메서드
	// 매개변수 : 최댓값과 최소값 => int min, int max
	// 리턴타입 : 생성된 랜덤한 수 => 정수 => int
	// 메서드명 : random
	
	public static int random(int min, int max) {
		if(max < min) {  // max가 min보다 작으면 바꿔줌 
			int tmp = max;
			max = min;
			min = tmp;
		}
		return (int)(Math.random() * (max - min +1) + min);
	}
}