package edu.java.method03;

import java.util.Random;

public class MethodMain03 {

	public static void main(String[] args) {
		Random random = new Random();
		
		int[] array = new int[random.nextInt(1, 6)];
		
		System.out.println("배열 길이: " + array.length);
		System.out.println("================== 배열의 원소 ==================");
		System.out.println("===============================================");
		
		for(int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(10);
			System.out.print(array[i] + "\t");
		}
		
		System.out.println();
		System.out.println("===============================================");

		// 배열의 합
		System.out.println("sum = " + sum(array));
		
		// 배열의 평균
		System.out.println("avg = " + mean(array));
		
		// 배열 원소 중 최댓값
		System.out.println("max = " + max(array));
		
		// 배열 원소 중 최댓값의 인덱스 값
		System.out.println("maxAt = " + maxAt(array));
		
		// 배열 원소 중 최솟값
		System.out.println("min = " + min(array));
		
		// 배열 원소 중 최솟값의 인덱스 값
		System.out.println("minAt = " + minAt(array));
	}
	
	/**
     * sum
     * 정수 배열의 모든 원소들의 합을 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 모든 원소들의 합.
     */
	public static int sum(int[] arr) {
		int sum = 0;
		for(int x : arr) {
			sum += x;
		}
		
		return sum;
	}
    
    /**
     * mean
     * 정수 배열의 모든 원소들의 평균을 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 모든 원소들의 평균.
     */
	public static double mean(int[] arr) {
		double avg = (double) sum(arr) / arr.length;
		
		return avg;
	}
    
    /**
     * max
     * 정수 배열에서 최댓값을 찾아서 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 원소들 중 최댓값.
     */
	public static int max(int[] arr) {
		int max = arr[0];
		for(int x : arr) {
			max = x > max ? x : max;
		}
		
		return max;
	}
    
    /**
     * maxAt
     * 정수 배열에서 최댓값의 인덱스 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 원소들 중 최댓값의 인덱스.
     * 최댓값이 여러개 있는 경우, 첫번째 최댓값의 인덱스.
     */
	public static int maxAt(int[] arr) {
		int maxAt = 0;
		for(int i = 0; i < arr.length; i++) {
			if(max(arr) == arr[i]) {
				maxAt = i;
				break;
			}
		}
		
		return maxAt;
	}
	
    // TODO

    /**
     * min
     * 정수 배열에서 최솟값을 찾아서 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 원소들 중 최솟값.
     */
    // TODO
	public static int min(int[] arr) {
		int min = arr[0];
		for(int x : arr) {
			min = x < min ? x : min;
		}
		
		return min;
	}
	
    /**
     * minAt
     * 정수 배열에서 최솟값의 인덱스 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 원소들 중 최솟값의 인덱스.
     * 최솟값이 여러개 있는 경우, 첫번째 최솟값의 인덱스.
     */
    // TODO
	public static int minAt(int[] arr) {
		int minAt = 0;
		for(int i = 0; i < arr.length; i++) {
			if(min(arr) == arr[i]) {
				minAt = i;
				break;
			}			 
		}
		
		return minAt;
	}

}
