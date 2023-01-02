package j03.형변환;

public class Casting1 {
	public static void main(String[] args) {
		char a = 'a';
		int num1 = a; // 묵시적 형 변환
		
		System.out.println((double)a);
		System.out.println((char)97.0);
		System.out.println((byte)300); // 256까지 절대 값으로 표현 할 수 있기에 그 것이 넘어간 후에는 0으로 다시시작 그래서 44라는 값이 나온다
		// 보수 개념 알아야함
		
		
		
	}
}
