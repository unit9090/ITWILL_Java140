package edu.java.class02;

// 클래스(class): 프로그램에서 필요한 데이터와 기능을 묶어서 하나의 "데이터 타입"으로 정의한 것.
// - 데이터 -> 필드(field), 멤버 변수, 속성(property)
// - 기능 -> 메서드(method)
// 데이터 타입 -> 변수 선언, 파라미터 선언, 메서드 리턴 타입 선언.
// 클래스 선언: [수식어] class 클래스이름 { ... }
// 클래스 이름 작성:
// - 영문자, 숫자, _, $를 사용할 수 있음.
// - 숫자로 시작할 수 없음.
// - 대문자로 시작하는 camel 표기법을 권장.

// 메서드 안에서 선언하는 변수 = 지역변수
// 클래스의 모든 메서드에서 사용 가능한 변수 = filed
// => 지역변수는 사용하기 전에 값을 넣어주어야 사용 가능하지만
// => filed는 호출하면 임시로 값이 생성된다. -> 기본값으로 채워진다.(0)

public class BasicTv {
	// field - 클래스의 모든 메서드에서 사용 가능.
	private static final int MAX = 5;
	private static final int MIN = 0;
	// -> final 수식어가 들어가면 한 번 저장된 값은 함수가 끝날 때까지 변경할 수 없다.
	
	boolean powerOn;	// TV의 전원 상태(true: ON, false: OFF)를 저장하는 필드.
	int channel;		// TV의 현재 채널을 저장하는 필드.
	int volume;			// TV의 현재 음량을 저장하는 필드.
	
	
	// 조건
	// 전원이 켜져있는 상태에서만 채널 및 음량이 변경 가능.
	// 채널과 볼륨은 0보다 크거나 같아야 한다.
	// 채널과 볼륨의 최댓값은 5다.
	// 채널은 최댓값에 마주하면 다시 1로 간다.
	// 볼륨은 최댓값을 마주하면 멈춘다.
	
	// method
	public void powerOnOff() {
		if(powerOn) {			// TV가 켜져 있으면
			powerOn = false;	// TV를 끔
			System.out.println("TV OFF");
		} else {				// TV가 꺼져 있으면
			powerOn = true;		// TV를 켬.
			System.out.println("TV ON");
		}
	}
	
	// 채널 값 1 증가(0 ~ 5)
	public void channelUp() {
		if(powerOn) {
			if(channel == MAX) {
				channel = MIN;
			} else {
				channel++;	// 현재 채널 번호를 1 증가.
			}
			System.out.println("채널: " + channel);
		}		
	}
	
	/* 강사님 풀이 */
	public void channelUp1() {
		if(powerOn) {			// TV 전원이 ON(true)인 경우에
			if(channel < MAX) {	// TV 채널 번호가 최댓값보다 작은 경우
				channel++;		// 현재 채널 번호를 1 증가
			} else {			// TV 채널 번호가 최댓값보다 크거나 같으면
				channel = MIN;	// TV 채널의 최솟값으로 바꾼다.(채널을 순환시킴.)
			}
		}
		System.out.println("채널: " + channel);
	}
	
	// 채널 값 1 감소(0 ~ 5)
	public void channelDown() {
		if(powerOn) {
			channel--;	// 현재 채널 번호를 1 감소.
			
			if(channel < MIN) {
				channel = MAX;
			} else if(channel == MAX) {
				channel = MIN;
			}
		}
		System.out.println("채널: " + channel);
	}
	
	/* 강사님 풀이 */
	public void channelDown1() {
		if(powerOn) {			// TV가 켜져 있을 때
			if(channel > MIN) {	// 현재 채널이 0보다 클 때(최솟값에 도달하지 않았을 때)
				channel--;		// 현재 채널 번호를 1 감소.
			} else {			// 채널이 0보다 작거나 같을 때(최솟값에 도달했을 때)
				channel = MAX;	// 현재 채널을 채널 최댓값으로 변경(채널을 순환)
			}
		}
		System.out.println("채널: " + channel);
	}
	
	
	// 볼륨 값 1 증가(0 ~ 5)
	public void volumeUp() {
		if(powerOn) {
			if(volume != MAX) {
				volume++;	// 현재 음량을 1 증가.
			}
		}
		System.out.println("음량: " + volume);
	}
	
	/* 강사님 풀이 */
	public void volumeUp1() {
		if(powerOn) {
			if(volume < MAX) {
				volume++;	// 현재 음량을 1 증가.
			}
		}
		System.out.println("음량: " + volume);
	}
	
	// 볼륨 값 1 감소(0 ~ 5)
	public void volumeDown() {
		if(powerOn) {
			if(volume != MIN) {
				volume--;	// 현재 음량을 1 감소.
			}
		}
		System.out.println("음량: " + volume);		
	}
	
	/* 강사님 풀이 */
	public void volumeDown1() {
		if(powerOn) {
			if(volume > MIN) {
				volume--;	// 현재 음량을 1 감소.
			}
		}
		System.out.println("음량: " + volume);		
	}
	
}
