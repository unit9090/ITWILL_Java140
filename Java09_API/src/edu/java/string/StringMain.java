package edu.java.string;

import java.util.Arrays;

public class StringMain {

	public static void main(String[] args) {
		// Ex 1. 아래의 주민번호 문자열에서 성별을 표시하는 위치의 문자만 출력.
		String ssn = "001231-1234567";
		String x = ssn.substring(ssn.indexOf("-") + 1, ssn.indexOf("-") + 2);
		System.out.println(x);
		
		/* 강사님 */
		char c = ssn.charAt(7);
		System.out.println(c);
		
		String[] array = ssn.split("-");
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[1].charAt(0));
		
		// Ex 2. 아래의 문자열 배열에서 "홍길동" 문자열이 처음 등장하는 인덱스를 출력.
		// 만약에 "홍길동" 문자열이 배열에 없으면 -1을 출력.
		String[] names = {"오쌤", "John", "Jane", "홍길동", "허균", "홍길동"};
//		String[] names = {"오쌤", "John", "Jane", "허균"};
		System.out.println(Arrays.asList(names).indexOf("홍길동"));
		
		/* 강사님 */
		int index = -1;
		for(int i = 0; i < names.length; i++) {
			if(names[i].equals("홍길동")) {
				System.out.println(i);
				index = i;
				break;
			}
		}
		
		System.out.println("홍길동 인덱스 = " + index);
		
		

		
		// Ex 3. 아래의 문자열 배열에서 5글자 이상인 문자열들을 찾아서 출력.
		String[] languages = {"Java", "SQL", "HTML", "CSS", "JavaScript", "Python"};
		for(String str : languages) {
			if(str.length() >= 5) {
				System.out.print(str + " ");
			}
		}
		
		System.out.println();
		
		// Ex 4. 아래의 문자열 배열에서 대소문자 구별 없이 "est"가 포함된 문자열들을 찾아서 출력.
		String[] tests = {"TEST", "test", "TeSt", "tEST", "테스트"};
		for(String str : tests) {
			if(str.toLowerCase().contains("est".toLowerCase())) {
				System.out.print(str + " ");
			}
		}
		
		System.out.println();
		
		// Ex 5. 아래의 "YYYY-MM-DD" 형식의 날짜 문자열에서 연/월/일 정보를 int 타입 변수에 저장하고 출력.
		String date = "2023-03-22";
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(date.indexOf("-") + 1, date.indexOf("-") + 3));
		int day = Integer.parseInt(date.substring(date.indexOf("-") + 4));
		
		System.out.println(year + "-" + month + "-" + day);
		
		/* 강사님 */
		String[] dataeStrings = date.split("-");
		int year1 = Integer.parseInt(dataeStrings[0]);
		int month1 = Integer.parseInt(dataeStrings[1]);
		int day1 = Integer.parseInt(dataeStrings[2]);
		
		System.out.println("year1: " + year1);
		System.out.println("month1: " + month1);
		System.out.println("day1: " + day1);
	}

}
