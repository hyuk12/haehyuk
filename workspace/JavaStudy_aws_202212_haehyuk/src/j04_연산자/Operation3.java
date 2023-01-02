package j04_연산자;

/*
 * 
 *  논리 연산자
 *  AND(곱) T && T , T && F 하나라도 F이면 F이다.
 *  
 *  OR(합) T || T , T || F , F || F  모두 F 여야 F이다.
 *  
 *  NOT(부정) !T 참이면 거짓, 거짓이면 참
 *  
 */
public class Operation3 {
	public static void main(String[] args) {
		int num = 11;
		
		boolean flag1 = true;
		boolean flag2 = true;
		boolean flag3 = num % 2 == 0;
		
		
		System.out.println(flag1 && flag2);
		System.out.println(flag1 && flag3);
		
		System.out.println(!(flag1 || flag3 && flag2));
	}
}
