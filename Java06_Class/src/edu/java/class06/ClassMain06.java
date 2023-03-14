package edu.java.class06;

public class ClassMain06 {

    public static void main(String[] args) {
    	// 기본 생성자
    	Circle cir1 = new Circle();
    	cir1.printInfo();
    	
    	cir1.radius = 2;
    	cir1.printInfo();
    	cir1.perimeter();
    	cir1.area();
    	
    	// argument를 갖는 생성자
    	Circle cir2 = new Circle(4);
    	cir2.printInfo();
    	cir2.perimeter();
    	cir2.area();

    }

}
