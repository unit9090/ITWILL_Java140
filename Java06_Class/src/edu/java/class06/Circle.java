package edu.java.class06;

// 원(동그라미)
public class Circle {
    // field - 객체의 속성
    double radius; // 원의 반지름
    
    // 생성자 - 객체 속성을 초기화
    // (1) 기본 생성자
    public Circle() {}

    // (2) argument 1개를 갖는 생성자
    public Circle(double radius) {
    	this.radius = radius;
    }
    
    
    // 메서드 - 객체의 기능
    // (1) printInfo - 원의 반지름 정보를 출력.
    public void printInfo() {
    	System.out.println("원의 반지름: " + radius);
    }
    
    // (2) perimeter - 원의 둘레 길이(2 x 3.14 x 반지름)을 리턴.
    public double perimeter() {
    	System.out.printf("원의 둘레 길이: %.2f\n", 2 * 3.14 * radius);
    	return 2 * 3.14 * radius;
    }
    
    // (3) area - 원의 넓이(3.14 x 반지름 x 반지름)을 리턴.
    public double area() {
    	System.out.printf("원의 넓이: %.2f\n", 3.14 * radius * radius);
    	return 3.14 * radius * radius;
    }

}
