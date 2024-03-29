package edu.java.class07;

public class Student {

	// field
	int stuNo;		// 학생 번호(학번)
	String name;	// 학생 이름
	Score score;	// 학생 (Java, SQL, HTML)시험 점수

	
	// constructor
	// -- 기본 생성자
	public Student() {}
	
	// -- stuNo, name, score를 초기화할 수 있는 생성자
	public Student(int stuNo, String name, Score score) {
		this.stuNo = stuNo;
		this.name = name;
		this.score = score;
	}
	
	// -- 만약?
	public Student(int stuNo, String name, int java, int sql, int html) {
		this.stuNo = stuNo;
		this.name = name;
		this.score = new Score(java, sql, html);
	}
	
	// method
	// -- printStudent - 학번, 이름, 세 과목 점수, 총점, 평균을 출력하는 메서드.
	public void printStudent() {
		System.out.println("--------- 학생 정보 ---------");
		System.out.println("학번: " + this.stuNo);
		System.out.println("이름: " + name);
		if(score == null) {
			System.out.println("점수: " + score);
			System.out.println("점수를 조회할 수 없습니다.");
			System.out.println("---------------------------");
		} else {
			System.out.println("Java 점수: " + score.java + "점");
			System.out.println("SQL 점수: " + score.sql + "점");
			System.out.println("HTML 점수: " + score.html + "점");
			score.printScore();
			System.out.println("총점: " + score.getTotal() + "점");
			System.out.println("총점: " + score.getAverage() + "점");
			System.out.println("---------------------------");
		}
		
		System.out.println();
	}
	
	
}
