package day06;

import java.util.Scanner;

public class AlphabetCountEx1 {

	public static void main(String[] args) {
		// 단어를 입력받아 단어의 각 알파벳이 몇번 나왔는지 출력하는 코드
		
		Scanner scan = new Scanner(System.in);
		
		// 단어 입력받기
		System.out.print("입력 : ");
		String str = scan.next();
		
		System.out.println("===============");
		
		// str의 길이만큼 배열 생성
		char[] strCount = new char[str.length()]; 
		
		// 문자 개수를 넣을 배열 생성
		int [] count1 = new int[str.length()];
		
		// str길이만큼 반복해서 strCount배열에 넣음
		for(int i = 0; i < str.length(); i++) {
			for(int j = 0; i < str.length(); i++) {
				
				count1[j]++;
				j++;
			}
		}
		
		for(int i = 0; i < strCount.length; i++) {
			System.out.println(str.charAt(i) + " : " + count1[i] + "개");
		}
		
		System.out.println("==================================강사님1");
		
		int arr[] = new int[26]; // 알파벳 26개 배열
		
		for(int i =0; i <str.length(); i++) {
			char ch = str.charAt(i); // 문자 읽어와서 ch에 넣음
			arr[ch - 'a']++; 
		}
		
		for(int i =0; i < arr.length; i++) {
			if(arr[i] != 0) {
				char ch = (char)('a' + i);
				System.out.println(ch + " : " + arr[i] + "");
			}
		}
		
		System.out.println("=========강사님2");
		
		// 다른 방법
		char ch = 'a';
		for(int count : arr) {
			if(count != 0) {
				System.out.println(ch + " : " + count);
			}
			ch++;
		}
		
		scan.close();
	} // main
}// AlphabetCountEx1