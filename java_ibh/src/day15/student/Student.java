package day15.student;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor	//반드시 필요하다고 지정한 매개변수로 생성자 생성
public class Student {
	
	@NonNull	// 필수항목이라고 지정
	private int grade,classNum,num;
	@NonNull
	private String name;
	private int kor,eng,math;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classNum == other.classNum && grade == other.grade && num == other.num;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(classNum, grade, num);
	}
	
	
}