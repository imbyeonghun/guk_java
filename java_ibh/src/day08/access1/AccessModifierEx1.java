package day08.access1;

public class AccessModifierEx1 {
	
	public static void main(String[] args) {
		Student std = new Student();
		
		// Student클래스의 grade접근제어자가 private이어서 같은 패키지에 있는 클래스에서 사용 불가
		// std.grade = 1;
		
		// Student클래스의 grade접근제어자가 default이어서 같은 패키지에 있는 클래스에서 사용가능
		std.classNum = 2;
		
		// Student클래스의 grade접근제어자가 public이어서 같은 패키지에 있는 클래스에서 사용가능
		std.num = 3;
		
		// grade가 private이어서 grade를 수정하기 위해 setter를 이용하여 수정
		std.setGrade(1);
		
		// System.out.println(std.grade + "학년");
		System.out.println(std.getGrade() + "학년");
	}
}