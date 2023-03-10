package edu.java.array03;

public class ArrayMain03 {

	public static void main(String[] args) {
		// Ex 1.
		// 정수(int) 10개를 저장할 수 있는 배열 선언
		// 배열에 순서대로 0, 2, 4, 6, 8, 10, ..., 18을 저장
		// 배열의 원소들을 한 줄로 출력.
		int x = 0;
		int[] number = new int[10];
		for(int i = 0; i < 10; i++) {
			number[i] = x;
			x += 2;
		}
		
		for(int num : number) {
			System.out.print(num + " ");
		}
		
		System.out.println("\n-----------------------------------------------------------");
		
		/* 강사님 풀이 */
		/*
			int[] evens = new int[10];
//			evens[0] = 0; evens[1] = 2; evens[2] = 4; evens[3] = 0; evens[4] = 0;
//			evens[5] = 0; evens[6] = 0; evens[7] = 0; evens[8] = 0; evens[9] = 0;
			
			for(int i = 0; i < evens.length; i++) {
				evens[i] = i * 2;
			}
			
			for(int q : evens) {
				System.out.print(q + " ");
			}
		*/
		
		
		// Ex 2.
		// boolean 10개를 저장할 수 있는 배열 선언.
		// 배열에 순서대로 true, false, true, false, ..., false를 저장
		// 배열의 원소들을 한 줄로 출력.
		boolean[] bool = new boolean[10];
		for(int i = 0; i < 10; i++) {
			if(i % 2 == 0) {
				bool[i] = true;
			} else {
				bool[i] = false;
			}
		}
		
		for(boolean y : bool) {
			System.out.print(y + " ");
		}
		
		System.out.println("\n-----------------------------------------------------------");
		
		/* 강사님 풀이 */
		/*
			boolean[] isEven = new boolean[10];
//			boolean[] isEven = {true, false, true, false, };
		
			for(int i = 0; i < isEven.length; i++) {
				if(i % 2 == 0) {
					isEven[i] = true;
				} else {
					isEven[i] = false;
				}
			}
			
			for(int i = 0; i < isEven.length; i++) {
				if(i % 2 == 0) {
					isEven[i] = true;
				}
			}
			
			for(boolean b : isEven) {
				System.out.print(b + " ");
			}
		*/
	}
}
