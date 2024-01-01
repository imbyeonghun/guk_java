package day15;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapEx1 {

	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<String,String>();
		// map.put(key,value);
		map.put("abc123", "abc123!");
		map.put("def456", "abc123!");	// 비번이 중복 => value 중복 => 가능
		map.put("abc123", "qwe123");	// 아이디 중복 => key가 중복 => 추가 안됨,value 변경
		map.put("admin", "admin");
		map.put("def", "def");
		System.out.println(map.remove("abc123"));
		System.out.println(map);
		
		// map자체로 반복문 사용 불가
		
		// keySet을 이용한 반복문 예제
		// keySet() : key값들을 모아서 Set으로 만듬
		Set<String> keySet = map.keySet();
		for(String tmp : keySet) {
			String value = map.get(tmp);
			System.out.println(value);
		}
		
		// entrySet을 이용한 반복문 예제
		// key와 value를 entry라는 클래스의 멤버변수로 가져옴
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		for(Map.Entry<String, String> tmp : entrySet) {
			System.out.println("[" + tmp.getKey() + " , " + tmp.getValue() + "]");
		}
		
		// 내부 클래스의 인스턴스를 생성하는 예제
		A a = new A();
		A.B b = a.new B();
	}
}

// 내부 클래스
class A{
	public class B{
		int num;
	}
}