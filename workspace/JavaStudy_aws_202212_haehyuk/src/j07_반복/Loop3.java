package j07_반복;

import java.util.Scanner;

public class Loop3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		int total = 0;
		
		System.out.print("반복횟수: ");
		count = scanner.nextInt();
		
		/*
		 *  반복의 횟수 만큼 각
		 *  a, b 라는 숫자를 받아서
		 *  반복 도는 중 받은 숫자를 더한 값을 나타낸다.
		 *  
		 */
		for(int i = 0; i < count; i++) {
			
			int a = 0;
			int b = 0;
			
			System.out.println();
			System.out.print((i + 1) + "번 반복\n");
			System.out.print("a: ");
			a = scanner.nextInt();
			
			System.out.print("b: ");
			b = scanner.nextInt();
			
			System.out.println((i + 1)+ "번 합: " + (a + b));
			
			total += a + b;
		}
		System.out.println("\n총합: " + total);
	}
}
