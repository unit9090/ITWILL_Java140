package edu.java.loop08;

public class LoopMain08 {

	public static void main(String[] args) {
		// 구구단 2단은 2x2까지, 3단은 3x3까지, ... , 9단은 9x9까지 출력
		
		// 방법 1: break 문 없이 for문 활용
		for(int x = 2; x < 10; x++) {
			System.out.println("--- " + x +"단 ---");
			
			for(int y = 1; y <= x; y++) {
				System.out.printf("%d X %d = %d\n", x, y, (x * y));
			}
		}
		
		System.out.println("\n===================================================\n");
		
		// 방법 2: break 문 활용하여 for문
		for(int x = 2; x < 10; x++) {
			System.out.println("--- " + x +"단 ---");
			
			for(int y = 1; y <= 9; y++) {
				if(y > x) {
					break;
				} else {
					System.out.printf("%d X %d = %d\n", x, y, (x * y));
				}
			}
		}
		
		System.out.println("\n===================================================\n");
		
		// 방법 3: break 문 없이 while 문 활용
		int p = 2;
		int q = 1;
		while(p < 10) {
			System.out.println("--- " + p +"단 ---");
			
			q = 1;
			while(q <= p) {
				System.out.printf("%d X %d = %d\n", p, q, (p * q));
				q++;
			}
			
			p++;
		}
		
		System.out.println("\n===================================================\n");
		
		// 방법 4: break 문 활용하여 while 문
		p = 2;
		while(p < 10) {
			System.out.println("--- " + p +"단 ---");
			
			q = 1;
			while(q <= p) {
				if(q > p) {
					break;
				} else {
					System.out.printf("%d X %d = %d\n", p, q, (p * q));
				}				
				q++;
			}
			
			p++;
		}

	}

}
