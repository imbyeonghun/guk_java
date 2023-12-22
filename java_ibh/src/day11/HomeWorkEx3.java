package day11;

import java.util.Scanner;

public class HomeWorkEx3 {

	//사이트에서 회원 관리(로그인,회원가입 등)를 위한 Member클래스를 작성하세요
	private static Member list[] = new Member[5];	// 회원 배열
	private static int count = 0; 					// 등록한 회원 숫자  
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 작성한 Member 클래스를 이용하여 인스턴스를 생성하고 구현한 매서드를 테스트해보세요
		
		System.out.print("아이디를 입력하세요 : ");
		String id = scan.next();
			
		System.out.print("비밀번호를 입력하세요 : ");
		String pass = scan.next();
		
		Member user1 = new Member(id,pass);
		list[count] = user1;
		count++;
		
		System.out.println("로그인하시겠습니까?");
		int menu = scan.nextInt();
		
		switch(menu) {
		case 1:
			System.out.print("아이디 : ");
			String userid = scan.next(); 
			
			int index = -1;
			for(int i = 0; i < count; i++) {
				if(list[i].equals(userid)) {
					index = i;
				}
			}
			
			System.out.print("비밀번호 : ");
			String userpass = scan.next();
			if(list[index].getPass() == userpass) {
				System.out.print("로그인 완료!");
			}else {
				System.out.print("비밀번호를 다시 확인해주세요.");
			}
			break;
		case 2:
			break;
		}
		
		scan.close();
	}
}

class Member{
	// 필요한 멤버변수 및 메서드를 정리하고 구현하세요
	// 변수
	// 아이디,비밀번호
	String id,pass;
	
	// 메서드
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	// 아이디 중복확인 메서드
	private boolean equalsId(String id) {
		return this.id == id;
	}
	
	// 비밀번호 중복확인 메서드
	private boolean equalsPass(String pass) {
		return this.pass == pass;
	}
	
	// 생성자
	public Member(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}
}