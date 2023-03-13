package edu.java.array01;

public class ArrayMain01 {

	public static void main(String[] args) {
		// 배열(array): 같은 타입의 데이터 여러 개를 하나의 변수 이름으로 저장하기 위한 메모리 공간.
		// 인덱스(index): 배열에서 데이터가 저장된 위치를 나타내는 정수.
		// 배열의 인덱스는 0부터 시작!
		// 배열의 마지막 인덱스는 (배열 원소 개수 - 1).
		// 모든 배열은 배열의 길이(배열의 원소 개수)를 알려주는 length 속성을 가지고 있음.
		
		// 정수(int) 4개를 저장할 수 있는 배열 선언, 초기화.
		int[] scores = new int[4];
//		int arr[] = new int [10];	// 대괄호의 위치를 이런 식으로 변경할 수 있다.
		
		// 배열의 특정 인덱스에 원소를 저장(재할당)
		scores[0] = 100;
		scores[1] = 90;
		
		// 배열의 특정 인덱스에 저장된 원소의 값 읽기
		System.out.println(scores);
		System.out.println(scores[0]);
		System.out.println(scores[1]);
		System.out.println(scores[2]);
		System.out.println(scores[3]);
		
		System.out.println();
		
		System.out.println("length = " + scores.length);
		for(int i = 0; i < scores.length; i++) {		// i < 4 -> 원소의 갯수 4개
			System.out.println(scores[i]);
		}
		
		System.out.println("======================");
		
		// 배열 선언 초기화 방법 2:
		int[] numbers = {100, 90, 0, 50, 80};
		// int[] numbers = new int[] {100, 90, 0, 50, 80};	=> 이런 방법도 가능
		
		for(int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
		
		numbers[2] = 99;
		System.out.println();
		
		for(int i = 0; i < numbers.length; i++) {                                                        
			System.out.println(numbers[i]);
		}
		
		System.out.println("======================");
		
		// 향상된 for 문(enhanced for statement). for-each 구문
		// for((배열이 가지고 있는 타입)변수 선언 : 배열의 이름)
		// * 향상된 for문을 가지곤 배열의 값을 변경할 수 없다. *
		for(int x : numbers) {
			System.out.println(x);
		}
		
	}

}
