package edu.java.method02;

import java.util.Random;

public class MethodMain02 {

	public static void main(String[] args) {
		// argument를 가지고, 리턴 값이 있는 메서드 작성/호출 연습
		
		// 같은 클래스 안에서 작성한 메서드인 경우에는 메서드 이름으로만 호출하면 됨.
		double result = add(1, 2);	// 메서드 호출. argument - 1, 2.
		System.out.println(result);
		
		// 뺄셈 결과
		System.out.println("뺄셈 = " + subtract(5, 6));
		
		// 곱셈 결과
		System.out.println("곱셈 = " + multiply(5, 6));
		
		// 나눗셈 결과
		System.out.println("나눗셈 = " + divide(5, 6));
		
		// 짝수 참, 거짓
		if(isEven(5) == true) {
			System.out.println("참, 거짓 = 짝수입니다.");
		} else {
			System.out.println("참, 거짓 = 홀수입니다.");
		}
		
		if(isEven(4) == true) {
			System.out.println("참, 거짓 = 짝수입니다.");
		} else {
			System.out.println("참, 거짓 = 홀수입니다.");
		}

		// 배열 출력
		System.out.println("============= 난수 배열 =============");
		for(int x : makeArray(5)) {
			System.out.print(x + "\t");
		}
		
		System.out.println();
		
	}
	
	/**
	 * 실수 2개를 전달받아서, 덧셈 결과를 리턴하는 메서드.
	 * @param x	실수(double) 타입.
	 * @param y	실수(double) 타입.
	 * @return x + y
	 */
	public static double add(double x, double y) {
		// 메서드 정의(선언)
		// 메서드 수식어 - public static
		// 메서드 리턴 타입 - double
		// 메서드 이름 - add
		// 파라미터(parameter) - double x, double y
		
		return x + y;	// 리턴 문장. x + y -> 리턴 값.
	}
	
	/**
     * subtract
     * 숫자 2개를 전달받아서, 뺄셈의 결과를 반환.
     * @param x double.
     * @param y double.
     * @return x - y.
     */
    // TODO
	public static double subtract(double x, double y) {
		return x - y;
	}
    
    /**
     * multiply
     * 숫자 2개 전달받아서 곱셈 결과를 반환.
     * @param x double.
     * @param y double.
     * @return x * y.
     */
    // TODO
	public static double multiply(double x, double y) {
		return x * y;
	}
    
    /**
     * divide
     * 숫자 2개를 전달받아서, 나눗셈 결과를 반환.
     * @param x double.
     * @param y double.
     * @return x / y.
     */
    // TODO
	public static double divide(double x, double y) {
		return x / y;
	}
	
    /**
     * isEven
     * 정수가 짝수인 지 아닌 지를 리턴하는 메서드.
     * @param n 짝수인 지 홀수인 지 검사할 정수.
     * @return n이 짝수이면 true, 그렇지 않으면 false.
     */
    // TODO
	public static boolean isEven(int n) {
		boolean result = false;
		
		if(n % 2 == 0) {
			result = true;
			// return true;
		}
		
		return result;
		
		// return n % 2 == 0;
	}
	
    /**
     * makeArray
     * argument로 전달된 배열의 길이 크기의 정수 배열을 생성하고,
     * 임의의 난수들로 배열을 초기화해서 리턴하는 함수.
     * @param length 배열의 길이. 양의 정수.
     * @return length개의 난수들로 초기화된 정수 배열.
     */
    // TODO
	public static int[] makeArray(int length) {
		Random random = new Random();
		int[] array = new int [length];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(101);
		}
		
		return array;
	}

}
