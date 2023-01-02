package j04_연산자;

public class Operation4 {
	public static void main(String[] args) {
		int num = 100;
		
		num = num + 1;
		
		num -= 100; // 복합 대입 연산자
		num *= 10; // 복합 대입 연산자
		num %= 3; // 복합 대입 연산자
		
		System.out.println(num);
	}
}
