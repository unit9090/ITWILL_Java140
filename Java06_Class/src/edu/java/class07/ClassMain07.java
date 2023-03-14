package edu.java.class07;

public class ClassMain07 {

	public static void main(String[] args) {

		// - 점수
		// 기본 생성자
		Score sc1 = new Score();
		sc1.printScore();
		sc1.html = 100;
		sc1.java = 78;
		sc1.sql = 63;
		sc1.printScore();
		System.out.println("총점: " + sc1.getTotal() + "점");
		System.out.println("평균: " + sc1.getAverage() + "점");

		// argument 3개를 갖는 생성자
		Score sc2 = new Score(67, 77, 91);
		sc2.printScore();
		System.out.println("총점: " + sc2.getTotal() + "점");
		System.out.println("평균: " + sc2.getAverage() + "점");
		
		System.out.println();
		
		// - 학생
		// 기본 생성자
		Student stu1 = new Student();
		stu1.printStudent();
		stu1.stuNo = 201916125;
		stu1.name = "홍길동1";
		stu1.score = sc1;
		stu1.printStudent();
		
		
		// argument를 가진 생성자
		Student stu2 = new Student(602270120, "홍길동2", sc2);
		stu2.printStudent();
		
		String emptyString = "";
		System.out.println("길이: " + emptyString.length());
//		String nullString = null;
//		System.out.println("길이: " +  nullString.length());
		// -> NullPointException 발생
		// null: 생성된 객체가 없다.
		// 데이터 타입의 기본값:
		// (1) boolean - false, (2) 정수 - 0, (3) 실수 - 0.0, (4) 참조(클래스) 타입 - null
		
		// 기본 생성자를 사용해서 Student 객체를 생성.
		Student student1 = new Student();
		System.out.println(student1);
		
		Student student2 = new Student(3, "이준혁", null);
		student2.printStudent();
		
		Student student3 = new Student(10, "위태욱", 100, 100, 100);
		student3.printStudent();
		
		
	}

}
