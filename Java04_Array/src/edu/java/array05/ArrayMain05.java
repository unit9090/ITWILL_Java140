package edu.java.array05;

import java.util.Random;

public class ArrayMain05 {

	public static void main(String[] args) {
		// int 10개를 저장할 수 있는 배열을 선언.
		int[] genderCodes = new int[10];
		Random random = new Random();
		
		// 배열에 난수(0, 1) 10개를 저장.
		for(int i = 0; i < genderCodes.length; i++) {
			genderCodes[i] = random.nextInt(2);
		}
		
		// 배열의 내용을 출력.
		for(int x : genderCodes) {
			System.out.print(x + " ");
		}
		
		System.out.println();
		
		// 문자열 10개를 저장할 수 있는 배열(genders)을 선언.
		String[] genders = new String[10];
		
		// genderCodes의 값이 0이면 "Male", 1이면 "Female"을 문자열 배열에 저장.
		for(int i = 0; i < genderCodes.length; i++) {
			if(genderCodes[i] == 0) {
				genders[i] = "Male";
			} else {
				genders[i] = "Female";
			}
		}
		
		// 문자열 배열 genders의 내용을 출력.
		for(String x : genders) {
			System.out.print(x + " ");
		}
		
		System.out.println();
		
		// 문자열 배열에 저장된 "Male"의 개수, "Female"의 개수를 출력.
		// (힌트) 두 숫자 x, y가 같은 지 비교:  x == y		
		// (힌트) 두 문자열 x, y가 같은 지 비교: x.equals(y)
		
		int male = 0;
		for(String x : genders) {
			if(x.equals("Male")) {
				male++;
			}			
		}
		
		System.out.printf("남자 %d명, 여자 %d명\n", male, (genders.length - male));
		
//=========================================================================================================

		/* 강사님 해설 */
		/*
			int count = 10;							// 배열의 길이(원소 개수)
			int[] genderCodes1 = new int[count];	// 이런 식으로도 가능.
			String[] genders = new String[count];
			// for문에서도 길이 대신 count로 넣어줄 수 있음.
			
			String m = "Male";
			String f = "Female"; 
			
			// int 10개를 저장할 수 있는 배열을 선언.
			int[] genderCodes1 = new int[10];
			
			// 배열에 난수(0, 1) 10개를 저장.
			Random rand = new Random();
			for(int i = 0; i < genderCodes1.length; i++) {
				genderCodes1[i] = rand.nextInt(2);	// 2 미만의 정수 난수를 배열 i번째에 저장. 
			}
			
			// 배열의 내용을 출력
			for(int x : genderCodes1) {
				System.out.print(x + " ");
			}
			
			System.out.println();
			
			// 문자열 10개를 저장할 수 있는 배열을 선언.
			String[] genders1 = new String[10];
			
			// genderCodes의 값이 0이면 "Male", 1이면 "Female"을 문자열 배열에 저장.
			for(int i = 0; i < genderCodes1.length; i++) {
				if(genderCodes1[i] == 0) {
					genders1[i] = "Male";
				} else {
					genders1[i] = "Female";
				}
			}
			
			// 문자열 배열 genders의 내용을 출력
			for(String s : genders1) {
				System.out.print(s + " ");
			}
			System.out.println();
	
			// 문자열 배열에 저장된 "Male"의 개수, "Female"의 개수를 출력.
			int numOfMales = 0;			// "Male"의 개수를 저장할 변수
			int numOfFemales = 0;		// "Female"의 개수를 저장할 변수
			for(String s : genders1) {	// 배열 genders의 원소들을 순서대로 반복하면서
				if(s.equals("Male")) {	// 배열에서 읽은 값이 "Male"과 같으면
					numOfMales++;		// 남성의 숫자를 1 증가
				} else {				// 배열에서 읽은 값이 "Female"과 같으면
					numOfFemales++;		// 여성의 숫자를 1 증가
				}
			}
			
			System.out.println("# of male = " + numOfMales);
			System.out.println("# of female = " + numOfFemales);
		*/
		
	}

}
