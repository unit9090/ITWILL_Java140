package edu.java.loop05;

public class LoopMain05 {

	public static void main(String[] args) {
		// 1 ~ 10 정수들을 오름차순으로 한 줄에 출력(1 2 3 4 ... 10)
		for(int i = 1; i <= 10; i++) {
			System.out.print(i + " ");
		}
		
		System.out.println();		
		
		// while 반복문
		int n = 1;
		while(n <= 10) {
			System.out.print(n + " ");
			n++;						// *실수 많음.
		}
		
		System.out.println();
		
		// 출력 결과: 1 3 5 7 9
		
		// 1. for 문
		for(int i = 1; i < 10; i += 2) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		/*
		for(int i = 1; i < 10; i++) {
			if(i % 2 != 0) {
				System.out.print(i + " ");
			}			
		}
		*/
		
		// 2. while 문
		n = 1;
		while(n < 10) {
			System.out.print(n + " ");
			n += 2;
		}
		
		System.out.println();
		
		/*
		int p = 1;		
		while(p < 10) {
			if(p % 2 != 0) {
				System.out.print(p + " ");
			}
			p++;
		}
		*/
		
		n = 1;
		while(n < 10) {
			if(n % 2 == 1) {
				System.out.print(n + " ");
			}			
			n++;
		}
		
		System.out.println();
		

		/*
		
		// while 문
		초기화 문장;
		while(조건식) {
			실행문;
			(조건 변경, 증감);
		}
		
		*/
		
		/*
		
		// do-while 문
		do {
			실행문;
			증감식(조건변경);
		} while (조건식);
		
		*/

	}

}
