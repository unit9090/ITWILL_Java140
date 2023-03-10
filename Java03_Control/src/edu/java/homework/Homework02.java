package edu.java.homework;

public class Homework02 {

	public static void main(String[] args) {
		// 369 게임 출력
        /* 실행 결과
            1   2   *   4   5   *   7   8   *   10  
            11  12  *   14  15  *   17  18  *   20  
            21  22  *   24  25  *   27  28  *   *   
            *   *   *   *   *   *   *   *   *   40  
            41  42  *   44  45  *   47  48  *   50  
            51  52  *   54  55  *   57  58  *   *   
            *   *   *   *   *   *   *   *   *   70  
            71  72  *   74  75  *   77  78  *   80  
            81  82  *   84  85  *   87  88  *   *   
            *   *   *   *   *   *   *   *   *   100
         */
		
		// 숫자에 3이 들어가는 경우 (n - (3 + 10 * k)  = 0)
		// 숫자에 6이 들어가는 경우 (n - (6 + 10 * k)  = 0)	
		// 숫자에 9가 들어가는 경우 (n - (9 + 10 * k)  = 0)

		int k = 0;		// 10의 자리 숫자
		int ten = 1;	// 30, 60, 90을 걸러내기 위한 변수
		
		for(int i = 1; i <= 100; i++) {
			if(i - (3 + 10 * k) == 0) {				// 숫자에 3이 들어가는 경우

				System.out.print("*\t");
				
			} else if(i - (6 + 10 * k) == 0) {		// 숫자에 6이 들어가는 경우
				
				System.out.print("*\t");
				
			} else if(i - (9 + 10 * k) == 0) {		// 숫자에 9가 들어가는 경우
				
				System.out.print("*\t");
				
			} else if(i % 10 == 0) {				// 10의 자리 숫자인 경우
				
				if(ten % 3 == 0) {					// 10의 자리 숫자가 3의 배수인 경우
					System.out.print("*\t\n");
				} else {							// 10의 자리 숫자가 3의 배수가 아닌 경우
					System.out.printf("%d\n", i);
				}
				
				ten++; k++;
			
			} else if(k == 3 || k == 6 || k == 9) {	// 10의 자리가 3, 6, 9인 경우
				System.out.print("*\t");
			} else {
				System.out.print(i + "\t");			// 3, 6, 9 및 10의 배수에 해당이 안되는 경우
			}
		}
		
		System.out.println("========================================================================================");
		System.out.println();
		
		/* 강사님 풀이 */
		
		/*
		// 방법 1:
		for(int n = 1; n <= 100; n++) {
			int n1 = n % 10;	// n을 10으로 나눈 나머지 -> 1의 자릿수
			int n10 = n / 10;	// n을 10으로 나눈 몫 -> 10의 자릿수
			
			boolean condition1 = (n1 == 3) || (n1 == 6) || (n1 == 9);
			
			// 숫자를 출력할 것인지, "*"를 출력할 것인지 판단.
			if(n1 == 3 || n1 == 6 || n1 == 9
			|| n10 == 3 || n10 == 6 || n10 == 9) {
				System.out.print("*\t");
			} else {
				System.out.print(n + "\t");
			}
			
			// 줄바꿈을 할 것인지, 아닌지 판단.
			if(n % 10 == 0) {
				System.out.println();	// 줄바꿈
			}
		}
		
		// 방법 2:
		for(int n = 1; n <= 100; n++) {
			int n1 = n % 10;	// n을 10으로 나눈 나머지 -> 1의 자릿수
			int n10 = n / 10;	// n을 10으로 나눈 몫 -> 10의 자릿수
			
			// 1의 자릿수가 3 또는 6 또는 9인 경우
			boolean condition1 = (n1 == 3) || (n1 == 6) || (n1 == 9);
			// 10의 자릿수가 3 또는 6 또는 9인 경우
			boolean condition2 = (n10 == 3) || (n10 == 6) || (n10 == 9);
			
			// 숫자를 출력할 것인지, "*"를 출력할 것인지 판단.
			if(condition1 && condition2) {
				System.out.print("**\t");
			} else if(condition1 || condition2) {
				System.out.print("*\t");
			} else {
				System.out.print(n + "\t");
			}
			
			// 줄바꿈을 할 것인지, 아닌지 판단.
			if(n % 10 == 0) {
				System.out.println();	// 줄바꿈
			}
		}
		*/
		
	}

}
