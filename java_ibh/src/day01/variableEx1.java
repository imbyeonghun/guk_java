package day01;

public class variableEx1 {

	// 문자형 변수 선언 예제
	public static void main(String[] args) {

		char var;
		char var2 = '+';
		
		var = 'A';
		
		System.out.println(var);
		System.out.println(var2);
		
		/*
		 * // "" : 문자열 의미 char var3 = "B"; 
		 * // 두 글자가 들어가서 오류 char var4 = '12';
		 */
		
		// \u0061 : 유니코드61
		// \u0061 : 유니코드에 있는 0061에 해당하는 글자
		char var5 = '\u0061';
		System.out.println(var5);
		
		// \n : 엔터, \t : 탭키만큼 공백, \\ : \문자
		char var7 = '\n';
		System.out.print (var7);
		
		// 아스키코드 61에 해당하는 글자
		char var6 = 61;
		System.out.println(var6);
	}

}
