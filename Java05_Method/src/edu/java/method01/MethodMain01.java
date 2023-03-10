package edu.java.method01;

import java.util.Random;

// 메서드(method): 클래스 안에서 정의하는 기능(함수, function).
// - 함수(function): 프로그램에서 사용될 기능을 코드 블록으로 작성한 것. 클래스 밖에서 작성하거나 클래스 안에서 만드는 것.
// - 메서드: 클래스 안에서 작성된 함수.
// 자바 언어는 메서드만 제공하고, 함수는 제공하지 않음!
// 자바 언어는 메서드 안에서 메서드를 정의하는 것을 제공하지 않음!

// 메서드 호출(call, invoke): 메서드를 사용하는 것.
// argument: 메서드를 호출할 때 메서드에게 전달하는 값.
// parameter(매개변수): argument를 저장하기 위한 메서드의 지역 변수.
// 반환 값(return value): 메서드가 모든 기능을 수행한 후 메서드를 호출한 곳으로 되돌려 주는 값.
// - 메서드는 반환 값이 있을 수도 있고, 없을 수도 있음.
// - println(): 반환 값이 없는 메서드.
// - nextInt(): 반환 값이 있는 메서드.

// 메서드 정의(선언) 방법: 
// [수식어] 리턴타입 메서드 이름([파라미터 선언, ..] => 변수선언) {	...	}
// [public static] void main(String[] args => 문자열을 배열로 넘겨준다.)
// public static int addMethod(int x, int y) {int sum = x + y; return sum;}
// 메서드의 리턴 값이 없는 경우에는 리턴 타입을 void라고 선언함.
// 수식어와 파라미터 선언은 있을 수도 있고 없을 수도 있다.
// 리턴 타입은 없을 수 없다.

// /** */: 문서화 주석

public class MethodMain01 {

	// main 메서드(method): 프로그램 시작점.
	public static void main(String[] args) {
		System.out.println("안녕하세요~");
		//-> println() 메서드 호출. -> 호출 결과: 콘솔 창에 문자열을 출력.
		
		Random random = new Random();
		int x = random.nextInt(10);
		//-> nextInt() 메서드(기능) 호출 및 10이라는 argument를 전달 -> nextInt() 메서드는 난수를 반환(return).
		// 함수(메서드)를 호출할 때 이 때 사용하게 되는 일련의 값(ex> 10)들을 아규먼트라고 부른다.
		// JDK 안에 메서드들이 있음. -> 만약 JDK에 없는 기능이 있다면 본인이 새로운 메서드들을 만든다.
		
		System.out.println(x);
		
		System.out.println("테스트");
		newLine();	// 같은 클래스에 정의(선언)된 메서드를 호출.
		System.out.println("테스트2");
		
		System.out.println("테스트3");
		newLine(3);
		System.out.println("테스트4");
		
		System.out.println(addMethod(7, 6));
	}
	
	/**
	 * 두 값을 넣으면 합을 구해주는 메서드
	 * @param x
	 * @param y
	 * @return sum
	 */
	public static int addMethod(int x, int y) {
		int sum = x + y;
		return sum;
	}
	
	/**
	 * 콘솔에 빈 줄 하나를 출력하는 메서드
	 */
	public static void newLine() {
		System.out.println();
	}
	
	/**
	 * 콘솔에 n개의 빈 줄을 출력하는 메서드.
	 * @param int n: 0 이상의 정수. 출력할 빈 줄의 개수.
	 */
	public static void newLine(int n) {
		for(int i = 0; i < n; i++) {
			System.out.println();
		}		
	}

}
