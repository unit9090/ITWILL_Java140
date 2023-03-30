package edu.java.file07;

import java.io.Serializable;

public class Student implements Serializable {
	private int id;
	private String name;
	private Score score;
	
	// TODO: 생성자, getters, setters, toString
	
	// 생성자
	public Student() {}
	
	public Student(int id, String name, Score score) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
	}

	// getter & setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}
	
	// toString
	@Override
	public String toString() {
//		return String.format("Student(id = %d, name = %s, score = {java = %d, web = %d, python = %d})",
//				this.id, this.name, this.score.getJava(), this.score.getWeb(), this.score.getPython());
		
		return String.format("Student(id= %d, name = %s, score = %s)",
								id, name, score);
	}
	
	
}
