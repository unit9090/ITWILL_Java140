package edu.java.conditional03;

import java.util.Scanner;

public class ConditionalMain03 {

	public static void main(String[] args) {
		// 간단한 성적 처리 프로그램
		// tip. Ctrl + Space: 코드 추천
		// tip. Ctrl + F11: 실행(Run java program)
		
		/*
		JAVA, SQL, HTML 3개의 과목이 있다.
		3개의 과목의 성적을 입력 받아 총점과 평균을 구하여라.
		평균에 따라 90, 80, 70, 60 이상과 그 이하로 나누어 성적을 A, B, C, D, F로 나누어라.
		*/
		
		Scanner sc = new Scanner(System.in);	// 입력장치 Scanner를 사용할 준비 끝남.		

		// 자바 성적
		System.out.print("Java 성적을 입력해주세요.(0~100): ");
		int java = sc.nextInt();
		System.out.println("Java 점수: " + java);
		
		// sql 성적
		System.out.print("SQL 성적을 입력해주세요.(0~100): ");
		int sql = sc.nextInt();
		System.out.println("SQL 점수: " + sql);
		
		// html 성적
		System.out.print("HTML 성적을 입력해주세요.(0~100): ");
		int html = sc.nextInt();
		System.out.println("HTML 점수: " + html);
		
		// 총점 및 평균 출력
		int result = java + sql + html;
		double avg = result / 3.0;
		// double avg = (double) total / 3;
		System.out.println("총점: " + result + ", 평균: " + avg);
		
		// 학점 출력
		if(avg >= 90) {
			System.out.println("학점: A");
		} else if(avg >= 80) {
			System.out.println("학점: B");
		} else if(avg >= 70) {
			System.out.println("학점: C");
		} else if(avg >= 60) {
			System.out.println("학점: D");
		} else {
			System.out.println("학점: F");
		}

	}

}
