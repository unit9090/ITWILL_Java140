package edu.java.loop09;

import java.util.Random;

public class LoopMain09 {

	public static void main(String[] args) {
        /* 문제 1. 아래와 같이 출력하세요.
	        *
	        **
	        ***
	        ****
	        *****
	      */
		
		System.out.println("===== 문제 1 =====");
		
		for(int p = 1; p <= 5; p++) {
			for(int q = 1; q <= p; q++) {
				System.out.print("*");
			}			
			
			System.out.println();
		}
		
		System.out.println();
		
		/* 강사님 풀이 */
		/*
			// 방법 1: for 문 활용
			for(int x = 1; x <= 5; x++) {			// 라인 수
				for(int y = 1; y <= x; y++) {		// 출력하는 횟수
					System.out.print("*");
				}
				System.out.println();
			}
			
			// 방법 2: while 문 활용
			int line = 1;
			while(line <= 5) {
				int count = 1;
				while(count <= line) {
					System.out.print("*");
					count++;
				}
				System.out.println();
				line++;
			}
			
		*/
		
		
		
		// Ctrl + Shift + F: 코드 포맷팅(자동 정렬)
	     
	     /* 문제 2. 아래와 같이 출력하세요.
	        *
	        **
	        ***
	        ****
	        *****
	        ****
	        ***
	        **
	        *
	      */
		
		System.out.println("===== 문제 2 =====");
		
		for(int p = 1; p <= 5; p++) {
			for(int q = 1; q <= p; q++) {
				System.out.print("*");
			}			
			
			System.out.println();
		}
		
		for(int p = 1; p <= 5; p++) {
			for(int q = 0; q <= 4 - p; q++) {
				System.out.print("*");
			}			
			
			System.out.println();
		}
		
		System.out.println();
		
		/* 강사님 풀이 */
		
		// 방법 1:
//		for(int x = 1; x <= 5; x++) {
//			for(int y = 1; y <= x; y++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		
//		for(int x = 4; x >= 1; x--) {
//			for(int y = 1; y <= x; y++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		// 아래 대체 코드 방법 1:
//		for(int x = 1; x <= 4; x++) {
//			for(int y = 4; y >= x; y--) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		// 아래 대체 코드 방법 2:
//		for(int x = 6; x <= 9; x++) {
//			for(int y = 4; y >= x - 5; y--) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		// 방법 2:
//		for(int x = 1; x <= 9; x++) {
//			if(x <= 5) {
//				// *를 하나씩 늘려나감.
//				for(int y = 1; y <= x; y++) {
//					System.out.print("*");
//				}
//			} else {
//				// *를 하나씩 줄여나감.
//				for(int y = 4; y >= x - 5; y--) {
//					System.out.print("*");
//				}
//			}
//			
//			System.out.println();
//		}
		
	
	     /* 문제 3. 주사위 2개를 던졌을 때 나오는 주사위 눈을 (x, y) 형식으로 출력하세요.
	        두 눈의 합이 5가 되면 출력을 멈추세요.
	        힌트 1: Random 타입의 nextInt(start, end) 메서드를 사용.
	        힌트 2: for( ; ; ) {...}, while(true) {...} => 무한 루프
	        출력 결과 예시:
	        (2, 4)
	        (6, 1)
	        (3, 3)
	        (4, 1)
	      */
		
		System.out.println("===== 문제 3 =====\n");
		
		Random random = new Random();		
		
		System.out.println("\t\t>>> 주사위 굴리기 <<<");
		System.out.println(">>> 주사위 2개를 던져 두 눈의 합이 5가 되도록 하세요. <<<");
		
		while(true) {
			int dice1 = random.nextInt(5) + 1;
			int dice2 = random.nextInt(5) + 1;
			
			System.out.println("(" + dice1 + ", " + dice2 + ")");
			
			int sum = dice1 + dice2;
			
			if(sum == 5) {
				break;
			}
		}
		
		System.out.println("주사위 게임을 완료하였습니다.");
		
		System.out.println();
		
		/* 강사님 풀이 */
		// for(;;)
		while(true) {
			int dice1 = random.nextInt(1, 7);	// 1 <= r < 7
			int dice2 = random.nextInt(6) + 1;
			
			System.out.printf("(%d, %d)\n", dice1, dice2);
			
			if(dice1 + dice2 == 5) {
				// 주사위 두 눈의 합이 5가 되면
				break;
			}			
		}
		
	}

}
