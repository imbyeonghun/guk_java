package day11.product;

public class Product {

	// 변수
	private String productName,productDate; 	// 제품명,일자
	private int productCount;					// 제품 수량
	private int productCountSale;				// 판매 당 비용
	private int productPrice;					// 제품 가격
	private static int salesList = 0;			// 총 매출

	
	// 메서드
	// 현재 등록된 제품 조회 및 수량 출력, getter.setter
	public  String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDate() {
		return productDate;
	}
	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public  int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public static int getSalesList() {
		return salesList;
	}
	public static void setSalesList(int sales) {
		Product.salesList = sales;
	}
	public int getProductCountSale() {
		return productCountSale;
	}
	public void setProductCountSale(int productCountSale) {
		this.productCountSale = productCountSale;
	}
	
	
	/**
	 * 입력받은 가격으로 해당 제품의 가격 변경
	 * @param price 변경할 가격
	 */
	public void priceModify(int price) {
		productPrice = price;
	}
	
	
	/**
	 * 입력받은 제품명과 등록명이 같을 경우
	 * @param name 제품명
	 */
	public boolean equals(String name) {
		return this.productName.equals(name);
	}
	
	
	/**
	 * 현재 등록된 수량 + 추가할 수량
	 * @param count 수량
	 */
	public void countSum(int count) {
		productCount += count;
	}
	
	
	/**
	 * 현재 등록된 수량 - 추가할 수량
	 * @param count 수량
	 */
	public void countSub(int count) {
		if(productCount == 0) {
			System.out.println("해당 제품의 수량이 없습니다.");
		}
		productCount -= count;
	}
	
	
	/**
	 * 현재 등록된 제품 조회 및 수량 출력
	 */
	public void print() {
		System.out.println("제품명 : " + productName + "수량 : " + productCount);
	}
	
	// 생성자
	public Product(String productName,String productDate,int productCount,int productCountSale) {
		this.productName = productName;
		this.productDate = productDate;
		this.productCount = productCount;
		this.productCountSale = productCountSale;
	}
	
	
	// 생성자
	public Product(String productName, int productCount,int productPrice) {
		this.productName = productName;
		this.productCount = productCount;
		this.productPrice = productPrice;
	}
}