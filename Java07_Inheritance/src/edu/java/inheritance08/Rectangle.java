package edu.java.inheritance08;

public class Rectangle extends Shape {
	// field
	private double width;	// 직사각형의 가로 길이
	private double height;	// 직사각형의 세로 길이

	// constructor
	public Rectangle(String type, double width, double height) {
		super(type);	// 상위 클래스의 argument를 갖는 생성자를 명시적으로 호출.
		// Shape에 기본 생성자가 없기 때문에 반드시 불러야 함.
		this.width = width;
		this.height = height;
	}

	// method
	// abstract method
	@Override
	public double area() {
		return width * height;
	}

	@Override
	public double perimeter() {
		return (width + height) * 2;
	}

}
