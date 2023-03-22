package edu.java.inheritance09;

public enum Singleton {
	// 싱글톤을 enum을 사용하여 생성할 수 있다.
	// singleton(싱글톤): 오직 한 번만 생성할 수 있는 객체.
	// singleton = (1) private static 클래스 필드 + (2) private 생성자 + (3) public static 클래스 메서드
	// enum 열거형 상수(public static final Menu 타입 변수) 선언
	INSTANCE;
	
	// -> INSTANCE singleton 예제 -> MenuTestTeacher.java
}
