package edu.java.loop02;

public class LoopMain02 {

	public static void main(String[] args) {
		// 복합 할당 연산자: +=, -=, *=, /=, %=, ...
		int x = 10;
		// x = x + 1;
		// System.out.println("x = " + x);
		x += 2;
		System.out.println("x = " + x);
		
		// System.out.println: print line. 출력하고 줄바꿈.
		System.out.println("test");
		
		// System.out.print: 출력하고 줄바꿈이 일어나지 않음. 출력이 끝난 위치에 커서가 위치.
		System.out.print("test1");
		System.out.print("test2");
		System.out.println("test3");
		
		// 결과: 0 2 4 6 8 10
		// 0 ~ 10 짝수들을 한 줄에 출력
		for(int i = 0; i <= 10; i += 2) {
			System.out.print(i + " ");
		}
		
		System.out.println();	// 줄바꿈
		
		/* 강사님 방법
			for(int n = 0; n <= 10; n += 2) {
				System.out.print(n + " ");
			}
			
			for(int n = 0; n <= 5; n++) {
				System.out.print((2 * n) + " ");
			}
			
			for(int n = 0; n <= 10; n++) {
				if(n % 2 == 0) {
					System.out.print(n + " ");
				}
			}
		*/
		
		// 결과: 1 3 5 7 9
		// 10 이하의 홀수들을 한 줄에 출력
		for(int i = 1; i <= 5; i++) {
			System.out.print((2 * i -1) + " ");
		}
		
		System.out.println();
		
		/* 강사님 방법
			for(int i = 1; i <= 9; i += 2) {
				System.out.print(i + " ");
			}
			
			for(int n = 0; n <= 10; n++) {
				if(n % 2 != 0) {
					System.out.print(n + " ");
				}
			}
		*/
		
	}

}
