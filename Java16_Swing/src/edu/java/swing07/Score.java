package edu.java.swing07;


// MVC 아키텍쳐에서 Model 객체
public class Score {
	private int korean;
	private int english;
	private int math;
	
	public Score() {}

	public Score(int korean, int english, int math) {
		super();
		this.korean = korean;
		this.english = english;
		this.math = math;
	};
	
	// TODO: 세 과목의 총점을 int 타입으로 리턴하는 메서드. getTotal
	public int getTotal() {
		return korean + english + math;
	}
	
	// TODO: 세 과목의 평균을 double 타입으로 리턴하는 메서드. getMean
	public double getMean() {
		return (double) getTotal() / 3.0;
	}
	
	// TODO: toString Override
	@Override
	public String toString() {
		return String.format("국어 = %d, 영어 = %d, 수학 = %d, 총점 = %d, 평균 = %f"
				, korean, english, math, getTotal(), getMean());
	}
	
	
}
