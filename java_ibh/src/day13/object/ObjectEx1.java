package day13.object;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

public class ObjectEx1 {
	
	/*
	 * toString() : 객체 정보를 문자열로 반환 / 디폴트 : 패키지.클래스명@해시코드값
	 * 			@ToString을 사용하면 자동 오러라이딩
	 * equals() : 두 객체사 같은지 알려줌 / 디폴트 : 주소를 비교 /
	 * 			  항상 모든 멤버를 다 비교할 필요는 없음 / 상황에따라 필요한 멤버만 비교
	 * hashCode() : 객체의 해시코드값을 반환 / 해시 값은 해시를 이용한 자료구조에서 사용
	 * clone() : 객체를 복사해서 같은 멤버값을 가진 새로운 객체 생성
	 * getClass() : 객체의 클래스명 클래스를 반환
	 */
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		A a = new A();
		System.out.println(a.toString());
		
		Student std1 = new Student(1, 1, 1, "홍길동");
		Student std2 = new Student(1, 1, 1, "임꺽정");
		
		if(std1.equals(std2)) {
			System.out.println("학년,반,번호가 같습니다.");
		}else {
			System.out.println("학년,반,번호가 다릅니다.");
		}
		
		A a1 = new A();
		a1.num1 = 20;
		// a1 출력
		System.out.println(a1);
		
		A a2 = a1;
		a2.num1 = 30;
		// a2의 num1을 수정한 후 a1을 출력 => a1,a2가 공유하기 때문에 값 변경
		System.out.println(a1);
		
		A a3 = a1.clone();
		a3.num2 = 40;
		// a3의 num2를 수정한 후 a1를 출력 => 공유가 아닌 복제이기 때문에 값 변경X
		System.out.println(a1);
	}
}

@AllArgsConstructor
class Student{
	int grade,classNum,num;
	String name;
	
	@Override
	public int hashCode() {
		return Objects.hash(classNum, grade, num);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)					// 같은 인스턴스를 공유(주소)하는지 확인
			return true;
		if (obj == null)					// 비교 대상이 존재하는지 확인
			return false;
		if (getClass() != obj.getClass())	// 다른 클래스의 인스턴스인 경우
			return false;
		Student other = (Student) obj;		// 다운캐스팅 => 클래스 형변환
		// 학년,반,번호가 모두 일치하는지 확인
		return classNum == other.classNum && grade == other.grade && num == other.num;
	}
}

@EqualsAndHashCode	// 전체를 비교해야 할 때 사용 용이
class A implements Cloneable{
	int num1 = 10;
	int num2 = 3;
	String name = "테스트";
	
	@Override
	public String toString() {
		return "A [num1=" + num1 + ", num2=" + num2 + ", name=" + name + "]";
	}
	
	@Override
	public A clone() throws CloneNotSupportedException{
		return (A)super.clone();
	}
}