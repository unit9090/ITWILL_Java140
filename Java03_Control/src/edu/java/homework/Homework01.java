package edu.java.homework;

import java.util.Random;
import java.util.Scanner;

public class Homework01 {

	public static void main(String[] args) {
		// 가위바위보 게임
		// 가위-0, 바위-1, 보-2

		// 컴퓨터의 가위/바위/보는 (정수) 난수로 만듦.
		Random random = new Random();
		int computer = random.nextInt(3);

		// 사용자는 콘솔창에서 키보드로 가위/바위/보에 해당하는 정수를 입력.
		System.out.println("가위/바위/보 게임");
		System.out.println("-----------------");
		System.out.println("[0] 가위");
		System.out.println("[1] 바위");
		System.out.println("[2] 보");
		System.out.println("-----------------");
		System.out.print("선택>>> ");

		Scanner scanner = new Scanner(System.in);
		int user = scanner.nextInt();

		// print(computer : user)
		System.out.println("computer(" + computer + ") : user(" + user + ")");

		// TODO: 누가 이겼는 지 결과를 출력하세요.
		
		// 보(2)는 바위(1)를 이김
		// 바위(1)는 가위(0)를 이김
		// 가위(0)는 보(2)를 이김
		
		// 컴퓨터와 사용자를 크기 비교 후
		// 차이가 0일 경우 비김.
		// 차이가 1일 경우 크기가 큰 사람이 이김.
		// 차이가 2일 경우 크기가 작은 사람이 이김.
		
		int gap = 0;
		String winner;
		
		if(computer >= user) {
			gap = computer - user;
		} else if(user > computer) {
			gap = user - computer;
		}
		
		
		switch(gap) {
		case 0:
			System.out.println("게임 결과: 비겼습니다.");
			break;
		case 1:
			winner = computer > user ? "computer" : "user";
			System.out.println("게임 결과: " + winner + "가 이겼습니다.");
			break;
		case 2:
			winner = computer < user ? "computer" : "user";
			System.out.println("게임 결과: " + winner + "가 이겼습니다.");
		}
		
		
		/*
			// 9개의 경우의 수
			// 비긴 경우 제외
			if(computer == user) {
				// 비긴 경우
				System.out.println("게임 결과: 비겼습니다.");
			} else {
				// 서로 다른 걸 낸 경우
				
				// 컴퓨터가 숫자가 더 큰 경우
				if(computer > user) {
					if(computer == 2) {
						System.out.println("게임 결과: 컴퓨터 졌습니다.");
					} else {
						System.out.println("게임 결과: 컴퓨터 이겼습니다.");
					}
				} else {	// user가 숫자가 더 큰 경우
					if(user == 2) {
						System.out.println("게임 결과: user가 졌습니다.");
					} else {
						System.out.println("게임 결과: user가 이겼습니다.");
					}
				}
				
			}
		*/
		
		
		/* 강사님 풀이 */
		
		/*
		// 방법 1:		
		if(user == 0) {
			// user가 가위를 낸 경우
			if(computer == 0) {
				// 컴퓨터가 가위를 낸 경우
				System.out.println("비김");
			} else if(computer == 1) {
				// 컴퓨터가 바위를 낸 경우
				System.out.println("컴퓨터 승");
			} else {
				// 컴퓨터가 보를 낸 경우
				System.out.println("사용자 승");
			}
		} else if(user == 1) {
			// user가 바위를 낸 경우
			if(computer == 0) {
				// 컴퓨터가 가위를 낸 경우
				System.out.println("사용자 승");
			} else if(computer == 1) {
				// 컴퓨터가 바위를 낸 경우
				System.out.println("비김");
			} else {
				// 컴퓨터가 보를 낸 경우
				System.out.println("컴퓨터 승");
			}
		} else {
			// user가 보자기를 낸 경우
			if(computer == 0) {
				// 컴퓨터가 가위를 낸 경우
				System.out.println("컴퓨터 승");
			} else if(computer == 1) {
				// 컴퓨터가 바위를 낸 경우
				System.out.println("사용자 승");
			} else {
				// 컴퓨터가 보를 낸 경우
				System.out.println("비김");
			}
		}
		
		// 방법 2:
		if(user == computer) {	// 비기는 경우
			System.out.println("비김");
		} else if(user == 0) {
			// user가 가위를 낸 경우
			if(computer == 1) {
				// 컴퓨터가 바위를 낸 경우
				System.out.println("컴퓨터 승");
			} else {
				// 컴퓨터가 보자기를 낸 경우
				System.out.println("사용자 승");
			}
		} else if(user == 1) {
			// user가 바위를 낸 경우
			if(computer == 0) {
				// 컴퓨터가 가위를 낸 경우
				System.out.println("사용자 승");
			} else {
				// 컴퓨터가 보자기를 낸 경우
				System.out.println("컴퓨터 승");
			}
		} else {
			// user가 보자기를 낸 경우
			if(computer == 0) {
				// 컴퓨터가 가위를 낸 경우
				System.out.println("컴퓨터 승");
			} else {
				// 컴퓨터가 바위를 낸 경우
				System.out.println("사용자 승");
			}
		}
		
		// 방법 3:
		if(user == computer) {
			// 비긴 경우
			System.out.println("비김");
		} else if( (user == 0 && computer == 2)
				|| (user == 1 && computer == 0)
				|| (user == 2 && computer == 1)) {	// 사용자가 이긴 경우 3가지
			System.out.println("사용자 승");
		} else {					// 사용자가 진 경우 3가지
			System.out.println("컴퓨터 승");
		}
		
		// 방법 4:
		int diff = user - computer;
		if(diff == 0) {
			// 비긴 경우
		} else if(diff == -2 || diff == 1) {
			// 사용자가 이긴 경우
			System.out.println("사용자 승");
		} else {
			// 사용자가 진 경우
			System.out.println("컴퓨터 승");
		}
		
		*/
	}

}
