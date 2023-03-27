package edu.java.list04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListMain04 {

	public static void main(String[] args) {
		// User 타입을 저장하는 ArrayList 타입 변수 선언, 객체 생성.
		List<User> userArray = new ArrayList<>();
		
		// 3개의 User 객체를 ArrayList에 저장.
//		Scanner sc = new Scanner(System.in);
//		while(userArray.size() < 3) {
//			System.out.print("User" + userArray.size() + "의 id를 입력하세요.> ");
//			String id = sc.nextLine();
//			System.out.print("User" + userArray.size() + "의 password를 입력하세요.> ");
//			String password = sc.nextLine();
////			User user = new User(id, password);
////			userArray.add(user);
//			userArray.add(new User(id, password));
//		}
//		
//		sc.close();
		
		User user1 = new User("1111", "1111");
		userArray.add(user1);
		
		userArray.add(new User("guest", "guest1234"));
		userArray.add(new User("guest111", "111guest1234"));
		
		// ArrayList 내용 출력.
		System.out.println(userArray);
		
		// 리스트 users에서 인덱스 0번 위치의 원소를 삭제
		userArray.remove(0);
		System.out.println(userArray);
		
		// id가 "guest"인 첫번째 User 객체를 리스트에서 삭제
		for(int i = 0; i < userArray.size(); i++) {
			if(userArray.get(i).getId().equals("guest")) {
				userArray.remove(i);
				break;
			}
		}
		
		System.out.println(userArray);

	}

}
