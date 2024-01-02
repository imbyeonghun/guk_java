package day16;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class StreamEx1 {

	public static void main(String[] args) {
		
		// list라는 List클래스에 해당 값을 가진 인스턴스 생성
		List<Student> list = 
				Arrays.asList(
						new Student(1, 1, 1, "홍길동", 80, 70, 90),
						new Student(1, 1, 2, "임꺽정", 100, 100, 100),
						new Student(2, 1, 1, "고길동", 95, 85, 55)
				);
		
		
		Stream<Student> stream = list.stream();
		// 학생들 중 1학년 학생들만 선택해서 학생 정보를 출력
		stream.filter(s->s.getGrade() == 1).forEach(s->System.out.println(s));
		
		
		// 스트림은 초기화가 안되기 때문에 재활용이 안되므로 다시 선언해줘야함
		stream = list.stream();
		// 학생 정보에서 국어 성적을 추출해서 점수를 출력
		stream.map(s->s.getKor()).forEach(k->System.out.println("국어 : " + k));
		
		
		stream = list.stream();
		// 학생들의 국어 성적 평균을 계산
		// map : A에서 B로 변환시킴 
		// mapToInt : A에서 Integer로 변환시킴
		// orElse(0.0) : 값이 null인 경우 0.0으로 대체해서 계산
		double avg = stream.mapToInt(Student::getKor).average().orElse(0.0);
		System.out.println("국어 성적 평균 : " + avg);
		
		
		stream = list.stream();
		// 국어 성적에 2를 곱한 뒤 합을 구함
		// 0은 초기값, sum은 누적, kor은 스트림에서 꺼낸 국어성적
		Integer res = stream.mapToInt(Student::getKor).reduce(0, (sum,kor)->{
			return sum + 2*kor;
		});
		System.out.println("2배 총합 : " + res);
		
		
		Student arr[] = new Student[] {
						new Student(1, 1, 1, "홍길동", 80, 70, 90),
						new Student(1, 1, 2, "임꺽정", 100, 100, 100),
						new Student(2, 1, 1, "고길동", 95, 85, 55)
		};
		Stream<Student> stream2 = Arrays.stream(arr);
		// 위에서 작성한 filter예제 복붙 후 stream2로 변경
		// 리스트로 만든 스트림과 배열로 만든 스트림을 같은 방법을 이용하여 사용 할 수 있다.
		stream2.filter(s->s.getGrade() == 1).forEach(s->System.out.println(s));
	}
}

@Data
@RequiredArgsConstructor
class Student{
	@NonNull
	Integer grade, classNum, num;
	@NonNull
	String name;
	@NonNull
	Integer kor, eng, math;
}