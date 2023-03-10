package edu.java.array09;

import java.util.Random;

public class ArrayMainTest {

	public static void main(String[] args) {
        // 1차원 정수(int) 배열 3개를 갖는 2차원 배열을 선언.
        // 첫번째 배열에는 난수 2개, 두번째 배열에는 난수 3개, 세번째 배열에는 난수 4개 저장.
        // 저장하는 난수의 범위는 0 이상 100 이하.
        // 2차원 배열의 원소들을 출력.
        // 2차원 배열의 모든 원소들의 합을 계산하고 출력.
        // 2차원 배열의 모든 원소들의 평균을 계산하고 출력.
        // 최댓값을 찾고 출력.
        // 최솟값을 찾고 출력.
		
		
		int[][] array = new int [3][];		// 2차원 정수 배열 선언
		
		// 열의 갯수 정해주기
		for(int i = 0; i < array.length; i++) {
			array[i] = new int[i + 2];
		}
		
		// 1차원 배열에 난수 저장
		Random random = new Random();
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				array[i][j] = random.nextInt(101);
			}			
		}
		
		int sum = 0;			// 모든 원소의 합계
		int objectSum = 0;		// 평균을 구하기 위해 모든 원소의 갯수 count
		int max = array[0][0];	// 최댓값
		int min = array[0][0];	// 최솟값
		
		for(int[] x : array) {
			
			objectSum += x.length;
			
			for(int y : x) {
				System.out.print(y + "\t");		// 모든 난수 출력
				sum += y;
				
				// 최댓값, 최솟값 구하는 if문
				if(y > max) {
					max = y;
				}
				
				if(y < min) {
					min = y;
				}
			}
			System.out.println();
		}
		
		System.out.println("================================");
		System.out.println("sum = " + sum);							// 2차원 배열의 모든 원소들의 합
		System.out.println("avg = " + ((double) sum / objectSum));	// 2차원 배열의 모든 원소들의 평균
		System.out.println("max = " + max + ", min = " + min);		// 최댓값, 최솟값 출력	

	}

}
