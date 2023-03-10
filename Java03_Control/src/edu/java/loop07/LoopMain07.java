package edu.java.loop07;

public class LoopMain07 {

	public static void main(String[] args) {
		// 2중 반복문
		for(int dan = 2; dan < 10; dan++) {
			System.out.println("---" + dan + "단 ---");
			for(int n = 1; n < 10; n++) {
				// System.out.println(dan + " X " + n + " = " + (dan * n));
				System.out.printf("%d X %d = %d\n", dan, n, (dan * n));				
			}
		}
		
		System.out.println("\n=============================\n");
		
		// while문을 사용한 구구단 출력
		int n = 2;		
		while(n < 10) {
			System.out.println("---" + n + "단 ---");
			int m = 1;
			while(m < 10) {
				System.out.printf("%d X %d = %d\n", n, m, (n * m));
				m++;
			}
			n++;
		}
		
		/*
		int x = 2;
		int y = 1;
		while(x < 10) {
			System.out.println("--- " + x + "단 ---");
			
			// 구구단 출력
			y = 1;
			while(y < 10) {
				System.out.printf("%d X %d = %d\n", x, y, (x * y));
				y++;
			}
			
			x++;
		}
		*/
		
		System.out.println("\n=============================\n");
		
		// for 문을 이용해 다음과 같이 *을 출력하시오.
		
		// 별 내림차순
		for(int may = 1; may <= 4; may++) {
			for(int p = 0; p <= 4 - may; p++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("\n=============================\n");
		
		// 별 오름차순		
		for(int p = 1; p <= 4; p++) {
			for(int q = 1; q <= p; q++) {
				System.out.print("*");
			}			
			
			System.out.println();
		}

	}

}
