package edu.java.inheritance08;

public class InheritanceMain08 {

	public static void main(String[] args) {
		// 추상 클래스는 생성자를 호출할 수 없음. 객체를 생성할 수 없음.
		// Shape shape = new Shape("직사각형");
		
		// Rectangle
		Rectangle rac1 = new Rectangle("Rectangle1", 20, 10);
		Rectangle rac2 = new Rectangle("Rectangle2", 40, 5);
		
		// Circle
		Circle cir1 = new Circle("Circle1", 5);
		Circle cir2 = new Circle("Circle2", 2);
		
		Shape[] shape = {rac1, rac2, cir1, cir2};
		for(Shape x : shape) {
			x.draw();
		}

		System.out.println();
		
		/* 강사님 */
		Shape[] shapes = {
				new Rectangle("직사각형", 3, 4),
				new Circle("원", 10)
		};
		
		for(Shape s : shapes) {
			s.draw();
		}
	}

}
