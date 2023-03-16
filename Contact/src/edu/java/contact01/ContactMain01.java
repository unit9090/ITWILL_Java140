package edu.java.contact01;

import java.util.Scanner;

public class ContactMain01 {
	// 상수(constant)
	private static final int MAX_LENGTH = 5;	// 연락처 배열의 최대 길이(원소 개수)
	
	// field
	private Contact[] contacts = new Contact[MAX_LENGTH];	// 연락처를 저장할 배열.
	private int count = 0;	// 연락처 배열에 현재까지 저장된 연락처의 개수. 배열에 저장될 때마다 값 증가.
	private Scanner scanner = new Scanner(System.in);		// 입력 도구.

	public static void main(String[] args) {
		System.out.println("***** 연락처 프로그램 v0.1 *****");
		
		ContactMain01 app = new ContactMain01();
		// -> static이 아닌 메서드들을 사용하기 위해서 참조 변수를 생성.
		
		boolean run = true;
		while(run) {
			// 메인 메뉴 보여주기 & 메인 메뉴에서 선택된 값 저장 => showMainMenu
			int menu = app.showMainMenu();
			switch(menu) {
				case 0:		// 프로그램 종료
					run = false;
					break;
				case 1: 	// 새 연락처 저장
					app.insertNewContact();
					break;
				case 2: 	// 연락처 전체 목록 보여주기
					app.contactListArray();
					break;
				case 3:		// 배열의 인덱스로 검색하기
					app.searchIndex();
					break;
				case 4:		// 연락처 이름/전화번호/이메일 정보 수정하기
					app.updateContact();
					break;
				case 5:		// 배열의 인덱스로 연락처 삭제하기
					app.deleteContact();
					break;
				default:
					System.out.println("메인 메뉴 번호를 확인하세요...");
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
		System.out.print("선택> ");
		
		// 콘솔 창에서 입력된 문자열 1개 라인을 정수(int)로 변환.
		int result = Integer.parseInt(scanner.nextLine());
		
		return result;
		
	}
	
	// 새 연락처 저장
	public void insertNewContact() {
		System.out.println();
		
		if(count < MAX_LENGTH) {

			System.out.println("--- 새 연락처 저장 ---");
			
			System.out.print("이름 입력> ");
			String name = scanner.nextLine();	// 공백을 포함해서 엔터가 입력될 때까지 모든 문자열을 읽음.
			System.out.print("전화번호 입력> ");
			String phone = scanner.nextLine();
			System.out.print("이메일 입력> ");
			String email = scanner.nextLine();
			
			// 입력받은 정보들로 Contact 타입의 객체를 생성.
			Contact c = new Contact(count, name, phone, email);

			// 생성된 Contact 타입의 객체를 배열에 저장.
			contacts[count] = c;
			
			// 배열에 저장된 원소(연락처) 개수를 1 증가.
			count++;
			
			System.out.println("새 연락처 저장 성공");
		} else {
			System.out.println("용량이 부족합니다! 연락처 삭제 후 실행시키십시오.");
		}
	}
	
	// 연락처 전체 목록 보여주기 => contactListArray
	public void contactListArray() {
		System.out.println();
		
		if(count != 0) {
			System.out.println("--- 모든 연락처 ---");
			for(int i = 0; i < count; i++) {
				if(contacts[i].getName() != null) {
					System.out.printf("번호 %d) name = %s, phone = %s, email = %s\n",
							contacts[i].getCid(), contacts[i].getName(), contacts[i].getPhone(), contacts[i].getEmail());
				}
			}
		} else {
			System.out.println("저장된 연락처가 없습니다.");
		}
		
	}
	
	// 배열의 인덱스로 검색하기 => searchIndex()
	public void searchIndex() {
		System.out.println();
		
		if(count == 0) {
			System.out.println("저장된 연락처가 없습니다.");
		} else {
			System.out.print("검색할 인덱스 번호를 입력하세요.(0 ~ " + (count - 1) + ")>> ");
			int num = Integer.parseInt(scanner.nextLine());
			
			if(num >= 0 && num <= (count - 1)) {
				contacts[num].printInfo();
			} else {
				System.out.println("해당 번호에 저장된 연락처는 없습니다.");
			}
		}
				
	}
	
	// 연락처 이름/전화번호/이메일 정보 수정하기 => updateContact()
	public void updateContact() {
		System.out.println();
		
		if(count == 0) {
			System.out.println("저장된 연락처가 없습니다.");
		} else {
			contactListArray();
			System.out.print("수정할 연락처 번호 >> ");
			int num = Integer.parseInt(scanner.nextLine());
			
			if(num >= 0 && num <= (count - 1)) {
				System.out.println("--- 연락처 수정 ---");
				
				System.out.print("이름 입력> ");
				String name = scanner.nextLine();
				System.out.print("전화번호 입력> ");
				String phone = scanner.nextLine();
				System.out.print("이메일 입력> ");
				String email = scanner.nextLine();
				
				// 입력받은 정보들로 Contact 타입의 객체 수정.
				contacts[num].setCid(num);
				contacts[num].setName(name);
				contacts[num].setPhone(phone);
				contacts[num].setEmail(email);
				
				System.out.println("해당 연락처가 수정되었습니다.");
			} else {
				System.out.println("해당 번호에 저장된 연락처는 없습니다.");
			}
		}
		
	}
	
	// 배열의 인덱스로 연락처 삭제하기 => deleteContact()
	public void deleteContact() {
		System.out.println();
		
		if(count == 0) {
			System.out.println("저장된 연락처가 없습니다.");
		} else {
			contactListArray();
			System.out.print("삭제할 연락처 번호 >> ");
			int num = Integer.parseInt(scanner.nextLine());
			
			if(num >= 0 && num <= (count - 1)) {
				if(num == 4) {
					Contact contact = new Contact();
					contacts[num] = contact;
				}
				
				for(int i = num; i < MAX_LENGTH - (num + 1); i++) {
					contacts[i].setCid(contacts[i + 1].getCid() - 1);
					contacts[i].setName(contacts[i + 1].getName());
					contacts[i].setPhone(contacts[i + 1].getPhone());
					contacts[i].setEmail(contacts[i + 1].getEmail());
				}
				
				count--;
				
				System.out.println("해당 연락처가 삭제되었습니다.");
			} else {
				System.out.println("해당 번호에 저장된 연락처는 없습니다.");
			}
		}
	}

}
