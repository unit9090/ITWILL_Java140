package edu.java.array04;

import java.util.Random;

public class ArrayMain04 {

	public static void main(String[] args) {
		// 정수 5개를 저장할 수 있는 배열을 선언.
		// 0 이상 9 이하의 정수 난수 5개를 배열에 저장.
		// 배열의 내용을 출력.
		// 배열의 모든 원소의 합을 계산하고 출력.
		// 배열 원소들의 평균을 double 타입으로 계산하고 출력.
		

		Random random = new Random();	// 랜덤 함수 호출
		int[] number = new int[5];		// 정수 5개 저장할 수 있는 배열 선언
		
		// 0 이상 9 이하의 정수 난수 5개를 배열에 저장.
		for(int i = 0; i < number.length; i++) {
			number[i] = random.nextInt(10);
		}
		
		// 난수 확인
		System.out.print("배열: ");
		for(int num : number) {
			System.out.print(num + " ");
		}
		
		System.out.println();			// 줄바꿈
		
		// 배열의 모든 원소의 합을 계산 후 출력
		int sum = 0;
		for(int num : number) {
			sum += num;
		}
		
		System.out.println("합계: " + sum);
		
//		for(int i = 0; i < number.length; i++) {
//			sum += number[i];
//		}
		
		// 배열 원소들의 평균 계산 후 출력
		System.out.println("평균: " + ((double) sum / number.length));
		
		
//		=========================================================================================================
		
		/* 강사님 풀이 */
		
		
			// 정수 5개를 저장할 수 있는 배열을 선언.
			int[] numbers = new int[5];
			
			// 0 이상 9 이하의 정수 난수 5개를 배열에 저장.
			Random rand = new Random();
			for(int i = 0; i < numbers.length; i++) {
				numbers[i] = rand.nextInt(10);
			}
			
			// 배열의 내용을 출력.
			for(int x : numbers) {
				System.out.print(x + " ");
			}
			
			System.out.println();
			
			// 배열의 모든 원소의 합을 계산하고 출력.
			int sum1 = 0;
	//		for(int i = 0; i < numbers.length; i++) {
	//			sum1 += numbers[i];		// sum1 = sum1 + numbers[i];
	//			// System.out.println("sum = " + sum1);
	//		}
			
			for(int x : numbers) {
				sum1 += x;
			}
			
			System.out.println("sum = " + sum1);
			
			// 배열 원소들의 평균을 double 타입으로 계산하고 출력.
			double average = (double) sum1 / numbers.length;
			System.out.println("average = " + average);
		

//		=========================================================================================================
		
		// 배열의 원소들 중 최댓값을 찾고 출력.
		int max = number[0];
		for(int x : number) {
			if(x > max) {
				max = x;
			}
		}
		
		System.out.println("최댓값: " + max);
		
		// 배열의 원소들 중 최솟값을 찾고 출력.
		int min = number[0];
		for(int x : number) {
			if(x < min) {
				min = x;
			}
		}
		
		System.out.println("최솟값: " + min);

		/*
			for(int x : number) {
				if(x < min) {
					min = x;
				}
				
				if(x > max) {
					max = x;
				}
			}
			
			System.out.println("최댓값: " + max + ", 최솟값: " + min);
		*/
		
//		=========================================================================================================
		
		/* 강사님 풀이 */
		
			// 배열의 원소들 중 최댓값을 찾고 출력.
			int max1 = numbers[0];		// 배열의 첫번째(인덱스 0번 위치의) 원소를 최댓값이라고 가정.
			for(int x : numbers) {		// 배열 numbers의 모든 원소들을 순회하면서
				if(x > max1) {			// 배열에서 읽은 값이 max보다 크다면
					max1 = x;			// max의 값을 x로 변경.
				}
			}
			
			System.out.println("max = " + max1);
			
			// 배열의 원소들 중 최솟값을 찾고 출력.
			int min1 = numbers[0];		// 배열의 첫번째 원소를 최솟값이라고 가정.
			for(int x : numbers) {		// 배열의 모든 원소를 순서대로 반복하면서,
				if(x < min1) {			// 배열에서 읽은 값이 min보다 작다면
					min1 = x;			// min의 값을 x(배열에 읽은 더 작은 값)로 변경.
				}
			}
			
			System.out.println("min1 = " + min1);
		
	}

}
