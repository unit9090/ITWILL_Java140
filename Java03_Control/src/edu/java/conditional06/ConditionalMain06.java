package edu.java.conditional06;

import java.util.Random;

public class ConditionalMain06 {

	public static void main(String[] args) {
		/*
			Random 타입의 변수를 선언하고 초기화.
			과목 3가지(java, sql, html) 점수를 난수로 만들어서 저장.(0~100)
			합격/불합격 여부를 출력 => 합격 조건: 세 과목의 점수가 모두 40점 이상이고, 세 과목의 평균이 60점 이상.
		*/
		
		// 난수 생성을 위한 클래스 선언
		Random random = new Random();
		
		// 과목별 점수 생성
		int java = random.nextInt(101);
		int sql = random.nextInt(101);
		int html = random.nextInt(101);
		System.out.println("JAVA: " + java + ", SQL: " + sql + ", HTML: " + html);
		
		// 점수 평균 구하기
		double avg = (java + sql + html) / 3.0;
		System.out.println("평균 점수: " + avg);
		
		// 합격 여부 구하기		
		
		// 1. 삼항 연산자
		String PassNonPass = java >= 40 && sql >= 40 && html >= 40 && avg >= 60 ? "합격" : "불합격";
		System.out.println("합격 여부: " + PassNonPass);
		
		// 2. if문
		if(java < 40 || sql < 40 || html < 40 || avg < 60) {
			System.out.println("합격 여부2: 불합격");
		} else {
			System.out.println("합격 여부2: 합격");
		}
		
		// 3. 그 외
		/*
		if(java >=40 && sql >= 40 && html >= 40) {
			if(avg >= 60) {
				합격;
			} else {
				불합격;
			}
		} else {
			불합격;
		}
		*/
	}

}
