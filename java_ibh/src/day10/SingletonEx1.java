package day10;

public class SingletonEx1 {

	public static void main(String[] args) {

		// private라 외부에서 접근 x
		// Singleton s = new Singleton();
		
		Singleton s = Singleton.getInstance();
		System.out.println(s.getstr());
		s.setstr("abc");
		System.out.println(s.getstr());
		
		System.out.println("---------------");
		
		Singleton s2 = Singleton.getInstance();
		// str의 초기값이 "Hi"가 아니라 앞에서 수정한 abc 출력
		System.out.println(s2.getstr());
		
		// 싱글톤 클래스의 인스턴스 s와 s2는 같은 인스턴스를 공유하기 때문에
		// s2에서 값을 수정하면 s에서 변경된 값을 확인 
		s2.setstr("def");
		System.out.println(s.getstr());
	}

}

class Singleton{
	
	// 본인 클래스의 인스턴스를 static으로 선언
	private static Singleton singleton = new Singleton();
	private String str;
	
	// 생성자의 접근제어자가 private 
	private Singleton() {
		str = "Hi";
	}
	
	public static Singleton getInstance() {
		return singleton;
	}
	
	public String getstr() {
		return str;
	}
	public void setstr(String str) {
		this.str = str;
	}
}