package day13;

public class ConsolProgramEx1 {

	public static void main(String[] args) {
		/*
		ConsolProgram cp = new ConsolProgram();
		cp.run();
		*/
		
		// 형변환 : 인터페이스와 구현 클래스 사이에서도 형변환 가능
		Program p = new ConsolProgram();
		p.run();
	}
}