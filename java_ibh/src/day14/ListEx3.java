package day14;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx3 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		
		String str;
		while(true){
			System.out.println("속담을 입력하세요.(종료하려면 -1) : ");
			str = scan.nextLine();
			// 종료하기 위해 -1을 입력했으면 반복문 종료
			if(str.equals("-1")) {
				break;
			}
			list.add(str);
		}
		
		for(String tmp : list) {
			System.out.println(tmp);
		}
	}
}