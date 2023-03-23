package edu.java.exception06;

import java.util.Scanner;

public class ExceptionMain06 {

	private Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO inputInteger() 메서드 테스트 코드.
		int x = 0;
		
		ExceptionMain06 em = new ExceptionMain06();
		
		while(true) {
			try {
				x = em.inputInteger();
				break;
			} catch (Exception e1) {
				System.out.println("정수를 입력해주세요.");
			}
		}
		
		System.out.println("입력된 값: " + x);
	}
	
	public int inputInteger() {
		// TODO Scanner를 사용해서 입력받은 정수를 리턴.
		// Integer.parseInt(scanner.nextLine()) 과정에서 NumberFormatException이 발생할 수 있음.
		
		System.out.print("정수 입력> ");
		int x = Integer.parseInt(scanner.nextLine());
		return x;
		
	}

}
