package edu.java.file07;

import java.io.Serializable;

public class Score implements Serializable {
	private int java;
	private int web;
	private int python;
	
	// TODO: 생성자, getters, setters, toString, 파일에 쓸 수 있는 클래스 타입이어야 함.
	
	// 생성자
	public Score() {}
	
	public Score(int java, int web, int python) {
		super();
		this.java = java;
		this.web = web;
		this.python = python;
	}
	
	// getter & setter
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getWeb() {
		return web;
	}
	public void setWeb(int web) {
		this.web = web;
	}
	public int getPython() {
		return python;
	}
	public void setPython(int python) {
		this.python = python;
	}
	

	// toString
	@Override
	public String toString() {
		return String.format("Score(java = %d, web = %d, python = %d)",
						this.java, this.web, this.python);
	}
	
	
	
}
