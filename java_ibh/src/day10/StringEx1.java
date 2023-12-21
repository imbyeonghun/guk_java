package day10;

public class StringEx1 {

	public static void main(String[] args) {

		// 문자열 비교하는 예제
		// 리터럴은 리터럴끼리 저장되기 때문에 저장된 공간에 str1값을 가져와서 연결
		
		// 데이터 영역에 abc가 추가되고 추가된 주소를 가져와서 str1에 저장
		String str1 = "abc";
		// 이미 추가된 abc의 주소를 가져와서 str2에 저장 => str1,str2가 공유
		String str2 = "abc";
		// 생성된 문자열 인스턴스의 주소를 str3에 저장
		String str3 = new String("abc");
		
		// 참조변수에서 ==는 주소를 비교 
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		System.out.println(str2 == str3);
		
		// 문자열은 equals라는 메서드를 이용해 비교
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));
		System.out.println(str2.equals(str3));
	}
}