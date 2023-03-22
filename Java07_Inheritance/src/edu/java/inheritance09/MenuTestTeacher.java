package edu.java.inheritance09;

import java.util.Scanner;

enum Menu1 {
	// enum 열거형 상수(public static final Menu 타입 변수) 선언
	QUIT, CREATE, READ_ALL, READ_BY_INDEX, UPDATE, DELETE, UNKNOWN;
	
	// method
	/**
	 * 정수가 입력되면, 그 정수에 해당하는 열거형 상수를 리턴.
	 * 0 -> QUIT, 1 -> CREATE, 2 -> READ_ALL, 3 -> READ_BY_INDEX,
	 * 4 -> UPDATE, 5 -> DELETE, ), 그 이외의 정수들인 경우에는 UNKNOWN을 리턴.
	 * @param n 정수(int)
	 * @return menu[n] Menu 타입의 열거형 상수.
	 */
	public static Menu1 getValue(int n) {
		// values(): 이 enum이 가지고 있는 값들을 다 불러와라.
		// enum 안에서 바로 호출하기 때문에 Menu1.values()에서 Menu1.을 생략할 수 있다.
		Menu1[] menu = values();
		int len = menu.length;
		if(n >= 0 && n < len) {
			return menu[n];
		} else {
			return menu[len-1];	// return UNKNOWN;
		}
	}
	
	
}


public class MenuTestTeacher {

	public static void main(String[] args) {
		Singleton s = Singleton.INSTANCE;
		//-> enum 타입이 열거형 상수를 1개만 가지고 있으면,
		// 그 enum 타입에 할당할 수 있는 객체는 1개만 있게 됨.
		// -> 싱글톤 객체
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("메뉴를 선택하세요.(0 ~ 5)");
		System.out.print("선택> ");
		
		int n = Integer.parseInt(sc.nextLine());
		Menu1 menu = Menu1.getValue(n); // 정수(int)를 전달하면 Menu의 상수들 중 하나를 리턴.
		
		switch(menu) {
			case QUIT:
				System.out.println(menu.name());
				break;
			case CREATE:
				System.out.println(menu.name());
				break;
			case READ_ALL:
				System.out.println(menu.name());
				break;
			case READ_BY_INDEX:
				System.out.println(menu.name());
				break;
			case UPDATE:
				System.out.println(menu.name());
				break;
			case DELETE:
				System.out.println(menu.name());
				break;
			default:
				System.out.println(menu.name());
		}
		
		sc.close();
		
	}

}
