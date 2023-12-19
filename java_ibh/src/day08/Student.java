package day08;

public class Student {
	// 학생의 국어,수학,영어 성적을 관리하기 위한 프로그램을 작성하려고 한다
	// 이때 필요한 학생 클래스를 생성해보세요
	
	// - 정보 : 멤버변수
    //	- 학년 반 학생번호 이름 국어,영어,수학 성적 
	int grade,classNum,number;
	String name;
	int kor, eng, math;
	
	// - 기능 : 메서드
	//	- 학생 정보 확인, 학생 성적 확인, 국어 성적 수정, 영어 성적 수정, 수학 성적 수정
	
	/* 기능 : 학생 정보(학년,반,번호,이름)을 콘솔에 출력하는 메서드
	 * 매개변수 : x
	 * 리턴타입 : void
	 * 메서드명 : printInfo
	 */
	public void printInfo() {
		System.out.println("--------------");
		System.out.println("학년 : " + grade);
		System.out.println("반 :" + classNum);
		System.out.println("번호 :" + number);
		System.out.println("이름 :" + name);
	}
	
	/* 기능 : 학생 성적(학년,반,번호,이름,국어,영어,수학)을 콘솔에 출력하는 메서드
	 * 매개변수 : x
	 * 리턴타입 : void
	 * 메서드명 : printScore
	 */
	public void printScore() {
		printInfo();
		System.out.println("국어 성적 : " + kor);
		System.out.println("영어 성적 : " + eng);
		System.out.println("수학 성적 : " + math);
	}
	
	/* 기능 : 국어성적을 수정하는 메서드
	 * 매개변수 : 수정할 점수 => int koreaScore
	 * 리턴타입 : void
	 * 메서드명 : setKor
	 */
	public void setKor(int koreaScore) {
		kor = koreaScore;
	}
	
	/* 기능 : 영어성적을 수정하는 메서드
	 * 매개변수 : 수정할 점수 => int engScore
	 * 리턴타입 : void
	 * 메서드명 : setEng
	 */
	public void setEng(int engScore) {
		eng = engScore;
	}
	
	/* 기능 : 수학성적을 수정하는 메서드
	 * 매개변수 : 수정할 점수 => int mathScore
	 * 리턴타입 : void
	 * 메서드명 : setMath
	 */
	public void setMath(int mathScore) {
		math = mathScore;
	}
}