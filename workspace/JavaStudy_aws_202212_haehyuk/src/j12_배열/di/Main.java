package j12_배열.di;

public class Main {
	
	public static void main(String[] args) {
		Test_C tc = new Test_C();
		Test_C tc2 = new Test_C();
		
		Test_B tb = new Test_B(tc2);
		
		// 의존성을 외부에서 주입해주는 방법 DI dependency injection
		// 생성자 주입방식
		Test_A ta = new Test_A(tb);
		
		ta.testA1();
		ta.testA2();
	}
}
