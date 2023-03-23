package edu.java.contact02;

import java.util.Scanner;

enum Menu {
	QUIT, CREATE, READ_ALL, READ_BY_INDEX, UPDATE, DELETE, UNKNOWN;
	
	public static Menu getValue(int n) {		
		if(n > Menu.values().length || n < 0) {
			Menu[] menu = Menu.values();
			return menu[6];
		}
		
		Menu[] menu = Menu.values();
		return menu[n];
	}
}


public class ContactMain02 {
	// 상수(constant) => static은 안써도 상관없긴 함.
	private static final int MAX_LENGTH = 5;	// 연락처 배열의 최대 길이(원소 개수)
	
	// field
	private Contact[] contacts = new Contact[MAX_LENGTH];	// 연락처를 저장할 배열.
	private int count = 0;	// 연락처 배열에 현재까지 저장된 연락처의 개수. 배열에 저장될 때마다 값 증가.
	private Scanner scanner = new Scanner(System.in);		// 입력 도구.

	public static void main(String[] args) {
		System.out.println("***** 연락처 프로그램 v0.2 *****");
		
		ContactMain02 app = new ContactMain02();
		// -> static이 아닌 메서드들을 사용하기 위해서 참조 변수를 생성.
		
		boolean run = true;
		while(run) {
			// 메인 메뉴 보여주기 & 메인 메뉴에서 선택된 값 저장 => showMainMenu
			Menu menu = Menu.getValue(app.showMainMenu());
			switch(menu) {
				case QUIT:		// 프로그램 종료
					run = false;
					break;
				case CREATE: 	// 새 연락처 저장
					app.insertNewContact();
					break;
				case READ_ALL: 	// 연락처 전체 목록 보여주기
					app.selectAllContacts();
					break;
				case READ_BY_INDEX:		// 배열의 인덱스로 검색하기
					app.selectContactByIndex();
					break;
				case UPDATE:		// 연락처 이름/전화번호/이메일 정보 수정하기
					app.updateContactByIndex();
					break;
				case DELETE:		// 배열의 인덱스로 연락처 삭제하기
					app.deleteContactByIndex();
					break;
				default:
//					System.out.println("메인 메뉴 번호를 확인하세요...");
					System.out.println(menu.name());
			}
		}
		
		System.out.println("***** 프로그램 종료 *****");
		
	}
	
	// method
	
	// 메인 메뉴
	public int showMainMenu() {
		System.out.println();
		System.out.println("----------------------------------------------------------");
		System.out.println("[0] 종료 [1] 새 연락처 [2] 전체 목록 [3] 검색 [4] 수정 [5] 삭제");
		System.out.println("----------------------------------------------------------");
		
		// 콘솔 창에서 입력된 문자열 1개 라인을 정수(int)로 변환.
		System.out.print("선택> ");
		int result = inputInteger();
		
		return result;
		
	}
	
	// 정수가 아닐 시 exception
	public int inputInteger() {
		int result = 0;
		while(true) {
			try {				
				result = Integer.parseInt(scanner.nextLine());
				break;
			} catch(NumberFormatException e) {
				System.out.println("정수로 입력해주세요...");
				System.out.print("선택> ");
			}
		}
		
		return result;
	}
	
	// 새 연락처 저장
	public void insertNewContact() {
		System.out.println();
		
		if(count == MAX_LENGTH) {
			System.out.println("용량이 부족합니다! 연락처 삭제 후 실행시키십시오.");
			return;		// 메서드 종료=> void문에서 return 시 메서드 종료 의미
		}

		System.out.println("--- 새 연락처 저장 ---");
		
		System.out.print("이름 입력> ");
		String name = scanner.nextLine();	// 공백을 포함해서 엔터가 입력될 때까지 모든 문자열을 읽음.
		System.out.print("전화번호 입력> ");
		String phone = scanner.nextLine();
		System.out.print("이메일 입력> ");
		String email = scanner.nextLine();
		
		// 입력받은 정보들로 Contact 타입의 객체를 생성.
		Contact c = new Contact(0, name, phone, email);

		// 생성된 Contact 타입의 객체를 배열에 저장.
		contacts[count] = c;
		
		// 배열에 저장된 원소(연락처) 개수를 1 증가.
		count++;
		
		System.out.println("새 연락처 저장 성공");
		
	}
	
	// 연락처 전체 목록 보여주기 => selectAllContacts
	public void selectAllContacts() {
		System.out.println("--- 연락처 목록 ---");
		for(int i = 0; i < count; i++) {
			contacts[i].printInfo();
		}
		
	}
	
	// 배열의 인덱스로 검색하기 => selectContactByIndex()
	public void selectContactByIndex() {
		System.out.println("--- 인덱스 검색 ---");
		System.out.print("검색할 인덱스 입력> ");
		int index = inputInteger();
		
		if(index >= 0 && index < count) {
			contacts[index].printInfo();
		} else {
			System.out.println("해당 번호에 저장된 연락처는 없습니다.");
		}
	}
	
	// 연락처 이름/전화번호/이메일 정보 수정하기 => updateContactByIndex()
	public void updateContactByIndex() {
		System.out.println("--- 연락처 수정 ---");
		System.out.println("수정할 연락처 인덱스 입력 > ");
		int index = inputInteger();
		
		if(index < 0 || index >= count) {
			System.out.println("해당 번호에 저장된 연락처는 없습니다.");
			return;
		}
		
		System.out.print("수정 전: ");
		contacts[index].printInfo();
		
		System.out.print("수정할 이름 입력> ");
		String name = scanner.nextLine();
		System.out.print("수정할 전화번호 입력> ");
		String phone = scanner.nextLine();
		System.out.print("수정할 이메일 입력> ");
		String email = scanner.nextLine();
		
		// 수정할 인덱스의 정보를 업데이트
		contacts[index] = new Contact(0, name, phone, email);
		
		System.out.print("수정 후: ");
		contacts[index].printInfo();
		
	}
	
	// 배열의 인덱스로 연락처 삭제하기 => deleteContactByIndex()
	public void deleteContactByIndex() {
		System.out.println("--- 연락처 삭제 ---");
		System.out.println("삭제할 연락처 인덱스 입력> ");
		int index = inputInteger();
		
		if(index < 0 || index >= count) {
			System.out.println("해당 번호에 저장된 연락처는 없습니다.");
			return;
		}
		
		for(int i = index; i < count - 1; i++) {
			contacts[i] = contacts[i + 1];	// 뒷쪽 연락처 정보를 한 칸 앞으로..
		}
		
		contacts[count - 1] = null;		// 삭제 전 배열의 마지막 원소를 null
		count--;	// 배열 원소 개수를 1 줄임.
		
		System.out.println("삭제 성공");
		
	}

}
