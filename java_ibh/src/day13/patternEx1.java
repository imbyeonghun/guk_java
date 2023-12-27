package day13;

import java.util.regex.Pattern;

public class patternEx1 {

	public static void main(String[] args) {
		// Pattern 클래스를 이용하여 문자열이 정규표현식에 맞는지 확인 예제
		String str = "add";
		String regex = "^[a-zA-Z]{3}$";		// 영문자이고 3자
		if(Pattern.matches(regex, str)) {
			System.out.println("영문자이고 3자입니다,");
		}else {
			System.out.println("영문자가 아니거나 3자가 아닙니다.");
		}
	}
}