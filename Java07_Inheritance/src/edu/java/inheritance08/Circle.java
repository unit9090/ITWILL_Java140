package edu.java.inheritance08;

public class Circle extends Shape {
	// field
	private double radius;	// 원의 반지름
	
	// constructor
	public Circle(String type, double radius) {
		super(type);
		this.radius = radius;
	}

	// method
	// abstract method
	// public static final double PI
	@Override
	public double area() {
		return Math.PI * radius * radius;
	}

	@Override
	public double perimeter() {
		return Math.PI * 2 * radius;
	}
	
}
