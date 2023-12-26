package day11;

public class Student {
	// 학년,반,번호,이름
	private int grade,classNum,num;
	private String name;
	
	// 성적들
	private Subject[] subjects;
	private int count = 0;	// 등록된 과목수

	// getter setter
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Subject[] getSubjects() {
		return subjects;
	}
	public void setSubjects(Subject[] subjects) {
		this.subjects = subjects;
	}
	
	// 과목 추가하는 메서드
	public boolean insertSubject(String title, int score) {
		// 등록된 모든 과목 조회
		for(Subject tmp : subjects) {
			// 과목 인스턴스가 있고,과목의 제목과 추가하려는 제목이 같으면
			if(tmp != null && tmp.equals(title)) {
				return false;
			}
		}
		// 과목을 등록
		subjects[count] = new Subject(title, score);
		count++;
		expandSubject();
		return true;
	}
	
	// 배열 늘리기
	private void expandSubject() {
		// 아직 안 찬 경우
		if(subjects.length > count) {
			return;
		}
		
		// 다 찬 경우
		Subject tmpList[] = new Subject[subjects.length + 5];
		System.arraycopy(subjects, 0, tmpList, 0, subjects.length);
		subjects = tmpList;
	}
	
	// 과목 삭제하는 메서드
	public boolean deleteSubject(String title) {
		// 삭제할 과목이 어디있는지 확인하기 위한 변수로
		// 번지이기 때문에 -1이면 없음, 0이상이면 있음
		int index = -1;
		// 삭제할 과목이 어디있는지 확인
		for(int i = 0; i < count; i++) {
			if(subjects[i].equals(title)) {
				index = i;
			}
		}
		// 없으면
		if(index == -1) {
			return false;
		}
		// 있으면 삭제될 예정이기 때문에 전체 개수에서 1감소
		count--;
		// 삭제된 항목이 마지막 항목이면
		if(index == count) {
			// 추가할 때 향상된 for문을 이용하기 때문에 삭제된 항목을 수정해야함
			subjects[count] = null;
			return true;
		}
		// 아닌 경우 
		Subject tmpList[] = new Subject[subjects.length];
		// 기존 과목 전체 복사
		System.arraycopy(subjects, 0, tmpList, 0, subjects.length);
		// 앞으로 당겨주기
		System.arraycopy(tmpList, index+1, subjects, index, count - index);
		subjects[index] = null;
		return true;
	}
	
	// 성적 수정하는 메서드
	public boolean updateSubject(String title, int score) {
		for(Subject tmp : subjects) {
			if(tmp != null && tmp.equals(title)) {
				tmp.updateScore(score);
				return true;
			}
		}
		return true;
	}
	
	// 학생 정보 출력하는 메서드
	public void print() {
		System.out.println(grade + "학년 " + classNum + "반 " + num + "번 " + name);
		for(Subject tmp : subjects) {
			if(tmp != null) {
				tmp.print();
			}
		}
	}
	
	// 생성자
	public Student() {}
	
	public Student(int grade, int classNum, int num, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
		subjects = new Subject[5];
	}
	
}