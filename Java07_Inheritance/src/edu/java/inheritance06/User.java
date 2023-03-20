package edu.java.inheritance06;

import java.util.Objects;

public class User {
	// field
	private String userId;
	private String password;
	
	// 생성자
	// (1) 기본 생성자
	public User() {}
	
	// (2) argument 2개를 갖는 생성자.
	public User(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
	
	// getters & setters
	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	// toString() override: "User(userId= ..., password= ...)"
	@Override
	public String toString() {
		return "User(userId = " + this.userId + ", password = " + this.password + ")";
	}
	
	// equals() override: 두 객체의 userId가 같으면 true, 그렇지 않으면 false.
	@Override
	public boolean equals(Object obj) {
		boolean check = false;
		
		if(obj instanceof User) {
			User other = (User) obj;
			check = (this.userId.equals(other.userId));
		}
		
		return check;
	}
	
	// hashCode() override
	@Override
	public int hashCode() {
//		return userId.hashCode() * 1000;
		return Objects.hash(userId);
	}
}
