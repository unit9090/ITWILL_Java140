package edu.java.inheritance09;

// enum:
// (1) 열거형 상수(들)을 정의하는 특별한 종류의 클래스.
// (2) java.lang.Enum 클래스를 상속하는 하위 클래스.
// (3) 필드, 생성자, 메서드를 선언(정의)할 수 있음.

//class Test extends Enum {}	// -> 문법적으로 막아버림.

class Test {
	public static final Test AM = new Test("오전");
	public static final Test PM = new Test("오후");
	
	private String meaning;
	
	private Test(String meaning) {
		this.meaning = meaning;
	}
	
}


enum Time {
//	AM, PM;	// 생성자 호출
	// 열거형 상수 선언
	AM("오전"), PM("오후");	// AM은 "오전"이라는 meaning 객체를 가지는 인스턴스??? => 알아보기
	// -> enum 타입의 열거형 상수들은 enum 타입으로 생성된 객체!
	
	// 필드
	private String meaning;
	
	// 생성자 - enum 생성자는 반드시 private!
	private Time(String meaning) {
		this.meaning = meaning;
	}
	
	// 메서드
	public String getMeaning() {
		return this.meaning;
	}
	
}

public class EnumTestMain {

	public static void main(String[] args) {
		Time t = Time.AM;
		System.out.println(t);				// am.toString()의 리턴 값을 출력.
		System.out.println(t.name());		// Enum 클래스에서 상속받은 메서드.			// name 메서드는 toString과 비슷한 결과를 준다.
		System.out.println(t.ordinal());	// Enum 클래스에서 상속받은 메서드.			// int를 리턴. override 불가.
		System.out.println(Time.values());	// Enum 클래스에서 상속받은 static 메서드.	// class 이름에 .을 찍으면 모두 static 메소드들만 나온다.
		Time[] times = Time.values();
		for(Time x : times) {
			System.out.println(x + ":" + x.getMeaning());
		}
	}

}
