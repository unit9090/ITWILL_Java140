package edu.java.modifier05;

import edu.java.modifier04.PublicClass;
//import edu.java.modifier04.PackageClass; => not visible

// 클래스 접근 수식어(access modifier)
// 1. public: 어디서나 사용할 수 있는 클래스
// 2. (package): 수식어가 없는 경우. 같은 패키지의 클래스들에서만 사용 가능한 클래스.
// (주의) public 클래스의 이름은 java 파일의 이름과 같아야 함!
// 1개의 java 파일에 2개의 public 클래스를 정의할 수 없다.

// public class A {} => 문법 오류

class B {} // 문법 오류 X => 가능은 하나 클래스 별로 자바파일을 따로 만들어주는 것을 권장.

public class ModifierMain05 {

	public static void main(String[] args) {

		// edu.java.modifier04.PublicClass 타입의 객체 생성
		PublicClass cls = new PublicClass();
		
//		edu.java.modifier04.PackageClass cls2; => not visible
		
	}

}

