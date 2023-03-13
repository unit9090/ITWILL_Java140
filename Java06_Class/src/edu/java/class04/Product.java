package edu.java.class04;


// 클래스의 멤버들:
// (1) 필드(멤버 변수)
// (2) 생성자
// (3) 메서드
public class Product {
	// 필드(field)
	int productId;			// 상품 아이디(코드)
	String productName;		// 상품명
	int productPrice;		// 상품 가격
	
	// 생성자:
	// (1) 기본 생성자
	public Product() {}
	
	// (2) argument 3개를 갖는 생성자 - id, name, price
	public Product(int productId, String productName, int productPrice) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	// (3) argument 2개를 갖는 생성자 - id, name
	public Product(int productId, String productName) {
		this(productId, productName, 0);
	} 
	
	
	// 메서드:
	// (1) printProductInfo: 상품의 모든 정보를 콘솔에 출력
	public void printProductInfo() {
		System.out.printf("상품 코드: %d, 상품명: %s, 상품 가격: %d원\n",
				this.productId, productName, productPrice);
		// 필드가 지역 변수 이름과 혼동되지 않으면 this를 생략해도 됨.
	}
	
	// (2) setProductPrice: 상품의 가격을 전달받은 값으로 변경하는 메서드.
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
}
