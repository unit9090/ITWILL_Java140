package edu.java.conditional05;

import java.util.Random;	// java.util 패키지의 Random 타입을 (변수 선언에서) 사용.

public class ConditionalMain05 {

	public static void main(String[] args) {
		// 난수(random number) 만드는 방법:
		Random random = new Random();	// Random 타입의 변수를 선언하고 초기화.
		int x = random.nextInt(5);		// 0 이상 5 미만의 정수 난수를 만들어 변수 x에 저장.
		System.out.println("x = " + x);
		
		int y = random.nextInt(5);
		System.out.println("y = " + y);
		
		// int 타입의 bigger 변수에 x와 y 중에서 더 큰 수를 저장.
		int bigger;

		if(x > y) {
			bigger = x;
			System.out.println("x = "  + bigger + " 의 값이 더 큽니다.");
		} else if (x < y){
			bigger = y;
			System.out.println("y = "  + bigger + " 의 값이 더 큽니다.");
		} else {
			bigger = x;
			System.out.println("x, y = "  + bigger + " 둘의 값이 같습니다.");
		}
		
		// 삼항 연산자
		int bigger2 = (x > y) ? x : y;
		System.out.println("bigger2 = " + bigger2);
		
		// int 타입의 diff 변수에 x와 y의 차이(|x - y|)를 저장.
		// 1. 삼항 연산자
		int diff = (x > y) ? x - y : y - x;
		System.out.println("diff = " + diff);
		
		// 2. if문 활용
		int diff2;
		if(x > y) {
			diff2 = x - y;
		} else {
			diff2 = y - x;
		}		
		System.out.println("diff2 = " + diff2);
		
		// String: 문자열 변수 저장
		
		// 10 이하의 정수 난수를 만들어서 number에 저장.
		// String 타입 변수 evenOrOdd에 number가 짝수이면 "짝수", 홀수이면 "홀수" 문자열을 저장.
		// 결과 출력.
		int number = random.nextInt(11);
		System.out.println("number = " + number);
		
		String evenOrOdd = "";
		if(number % 2 == 0) {
			evenOrOdd = "짝수";
		} else {
			evenOrOdd = "홀수";
		}
		System.out.println("evenOrOdd = " + evenOrOdd);
		
		String evenOrOdd2 = number % 2 == 0 ? "짝수" : "홀수";
		System.out.println("evenOrOdd2 = " + evenOrOdd2);
		
	}

}
