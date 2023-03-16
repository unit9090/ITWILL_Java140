package modifier07;

public class Test {
	// 인스턴스 멤버는 객체를 생성하지 않으면 사용할 수 없음.
	
	int x;	// static이 안 붙어있는 필드 -> 인스턴스 필드
	static int y;	// static 필드
	
	
	// static이 안 붙어있는 메서드 -> 인스턴스 메서드
	public void printInfo() {
		System.out.println("--- instance method ---");
		System.out.println("x = " + this.x);	// this.생략 가능
		System.out.println("y = " + y);
		// -> 인스턴스 메서드는 static 필드/메서드를 사용할 수 있음.
//		System.out.println("y = " + this.y); => this는 생성된 객체 인스턴스를 의미하기 때문에 권장하지 않음.
//		System.out.println("y = " + Test.y); => Test 생략 가능.
		System.out.println("-----------------------");
	}
	
	// 수식어들의 순서는 상관 없음. => static public으로 써도 됨.
	public static void printStaticInfo() {
		System.out.println("---- static method ----");
//		System.out.println("x = " + x); => static 메서드에서 인스턴스 필드/메서드를 사용할 수 없기 때문에.
		System.out.println("y = " + y);
		System.out.println("-----------------------");
	}

}
