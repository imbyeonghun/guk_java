package day08.access2;

import day08.access1.Student;

public class AccessModifierEx1 {
	public static void main(String[] args) {
		Student std = new Student();
		
		// Student클래스의 grade접근제어자가 private이어서 다른 패키지에 있는 클래스에서 사용불가
		// std.grade = 1;
		
		// Student클래스의 grade접근제어자가 default이어서 다른 패키지에 있는 클래스에서 사용불가
		// std.classNum = 1;
		
		// Student클래스의 grade접근제어자가 public이어서 다른 패키지에 있는 클래스에서 사용가능
		std.num = 1;
	}
}