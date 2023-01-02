package j04_연산자;

public class Operation5 {
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 5;
		
		int result = num1 > num2 ? num1 * -1 : num2 * -1;
		System.out.println(result);
		
		int num = 79;
		
		// 줄 바꿈을 할 때는 연산자 앞에서 줄 바꿈을하고 삼항 연산자는 콜론앞에서 바꾼다
		int result2 = num / 90 == 1 ? 90 
				: num / 80 == 1 ? 80 
				: num / 70 == 1 ? 70 : 0;
		System.out.println(result2);
	}
}
