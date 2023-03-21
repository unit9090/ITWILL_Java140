package edu.java.inheritance09;

import java.util.Scanner;

enum Menu {
	// enum 상수(public static final 변수) 선언
	QUIT, CREATE, READ_ALL, READ_BY_INDEX, UPDATE, DELETE, UNKNOWN;
	
	// method
	/**
	 * 정수가 입력되면, 그 정수에 해당하는 열거형 상수를 리턴.
	 * 0 -> QUIT, 1 -> CREATE, 2 -> READ_ALL, 3 -> READ_BY_INDEX,
	 * 4 -> UPDATE, 5 -> DELETE, ), 그 이외의 정수들인 경우에는 UNKNOWN을 리턴.
	 * @param n 정수(int)
	 * @return menu[n] Menu 타입의 열거형 상수.
	 */
	public static Menu getValue(int n) {		
		if(n > Menu.values().length || n < 0) {
			Menu[] menu = Menu.values();
			return menu[6];
		}
		
		Menu[] menu = Menu.values();
		return menu[n];
	}
	
}


public class MenuTest {
//	public static final int QUIT = 0; => 이렇게 써야 하는 걸 위에 enum으로 끝냄.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
			System.out.println("메뉴를 선택하세요.(0 ~ 5)");
			System.out.print("선택> ");
			
			int n = Integer.parseInt(sc.nextLine());
			
//			if(n > Menu.values().length || n < 0) {
//				System.out.println("menu에 없는 번호를 입력하였습니다. 다시 입력하세요.");
//				continue;
//			}
			
			Menu menu = Menu.getValue(n); // 정수(int)를 전달하면 Menu의 상수들 중 하나를 리턴.
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
					System.out.println("menu에 없는 번호를 입력하였습니다. 다시 입력하세요.");
			}
		
		sc.close();
		
	}

}
