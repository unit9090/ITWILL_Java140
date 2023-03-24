package edu.java.contact.model;


// MVC(Model-View-Controller) 아키텍처에서 Model에 해당하는 클래스.
// 특별한 기능은 없는, 순수하게 데이터만 설계하는 클래스.
// VO(Value Object): 값(자료)를 표현하는 객체.
// DTO(Data Transfer Object): 데이터를 전달(메서드 아규먼트, 리턴 값)할 때 사용되는 객체.
public class Contact {
	// fields
	private int cid;		// 연락처 고유 번호
	private String name;	// 이름
	private String phone;	// 전화번호
	private String email;
	
	// constructor
	public Contact() {};
	
	public Contact(int cid, String name, String phone, String email) {
		super();
		this.cid = cid;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	// getter/setter method
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCid() {
		return cid;
	}
	
	// toString method
	@Override
	public String toString() {
		return "Contact(cid =" + this.cid
				+ ", name = " + this.name
				+ ", phone = " + this.phone
				+ ", email = " + this.email
				+ ")";
		// return String.format("Contact(cid = %d, name = %s, phone = %s, email = %s)", cid, name, phone, email);
	}
	
	

}
