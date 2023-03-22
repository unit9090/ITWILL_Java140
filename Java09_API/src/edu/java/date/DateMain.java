package edu.java.date;

// java.lang.String, java.lang.System, ... -> import 문장 생략
import java.time.LocalDate;

public class DateMain {

	public static void main(String[] args) {
		// Java 8 버전에서 새로 추가된 날짜/시간 관련 클래스와 메서드
		LocalDate now = LocalDate.now();	// LocalDate 클래스의 static 메서드 호출.
		System.out.println(now);			// LocalDate 클래스는 toString() 메서드를 override.
		System.out.println(now.getYear());
		System.out.println(now.getMonth());			// java.time.Month enum 상수를 리턴.
		System.out.println(now.getMonthValue());	// 월을 숫자(int)로 리턴.
		System.out.println(now.getDayOfWeek());		// java.time.DayOfWeek enum 상수를 리턴
		System.out.println(now.plusDays(7));
		System.out.println(now.plusWeeks(2));
		
		LocalDate date = LocalDate.of(2023, 2, 28);
		System.out.println(date);
	}

}
