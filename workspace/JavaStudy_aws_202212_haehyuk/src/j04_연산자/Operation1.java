package j04_연산자;

public class Operation1 {
	public static void main(String[] args) {
		int add = 1 + 3 ;
		int sub = 10 - 5;
		int mul = 10 * 2;
		int div = 10 / 5;
		int remainder = 10 % 5;
		
		System.out.println(add); // 더하기
		System.out.println(sub); // 빼기
		System.out.println(mul); // 곱하기
		System.out.println(div); // 나누기 몫(정수 끼리의 나누기 경우)
		System.out.println(remainder); // 나머지 (배수를 구할 때) (짝수/ 홀수 구할 때)
		
		System.out.println(remainder == 0 ? "5의 배수이다." : "5의 배수가 아니다.");
	}
}
