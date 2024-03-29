package edu.java.inheritance06;

public class InheritanceUserMain {

	public static void main(String[] args) {
//		System.out.println("================== user1 정보 ==================");
//		User user1 = new User();
//		System.out.println(user1);
//		
//		user1.setUserId("user123");
//		user1.setPassword("user123!");
//		System.out.println(user1);
//		System.out.println("===============================================");
//		
//		System.out.println();
//		
//		System.out.println("================== user2 정보 ==================");
//		User user2 = new User("user123", "user12345678");
//		System.out.println(user2);
//		System.out.println("===============================================");
//
//		System.out.println();
//		
//		System.out.println("============ user1 & user2 정보 비교 ============");
//		System.out.println("user1과 user2 ID 비교: " + user1.equals(user2));
//		System.out.println(user1.hashCode());
//		System.out.println(user2.hashCode());
//		System.out.println("===============================================");
//
//		System.out.println();
//		
//		System.out.println("================== user3 정보 ==================");
//		User user3 = new User("user0000", "user123!");
//		System.out.println(user3);
//		System.out.println("===============================================");
//		
//		System.out.println();
//		
//		System.out.println("============ user1 & user3 정보 비교 ============");
//		System.out.println("user1과 user3 ID 비교: " + user1.equals(user3));
//		System.out.println(user3.hashCode());
//		System.out.println("===============================================");
		
//		----------------------------------------------------------------------------------------------
		
		User user1 = new User("admin", "admin1234");
		System.out.println("user1: " + user1);
		
		User user2 = new User("admin", "0000");
		System.out.println("user2: " + user2);
		
		System.out.println("== 연산자: " + (user1 == user2)); //-> false
		System.out.println("equals 메서드: " + user1.equals(user2)); //-> true
		
		System.out.println("user1 hash = " + user1.hashCode());
		System.out.println("user2 hash = " + user2.hashCode());

	}

}
