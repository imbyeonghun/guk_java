package day13;

import java.util.Scanner;
import java.util.regex.Pattern;

public class patternEx2 {

	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		/* 아이디를 입력받아 아이디 형식에 맞는지 틀린지 출력하는 프로그램을 작성하세요
		 * 아이디 정규표현식 : 영문,숫자로 구성이 된 8~13자
		 * 
		 * 아이디 : abc
		 * 아이디 형식에 맞지않습니다.
		 * 
		 * 아이디 : abcd1234
		 * 아이디로 사용가능합니다.
		 */
		System.out.print("사용할 아이디를 입력하세요 : ");
		String str = scan.next();
		// java에서 \는 의미가 있는 문자여서 문자열에 저장할땐 \\로 바꿔야한다.
		// String regex = "^\\w{8,13}$"; 	
		// \w => _등 특수기호 포함
		String regex = "^[a-zA-Z0-9]{8,13}$";
		if(Pattern.matches(regex, str)) {
			System.out.println("아이디로 사용가능합니다.");
		}else {
			System.out.println("아이디형식에 맞지않습니다.");
		}
		
	}
}