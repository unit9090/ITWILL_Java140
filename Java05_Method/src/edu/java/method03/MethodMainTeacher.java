package edu.java.method03;

import java.util.Random;

public class MethodMainTeacher {

	public static void main(String[] args) {
		// 메서드 기능 테스트를 위한 배열 만들기
		int[] array = makeTestArray(5);
		
		// 테스트 데이터 출력하기
		printTestArray(array);
		
		
		// sum 메소드 호출
		int total = sum(array);
		System.out.println("sum = " + total);
		
		// mean 메소드 호출
		double average = mean(array);
		System.out.println("avg = " + average);
		
		// max 메소드 호출
		int max = max(array);
		System.out.println("max = " + max);
		
		// maxIndex 메소드 호출
		int maxIndex = maxAt(array);
		System.out.println("max index = " + maxIndex);
		
		int minValue = min(array);
		System.out.println("min = " + minValue);
		
		int minIndex = minAt(array);
		System.out.println("min index = " + minIndex);
	}
	
	/**
	 * 메서드 기능 테스트를 위한 배열 만들기
	 * @param n
	 * @return array
	 */
	public static int[] makeTestArray(int n) {
		int[] array = new int[n];
		Random random = new Random();
		
		// 메서드 기능 테스트를 위한 배열 만들기		
		for(int i = 0; i < n; i++) {
			array[i] = random.nextInt(10);
		}
		
		return array;
	}
	
	/**
	 * 테스트 데이터 출력하기
	 * @param array
	 */
	public static void printTestArray(int[] array) {
		// 테스트 데이터 출력하기
		System.out.print("[ ");
		for(int x : array) {
			System.out.print(x + " ");
		}
		System.out.println(" ]");
	}
	
	/**
     * sum
     * 정수 배열의 모든 원소들의 합을 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 모든 원소들의 합.
     */
    public static int sum(int[] arr) {
    	int total = 0;
    	for(int x : arr) {
    		total += x;
    	}
    	
    	return total;
    }
    
    /**
     * mean
     * 정수 배열의 모든 원소들의 평균을 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 모든 원소들의 평균.
     */
    public static double mean(int[] arr) {
    	// 평균 = 합계 / 개수;
    	return (double) sum(arr) / arr.length;
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
    		max = (x > max) ? x : max;
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
    	int max = arr[0];	// 배열의 최댓값을 저장할 변수
    	int index = 0;		// 배열의 최댓값의 인덱스를 저장할 변수.
    	for(int i = 1; i < arr.length; i++) {	// 배열의 원소들을 순서대로 반복하면서
    		if(arr[i] > max) {					// 배열에서 읽은 값이 max보다 크다면
    			max = arr[i];					// max 값을 배열에서 읽은 값으로 변경
    			index = i;						// 최댓값의 인덱스를 현재 인덱스로 변경
    		}
    	}
    	
    	// 다른 방법
    	int index1 = 0;
    	for(int i = 0; i < arr.length; i++) {
    		if(arr[i] > arr[index1]) {
    			index1 = i;
    		}
    	}
    	
    	return index;
    }

    /**
     * min
     * 정수 배열에서 최솟값을 찾아서 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 원소들 중 최솟값.
     */
    public static int min(int[] arr) {
    	int minVal = arr[0];
    	for(int x : arr) {
    		if(x < minVal) {
    			minVal = x;
    		}
    	}
    	return minVal;
    }
    
    /**
     * minAt
     * 정수 배열에서 최솟값의 인덱스 리턴.
     * @param arr 정수 배열.
     * @return 배열 arr의 원소들 중 최솟값의 인덱스.
     * 최솟값이 여러개 있는 경우, 첫번째 최솟값의 인덱스.
     */
    public static int minAt(int[] arr) {
    	// 최솟값을 찾음.
    	int minVal = min(arr);
    	int index = 0;		// 배열의 인덱스
    	for(index = 0; index < arr.length; index++) {
        	// 배열의 원소들을 순서대로 반복하면서, 그 원소가 최솟값인 지 검사.
    		if(arr[index] == minVal) {
    			break;	// 최솟값을 찾았으면 반복을 종료.
    		}
    	}
    	
    	//================================================    	
    	int minAt = 0;
    	int minVal1 = min(arr);
    	for(int i = 0; i < arr.length; i++) {
    		if(minVal1 == arr[i]) {
    			minAt = i;
    			break;
    		}
    	}
    	System.out.println(minAt);
    	
    	
    	return index;	// 반복문이 종료됐을 때의 인덱스를 리턴.
    	

    	
    	
    	
    }
}
