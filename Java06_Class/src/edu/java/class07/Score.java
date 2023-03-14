package edu.java.class07;

public class Score {

	// 필드 - 객체의 속성(데이터)
	int java; 	// Java 과목 점수
	int sql;	// SQL 과목 점수
	int html;	// HTML 과목 점수
	
	// 생성자 - 객체 생성 & 속성 초기화
	// -- 기본 생성자
	public Score() {}
	
	// --argument 3개를 갖는 생성자
	public Score(int java, int sql, int html) {
		this.java = java;
		this.sql = sql;
		this.html = html;
	}
	
	// 메서드 - 객체 기능
	// -- printScore - 세 과목 점수 출력
	public void printScore() {
		System.out.printf("Java 점수: %d점, SQL 점수: %d점, HTML 점수: %d점\n",
							java, sql, html);
	}
	
	// -- getTotal - 세 과목의 총점 리턴
	public int getTotal() {
		return java + sql + html;
	}
	
	// -- getAverage - 세 과목의 평균(double) 리턴
	public double getAverage() {		
		return (double) getTotal() / 3;
	}
	
	
}
