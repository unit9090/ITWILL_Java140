package edu.java.array02;

public class ArrayMain02 {

	public static void main(String[] args) {
		// 문자열 3개를 저장할 수 있는 배열(names)을 선언, 초기화.
		String[] names = new String[3];
		
		// 배열 names에 문자열을 저장.
		names[0] = "이찬희";
		names[1] = "지대한";
		names[2] = "김다훈";
//		names[3] = "유다한"; : 문법적 오류는 없음. 하지만 가지고 있는 배열의 크기는 정해져 있기에 오류가 남.
		
		
		/* 배열의 names의 내용을 한 줄로 출력. */
		// (1) for 구문
		for(int i= 0; i < names.length; i++) {
			System.out.print(names[i] + "\t");
		}
		
		System.out.println("\n--------------------------");
		
		// (2) for-each 구문
		for(String name : names) {
			System.out.print(name + "\t");
		}
		
		System.out.println("\n--------------------------");
		
		String[] subjects = {"Java", "SQL", "HTML", "JavaScript"};
		for(String sub : subjects) {
			System.out.print(sub + " ");
		}
		
		System.out.println("\n--------------------------");
		
	}

}
