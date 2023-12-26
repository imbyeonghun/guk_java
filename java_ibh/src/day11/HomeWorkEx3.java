package day11;

public class HomeWorkEx3 {

	//사이트에서 회원 관리(로그인,회원가입 등)를 위한 Member클래스를 작성하세요
	public static void main(String[] args) {
		
		Member mem1 = new Member();
		mem1.print();
		
		// 아이디와 비번이 없는 인스턴스이기 때문에 아이디 abc와 비번 def로 비교하면 false
		System.out.println(mem1.eqauals("abc", "def"));
		
		// 아이디가 abc, 비번이 def, 이메일이 abc@naver.com인 인스턴스 생성
		Member mem2 = new Member("abc", "def", "abc@naver.com");
		mem2.print();
		System.out.println(mem2.eqauals("abc", "def"));
	}
}

class Member{
	
	// 필요한 멤버변수 및 메서드를 정리하고 구현하세요
	// 변수
	// 아이디,비밀번호,이메일
	String id,pass,eamil;
	
	// getter setter
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

	public String getEamil() {
		return eamil;
	}

	public void setEamil(String eamil) {
		this.eamil = eamil;
	}
	
	
	// equals : 아이디,비번이 주어지면 내 정보와 같은지 알려주는 메서드
	public boolean eqauals(String id, String pass) {
		// 아이디가 없거나
		if(this.id == null) {
			return false;
		}
		// 비번이 없거나
		if(this.pass == null) {
			return false;
		}
		// 아이디와 비번이 일치하면
		if(this.id.equals(id) && this.pass.equals(pass)) {
			return true;
		}
		return false;
	}

	// 회원정보를 출력하는 메서드
	public void print() {
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pass);
		System.out.println("이메일 : " + eamil);
	}
	
	// 생성자 : 기본. 아이디,비번,이메일이 필요한 생성자. 아이디,비번이 필요한 생성자
	public Member() {
		
	}
	
	public Member(String id, String pass, String eamil) {
		this.id = id;
		this.pass = pass;
		this.eamil = eamil;
	}

	public Member(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}
}
