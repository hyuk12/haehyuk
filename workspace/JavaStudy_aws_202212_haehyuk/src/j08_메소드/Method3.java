package j08_메소드;

public class Method3 {
	
	// 메소드 오버로딩(오버로드) 호출 하는 시점에 어떤 매개변수를 넣느냐에 따라 달라진다
	//, 오버라이드 메소드 실행을 재 정의 해서 쓴다.
	
	public static void ov1() {
		System.out.println("매개변수 없음");
	}
	
	public static void ov1(int num) {
		System.out.println("int 매개변수 하나");
	}
	
	public static void ov1(int num, String b) {
		System.out.println("int 먼저 그다음 String");
	}
	
	public static void ov1(String num, int b) {
		System.out.println("String 먼저 그다음 int");
	}
	
	public static boolean ov2 (int a) {
		if (a < 10) {
			return true;
		}else {
			return false;
		}
	}
	
	public static int ov2 (String b) {
		return 1;
	}
	public static void main(String[] args) {
		
		ov1();
		ov1(10);
		ov1(10,"b");
		
		System.out.println(ov2(3));
		System.out.println(ov2("b"));
	}
}
