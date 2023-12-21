package day10;

public class StaticEx1 {

	public static void main(String[] args) {
		KiaCar c1;
		c1 = new KiaCar("모닝");
		KiaCar c2 = new KiaCar("레이");
		KiaCar c3 = new KiaCar("K3");
		c1.brand = "기아";
		c2.brand = "기아";
		c3.brand = "기아";
		c1.print();
		c2.print();
		c3.print();
		System.out.println("----------");
		
		// 인스턴스가 생성되기전에 static 변수가 메모리에 할당이 됨
		// 따라서 사용가능
		KiaCar2 c4;
		System.out.println(KiaCar2.brand);
		c4 = new KiaCar2("모닝");
		KiaCar2 c5 = new KiaCar2("레이");
		KiaCar2 c6 = new KiaCar2("K3");
		// 인스턴스를 통해서 접근이 가능하지만 static은 클래스명을 통해 접근하는 걸 추천
		// c4.brand = "기아";
		KiaCar2.brand = "기아";
		c4.print();
		c5.print();
		c6.print();
		
		System.out.println("대표적인 staic변수 Math.PI " + Math.PI);
	}
}

class KiaCar{
	// static이 아닐 경우 brand를 변경할 경우 각 객체마다 수행
	public String brand = "KIA";
	public String name; // 차 이름
	
	public KiaCar(String name) {
		this.name = name;
	}
	
	public void print() {
		System.out.println(brand);
		System.out.println("차명 : " + name);
	}
}

class KiaCar2{
	// static일 경우 brand를 변경할 경우 한번만 수행 
	public static String brand = "KIA";
	public String name; // 차 이름
	
	public KiaCar2(String name) {
		this.name = name;
	}
	
	public void print() {
		System.out.println(brand);
		System.out.println("차명 : " + name);
	}
}