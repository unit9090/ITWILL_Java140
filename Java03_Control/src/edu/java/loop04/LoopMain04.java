package edu.java.loop04;

public class LoopMain04 {

	public static void main(String[] args) {
		// 반복문에서 break와 continue
		
		for(int n = 1; n <= 5; n++) {
			if(n == 3) {
				break;
				// break가 포함된 가장 가까운 반복문을 종료.
				// : 지금 위치에서 반복문을 중단하라.
			}
			
			System.out.println(n);
		}
		
		System.out.println("=======================================");

		for(int n = 1; n <= 5; n++) {
			if(n == 3) {
				continue;	
				// continue 아래의 코드들을 실행하지 않고, 그 다음 반복을 계속해서 수행.
				// : 지금 위치에서 반복문을 계속 진행하라.
			}
			
			System.out.println(n);
		}
		
	}

}
