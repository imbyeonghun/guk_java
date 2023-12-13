package test;

public class test {

	public static void main(String[] args) {

		// 특정 문자만 랜덤으로 출력
		
		// 출력하고자 하는 문자를 문자열로 선언
		String str = "SRP";
		
		// for문으로 반복
		for(int i = 1; i <= 3; i++) {
			// 자리를 랜덤으로 돌림
			char r = (char)(Math.random()*3);
			// 돌린 자리수를 charAt()에 넣어 그 자리값에 맞는 문자 출력
			System.out.println(str.charAt(r));
		}
	}
}