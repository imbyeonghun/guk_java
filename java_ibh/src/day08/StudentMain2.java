package day08;

public class StudentMain2 {

	public static void main(String[] args) {
		// 5명의 학생을 저장하기 위한 배열을 생성해보세요
		
		// Student는 참조형이기 때문에 처음에 null로 들어가있음
		Student stds[] = new Student[5];
		
		// 학생 5명의 학생 정보를 출력하는 코드를 작성하세요
		for(int i = 0; i < 5; i++) {
			// 값이 있는게 아니라 null이기 때문에 
			// new Student()라는 생성자로 생성을 해줘야 오류가 안남
			stds[i] = new Student();
			stds[i].printInfo();
		}
	}
}