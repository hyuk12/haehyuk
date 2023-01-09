package j12_배열.di;

public class Test_A {
	private final Test_B tb;
	
	
	// requierdArgumentsConstructor - > 멤버변수에 final 이잡혔을 때 필수 생성자
	// 기본생성자는 NoArgumentsConstructor
	// 전체 생성자는 AllArgumentsConstructor
	public Test_A(Test_B tb) {
		this.tb = tb;
	}
	
//	public void setTb(Test_B tb) {
//		this.tb = tb;
//	}
	
	public void testA1() {
		System.out.println("테스트A1 메소드 호출!!!");
	
		tb.testB1();
	}
	
	public void testA2() {
		System.out.println("테스트A2 메소드 호출!!!");

		tb.testB1();
	}
}
