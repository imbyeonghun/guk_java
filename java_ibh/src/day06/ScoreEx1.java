package day06;

import java.util.Scanner;

public class ScoreEx1 {

	public static void main(String[] args) {
		/*
		성적 관리 프로그램
		- 1반의 성적을 관리
		- 최대 30명
		- 성적은 번호순으로 관리
		- 성적 : 국,영,수
		
		메뉴
		1. 성적 수정
		2. 성적 조회
		3. 프로그램 종료
		메뉴 선택 :
		
		 성적수정
			 1. 국어
			 2. 영어
			 3. 수학
			 과목 선택 :
			  
			 학생 선택 : 번호를 선택
			 성적 입력 : 
		 
		 성적 조회
			 1. 과목별 조회
			 2. 학생별 조회
			 선택 : 
			 
			  과목별 조회
			  1. 국어
			  2. 영어
			  3. 수학
			  과목 선택 : 1
			  1번 : 0점
			  ... 
			  30번 : 0점
			  
			  학생별 조회
			  학생 선택 : 3
			  국어 : 100점
			  영어 : 0점
			  수학 : 0점
		*/
		Scanner scan = new Scanner(System.in);
		int menu;	// 메뉴 생성
		
		// 국,영,수 각 점수를 담는 30개 배열 생성
		int[] koreaScore = new int[31];
		int[] engScore = new int[31];
		int[] mathScore = new int[31];
		 
		int studentSelect;	// 학생번호
		int selectScore;	// 과목 점수
		int subject;		// 과목
		
		
		do {
			System.out.println("---메뉴---");
			System.out.println("1. 성적 수정");
			System.out.println("2. 성적 조회");
			System.out.println("3. 프로그램 종료");
			System.out.println("---------");
			System.out.print("메뉴 선택 : ");
			menu = scan.nextInt();
			System.out.println("---------");
			
			switch(menu) {
			
			case 1:
				// 1일때 성적 수정
				// 1일때 국어배열을 가져오고
				// 배열인자 선택
				// 점수를 입력받아 국어배열 해당 인자에  삽입
				System.out.println("1. 국어");
				System.out.println("2. 영어");
				System.out.println("3. 수학");
				System.out.println("---------");
				System.out.print("과목을 선택 : ");
				
				subject = scan.nextInt();
				System.out.println("---------");

				System.out.print("학생의 번호를 선택하세요 : ");
				studentSelect = scan.nextInt();

				System.out.print("수정할 점수를 입력하세요 : ");
				selectScore = scan.nextInt();
				
				if(subject == 1) {
					koreaScore[studentSelect] = selectScore;
					System.out.println(koreaScore[studentSelect]);
					
				}else if(subject == 2){
					engScore[studentSelect] = selectScore;
					System.out.println(engScore[studentSelect]);
					
				}else if(subject == 3){
					mathScore[studentSelect] = selectScore;
					System.out.println(mathScore[studentSelect]);
					
				}else {
					System.out.println("과목 선택을 잘못 하셨습니다.");
				}
				break;
				
			case 2:
				System.out.println("1. 과목별 조회 ");
				System.out.println("2. 학생별 조회 ");
				System.out.println("조회 선택 : ");
				int subScoSelect = scan.nextInt();
				System.out.println("---------");
				
				if(subScoSelect == 1) {
					// 과목별 조회
					System.out.print("과목을 선택하세요(1. 국어, 2.영어, 3. 수학) : ");
					int subSubSelect = scan.nextInt();
					if(subSubSelect == 1) {
						for(int i = 1; i < koreaScore.length; i++) {
							System.out.println(i + "번 학생의 국어 성적은 : " + koreaScore[i]);
						}
					}else if(subSubSelect == 2) {
						for(int i = 1; i < engScore.length; i++) {
							System.out.println(i + "번 학생의 영어 성적은 : " + engScore[i]);
						}
					}else if(subSubSelect == 3) {
						for(int i = 1; i < mathScore.length; i++) {
							System.out.println(i + "번 학생의 수학 성적은 : " + mathScore[i]);
						}
					}
				}else if(subScoSelect == 2) {
					// 학생별 조회
					// 입력받은 학생의 국어,영어,수학 성적 출력
					System.out.print("성적을 보고싶은 학생의 번호를 선택하세요 : ");
					studentSelect = scan.nextInt();
					System.out.println(koreaScore[studentSelect]);
					System.out.println(engScore[studentSelect]);
					System.out.println(mathScore[studentSelect]);
				}else {
					System.out.println("선택을 잘못 하셨습니다.");
				}
				break;
				
			case 3:
				System.out.println("프로그램을 종료합니다.");
				break;
				
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}while(menu != 3);
		
		scan.close();
		//-------------------------------------------------------------------
		/*
		강사님 코드
		int menu = 1;
		Scanner scan = new Scanner(System.in);
		int subject;//과목
		int num;//학생 번호
		int score;//성적
		int maxStudent = 30;
		//국어, 영어, 수학 성적을 저장할 배열
		int [] kor = new int[maxStudent];
		int [] eng = new int[maxStudent];
		int [] math= new int[maxStudent];
		int submenu;
		//반복문 선택한 메뉴가 프로그램 종료가 아닐때까지
		do {
			//메인 메뉴출력
			System.out.println("메뉴");
			System.out.println("1.성적수정");
			System.out.println("2.성적조회");
			System.out.println("3.프로그램 종료");
			System.out.print("메뉴 선택 : ");
			
			//메인메뉴를 선택
			menu = scan.nextInt();
			
			//선택한 메인메뉴에 따른 기능 실행
			switch(menu) {
			case 1:
				//서브메뉴 출력 
				System.out.println("성적수정");
				System.out.println("1. 국어");
				System.out.println("2. 영어");
				System.out.println("3. 수학");
				System.out.print("과목 선택 : ");
				//과목 선택
				subject = scan.nextInt();
				//학생 선택
				System.out.print("학생 선택 : ");
				num = scan.nextInt();
				//성적 입력
				System.out.print("성적 입력 : ");
				score = scan.nextInt();
				//성적을 저장
				switch(subject) {
				case 1:	kor[num-1] = score;	break;
				case 2:	eng[num-1] = score; break;
				case 3:	math[num-1]= score;	break;
				}
				break;
			case 2:
				//서브 메뉴 출력
				System.out.println("성적조회");
				System.out.println("1. 과목별조회");
				System.out.println("2. 학생별조회");
				System.out.print("선택 : ");
				//서브 메뉴 선택
				submenu = scan.nextInt();
				//서브 메뉴에 따른 기능 실행
				switch(submenu) {
				case 1:
					//과목선택메뉴 출력
					System.out.println("과목별조회");
					System.out.println("1.국어");
					System.out.println("2.영어");
					System.out.println("3.수학");
					System.out.print("과목 선택 : ");
					//과목 선택
					subject = scan.nextInt();
					//선택한 과목의 성적을 출력
					int []selectedSubject = null;
					switch(subject) {
					case 1:	selectedSubject = kor;	break;
					case 2:	selectedSubject = eng;	break;
					case 3:	selectedSubject = math;	break;
					default:
						System.out.println("잘못된 과목입니다.");
					}
					if(selectedSubject != null) {
						for(int i = 0; i<selectedSubject.length; i++) {
							System.out.println((i+1)+"번 : " + selectedSubject[i] + "점");
						}
					}
					break;
				case 2:
					//학생 선택
					System.out.print("학생 선택 : ");
					num = scan.nextInt();
					//선택한 학생의 국어,영어,수학점수를 출력
					System.out.println("국어 : " + kor[num-1]);
					System.out.println("영어 : " + eng[num-1]);
					System.out.println("수학 : " + math[num-1]);
					break;
				default:
					System.out.println("잘못된 메뉴입니다.");
				}
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}while( menu != 3);
		
		scan.close();
		*/
		
	}
}