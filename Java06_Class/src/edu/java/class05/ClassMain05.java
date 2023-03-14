package edu.java.class05;

public class ClassMain05 {

	public static void main(String[] args) {
		// 기본 생성자
		Rectangle rectangle1 = new Rectangle();
		System.out.println(rectangle1);
		System.out.print("세로: " + rectangle1.height + ", ");
		System.out.println("가로: " + rectangle1.width);
		// . => 참조연산자
		rectangle1.height = 12;
		rectangle1.width = 5;
		rectangle1.perimeter();
		rectangle1.area();
		
		// 직사각형의 가로/세로 길이 전달
		Rectangle rectangle2 = new Rectangle(2.3, 3.5);
		rectangle2.perimeter();
		rectangle2.area();
	}

}
