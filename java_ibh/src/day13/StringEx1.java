package day13;

public class StringEx1 {

	public static void main(String[] args) {
		String str = "abcde";
		
		// 0번지에 있는 문자 반환
		System.out.println("charAt");
		System.out.println(str.charAt(0));

		// 두 문자열이 같은지 비교
		System.out.println("\n"+"equals");
		System.out.println(str.equals("abc"));
		System.out.println(str.equals("abcde"));
		
		// 있으면 문자열의 시작번지 반환
		System.out.println("\n"+"indexOf");
		System.out.println(str.indexOf("cdf"));
		
		// 있으면 있다, 없으면 없다 반환
		System.out.println("\n"+"contains");
		System.out.println(str.contains("cdf"));
		
		// 문자열의 길이를 반환
		System.out.println("\n"+"length");
		System.out.println(str.length());
		
		// 문자열을 바꿔서 새 문자열을 반환
		System.out.println("\n"+"replace");
		String str2 = str.replace("cd", "aa");
		// 기존 문자열은 안 바뀜
		System.out.println(str);
		System.out.println(str2);
		
		// 부분 문자열을 반환
		System.out.println("\n"+"substring");
		// 1번지부터 3번지 앞까지(2번지까지)
		String str3 = str.substring(1,3);
		// 기존 문자열은 안 바뀜
		System.out.println(str);
		System.out.println(str3);
		
		// 대문자로
		System.out.println("\n"+"toUpperCase");
		String str4 = str.toUpperCase();
		System.out.println(str);
		System.out.println(str4);
		
		// 소문자로
		System.out.println("\n"+"toUpperCase");
		String str5 = str4.toLowerCase();
		System.out.println(str4);
		System.out.println(str5);
		
		// 시작문자 앞,마지막 문자 뒤 공백 제거
		System.out.println("\n"+"trim");
		String str6 = "\n\nabc\tdef\t\t";
		System.out.println(str6);
		String str7 = str6.trim();
		System.out.println(str6);
		System.out.println(str7);
		
		// 문자열에서 문자열들을 추출해서 배열로 변환
		System.out.println("\n"+"split");
		String fruits = "사과,배,오렌지";
		String[] fruitsArray = fruits.split(",");
		System.out.println(fruits);
		for(String tmp : fruitsArray) {
			System.out.println(tmp);
		}
	}
}