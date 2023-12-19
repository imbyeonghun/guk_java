package day08;

public class StudentMain {

	public static void main(String[] args) {
		// 학생 1명의 정보를 저장하는 인스턴스를 생성해보세요
		
		Student asd = new Student();
		
		// 1학년 1반 1번 홍길동
		asd.grade = 1;
		asd.classNum = 1;
		asd.number = 1;
		asd.name = "홍길동";
		asd.printInfo();
		
		// 국어 : 90, 영어 : 100, 수학 : 80으로 수정
		asd.setKor(90);
		asd.setEng(100);
		asd.setMath(80);
		asd.printScore();
	}
}