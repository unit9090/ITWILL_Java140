package edu.java.class05;

// 직사각형
public class Rectangle {
	// field - 객체 속성
	double width;	// 직사각형 가로 길이
	double height;	// 직사각형 세로 길이
	
	// 생성자 - 필드 초기화

	// (1) 기본 생성자
	public Rectangle() {}

	// (2) 직사각형의 가로/세로 길이를 전달받은 값으로 초기화 하는 생성자
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	
	// 메서드 - 객체 기능
	
	// (1) perimeter - 직사각형의 둘레 길이를 리턴.
	public double perimeter() {
		System.out.printf("가로: %.2f, 세로: %.2f => 둘레: %.2f\n"
					, width, height, width * 2 + height * 2);
		return width * 2 + height * 2;
	}
	
	// (2) area - 직사각형의 넓이를 리턴.
	public double area() {
		System.out.printf("가로: %.2f, 세로: %.2f => 넓이: %.2f\n"
				, width, height, width * height);
		return width * height;
	}
	
}
