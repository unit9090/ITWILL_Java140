package edu.java.array08;

public class ArrayMain08 {

	public static void main(String[] args) {
		// 1차원 배열 선언 초기화
		// (1): type[] array = { ... };
		// (2): type[] array = new type[개수];
		
		// 2차원 배열 선언 초기화
		// (1): type[][] array = { {...}, {...}, {...}, ...};
		// (2): type[][] array = new type[행의 개수][열의 개수];
		// new type[2차원 배열의 원소의 개수][1차원 배열의 원소의 개수];
		
		int[][] array1 = new int[3][4];
		for(int i = 0; i < array1.length; i++) {
			for(int j = 0; j < array1[i].length; j++) {
				array1[i][j] = i * 4 + j + 1;
			}
		}
		
		for(int[] member : array1) {
			for(int x : member) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		
		System.out.println("======================================================");
		
		// 이렇게 만들 경우 정사각형 모양의 행렬만 만들 수 있음. 그래서 만들어짐.
		// 2차원 배열을 선언하고 생성할 때 행의 개수(2차원 배열의 원소의 개수)는 반드시 필요함.
		// 2차원 배열의 열의 개수(각각의 1차원 배열의 원소 개수)는 나중에 설정할 수 있음.
		int[][] array2 = new int[3][];		// 1) 원소 개수 둘 다 비워두는 것, 2) 행 원소 개수 비워두는 것 불가.
		array2[0] = new int[3];				// => 0번째 행에 열 3개
		array2[1] = new int[4];				// => 1번째 행에 열 4개
		array2[2] = new int[2];				// => 2번째 행에 열 2개
		
		array2[0][0] = 123;
		array2[2][1] = 456;
		
		for(int[] member : array2) {
			for(int x : member) {
				System.out.print(x + "\t");
			}
			System.out.println();
		}
		
		System.out.println("======================================================");
		
		for(int i = 0; i < array2.length; i++) {
			for(int j = 0; j < array2[i].length; j++) {
				array2[i][j] = i * 4 + j + 1;
			}
		}
		
		for(int[] member : array2) {
			for(int x : member) {
				System.out.print(x + "\t");
			}
			System.out.println();
		}

	}

}
