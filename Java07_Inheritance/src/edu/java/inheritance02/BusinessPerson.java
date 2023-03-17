package edu.java.inheritance02;

// 회사원은 사람이다. == 회사원은 사람을 확장한다.
public class BusinessPerson extends Person {
	// field
	private String company;
	
	// constructors	
	public BusinessPerson() {
//		super();	=> 상위 클래스의 기본 생성자 호출은 생략 가능.
		System.out.println("BusinessPerson() 생성자 호출.");
	}
	
	public BusinessPerson(String company) {
		this.company = company;
		System.out.println("BusinessPerson(company) 생성자 호출");
	}
	
	public BusinessPerson(String name, String company) {
		// 부모의 생성자를 명시적으로 호출.
		super(name);
		// => super는 다른 코드보다 아래에 쓸 수 없다.
		// ex>
		//		System.out.println("BusinessPerson(name, company) 생성자 호출.");
		//		super(name);	=> 불가. 맨 위로 올라가야 함.
		this.company = company;
		System.out.println("BusinessPerson(name, company) 생성자 호출.");
	}
	
}
